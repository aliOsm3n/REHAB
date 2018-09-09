package com.example.ascom.rehab.adaptors;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ascom.rehab.R;

import java.util.ArrayList;
import java.util.List;

public class ImagesCer_Adaptor extends RecyclerView.Adapter<ImagesCer_Adaptor.MyViewHolder> {
    List<Integer> arrayList ;
    Context context ;

    public ImagesCer_Adaptor(List<Integer> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ImagesCer_Adaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image ,parent , false);
        return new ImagesCer_Adaptor.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesCer_Adaptor.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {
        ImageView imageView ;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView  = itemView.findViewById(R.id.image_item);
        }
    }
}
