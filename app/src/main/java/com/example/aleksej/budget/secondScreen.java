package com.example.aleksej.budget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.*;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class secondScreen extends AppCompatActivity {
    final Context c = this;
    String s;
    double d;
    ArrayList<budget> arrayList = new ArrayList<budget>();
    RecyclerView recyclerView;
    adapter mAdapter;
    RecyclerView.LayoutManager manager = new LinearLayoutManager(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);


        Button addButton = findViewById(R.id.addButton);
        Button buttonSave = findViewById(R.id.saveButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        loadData();
        buildRecycleView();
    }

    public void add(){
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
                    arrayList.add(b);
                    System.out.println(arrayList.toString());

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

    private void saveData(){
        System.out.println("Enter save");
        SharedPreferences  sharedPreferences = getSharedPreferences("Shared Preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        editor.putString("Task List", json);
        System.out.println(json);
        editor.commit();
        System.out.println("Save executed");
    }

    private void loadData(){
        System.out.println("Enter load");
        SharedPreferences  sharedPreferences = getSharedPreferences("Shared Preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Task List", null);
        Type type = new TypeToken<ArrayList<budget>>() {}.getType();
        arrayList = gson.fromJson(json , type);
        System.out.println(json);
        if(arrayList == null){
            arrayList = new ArrayList<budget>();
            System.out.println("null list");
        }
        System.out.println("Load executed");
    }


    public void removeItem(int position){
        arrayList.remove(position);
        mAdapter.notifyItemChanged(position);
    }

    public void buildRecycleView(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        mAdapter = new adapter(arrayList);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            Intent intent = new Intent(secondScreen.this, budget_screen.class);
            intent.putExtra("Budget", arrayList.get(position));

            startActivity(intent);
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });

    }

}
