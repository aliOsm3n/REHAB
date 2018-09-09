package com.example.ascom.rehab;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ascom.rehab.adaptors.ButtonAdapter;
import com.example.ascom.rehab.customDialogs.Dialogs;
import com.example.ascom.rehab.fragments.MyDatePickerFragment;
import com.example.ascom.rehab.interfaces.callMethod;
import com.google.android.gms.maps.MapFragment;
import com.android.datetimepicker.date.DatePickerDialog;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.text.DateFormat;
import java.util.Locale;

public class Home3Patient extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,callMethod ,  DatePickerDialog.OnDateSetListener{
    @Override
    public void call(int pos) {
        showCustomDialog(true);
       // Toast.makeText(this, ""+pos, Toast.LENGTH_SHORT).show();
    }

    TextView DatepickerTV ;
    TextView txtRate , addressTX ;
    private Calendar calendar;
    private DateFormat dateFormat;
    GridView gridView;
    ButtonAdapter buttonAdapter ;
    List<String> lists = new ArrayList<>();
    ImageView imageView ;

    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home3_patient);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        calendar = Calendar.getInstance();
        dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        putData();

        myDialog = new Dialog(this);

        buttonAdapter = new ButtonAdapter(getBaseContext() , lists);
        buttonAdapter.setCon(Home3Patient.this);
//        textView = findViewById(R.id.thisDay);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DialogFragment newFragment = new MyDatePickerFragment();
//                newFragment.show(getSupportFragmentManager(), "date picker");
//            }
//        });

        txtRate = findViewById(R.id.txRate);
        txtRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home3Patient.this , RatesActivity.class);
                startActivity(intent);
            }
        });

        gridView = (GridView) findViewById(R.id.gridView2);
        gridView.setAdapter(buttonAdapter);

        addressTX = findViewById(R.id.addressTX);
        addressTX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Fragment fragment = new MapFragment();
//                FragmentManager manager = getFragmentManager();
//                FragmentTransaction transaction = manager.beginTransaction();
//                transtioaction.replace(R.id.Frame3layout,fragment);
//                transacn.addToBackStack(null);
//                transaction.commit();
                Double myLatitude = 30.5605;
                Double myLongitude = 31.0079;
                @SuppressLint("ResourceType")
                String labelLocation =getResources().getString(R.string.moustafa);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<" + myLatitude  + ">,<" + myLongitude + ">?q=<" + myLatitude  + ">,<" + myLongitude + ">(" + labelLocation + ")"));
                startActivity(intent);

            }
        });

        DatepickerTV = findViewById(R.id.thisDay);
        DatepickerTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.newInstance(Home3Patient.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show(getFragmentManager(), "datePicker");
             //   Toast.makeText(Home3Patient.this, ""+ calendar.get(Calendar.MONTH) + " -" + calendar.get(Calendar.DAY_OF_MONTH) , Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void showCustomDialog(boolean status) {

        myDialog.setContentView(R.layout.custom_dialog1);
        Button button = myDialog.findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog(false);
                Toast.makeText(Home3Patient.this, "Done Already !" , Toast.LENGTH_SHORT).show();
              //  showCustomDialog2(true);
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        if (status) {
            myDialog.show();
        }else {
            myDialog.dismiss();
        }
    }


//    public void showCustomDialog2(boolean status) {
//
//        myDialog.setContentView(R.layout.custom_dialog2);
//        Button button = myDialog.findViewById(R.id.makeRate);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(Home3Patient.this, "thanks alot ", Toast.LENGTH_SHORT).show();
//            }
//        });
//        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        if (status) {
//            myDialog.show();
//        }else {
//            myDialog.dismiss();
//        }
//    }

    private void putData() {
        lists.add("7:00 م");
        lists.add("8:00 م");
        lists.add("9:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
        lists.add("7:00 م");
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
        getMenuInflater().inflate(R.menu.home3_patient, menu);
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
            Intent intent = new Intent(Home3Patient.this , Home2Patient.class);
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
            Intent intent = new Intent(Home3Patient.this , HomeActivity.class);
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

    @Override
    public void onDateSet(DatePickerDialog dialog, int year, int monthOfYear, int dayOfMonth) {
        calendar.set(year, monthOfYear, dayOfMonth);
        update();
    }

    private void update() {
        DatepickerTV.setText(dateFormat.format(calendar.getTime()));
        Toast.makeText(this, "" + dateFormat.format(calendar.getTime()), Toast.LENGTH_SHORT).show();
    }

}
