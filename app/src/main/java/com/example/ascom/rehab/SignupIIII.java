package com.example.ascom.rehab;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class SignupIIII extends AppCompatActivity {

    EditText key ;
    TextView resend ;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_iiii);
        initialization();
        Actionbar();
    }


    public  void initialization(){
        key = findViewById(R.id.key);
        resend = findViewById(R.id.resend);
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignupIIII.this, "Thank you for Register", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignupIIII.this , HomeActivity.class);
                startActivity(intent);
            }
        });

    }

    public void Actionbar(){
        getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(45,67,91)));
        View view =getSupportActionBar().getCustomView();

        ImageView imageView = view.findViewById(R.id.img_return);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupIIII.this , SignupIII.class);
                startActivity(intent);
            }
        });

        ImageView imageView2 = view.findViewById(R.id.btn_left);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignupIIII.this, "Logo Clicked !", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
