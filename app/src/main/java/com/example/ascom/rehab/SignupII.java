package com.example.ascom.rehab;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.ascom.rehab.prefs.CacheUtils;
import com.example.ascom.rehab.util.AppUtils;

public class SignupII extends AppCompatActivity {

    EditText username , phonenum , email , password ;
    Button next;
    String PersonType = "" ;

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        PersonType = intent.getStringExtra("PersonType");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_ii);
        initialization();
        Actionbar();
    }

    public  void initialization(){
        username = findViewById(R.id.usernameEd);
        phonenum = findViewById(R.id.phoneEd);
        email = findViewById(R.id.emailEd);
        password = findViewById(R.id.passEd);
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.equals("") || phonenum.equals("") || email.equals("") || password.equals("")){
                    AppUtils.showInfoDialog(SignupII.this , R.string.CheckAllData);
                }else if(PersonType.equals("Patient")){
                    Intent intent = new Intent(SignupII.this , SignupIIII.class);
                    startActivity(intent);
                }else if(PersonType.equals("Doctor")){
                    Intent intent = new Intent(SignupII.this , SignupIII.class);
                    startActivity(intent);
                }
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
                Intent intent = new Intent(SignupII.this ,SignupI.class);
                startActivity(intent);
            }
        });

        ImageView imageView2 = view.findViewById(R.id.btn_left);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignupII.this, "Logo Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
