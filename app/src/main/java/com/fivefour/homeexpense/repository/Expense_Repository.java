package com.fivefour.homeexpense.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.fivefour.homeexpense.db.Expense;
import com.fivefour.homeexpense.db.Expense_Dao;
import com.fivefour.homeexpense.db.Expense_Database;

import java.util.List;

public class Expense_Repository {
    private Expense_Dao expense_dao;
    private LiveData<List<Expense>> allExpense;
    private List<Expense> allexpensecount;

    public Expense_Repository(Application application) {
        Expense_Database database = Expense_Database.getInstance(application);
        expense_dao = database.expense_dao();
        allExpense = expense_dao.getAllExpense();
    }


   /* public Boolean checkdbsize(Application application) {
        Expense_Database database = Expense_Database.getInstance( application);
        expense_dao = database.expense_dao();

        allexpensecount = expense_dao.getalldatacount();



        if (allexpensecount == null) {

            return true;
        }else {
            return false;
        }

    }*/


    public void insert(Expense expense) {
        new InsertExpesneAsyncTASK(expense_dao).execute(expense);

    }

    //update
    public void update(Expense expense) {
        new UpdateExpesneAsyncTASK(expense_dao).execute(expense);

    }

    public void delete(Expense expense) {

        new DeleteExpesneAsyncTASK(expense_dao).execute(expense);
    }

    public void deleteAllNotes() {
        new DeleteAllNotesAsyncTask(expense_dao).execute();
    }


    public LiveData<List<Expense>> getAllExpense() {

        return allExpense;
    }

    public List<Expense> getAllexpensecount() {

        return allexpensecount;
    }


    // Insert asyncTask
    private static class InsertExpesneAsyncTASK extends AsyncTask<Expense, Void, Void> {

        private Expense_Dao expense_dao;

        private InsertExpesneAsyncTASK(Expense_Dao expense_dao) {

            this.expense_dao = expense_dao;

        }

        @Override
        protected Void doInBackground(Expense... expenses) {
            expense_dao.insert(expenses[0]);
            return null;
        }
    }

    // Update AsyncTask
    private static class UpdateExpesneAsyncTASK extends AsyncTask<Expense, Void, Void> {

        private Expense_Dao expense_dao;

        private UpdateExpesneAsyncTASK(Expense_Dao expense_dao) {

            this.expense_dao = expense_dao;

        }

        @Override
        protected Void doInBackground(Expense... expenses) {
            expense_dao.update(expenses[0]);
            return null;
        }
    }

    private static class DeleteExpesneAsyncTASK extends AsyncTask<Expense, Void, Void> {

        private Expense_Dao expense_dao;

        private DeleteExpesneAsyncTASK(Expense_Dao expense_dao) {

            this.expense_dao = expense_dao;
        }

        @Override
        protected Void doInBackground(Expense... expenses) {
            expense_dao.delete(expenses[0]);
            return null;
        }
    }


    //delete all data
    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void> {
        private Expense_Dao expense_dao;

        private DeleteAllNotesAsyncTask(Expense_Dao expense_dao) {
            this.expense_dao = expense_dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            expense_dao.deleteAllNotes();
            return null;
        }
    }
}
