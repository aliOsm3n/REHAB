package com.example.ascom.rehab.adaptors;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.ascom.rehab.R;
import com.example.ascom.rehab.models.Favourite;

import java.util.List;

public class Favourit_Adaptor extends RecyclerView.Adapter<Favourit_Adaptor.MyViewHolder> {
    Context context ;
    List<Favourite> favouritList;

    public Favourit_Adaptor(Context context, List<Favourite> favouritList) {
        this.context = context;
        this.favouritList = favouritList;
    }

    @NonNull
    @Override
    public Favourit_Adaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.favourit_list_item,parent,false);
        return new Favourit_Adaptor.MyViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull Favourit_Adaptor.MyViewHolder holder, int position) {
     Favourite favourit = favouritList.get(position);
     holder.image.setImageResource(Integer.valueOf(favourit.getImg()));
     holder.name.setText(favourit.getName());
     holder.job.setText(favourit.getSpecialization());
     holder.descreption.setText(favourit.getDescreption());
     holder.ratingBar.setRating(Float.parseFloat(favourit.getRate()));
    }

    @Override
    public int getItemCount() {
        return favouritList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {
        public ImageView image ,ImageLike;
        public TextView name, job , descreption;
        public RatingBar ratingBar;
        public MyViewHolder(View itemView) {
            super(itemView);
            image =  itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.nameDoctor);
            job = (TextView) itemView.findViewById(R.id.DoctorJob);
            descreption = (TextView) itemView.findViewById(R.id.Descreption);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            ImageLike = itemView.findViewById(R.id.imageLike);
            ImageLike.setOnClickListener(new View.OnClickListener() {
                Boolean fun = true;
                @Override
                public void onClick(View v) {
                    if(fun)
                    {
                        ImageLike.setImageResource(R.drawable.like_black);
                        fun=false;
                    }
                    else
                    {
                        fun=true;
                        ImageLike.setImageResource(R.drawable.like);
                    }
                }
            });
        }
    }
}
