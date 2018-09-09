package com.example.ascom.rehab.adaptors;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.ascom.rehab.Home3Patient;
import com.example.ascom.rehab.R;
import com.example.ascom.rehab.fragments.MyTimesFragment;

import java.util.List;

public class Button2Adaptor extends BaseAdapter {

    MyTimesFragment timesFragment ;
    Dialog myDialog;

    Context context  ;
    Button textView ;
    Home3Patient home3Patient;
    List<String> strings ;

    public Button2Adaptor(Context context, List<String> strings , MyTimesFragment fragment) {
        this.context = context;
        this.strings = strings;
        this.timesFragment = fragment;

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
                timesFragment.calldialog("Dialog2");
            }
        });
        return view;
    }
    
}
