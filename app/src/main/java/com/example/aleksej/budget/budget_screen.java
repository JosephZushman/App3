package com.example.aleksej.budget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.*;

import java.text.DecimalFormat;

public class budget_screen extends AppCompatActivity {
    EditText amountSpent;
    private Button addAmountSpent;
    Double spentAmount =0.0;
    Double amount = 0.0;
    DecimalFormat df = new DecimalFormat("0.00");

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_screen);

        Intent intent = getIntent();
        final budget budget = intent.getParcelableExtra("Budget");

        String name = budget.getName();
        final Double b = budget.getBudget();

        TextView textView1 = findViewById(R.id.textView2);
        textView1.setText(name);

        final TextView textView2 = findViewById(R.id.textView3);
        String str = "Amount Budgeted $" + b;
        textView2.setText(str);

        amountSpent = findViewById(R.id.amountSpent);

        addAmountSpent = (Button)findViewById(R.id.setAmountSpent);
        addAmountSpent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    spentAmount = Double.parseDouble(amountSpent.getText().toString());
                    if (spentAmount < 0) {
                        Toast.makeText(budget_screen.this, "You cant do that!", Toast.LENGTH_LONG).show();
                    } else {
                        amount += spentAmount;
                        budget.setSpentAmount(amount);
                        final TextView textView3 = findViewById(R.id.textView4);
                        String str2 = "Amount Spent $" + df.format(budget.getSpentAmount());
                        textView3.setText(str2);
                        if (amount > b) {
                            textView2.setTextColor(Color.parseColor("#b71c1c"));
                            textView3.setTextColor(Color.parseColor("#b71c1c"));
                            Toast.makeText(budget_screen.this, "You have exceeded your budget!", Toast.LENGTH_LONG).show();
                        } else if (b > amount) {
                            textView2.setTextColor(Color.parseColor("#2e7d32"));
                            textView3.setTextColor(Color.parseColor("#2e7d32"));
                        }
                    }
                }
                catch (NumberFormatException e){
                    Toast.makeText(budget_screen.this, "You cant do that!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}