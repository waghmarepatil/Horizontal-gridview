package com.pramod.gridviewhorizontal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView truckListView;
    private ArrayList<String> truckNo;
    private ArrayList<Integer> truckImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize view
        truckListView = (GridView)findViewById(R.id.truckList);

        //initialize truck data
        truckNo = new ArrayList<>();
        truckImage = new ArrayList<>();

        // add values
        truckNo.add("MH12MH12");
        truckNo.add("MH11MH11");
        truckNo.add("MH10MH10");
        truckNo.add("MH09MH09");
        truckNo.add("MH08MH08");
        truckNo.add("MH07MH07");

        truckImage.add(R.mipmap.bulkar);
        truckImage.add(R.mipmap.bulkar);
        truckImage.add(R.mipmap.bulkar);
        truckImage.add(R.mipmap.bulkar);
        truckImage.add(R.mipmap.bulkar);
        truckImage.add(R.mipmap.bulkar);

        customizeCountryView();

        truckListView.setAdapter(new CustomAdapter());
    }

    /**
     * Function to manipulate size of each item in grid view
     */
    private void customizeCountryView() {
        truckListView.setNumColumns(truckNo.size());

        //manipulate the width of each item in grid view / truck list
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        // width = your devices width
        int width = dm.widthPixels;

        Log.d("MainActivity","hori grid width "+width);

        // number of items you have to display in screen
        int numOfItemPerScreen = 3;
        Log.d("MainActivity","hori grid width per screen "+numOfItemPerScreen);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                (width * (truckNo.size() / numOfItemPerScreen)), LinearLayout.LayoutParams.MATCH_PARENT);

        truckListView.setLayoutParams(params);
        // width of each item in grid I am displaying 3 items per screen
        truckListView.setColumnWidth(width / numOfItemPerScreen);
        truckListView.setHorizontalSpacing(2);
        truckListView.setStretchMode(GridView.STRETCH_SPACING);
        truckListView.setNumColumns(truckNo.size());
        // render truck mapping details
        truckListView.setAdapter(new CustomAdapter());
    }

    /**
     * Class used to customize country
     */
    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return truckNo.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View customCountryView = getLayoutInflater().inflate(R.layout.custom_country_info,null);
            TextView txtTruckNo = (TextView)customCountryView.findViewById(R.id.txtTruckNo);
            txtTruckNo.setText(truckNo.get(position));
            txtTruckNo.setCompoundDrawablesWithIntrinsicBounds(0, truckImage.get(position),0,0);
            return customCountryView;
        }
    }
}
