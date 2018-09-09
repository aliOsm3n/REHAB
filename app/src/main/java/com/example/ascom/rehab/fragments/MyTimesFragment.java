package com.example.ascom.rehab.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ascom.rehab.R;
import com.example.ascom.rehab.adaptors.Button2Adaptor;
import com.example.ascom.rehab.adaptors.ButtonAdapter;
import com.example.ascom.rehab.interfaces.CallDialog;
import com.example.ascom.rehab.interfaces.callMethod;

import java.util.ArrayList;
import java.util.List;


public class MyTimesFragment extends Fragment {

    TextView textView ;
    GridView gridView;
    Button2Adaptor buttonAdapter ;
    List<String> lists = new ArrayList<>();
    CallDialog callDialog ;


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_times ,container , false );
        textView = v.findViewById(R.id.ddday);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calldialog("Dialog1");
                Toast.makeText(getActivity(), "  0: 07", Toast.LENGTH_SHORT).show();
            }
        });

        buttonAdapter = new Button2Adaptor(v.getContext() , lists ,MyTimesFragment.this);
        gridView = v.findViewById(R.id.gridView3);
        gridView.setAdapter(buttonAdapter);
        FillData();
        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callDialog = (CallDialog) context ;
    }

    public  void  calldialog(String data){
        callDialog.onCallDialog(data);
    }

    private void FillData() {
        lists.add("7:00 م");
        lists.add("8:00 م");
        lists.add("9:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
    }

}
