package com.example.ascom.rehab;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ascom.rehab.adaptors.Messege_Adaptor;
import com.example.ascom.rehab.models.Msg;

import java.util.ArrayList;
import java.util.List;

public class TheMesseges_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView listViewMessege ;
    List<Msg> messageList ;
    Messege_Adaptor messege_adaptor ;
    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_messeges_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        myDialog = new Dialog(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        messageList = new ArrayList<>();
        messege_adaptor = new Messege_Adaptor(messageList , this);
        listViewMessege = findViewById(R.id.ListMessgs);
        listViewMessege.setAdapter(messege_adaptor);
        listViewMessege.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        FillData();

    }

//    public void showCustomDialog3(boolean status) {
//
//        myDialog.setContentView(R.layout.custom_dialog4);
//        Button button = myDialog.findViewById(R.id.Replay);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showCustomDialog3(false);
//                showCustomDialog4(true);
//            }
//        });
//
//        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        if (status) {
//            myDialog.show();
//        }else {
//            myDialog.dismiss();
//        }
//    }


//    public void showCustomDialog4(boolean status) {
//
//        myDialog.setContentView(R.layout.custom_dialog5);
//        Button button = myDialog.findViewById(R.id.Send);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(TheMesseges_Activity.this, "Done Already !", Toast.LENGTH_SHORT).show();
//                myDialog.dismiss();
//            }
//        });
//        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        if (status) {
//            myDialog.show();
//        }else {
//            myDialog.dismiss();
//        }
//    }

    private void FillData() {
        Msg msg = new Msg(getResources().getString(R.string.marid_name) , getResources().getString(R.string.time_date) ,
                getResources().getString(R.string.desc));
        messageList.add(msg);

        msg = new Msg(getResources().getString(R.string.marid_name) , getResources().getString(R.string.time_date) ,
                getResources().getString(R.string.desc));
        messageList.add(msg);
        messege_adaptor.notifyDataSetChanged();
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
        getMenuInflater().inflate(R.menu.the_messeges_, menu);
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
            Toast.makeText(this, "You Already on Messeges !", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.my_appointments) {

        } else if (id == R.id.the_payment) {

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
