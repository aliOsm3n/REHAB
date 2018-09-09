package com.example.ascom.rehab.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ascom.rehab.R;
import com.example.ascom.rehab.RatesActivity;
import com.example.ascom.rehab.interfaces.CallDialog;


public class MyProfileFragment extends Fragment {
    CallDialog callDialog ;
    TextView Rates , TV_Certificates ;
    Button BtnRates ,editBtn ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_my_profile , container , false);
        TV_Certificates = view.findViewById(R.id.TV_Certificates);
        TV_Certificates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCallDialog("open_Certificates");
            }
        });

        BtnRates = view.findViewById(R.id.BtnRates);
        BtnRates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCallDialog("MyRatesActivity");
            }
        });

        editBtn = view.findViewById(R.id.editBtn);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCallDialog("EditActivity");
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callDialog = (CallDialog) context ;
    }

    public  void  onCallDialog(String data){
        callDialog.onCallDialog(data);
    }

}
