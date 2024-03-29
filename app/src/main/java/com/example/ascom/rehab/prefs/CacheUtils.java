package com.example.ascom.rehab.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import asia.fivejuly.securepreferences.SecurePreferences;

public class CacheUtils {

    private static final String ENCRYPT_KEY = "rehab@742mhfs9$", PREFS_FILE = "rehab_prefs";

    @NonNull
    public static SharedPreferences getSharedPreferences(Context context) {
        return new SecurePreferences.Builder(context)
                .password(ENCRYPT_KEY)
                .filename(PREFS_FILE)
                .build();
    }

    public static String getUser(Context context,String key){
        String user = getSharedPreferences(context).getString(key, null);
        if (user==null){
            return null;
        }
        return user;
    }

    public static String getUserId(Context context,String key){
        String user = getSharedPreferences(context).getString(key, null);
        String id=null;
        if (user==null){
            return null;
        }
        try {
            id= new JSONObject(user).getString("id");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (id==null){
            return null;
        }
        return id;
    }

    public static String getUserName(Context context,String key){
        String user = getSharedPreferences(context).getString(key, null);
        String name=null;
        if (user==null){
            return null;
        }
        try {
            name= new JSONObject(user).getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (name==null){
            return null;
        }
        return name;
    }

    public static String getUserPhone(Context context,String key){
        String user = getSharedPreferences(context).getString(key, null);
        String phone=null;
        if (user==null){
            return null;
        }
        try {
            phone= new JSONObject(user).getString("phone");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (phone==null){
            return null;
        }
        return phone;
    }

    public static String getUserPhoto(Context context,String key){
        String user = getSharedPreferences(context).getString(key, null);
        String photo=null;
        if (user==null){
            return null;
        }
        try {
            photo= new JSONObject(user).getString("photo");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (photo==null){
            return null;
        }
        return photo;
    }

    public static String getUserEmail(Context context,String key){
        String user = getSharedPreferences(context).getString(key, null);
        String rate=null;
        if (user==null){
            return null;
        }
        try {
            rate= new JSONObject(user).getString("email");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (rate==null){
            return null;
        }
        return rate;
    }

    public static String getUserToken(Context context,String key){
        String user = getSharedPreferences(context).getString(key, null);
        String token=null;
        if (user==null){
            return null;
        }
        try {
            token= new JSONObject(user).getString("token");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (token==null){
            return null;
        }
        return token;
    }
}
