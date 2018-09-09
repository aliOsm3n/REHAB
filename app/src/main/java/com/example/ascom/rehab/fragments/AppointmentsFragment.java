package com.example.ascom.rehab.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ascom.rehab.R;
import com.example.ascom.rehab.adaptors.Appointment_Adaptor;
import com.example.ascom.rehab.models.Appointment;

import java.util.ArrayList;
import java.util.List;


public class AppointmentsFragment extends Fragment {


    RecyclerView recyclerView ;
    List<Appointment> appointmentList = new ArrayList<>();
    Appointment_Adaptor appointment_adaptor ;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appointments , container , false);
        recyclerView = view.findViewById(R.id.my_appointments_Recycler);
        appointment_adaptor = new Appointment_Adaptor(getContext() , appointmentList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext()) {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return null;
            }
        };
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(appointment_adaptor);
        fillData();
        return view;
    }

    private void fillData() {
        Appointment appointment = new Appointment(String.valueOf(R.drawable.profile) , getResources().getString(R.string.moustafa1) ,getResources().getString(R.string.job1) ,
                "3" ,getResources().getString( R.string.day1) ,getResources().getString( R.string.time) , getResources().getString(R.string.salary1 ),getResources().getString( R.string.address));
        appointmentList.add(appointment);

        Appointment appointment2 = new Appointment(String.valueOf(R.drawable.profile) , getResources().getString(R.string.moustafa2) ,getResources().getString(R.string.job1) ,
                "2" ,getResources().getString( R.string.day2) ,getResources().getString( R.string.time) , getResources().getString(R.string.salary2) ,getResources().getString(R.string.address));
        appointmentList.add(appointment2);


        Appointment appointment3 = new Appointment(String.valueOf(R.drawable.profile) , getResources().getString(R.string.moustafa3) ,getResources().getString(R.string.job1) ,
                "1" , getResources().getString(R.string.day3) , getResources().getString(R.string.time) , getResources().getString(R.string.salary3 ), getResources().getString(R.string.address));
        appointmentList.add(appointment3);
//
//
//        Appointment appointment4 = new Appointment(String.valueOf(R.drawable.profile) ,getResources().getString(R.string.moustafa4) ,getResources().getString(R.string.job1),
//                "5" , getResources().getString(R.string.day4) ,getResources().getString( R.string.time ), getResources().getString(R.string.salary4) ,getResources().getString( R.string.address4));
//        appointmentList.add(appointment4);

    }


}
