package com.example.aleksej.budget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import java.lang.String;
import java.util.*;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class secondScreen extends AppCompatActivity {
    final Context c = this;
    String s;
    double d;
    ArrayList<budget> list = new ArrayList<budget>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        Button addButton = (Button) findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            final LayoutInflater layoutInflaterAndriod = LayoutInflater.from(c);
            View v = layoutInflaterAndriod.inflate(R.layout.user_input_dialog_box, null);
            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
            alertDialogBuilderUserInput.setView(v);

            final EditText inputName = (EditText) v.findViewById(R.id.name);
            final EditText inputNumber = (EditText) v.findViewById(R.id.amount);



                alertDialogBuilderUserInput.setCancelable(false);
                alertDialogBuilderUserInput.setPositiveButton("Create", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            s = inputName.getText().toString();
                            d = Double.parseDouble(inputNumber.getText().toString());
                            budget b = new budget(s, d);
                            list.add(b);
                            System.out.println(list.toString());

                        } catch (NumberFormatException q) {
                            Toast.makeText(secondScreen.this, "Please Enter A Number in the Enter Amount", Toast.LENGTH_LONG).show();
                        }



                    }
                });
                alertDialogBuilderUserInput.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();
            }
        });
    }


}
