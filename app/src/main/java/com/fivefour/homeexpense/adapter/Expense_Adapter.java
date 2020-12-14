package com.fivefour.homeexpense.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fivefour.homeexpense.R;
import com.fivefour.homeexpense.db.Expense;

import java.util.ArrayList;
import java.util.List;

public class Expense_Adapter extends RecyclerView.Adapter<Expense_Adapter.ExpenseHolder> {

    private List<Expense> expenses = new ArrayList<>();

    @NonNull
    @Override
    public ExpenseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expense_card_view, parent, false);
        return new ExpenseHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseHolder holder, int position) {
         Expense currentExpense = expenses.get(position);
         holder.yearHolder.setText(currentExpense.getYearmonth());
         holder.totalHolder.setText(String.valueOf(currentExpense.getExp_total()));

    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    class ExpenseHolder extends RecyclerView.ViewHolder {

        private TextView yearHolder;
        private TextView totalHolder;

        public ExpenseHolder(View itemView) {
            super(itemView);

            yearHolder = itemView.findViewById(R.id.holder_year);
            totalHolder = itemView.findViewById(R.id.holder_total);

        }
    }
}
