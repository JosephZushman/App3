package com.example.aleksej.budget;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.BudgetViewHolder> {
   private ArrayList<budget> mList;
    public static class BudgetViewHolder extends RecyclerView.ViewHolder{
        public TextView textView1;
        public TextView textView2;

        public BudgetViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.text1);
            textView2 = itemView.findViewById(R.id.text2);
        }
    }

    public adapter(ArrayList<budget> list){
        mList = list;
    }

    @NonNull
    @Override
    public BudgetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.budget_item, viewGroup, false);
        BudgetViewHolder bvh = new BudgetViewHolder(v);
        return bvh;
    }

    @Override
    public void onBindViewHolder(@NonNull BudgetViewHolder holder, int i) {
        budget bug = mList.get(i);

        holder.textView1.setText(bug.toString());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


}
