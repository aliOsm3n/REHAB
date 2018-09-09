package com.example.ascom.rehab.adaptors;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ascom.rehab.Home2Patient;
import com.example.ascom.rehab.Home3Patient;
import com.example.ascom.rehab.R;
import com.example.ascom.rehab.models.Result;

import java.util.List;

public class SearchResult_Adaptor extends RecyclerView.Adapter<SearchResult_Adaptor.MyViewHolder> {

    Context  context ;
    List<Result> resultList ;

    public SearchResult_Adaptor(Context context, List<Result> resultList ) {
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public SearchResult_Adaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.searchresult_list_item , parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchResult_Adaptor.MyViewHolder holder, int position) {
        Result result = resultList.get(position);
        holder.image.setImageResource(Integer.valueOf(result.getImg()));
        holder.name.setText(result.getName());
        holder.job.setText(result.getSpecialization());
        holder.descreption.setText(result.getDescreption());
        holder.ratingBar.setRating(Float.parseFloat(result.getRate()));

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class MyViewHolder  extends ViewHolder{

        public ImageView image , likeImg;
        public TextView name, job , descreption;
        public RatingBar ratingBar;
        public Button button;

        public MyViewHolder(final View itemView) {
            super(itemView);
            image =  itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.nameDoctor);
            job = (TextView) itemView.findViewById(R.id.DoctorJob);
            descreption = (TextView) itemView.findViewById(R.id.Descreption);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            button = itemView.findViewById(R.id.book);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), Home3Patient.class);
                    v.getContext().startActivity(intent);
                }
            });
            likeImg = itemView.findViewById(R.id.imageView5);
            likeImg.setOnClickListener(new View.OnClickListener() {
                Boolean fun = true;
                @Override
                public void onClick(View v) {
                    if(fun)
                    {
                        likeImg.setImageResource(R.drawable.like_black);
                        fun=false;
                    }
                    else
                    {
                        fun=true;
                        likeImg.setImageResource(R.drawable.like);
                    }
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), Home2Patient.class);
                    v.getContext().startActivity(intent);
                    Log.d("You" , "Position " +  getPosition());
                }
            });

        }
    }
}
