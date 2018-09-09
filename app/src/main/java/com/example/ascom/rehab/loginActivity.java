package com.example.ascom.rehab;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.example.ascom.rehab.prefs.CacheUtils;
import com.example.ascom.rehab.util.AppDialog;
import com.example.ascom.rehab.util.AppUtils;
import com.example.ascom.rehab.util.DialogUtils;
import com.example.ascom.rehab.view.CustomTextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class loginActivity extends Activity {
    EditText phone, password;
    Button login;
    TextView creatwAccount, ChangeLang;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inistiLization();
    }

    public void inistiLization() {

        phone = findViewById(R.id.phoneEDLogin);
        password = findViewById(R.id.passwordEDLogin);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        creatwAccount = findViewById(R.id.createAccount);
        creatwAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Create_new_Acount();
            }
        });
        ChangeLang = findViewById(R.id.ChangeLang);
        ChangeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Show_Change_Dialog();
            }
        });
    }
    public  void  Create_new_Acount(){
        if (AppUtils.isInternetAvailable(this)){
            Intent intent = new Intent(loginActivity.this, SignupI.class);
            startActivity(intent);
            }else {
            AppUtils.showInfoDialog(loginActivity.this,R.string.CheckInternetConnection);
            //Show_Custom_Toast(this ,getResources().getString(R.string.CheckInternetConnection));
        }
    }

    public void signIn() {
        if (AppUtils.isInternetAvailable(this)) {
            loginUser();
        }else {
            AppUtils.showInfoDialog(loginActivity.this,R.string.CheckInternetConnection);
           // Show_Custom_Toast(this ,getResources().getString(R.string.CheckInternetConnection));
        }
    }

    public void Show_Custom_Toast(Context context , String text){
        LayoutInflater inflater = getLayoutInflater();
        View layouttoast = inflater.inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.toastcustom));
        ((TextView) layouttoast.findViewById(R.id.texttoast)).setText(text);

        Toast mytoast = new Toast(context);
        mytoast.setView(layouttoast);
        mytoast.setDuration(Toast.LENGTH_LONG);
        mytoast.show();
    }


    private void loginUser() {

        final String user_phone = phone.getText().toString();
        final String user_password = password.getText().toString();

        if (user_phone.equals("") || user_password.equals("")) {
            AppUtils.showInfoDialog(this, R.string.error_dialog_missing_inputs);
            return;
        }
        if (user_phone.equals("") && user_password.equals("")) {
            AppUtils.showInfoDialog(this, R.string.error_dialog_missing_inputs);
            return;
        }

        if (!AppUtils.isInternetAvailable(this)) {
            AppUtils.showNoInternetDialog(this);
            return;
        }

        AppUtils.showProgressDialog(this);

        AndroidNetworking.post("http://athelapps.com/phone/api/user/login")
                .addBodyParameter("phone", "966")
                .addBodyParameter("password", user_password)
                .addBodyParameter("device_id", "")
                .addBodyParameter("api_key", "BUNgDZlDqosZXWJtjYUgdx5aWbqKC2gr7wRxzVFh8Pg")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("login_Response", response);
                        try {

                            if (new JSONObject(response).getString("code").toString().equals("200")) {
                                saveUser(response);
                            } else if (new JSONObject(response).getString("code").toString().equals("401")) {
                                AppUtils.dismissProgressDialog();
                                AppUtils.showErrorToast(loginActivity.this, getString(R.string.error_dialog_user_not_found));
                            } else {
                                AppUtils.dismissProgressDialog();
                                AppUtils.showErrorToast(loginActivity.this, getString(R.string.error_dialog_user_not_found));
                            }
                        } catch (Exception e) {
                            AppUtils.dismissProgressDialog();
                            showCanNotLoadDataDialog();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        AppUtils.dismissProgressDialog();
                        showCanNotLoadDataDialog();
                    }
                });
    }

    private void saveUser(String response) {

        try {
            JSONObject save_object=new JSONObject();
            JSONObject rec_object = new JSONObject(response);
            JSONObject object = rec_object.getJSONObject("data");

            save_object.put("id",object.getString("id"));
            save_object.put("name",object.getString("name"));
            save_object.put("phone",object.getString("phone"));
            save_object.put("email",object.getString("email"));
            save_object.put("token",object.getString("token"));
            save_object.put("gender",object.getString("gender"));
            save_object.put("city",object.getString("city_id"));
            save_object.put("photo",object.getString("photo"));

            String user=save_object.toString();
            CacheUtils.getSharedPreferences(loginActivity.this).edit().putString("user", user).apply();
            AppUtils.dismissProgressDialog();
            startActivity(new Intent(loginActivity.this, HomeActivity.class));
            finish();
        } catch (JSONException e) {
        }

    }


        private void showCanNotLoadDataDialog(){
            DialogUtils.showTwoActionButtonsDialog(this, R.string.dialog_error_no_internet,
                    R.string.dialog_ok, new AppDialog.Action1ButtonListener() {
                        @Override
                        public void onAction1ButtonClick(Dialog dialog) {
                            dialog.dismiss();
                        }
                    }, R.string.dialog_cancel, new AppDialog.Action2ButtonListener() {
                        @Override
                        public void onAction2ButtonClick(Dialog dialog) {
                            finish();
                        }
                    }, false);
        }



    private void Show_Change_Dialog() {
        final String[] List_item = {"English", "Arabic"};
        AlertDialog.Builder builder = new AlertDialog.Builder(loginActivity.this);
        builder.setSingleChoiceItems(List_item, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    SetLocate("en");
                    recreate();
                }
                if (which == 1) {
                    SetLocate("ar");
                    recreate();
                    Log.e("afterNow", "language Arabic " );
                }
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    private void SetLocate(String lang) {
        Locale locale = new Locale(lang);
        locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());


        SharedPreferences.Editor editor = getSharedPreferences("strings", MODE_PRIVATE).edit();
        editor.putString("My_lang", lang);
        editor.apply();
    }

    public void LoadData() {
        SharedPreferences shr = getSharedPreferences("strings", MODE_PRIVATE);
        String s = shr.getString("My_lang", "");
        SetLocate(s);
    }
}
