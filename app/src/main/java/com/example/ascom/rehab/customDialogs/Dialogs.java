package com.example.ascom.rehab.customDialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ascom.rehab.HomeActivity;
import com.example.ascom.rehab.R;
import com.example.ascom.rehab.interfaces.CallDialog;

public class Dialogs {

     public static CallDialog callDialog ;


    public static void showCustomDialogPaymentPatient(boolean status, final Context context) {
        final Dialog myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.custom_dialog_patient_pay);
        Button addBalance = myDialog.findViewById(R.id.addBalanceBtn);
        addBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "thanks alot ", Toast.LENGTH_SHORT).show();
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

    public static void showCustomDialogPaymentDoctor(boolean status, final Context context) {
        final Dialog myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.custom_dialog_doctor_payment);
        Button payBill = myDialog.findViewById(R.id.pay_the_bill_Btn);
        payBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDialog = (CallDialog) context ;
                callDialog.onCallDialog("openSecondActivity");
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


    public static void showCustomDialogPaymentDoctorNext(boolean status, final Context context) {
        final Dialog myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.custem_dialog_second_doctor_payment);
//        Button addBalance = myDialog.findViewById(R.id.addBalanceBtn);
//        addBalance.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "thanks alot ", Toast.LENGTH_SHORT).show();
//                myDialog.dismiss();
//            }
//        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        if (status) {
            myDialog.show();
        }else {
            myDialog.dismiss();
        }
    }
}
