package com.fivefour.homeexpense.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.fivefour.homeexpense.db.Expense;
import com.fivefour.homeexpense.repository.Expense_Repository;

import java.util.List;

public class Expense_VIewModel extends AndroidViewModel {

    private Expense_Repository repository;
    private LiveData<List<Expense>> allExpense;
    public Expense_VIewModel(@NonNull Application application) {
        super(application);
        repository = new Expense_Repository(application);
        allExpense=repository.getAllExpense();
    }

    public void insert(Expense expense){
        repository.insert(expense);
    }

    public LiveData<List<Expense>> getAllExpense() {
        return allExpense;
    }
}
