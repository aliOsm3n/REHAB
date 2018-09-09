package com.example.ascom.rehab.adaptors;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ascom.rehab.Home3Patient;
import com.example.ascom.rehab.R;

import java.util.ArrayList;
import java.util.List;

public class ButtonAdapter extends BaseAdapter {

    Dialog myDialog;

    Context context  ;
    Button textView ;
    Home3Patient home3Patient;
    List<String> strings ;

    public ButtonAdapter(Context context, List<String> strings) {
        this.context = context;
        this.strings = strings;
        myDialog = new Dialog(context);

    }
    public void setCon(Home3Patient home3Patient){
        this.home3Patient=home3Patient;
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public Object getItem(int position) {
        return strings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView (final int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.button , parent , false);
        textView =(Button) view.findViewById(R.id.itembtn);
        textView.setText(strings.get(position));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                            Toast.makeText(context, "thanks alot", Toast.LENGTH_SHORT).show();
                            home3Patient.call(position);
            }
        });
        return view;
    }
}
