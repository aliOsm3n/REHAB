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

import java.util.List;

public class Button3Adaptor extends BaseAdapter {

    Dialog myDialog;

    Context context  ;
    Button textView ;
    Home3Patient home3Patient;
    List<String> strings ;

    public Button3Adaptor(Context context, List<String> strings) {
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

        final View view = LayoutInflater.from(context).inflate(R.layout.button , parent , false);
        textView =(Button) view.findViewById(R.id.itembtn);
        textView.setText(strings.get(position));
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                strings.remove(position);
                Toast.makeText(context, " you clicked long !", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
                return true;
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, " thanks alot !", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
