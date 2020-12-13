package com.fivefour.homeexpense.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface Expense_Dao {

  //  @Query(" SELECT * FROM expense_table ")
  //  List<Expense> getAll();

    @Insert
    Void insert(Expense expense);
}
