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

import com.example.ascom.rehab.FragmentAdapter;
import com.example.ascom.rehab.R;
import com.example.ascom.rehab.adaptors.Favourit_Adaptor;
import com.example.ascom.rehab.models.Favourite;

import java.util.ArrayList;
import java.util.List;

public class FavouritFragment extends Fragment {
    RecyclerView  recyclerFavourite;
    List<Favourite> movieList = new ArrayList<>();
    Favourit_Adaptor favourit_adaptor ;

    public FavouritFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourit , container ,false);
        recyclerFavourite = view.findViewById(R.id.Favourit_Recycler);
        favourit_adaptor = new Favourit_Adaptor(getContext(),movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext()) {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return null;
            }
        };
        recyclerFavourite.setLayoutManager(mLayoutManager);
        recyclerFavourite.setAdapter(favourit_adaptor);
        prepareMovieData();
        return view;
    }

    private void prepareMovieData() {
        Favourite favourite = new Favourite(String.valueOf(R.drawable.profile),
                getResources().getString(R.string.moustafa1) ,
                getResources().getString(R.string.job1),
                "5",
                getResources().getString(R.string.desc));
        movieList.add(favourite);

        Favourite favourite2 = new Favourite(String.valueOf(R.drawable.profile),
                getResources().getString(R.string.moustafa1) ,
                getResources().getString(R.string.job1),
                "5",
                getResources().getString(R.string.desc));
        movieList.add(favourite2);

        Favourite favourite3 = new Favourite(String.valueOf(R.drawable.profile),
                getResources().getString(R.string.moustafa1) ,
                getResources().getString(R.string.job1),
                "5",
                getResources().getString(R.string.desc));
        movieList.add(favourite3);

        Favourite favourite4 = new Favourite(String.valueOf(R.drawable.profile),
                getResources().getString(R.string.moustafa1) ,
                getResources().getString(R.string.job1),
                "5",
                getResources().getString(R.string.desc));
        movieList.add(favourite4);

        Favourite favourite5 = new Favourite(String.valueOf(R.drawable.profile),
                getResources().getString(R.string.moustafa1) ,
                getResources().getString(R.string.job1),
                "5",
                getResources().getString(R.string.desc));
        movieList.add(favourite5);

    }


}
