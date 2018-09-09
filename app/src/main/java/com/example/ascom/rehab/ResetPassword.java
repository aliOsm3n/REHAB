package com.example.ascom.rehab;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ResetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        Actionbar();
        initiation();
    }

    private void initiation() {
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
                Intent intent = new Intent(ResetPassword.this ,EditProfileActivity.class);
                startActivity(intent);
            }
        });
    }
    
    
}
