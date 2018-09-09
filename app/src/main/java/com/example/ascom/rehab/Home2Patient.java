package com.example.ascom.rehab;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ascom.rehab.customDialogs.Dialogs;

public class Home2Patient extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button btnbook;
    Button btncall , btnMsg;
    TextView RateTV , AddressTV ,textCertificate ;
    ImageView like ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2_patient);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        btnbook = findViewById(R.id.book);
        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home2Patient.this , Home3Patient.class);
                startActivity(intent);
            }
        });

        RateTV = findViewById(R.id.RateTV);
        RateTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home2Patient.this , RatesActivity.class);
                startActivity(intent);
            }
        });

        btncall = findViewById(R.id.btnCall);
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "+34666777888";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });

        btnMsg = findViewById(R.id.BtnMsg);
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "12346556";  // The number on which you want to send SMS
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));
            }
        });
        like = findViewById(R.id.heart);
        like.setOnClickListener(new View.OnClickListener() {

            private  boolean fun = true;
            @Override
            public void onClick(View v) {
                if(fun){
                    like.setImageResource(R.drawable.like_black);
                    fun = false;
                }else {
                    fun = true;
                    like.setImageResource(R.drawable.like);
                    Toast.makeText(getApplicationContext(), "Changed", Toast.LENGTH_LONG).show();
                }
            }
        });

        AddressTV = findViewById(R.id.AddressTV);
        AddressTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double myLatitude = 30.5605;
                Double myLongitude = 31.0079;
                @SuppressLint("ResourceType")
                String labelLocation =getResources().getString(R.string.moustafa);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<" + myLatitude  + ">,<" + myLongitude + ">?q=<" + myLatitude  + ">,<" + myLongitude + ">(" + labelLocation + ")"));
                startActivity(intent);
            }
        });
        textCertificate = findViewById(R.id.textCertificate);
        textCertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowImageDiakog(true);
            }
        });
    }


        public void showCustomDialog2(boolean status) {
            final Dialog myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.custom_dialog2);
        Button button = myDialog.findViewById(R.id.makeRate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home2Patient.this, "thanks alot ", Toast.LENGTH_SHORT).show();
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        if (status) {
            myDialog.show();
        }else {
            myDialog.dismiss();
        }
    }

    public  void ShowImageDiakog(boolean State){
        final  Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_image_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button button = dialog.findViewById(R.id.close);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        if(State){
            dialog.show();
        }else {
            dialog.dismiss();
        }

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home2_patient, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.back) {
            Intent intent = new Intent(Home2Patient.this , HomePatient.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.my_account) {
            // Handle the camera action
        } else if (id == R.id.the_mail) {
            Intent intent = new Intent(this , TheMesseges_Activity.class );
            startActivity(intent);

        } else if (id == R.id.my_appointments) {
            Intent intent = new Intent(Home2Patient.this , HomeActivity.class);
            intent.putExtra("openF3" ,"openF3");
            startActivity(intent);

        } else if (id == R.id.the_payment) {
            Dialogs.showCustomDialogPaymentPatient(true , this);

        } else if (id == R.id.the_setting) {

        } else if (id == R.id.exit) {
            finish();
            System.exit(0);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
