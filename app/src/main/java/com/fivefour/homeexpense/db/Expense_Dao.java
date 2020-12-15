package com.fivefour.homeexpense.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Expense_Dao {

  //  @Query(" SELECT * FROM expense_table ")
  //  List<Expense> getAll();

    @Insert
    Void insert(Expense expense);

    @Update
    Void update(Expense expense);

    @Delete
    void delete(Expense expense);

    @Query(" SELECT * FROM expense_table WHERE id = :expenseId")
    Expense getExpenseById (int expenseId);

    @Query("SELECT * FROM expense_table ")
    LiveData<List<Expense>> getAllExpense();
}
