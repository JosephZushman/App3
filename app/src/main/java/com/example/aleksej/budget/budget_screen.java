package com.example.aleksej.budget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class budget_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_screen);

        Intent intent = getIntent();
        budget budget = intent.getParcelableExtra("Budget");

        String name = budget.getName();
        Double b = budget.getBudget();

        TextView textView1 = findViewById(R.id.textView2);
        textView1.setText(name);

        TextView textView2 = findViewById(R.id.textView3);
        String str = "$" + b;
        textView2.setText(str);
    }
}
