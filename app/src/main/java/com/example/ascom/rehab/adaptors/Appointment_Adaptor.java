package com.example.ascom.rehab.adaptors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.ascom.rehab.R;
import com.example.ascom.rehab.interfaces.OnDataPass;
import com.example.ascom.rehab.models.Appointment;
import com.example.ascom.rehab.models.Rate;

import java.util.List;

public class Appointment_Adaptor extends RecyclerView.Adapter<Appointment_Adaptor.MyViewHolder> {
    Context context ;
    List<Appointment> appointmentsList ;
    OnDataPass dataPass  ;

    public Appointment_Adaptor(Context context, List<Appointment> appointments) {
        this.context = context;
        this.appointmentsList = appointments;
    }

    @NonNull
    @Override
    public Appointment_Adaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.appointments_list_item , parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Appointment_Adaptor.MyViewHolder holder, int position) {
     Appointment appointment  = appointmentsList.get(position);
     holder.name.setText(appointment.getName());
     holder.specialization.setText(appointment.getSpecialization());
     holder.day.setText(appointment.getDay());
     holder.time.setText(appointment.getTime());
     holder.salary.setText(appointment.getSalary());
     holder.address.setText(appointment.getAddress());
     holder.ratingBar.setRating(Float.parseFloat(appointment.getRate()));
    }

    @Override
    public int getItemCount() {
        return appointmentsList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {
        public TextView name , specialization , day , time , salary , address ;
        public Button RateBtn ;
        public RatingBar ratingBar;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            specialization = itemView.findViewById(R.id.position);
            day = itemView.findViewById(R.id.day);
            time = itemView.findViewById(R.id.time);
            salary = itemView.findViewById(R.id.salary);
            address = itemView.findViewById(R.id.address);
            address.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Double myLatitude = 30.5605;
                    Double myLongitude = 31.0079;
                    @SuppressLint("ResourceType")
                    String labelLocation =context.getResources().getString(R.string.moustafa);
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<" + myLatitude  + ">,<" + myLongitude + ">?q=<" + myLatitude  + ">,<" + myLongitude + ">(" + labelLocation + ")"));
                    context.startActivity(intent);
                }
            });
            ratingBar = itemView.findViewById(R.id.ratingBar);
            RateBtn   =itemView.findViewById(R.id.RateBtn);
            RateBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dataPass = (OnDataPass) context;
                    Pass("openRate");
                }
            });
        }

        public void Pass(String data){
            dataPass.onDataPass(data);
        }
    }
}
