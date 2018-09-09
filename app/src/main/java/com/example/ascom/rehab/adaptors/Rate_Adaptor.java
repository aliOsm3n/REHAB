package com.example.ascom.rehab.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.ascom.rehab.R;
import com.example.ascom.rehab.models.Rate;

import java.util.ArrayList;
import java.util.List;

public class Rate_Adaptor extends BaseAdapter {
    Context context ;
    List<Rate> rateList = new ArrayList<>();
    TextView username , date , desc ;
    RatingBar ratingBar ;

    public Rate_Adaptor(Context context, List<Rate> rateList) {
        this.context = context;
        this.rateList = rateList;
    }

    @Override
    public int getCount() {
        return rateList.size();
    }

    @Override
    public Object getItem(int position) {
        return rateList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Rate rate = rateList.get(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.rates_list_item , parent , false);
        username = convertView.findViewById(R.id.usernameTV);
        date = convertView.findViewById(R.id.dateTV);
        desc =convertView.findViewById(R.id.desc_TV);
        ratingBar = convertView.findViewById(R.id.rate_bar);
        username.setText(rate.getName());
        date.setText(rate.getDate());
        desc.setText(rate.getDescription());
        ratingBar.setRating(Float.valueOf(rate.getRate()));
        return convertView;
    }
}
