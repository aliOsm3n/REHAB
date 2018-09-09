package com.example.ascom.rehab;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
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
import android.widget.Toast;

import com.example.ascom.rehab.customDialogs.Dialogs;
import com.example.ascom.rehab.interfaces.OnDataPass;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,OnDataPass {

    final int[] ICONS = new int[]{
            R.drawable.checked,
            R.drawable.heart,
            R.drawable.clock_white};

    TabLayout tbl_pages ;
    String state;
    Intent intent ;
    ViewPager vp_pages ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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




        vp_pages = (ViewPager) findViewById(R.id.vp_pages);
        PagerAdapter pagerAdapter=new FragmentAdapter(getSupportFragmentManager() , this);
        vp_pages.setAdapter(pagerAdapter);

        tbl_pages= (TabLayout) findViewById(R.id.tbl_pages);
        tbl_pages.setupWithViewPager(vp_pages);
        tbl_pages.getTabAt(0).setIcon(ICONS[0]);
        tbl_pages.getTabAt(1).setIcon(ICONS[1]);
        tbl_pages.getTabAt(2).setIcon(ICONS[2]);

        openFragmentAppointment();

    }

    private void openFragmentAppointment() {

        String GetData = getIntent().getStringExtra("openF3");
        if(GetData!=null){
            if (GetData.equals("openF3")){
                vp_pages.setCurrentItem(2);
            }}
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onDataPass(String data) {

//        if(data == "B"){
//            Log.d("LOG","hello " + data);
//            tbl_pages.setVisibility(View.GONE);
//            state = "tr";
//            invalidateOptionsMenu();
//            Fragment fragment = new DetailsBookFragment();
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame, fragment,
//                    fragment.getClass().getSimpleName()).addToBackStack(null).commit();
//        }
        if(data == "A") {
            Log.d("LOG","hello " + data);
//            tbl_pages.setVisibility(View.GONE);
//            state = "tr";
//            invalidateOptionsMenu();
//            Fragment fragment = new SearchResultFragment();
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame, fragment,
//                    fragment.getClass().getSimpleName()).addToBackStack(null).commit();
            Intent intent = new Intent(HomeActivity.this , HomePatient.class);
            startActivity(intent);
        }
//        else if(data == "C"){
//            Log.d("LOG","hello " + data);
//            tbl_pages.setVisibility(View.GONE);
//            state = "tr";
//            invalidateOptionsMenu();
//            Fragment fragment = new TimesDoctorFragment();
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame, fragment,
//                    fragment.getClass().getSimpleName()).addToBackStack(null).commit();
//
//        }
        if(data == "openRate"){
            showCustomDialogRate(true);
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
        getMenuInflater().inflate(R.menu.home, menu);
        if(state == "tr"){
            menu.getItem(0).setVisible(false);
        }
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
            Toast.makeText(this, "back clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.logo){
            Toast.makeText(this, "logo Clicked", Toast.LENGTH_SHORT).show();
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
        }
        else if (id == R.id.the_mail) {
            Intent intent = new Intent(this , TheMesseges_Activity.class );
            startActivity(intent);
        }
        else if (id == R.id.my_appointments) {

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

    public void showCustomDialogRate(boolean status) {
        final Dialog myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.custom_dialog2);
        Button button = myDialog.findViewById(R.id.makeRate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "thanks alot ", Toast.LENGTH_SHORT).show();
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

}
