package com.example.ascom.rehab.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.ascom.rehab.HomeActivity;
import com.example.ascom.rehab.R;
import com.example.ascom.rehab.interfaces.OnDataPass;


public class BookDoctorFragment extends Fragment {
    Button SearchBtn;
    Button MenBtn , WomansBtn , CosultingBtn ;
    EditText Doctorname;
    ImageView imageView ;
    OnDataPass dataPasser;

    Spinner Specialization , Contrie, Citie  , nationalit;



    public BookDoctorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initiation();

    }

    private void initiation() {
        imageView = getActivity().findViewById(R.id.Img);
        Doctorname = getActivity().findViewById(R.id.DoctorName);
        CosultingBtn = getActivity().findViewById(R.id.ConsultingBT);
        MenBtn = getActivity().findViewById(R.id.MenBtn);
        MenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenBtn.setVisibility(View.INVISIBLE);
                WomansBtn.setVisibility(View.INVISIBLE);
                CosultingBtn.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.VISIBLE);
                Specialization.setVisibility(View.VISIBLE);
                Contrie.setVisibility(View.VISIBLE);
                Citie.setVisibility(View.VISIBLE);
                nationalit.setVisibility(View.VISIBLE);
                Doctorname.setVisibility(View.VISIBLE);
                SearchBtn.setVisibility(View.VISIBLE);
            }
        });
        WomansBtn = getActivity().findViewById(R.id.WomansBtn);
        WomansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenBtn.setVisibility(View.INVISIBLE);
                WomansBtn.setVisibility(View.INVISIBLE);
                CosultingBtn.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.VISIBLE);
                Specialization.setVisibility(View.VISIBLE);
                Contrie.setVisibility(View.VISIBLE);
                Citie.setVisibility(View.VISIBLE);
                nationalit.setVisibility(View.VISIBLE);
                Doctorname.setVisibility(View.VISIBLE);
                SearchBtn.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_doctor , container ,false);
        // show the Actionbar Back on Fragment
//        ( (HomeActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
//        ( (HomeActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled (true);

        String[] Specializations = getActivity().getResources().getStringArray(R.array.Specializations);
        String[] Contries = getActivity().getResources().getStringArray(R.array.Contries);
        String[] Cities = getActivity().getResources().getStringArray(R.array.Cities);
        String[] companies =getActivity().getResources().getStringArray(R.array.companies);
        String[] nationalite = getActivity().getResources().getStringArray(R.array.nationalite);

        Specialization = view.findViewById(R.id.spinner);
        Contrie = view.findViewById(R.id.spinner2);
        Citie = view.findViewById(R.id.spinner3);
        nationalit = view.findViewById(R.id.spinner5);
        SearchBtn = view.findViewById(R.id.search);
        SearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              passData("A");
            }
        });
        ArrayAdapter aa = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,Specializations);
        ArrayAdapter bb = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,Contries);
        ArrayAdapter cc = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,Cities);
        ArrayAdapter ee = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nationalite);
        Specialization.setAdapter(aa);
        Contrie.setAdapter(bb);
        Citie.setAdapter(cc);
        nationalit.setAdapter(ee);

        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataPasser = (OnDataPass) context;
    }

    public void passData(String data) {
        dataPasser.onDataPass(data);
    }


}
