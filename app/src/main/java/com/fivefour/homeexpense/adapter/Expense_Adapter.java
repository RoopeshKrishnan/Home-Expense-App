package com.fivefour.homeexpense.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.fivefour.homeexpense.R;
import com.fivefour.homeexpense.db.Expense;

import java.util.ArrayList;
import java.util.List;

import static android.view.animation.AnimationUtils.*;
import static android.widget.Toast.*;

public class Expense_Adapter extends RecyclerView.Adapter<Expense_Adapter.ExpenseHolder> {

    private List<Expense> expenses = new ArrayList<>();
    private OnItemClickListener listener;
    Context context;

    @NonNull
    @Override
    public ExpenseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expense_card_view, parent, false);
        return new ExpenseHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseHolder holder, int position) {

        //holder.container.setAnimation(AnimationUtils.loadAnimation(context, R.anim.layout_animation_down_to_up ));

        Expense currentExpense = expenses.get(position);
        holder.yearHolder.setText(currentExpense.getYearmonth());
        holder.totalHolder.setText(String.valueOf(currentExpense.getExp_total()));

        //holder.container.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition_animation));

    }

    @Override
    public int getItemCount() {
        int sizeof = expenses.size();

        return sizeof;

        //  return expenses.size();

    }

    // Update recycler view with each cahnges
    public void updateExpenseon(List<Expense> expenses) {

        this.expenses = expenses;
        notifyDataSetChanged();
    }

    // for item positions
    public Expense getExpenseAt(int position) {
        return expenses.get(position);
    }


    // ViewHolder
    class ExpenseHolder extends RecyclerView.ViewHolder {
        //CardView container;
        private TextView yearHolder;
        private TextView totalHolder;
        //LinearLayout anim_container;

        public ExpenseHolder(View itemView) {
            super(itemView);
            // anim_container = itemView.findViewById(R.id.linear_container);
            // container = itemView.findViewById(R.id.card_container);
            yearHolder = itemView.findViewById(R.id.holder_year);
            totalHolder = itemView.findViewById(R.id.holder_total);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(expenses.get(position));
                    }
                }
            });

        }
    }


    public interface OnItemClickListener {
        void onItemClick(Expense expense);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {

        this.listener = listener;

    }

}
