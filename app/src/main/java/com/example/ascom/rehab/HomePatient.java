package com.example.ascom.rehab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ascom.rehab.adaptors.SearchResult_Adaptor;
import com.example.ascom.rehab.customDialogs.Dialogs;
import com.example.ascom.rehab.fragments.AppointmentsFragment;
import com.example.ascom.rehab.interfaces.OnDataPass;
import com.example.ascom.rehab.models.Result;
import com.google.android.gms.instantapps.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

public class HomePatient extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView ;
    List<Result> resultList = new ArrayList<>();
    SearchResult_Adaptor resultAdaptor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_patient);
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

          recyclerView = findViewById(R.id.SearchResult_Recycler);
          resultAdaptor = new SearchResult_Adaptor(this, resultList);
          recyclerView.setLayoutManager(new LinearLayoutManager(this));
          recyclerView.setAdapter(resultAdaptor);
          prepareMovieData();




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
        getMenuInflater().inflate(R.menu.home_patient, menu);
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
            Intent intent = new Intent(HomePatient.this , HomeActivity.class);
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
            Intent intent = new Intent(HomePatient.this , HomeActivity.class);
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

        private void prepareMovieData() {
        Result favourite = new Result(String.valueOf(R.drawable.profile),
                getResources().getString(R.string.moustafa1) ,
                getResources().getString(R.string.job1),
                "5",
                getResources().getString(R.string.desc));
        resultList.add(favourite);

            Result favourite2 = new Result(String.valueOf(R.drawable.profile),
                    getResources().getString(R.string.moustafa1) ,
                    getResources().getString(R.string.job1),
                    "5",
                    getResources().getString(R.string.desc));
            resultList.add(favourite2);


            Result favourite3 = new Result(String.valueOf(R.drawable.profile),
                    getResources().getString(R.string.moustafa1) ,
                    getResources().getString(R.string.job1),
                    "5",
                    getResources().getString(R.string.desc));
            resultList.add(favourite3);


            Result favourite4 = new Result(String.valueOf(R.drawable.profile),
                    getResources().getString(R.string.moustafa1) ,
                    getResources().getString(R.string.job1),
                    "5",
                    getResources().getString(R.string.desc));
            resultList.add(favourite4);

            Result favourite5 = new Result(String.valueOf(R.drawable.profile),
                    getResources().getString(R.string.moustafa1) ,
                    getResources().getString(R.string.job1),
                    "5",
                    getResources().getString(R.string.desc));
            resultList.add(favourite5);

    }

}
