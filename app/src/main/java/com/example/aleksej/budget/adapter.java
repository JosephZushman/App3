package com.example.aleksej.budget;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.BudgetViewHolder> {
   private ArrayList<budget> mList;
   private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class BudgetViewHolder extends RecyclerView.ViewHolder{
        public TextView textView1;
        public TextView textView2;
        public ImageView mDeleteImage;

        public BudgetViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.text1);
            textView2 = itemView.findViewById(R.id.text2);
            mDeleteImage = itemView.findViewById(R.id.image_delete);

            mDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

    public adapter(ArrayList<budget> list){
        mList = list;
    }

    @NonNull
    @Override
    public BudgetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.budget_item, viewGroup, false);
        BudgetViewHolder bvh = new BudgetViewHolder(v, mListener);
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
