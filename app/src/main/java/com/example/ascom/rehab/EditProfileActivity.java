package com.example.ascom.rehab;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ascom.rehab.fragments.MAp_Dialog;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class EditProfileActivity extends AppCompatActivity {

    ImageView ivimage;
    ImageView ibgallery;
    Button btnupdate;
    EditText etfname;
    EditText etlname;
    EditText etemail;
    TextView PinLocation  , ChangePassword;
    private int REQUEST_LOAD_IMG1 = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        initiation();
        Actionbar();
    }

    private void initiation() {
        ChangePassword = findViewById(R.id.ChangePassword);
        ChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           Intent intent  = new Intent(EditProfileActivity.this , ResetPassword.class);
           startActivity(intent);
            }
        });
        ivimage = (ImageView) findViewById(R.id.epivimage);
        ibgallery = findViewById(R.id.epibgallery);
        ibgallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, REQUEST_LOAD_IMG1);
            }
        });
        btnupdate = (Button) findViewById(R.id.epbtnupdate);
        PinLocation= (TextView) findViewById(R.id.pinCurrentLocation);
        PinLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MAp_Dialog mAp_dialog = new MAp_Dialog();
                mAp_dialog.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Light_Panel);
                mAp_dialog.show(getSupportFragmentManager() , "Dialog");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
        if(requestCode == 3 ){
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                ivimage.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(EditProfileActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }
        }
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
                Intent intent = new Intent(EditProfileActivity.this ,HomeDoctor.class);
                startActivity(intent);
            }
        });
    }

}
