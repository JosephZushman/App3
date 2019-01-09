package com.example.aleksej.budget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class budget_screen extends AppCompatActivity {
    EditText amountSpent;
    private Button addAmountSpent;
    Double amountSpentNum = 0.0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_screen);

        Intent intent = getIntent();
        budget budget = intent.getParcelableExtra("Budget");

        /*String name = budget.getName();
        Double b = budget.getBudget();

        TextView textView1 = findViewById(R.id.textView2);
        textView1.setText(name);

        TextView textView2 = findViewById(R.id.textView3);
        String str = "$" + b;
        textView2.setText(str);
        amountSpent = findViewById(R.id.amountSpent);*/

        addAmountSpent = (Button)findViewById(R.id.setAmountSpent);
        addAmountSpent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Hello");
            }
        });

    }



}
