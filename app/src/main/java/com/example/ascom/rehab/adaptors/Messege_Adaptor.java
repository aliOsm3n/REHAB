package com.example.ascom.rehab.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ascom.rehab.R;
import com.example.ascom.rehab.models.Msg;

import java.util.List;

public class Messege_Adaptor extends BaseAdapter {

    List<Msg> msgList;
    Context context ;
    TextView PatientName , Date;

    public Messege_Adaptor(List<Msg> msgList, Context context) {
        this.msgList = msgList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return msgList.size();
    }

    @Override
    public Object getItem(int position) {
        return msgList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.messeges_list_item ,parent , false);
        Msg msg = msgList.get(position);
        PatientName = convertView.findViewById(R.id.PatientName);
        Date = convertView.findViewById(R.id.Date);
         PatientName.setText(msg.getName());
         Date.setText(msg.getDate());
        return convertView;
    }
}
