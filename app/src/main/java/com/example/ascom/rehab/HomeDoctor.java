package com.example.ascom.rehab;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.ascom.rehab.adaptors.ImagesCer_Adaptor;
import com.example.ascom.rehab.customDialogs.Dialogs;
import com.example.ascom.rehab.fragments.MyDatePickerFragment;
import com.example.ascom.rehab.interfaces.CallDialog;

import java.util.ArrayList;
import java.util.List;

public class HomeDoctor extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , CallDialog {

    final int[] ICONS = new int[]{
            R.drawable.user,
            R.drawable.alarm_clock,
            R.drawable.clock_white};

    TabLayout tblayout_pages ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_doctor);
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

        ViewPager vp_pages= (ViewPager) findViewById(R.id.vpager_pages);
        PagerAdapter pagerAdapter=new Fragment2Adapter(getSupportFragmentManager() , this);
        vp_pages.setAdapter(pagerAdapter);

        tblayout_pages= (TabLayout) findViewById(R.id.tblayout_pages);
        tblayout_pages.setupWithViewPager(vp_pages);
        tblayout_pages.getTabAt(0).setIcon(ICONS[0]);
        tblayout_pages.getTabAt(1).setIcon(ICONS[1]);
        tblayout_pages.getTabAt(2).setIcon(ICONS[2]);
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
        getMenuInflater().inflate(R.menu.home_doctor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

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

        } else if (id == R.id.the_payment) {
            Dialogs.showCustomDialogPaymentDoctor(true , this);

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
    public void onCallDialog(String data) {
        if(data == "Dialog1"){
            DialogFragment newFragment = new MyDatePickerFragment();
            newFragment.show(getSupportFragmentManager(), "date picker");
        }else if(data == "Dialog2"){
            showCustomDialogTimes(true);

        }else  if(data == "Dialog3"){
            showDialog3(true);
        }else  if(data == "DatePicker"){
            DialogFragment newFragment = new MyDatePickerFragment();
            newFragment.show(getSupportFragmentManager(), "date picker");
        }else  if (data == "open_Certificates"){
            ShowCertificatesDialog(true);
        }else  if (data == "MyRatesActivity"){
            ShowRatesActivity(true);
        }else if (data == "EditActivity"){
            Intent intent = new Intent(this ,EditProfileActivity.class);
            startActivity(intent);
        }else  if (data == "openSecondActivity"){
            Dialogs.showCustomDialogPaymentDoctorNext(true , this);
        }
    }

    public void showCustomDialogTimes(boolean status){
        final Dialog myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.my_times_list_item);
        Button btnclose = myDialog.findViewById(R.id.close);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

    public void showDialog3(boolean status){
        final Dialog myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.custom_dialog3);
        Button AddBookTime = myDialog.findViewById(R.id.addBookTime);
        AddBookTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeDoctor.this, "Done", Toast.LENGTH_SHORT).show();
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

    public  void  ShowCertificatesDialog(boolean state){
        List<Integer> list = new ArrayList();
        list.add(R.drawable.certificate_doctor);
        list.add(R.drawable.certificate_doctor);
        ImagesCer_Adaptor imagesCer_adaptor = new ImagesCer_Adaptor(list , this);
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_images_dialog);
        RecyclerView recyclerView = dialog.findViewById(R.id.Recycle_Image);
        recyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));
        recyclerView.setAdapter(imagesCer_adaptor);
        Button btnclose = dialog.findViewById(R.id.close);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        if(state){
            dialog.show();
        }else {
            dialog.dismiss();
        }
    }

    public  void  ShowRatesActivity(boolean state){
        Intent intent = new Intent(this , RatesActivity.class);
        startActivity(intent);
    }
}
