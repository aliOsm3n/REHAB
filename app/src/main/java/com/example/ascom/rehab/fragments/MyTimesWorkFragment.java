package com.example.ascom.rehab.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ascom.rehab.R;
import com.example.ascom.rehab.adaptors.Button2Adaptor;
import com.example.ascom.rehab.adaptors.Button3Adaptor;
import com.example.ascom.rehab.interfaces.CallDialog;

import java.util.ArrayList;
import java.util.List;

public class MyTimesWorkFragment extends Fragment {

    TextView textView  ;
    GridView gridView;
    FloatingActionButton fab ;
    Button3Adaptor buttonAdapter ;
    List<String> lists = new ArrayList<>();
    CallDialog callDialog ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_times_work , container , false);
        textView = view.findViewById(R.id.d3day);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePiker("DatePicker");
                Toast.makeText(getContext(), "thanks", Toast.LENGTH_SHORT).show();
            }
        });
        fab = view.findViewById(R.id.fab_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calldialog3("Dialog3");
            }
        });
        gridView  = view.findViewById(R.id.gridView4);
        buttonAdapter = new Button3Adaptor(getContext() , lists);
        gridView.setAdapter(buttonAdapter);
        FillData3();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callDialog = (CallDialog) context;
    }

    public  void openDatePiker(String dataa){
        callDialog.onCallDialog(dataa);
    }

    public  void  calldialog3(String data){

        callDialog.onCallDialog(data);
    }

    private void FillData3() {

        lists.add("7:00 م");
        lists.add("8:00 م");
        lists.add("9:00 م");
    }

}
