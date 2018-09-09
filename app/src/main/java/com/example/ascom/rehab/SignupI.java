package com.example.ascom.rehab;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.ascom.rehab.util.AppUtils;

public class SignupI extends AppCompatActivity {

    Button marid , tabib , next ;
    String PersonType = "" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_i);
        initialization();
        Actionbar();
    }

    public  void initialization(){
        marid = findViewById(R.id.marid);
        marid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonType = "Patient";
                Toast.makeText(SignupI.this, ""+ getResources().getString(R.string.welcom), Toast.LENGTH_SHORT).show();
            }
        });
        tabib = findViewById(R.id.tabib);
        tabib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonType = "Doctor";
                Toast.makeText(SignupI.this, ""+ getResources().getString(R.string.welcom), Toast.LENGTH_SHORT).show();
            }
        });
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(PersonType.equals("")){
                    AppUtils.showInfoDialog(SignupI.this,R.string.ChooseType);
                }else if (PersonType.equals("Patient")){
                    Intent intent  = new Intent(SignupI.this , SignupII.class);
                    intent.putExtra("PersonType" , PersonType);
                    startActivity(intent);
                }else if(PersonType.equals("Doctor")){
                    Intent intent  = new Intent(SignupI.this , SignupII.class);
                    intent.putExtra("PersonType" , PersonType);
                    startActivity(intent);
                }

            }
        });
    }


    public  void Actionbar(){
        getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar2);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(45,67,91)));
        View view =getSupportActionBar().getCustomView();

        ImageView imageView = view.findViewById(R.id.img_return);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(SignupI.this ,loginActivity.class);
               startActivity(intent);
            }
        });
    }





}
