package com.fivefour.homeexpense.model;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.fivefour.homeexpense.db.Expense;
import com.fivefour.homeexpense.repository.Expense_Repository;

import java.util.List;

import static android.widget.Toast.*;

public class Expense_VIewModel extends AndroidViewModel {

    private Expense_Repository repository;
    private LiveData<List<Expense>> allExpense;

    public Expense_VIewModel(@NonNull Application application) {
        super(application);
        repository = new Expense_Repository(application);
        allExpense = repository.getAllExpense();

    }

    public void insert(Expense expense) {
        repository.insert(expense);
    }

    public void update(Expense expense) {
        repository.update(expense);
    }

    public void delete(Expense expense) {
        repository.delete(expense);
    }

    public LiveData<List<Expense>> getAllExpense() {
        return allExpense;
    }

    public void deleteAllNotes() {
        repository.deleteAllNotes();
    }

    public void getalldatacount() {
        repository.getAllexpensecount();
    }

   /* public Boolean checkdbsizebbbb() {
     return    repository.checkdbsize(getApplication());

    }*/
}



