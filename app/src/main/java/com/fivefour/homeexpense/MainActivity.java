package com.fivefour.homeexpense;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.*;


import com.fivefour.homeexpense.adapter.Expense_Adapter;
import com.fivefour.homeexpense.db.Expense;
import com.fivefour.homeexpense.model.Expense_VIewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;


import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.DialogInterface.*;
import static androidx.appcompat.app.AlertDialog.*;
import static androidx.appcompat.app.AppCompatDelegate.*;
import static androidx.core.view.MenuItemCompat.*;
import static androidx.recyclerview.widget.ItemTouchHelper.*;
import static com.google.android.material.snackbar.Snackbar.*;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final int ADD_EXPENSE_REQUEST = 1;
    public static final int UPDATE_EXPENSE_REQUEST = 2;

    private boolean doubleBackToExitPressedOnce = false;


    DrawerLayout drawer;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    FloatingActionButton fab;
    RecyclerView recyclerView;
    Expense_VIewModel expense_vIewModel;
    Expense_Adapter expenseAdapter;
    private ArrayList<Expense> expenseArrayList;
    Dialog dialog;

    Boolean isNightModeOn;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPrefsEdit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("shareprefrence",0);
        sharedPrefsEdit = sharedPreferences.edit();
        isNightModeOn = sharedPreferences.getBoolean("NightMode",false);
        if (isNightModeOn){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        }

     
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Expense_Edit_calculation_Activity.class);
                startActivityForResult(intent, ADD_EXPENSE_REQUEST);


            }
        });


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        // navigation drawer hamburger icon color
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.purple_700));
        toggle.syncState();


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //RecyclerView
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        Expense_Adapter expenseAdapter = new Expense_Adapter();
        recyclerView.setAdapter(expenseAdapter);

        // animation rerun  when dataset changed



        expense_vIewModel = ViewModelProviders.of(this).get(Expense_VIewModel.class);
        expense_vIewModel.getAllExpense().observe(this, new Observer<List<Expense>>() {
            @Override
            public void onChanged(List<Expense> expenses) {
                //update recycler view
                expenseAdapter.updateExpenseon(expenses);
                //Toast.makeText(MainActivity.this, "onChanged", Toast.LENGTH_SHORT).show();
            }
        });


        new ItemTouchHelper(new SimpleCallback(0,
                LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

               /* new AlertDialog.Builder(MainActivity.this)
                        .setMessage("Delete Note?")
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                expense_vIewModel.delete(expenseAdapter.getExpenseAt(viewHolder.getAdapterPosition()));
                                expenseAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                recyclerView.getAdapter().notifyItemChanged(viewHolder.getAdapterPosition());


                            }
                        })
                        .setCancelable(false)
                        .create().show();*/
                dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.delete_confirm_layout);

               // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
               //     dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.delete_button));

             //   }
             //   dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);
                dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

                Button delete_ok_btn = dialog.findViewById(R.id.delete_ok_bt);
                Button delete_cancel_btn = dialog.findViewById(R.id.delete_cancel_bt);

                delete_ok_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        expense_vIewModel.delete(expenseAdapter.getExpenseAt(viewHolder.getAdapterPosition()));
                        expenseAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                    }
                });

                delete_cancel_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        recyclerView.getAdapter().notifyItemChanged(viewHolder.getAdapterPosition());
                        dialog.dismiss();
                    }
                });
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

            }

            //expense_vIewModel.delete(expenseAdapter.getExpenseAt(viewHolder.getAdapterPosition()));
            // Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();


        }).attachToRecyclerView(recyclerView);


        // recycler view item click listner implementing
        expenseAdapter.setOnItemClickListener(new Expense_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(Expense expense) {

                Intent intent = new Intent(MainActivity.this, Expense_Edit_calculation_Activity.class);

                intent.putExtra(Expense_Edit_calculation_Activity.key_id, expense.getId());
                intent.putExtra(Expense_Edit_calculation_Activity.key_year, expense.getYearmonth());
                intent.putExtra(Expense_Edit_calculation_Activity.key_one, expense.getExp_one());
                int chumma = expense.getExp_one();
                intent.putExtra(Expense_Edit_calculation_Activity.key_two, expense.getExp_two());
                intent.putExtra(Expense_Edit_calculation_Activity.key_three, expense.getExp_three());
                intent.putExtra(Expense_Edit_calculation_Activity.key_four, expense.getExp_four());
                intent.putExtra(Expense_Edit_calculation_Activity.key_five, expense.getExp_five());
                intent.putExtra(Expense_Edit_calculation_Activity.key_six, expense.getExp_six());
                intent.putExtra(Expense_Edit_calculation_Activity.key_seven, expense.getExp_seven());
                intent.putExtra(Expense_Edit_calculation_Activity.key_eight, expense.getExp_eight());
                intent.putExtra(Expense_Edit_calculation_Activity.key_nine, expense.getExp_nine());
                intent.putExtra(Expense_Edit_calculation_Activity.key_ten, expense.getExp_ten());
                intent.putExtra(Expense_Edit_calculation_Activity.key_eleven, expense.getExp_eleven());
                intent.putExtra(Expense_Edit_calculation_Activity.key_twelve, expense.getExp_twelve());
                intent.putExtra(Expense_Edit_calculation_Activity.key_thirteen, expense.getExp_thirteen());
                intent.putExtra(Expense_Edit_calculation_Activity.key_fourteen, expense.getExp_fourteen());
                intent.putExtra(Expense_Edit_calculation_Activity.key_fifteen, expense.getExp_fifteen());
                intent.putExtra(Expense_Edit_calculation_Activity.key_sixteen, expense.getExp_sixteen());
                intent.putExtra(Expense_Edit_calculation_Activity.key_seventeen, expense.getExp_seventeen());
                intent.putExtra(Expense_Edit_calculation_Activity.key_total, expense.getExp_total());
                startActivityForResult(intent, UPDATE_EXPENSE_REQUEST);
            }
        });


        // animation for recyclerview


    }


    // end of on create


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // int receive_one;
        if (requestCode == ADD_EXPENSE_REQUEST && resultCode == RESULT_OK) {

            /*int one =data.getIntExtra(Expense_calculation_Activity.key_one, 0);
            String onee = String.valueOf(one);
            if (onee.trim().isEmpty()) {
                receive_one = 1;
            }else{
             receive_one = data.getIntExtra(Expense_calculation_Activity.key_one, 0);
                Toast.makeText(MainActivity.this, receive_one+"haha", Toast.LENGTH_SHORT).show();}*/
            String receive_year = data.getStringExtra(Expense_Edit_calculation_Activity.key_year);
            int receive_one = data.getIntExtra(Expense_Edit_calculation_Activity.key_one, 0);
            int receive_two = data.getIntExtra(Expense_Edit_calculation_Activity.key_two, 0);
            int receive_three = data.getIntExtra(Expense_Edit_calculation_Activity.key_three, 0);
            int receive_four = data.getIntExtra(Expense_Edit_calculation_Activity.key_four, 0);
            int receive_five = data.getIntExtra(Expense_Edit_calculation_Activity.key_five, 0);
            int receive_six = data.getIntExtra(Expense_Edit_calculation_Activity.key_six, 0);
            int receive_seven = data.getIntExtra(Expense_Edit_calculation_Activity.key_seven, 0);
            int receive_eight = data.getIntExtra(Expense_Edit_calculation_Activity.key_eight, 0);
            int receive_nine = data.getIntExtra(Expense_Edit_calculation_Activity.key_nine, 0);
            int receive_ten = data.getIntExtra(Expense_Edit_calculation_Activity.key_ten, 0);
            int receive_eleven = data.getIntExtra(Expense_Edit_calculation_Activity.key_eleven, 0);
            int receive_twleve = data.getIntExtra(Expense_Edit_calculation_Activity.key_twelve, 0);
            int receive_thirteen = data.getIntExtra(Expense_Edit_calculation_Activity.key_thirteen, 0);
            int receive_fourteen = data.getIntExtra(Expense_Edit_calculation_Activity.key_fourteen, 0);
            int receive_fifteen = data.getIntExtra(Expense_Edit_calculation_Activity.key_fifteen, 0);
            int receive_sixteen = data.getIntExtra(Expense_Edit_calculation_Activity.key_sixteen, 0);
            int receive_seventeen = data.getIntExtra(Expense_Edit_calculation_Activity.key_seventeen, 0);
            int receive_total = data.getIntExtra(Expense_Edit_calculation_Activity.key_total, 0);


            Expense expense = new Expense(receive_year, receive_one, receive_two, receive_three, receive_four, receive_five, receive_six, receive_seven, receive_eight, receive_nine, receive_ten, receive_eleven, receive_twleve, receive_thirteen, receive_fourteen, receive_fifteen, receive_sixteen, receive_seventeen, receive_total);
            expense_vIewModel.insert(expense);
            //  Toast.makeText(this, "Added successfully", Toast.LENGTH_SHORT).show();


        } else if (requestCode == UPDATE_EXPENSE_REQUEST && resultCode == RESULT_OK) {

            int id = data.getIntExtra(Expense_Edit_calculation_Activity.key_id, -1);
            if (id == -1) {
                //  Toast.makeText(this, "Can't Update", Toast.LENGTH_SHORT).show();
                return;
            }

            String receive_year = data.getStringExtra(Expense_Edit_calculation_Activity.key_year);
            int receive_one = data.getIntExtra(Expense_Edit_calculation_Activity.key_one, 0);
            int receive_two = data.getIntExtra(Expense_Edit_calculation_Activity.key_two, 0);
            int receive_three = data.getIntExtra(Expense_Edit_calculation_Activity.key_three, 0);
            int receive_four = data.getIntExtra(Expense_Edit_calculation_Activity.key_four, 0);
            int receive_five = data.getIntExtra(Expense_Edit_calculation_Activity.key_five, 0);
            int receive_six = data.getIntExtra(Expense_Edit_calculation_Activity.key_six, 0);
            int receive_seven = data.getIntExtra(Expense_Edit_calculation_Activity.key_seven, 0);
            int receive_eight = data.getIntExtra(Expense_Edit_calculation_Activity.key_eight, 0);
            int receive_nine = data.getIntExtra(Expense_Edit_calculation_Activity.key_nine, 0);
            int receive_ten = data.getIntExtra(Expense_Edit_calculation_Activity.key_ten, 0);
            int receive_eleven = data.getIntExtra(Expense_Edit_calculation_Activity.key_eleven, 0);
            int receive_twleve = data.getIntExtra(Expense_Edit_calculation_Activity.key_twelve, 0);
            int receive_thirteen = data.getIntExtra(Expense_Edit_calculation_Activity.key_thirteen, 0);
            int receive_fourteen = data.getIntExtra(Expense_Edit_calculation_Activity.key_fourteen, 0);
            int receive_fifteen = data.getIntExtra(Expense_Edit_calculation_Activity.key_fifteen, 0);
            int receive_sixteen = data.getIntExtra(Expense_Edit_calculation_Activity.key_sixteen, 0);
            int receive_seventeen = data.getIntExtra(Expense_Edit_calculation_Activity.key_seventeen, 0);
            int receive_total = data.getIntExtra(Expense_Edit_calculation_Activity.key_total, 0);
            Expense expense = new Expense(receive_year, receive_one, receive_two, receive_three, receive_four, receive_five, receive_six, receive_seven, receive_eight, receive_nine, receive_ten, receive_eleven, receive_twleve, receive_thirteen, receive_fourteen, receive_fifteen, receive_sixteen, receive_seventeen, receive_total);
            expense.setId(id);
            expense_vIewModel.update(expense);
            //   Toast.makeText(this, "Updated successfully", Toast.LENGTH_SHORT).show();
        } else {

            //  Toast.makeText(this, "Something Wrong", Toast.LENGTH_SHORT).show();

        }
    }

  /*  @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            Builder alertDialogBuilder = new Builder(this, R.style.CustomDialogTheme);
            alertDialogBuilder.setTitle("Exit Application?");
            alertDialogBuilder
                    .setMessage("Click yes to exit!")
                    .setCancelable(false)
                    .setPositiveButton("Yes",
                            new OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    moveTaskToBack(true);
                                    android.os.Process.killProcess(android.os.Process.myPid());
                                    System.exit(1);
                                }
                            })

                    .setNegativeButton("No",
                            new OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    dialog.cancel();
                                }
                            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }*/


    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            Toast.makeText(this, "You are @ home", Toast.LENGTH_SHORT).show();
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
        } else if (id == R.id.nav_about) {
            show_about_dialog();

            return false;
        } else if (id == R.id.nav_contact) {

            show_contact_dialog();
            return false;

        } else if (id == R.id.nav_version) {
            Intent intent = new Intent(MainActivity.this, VersionActivity.class);
            startActivity(intent);
            return false;
        } else if (id == R.id.nav_settings) {
            show_settings_dialog();
            return false;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void show_contact_dialog() {
        dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_contact);
        dialog.show();
    }


    public void show_about_dialog() {
        dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_about);
        dialog.show();

    }

    public void show_settings_dialog() {

        dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.settings_layout);

        ImageButton imagebuttonn = dialog.findViewById(R.id.imagebutton);
        Button themechanger = dialog.findViewById(R.id.buttton);
        themechanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (isNightModeOn){

                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    sharedPrefsEdit.putBoolean("NightMode",false);
                    sharedPrefsEdit.apply();
                } else {
                    sharedPrefsEdit.putBoolean("NightMode",true);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    sharedPrefsEdit.apply();

                }


            }
        });



        imagebuttonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               //
                dialog.dismiss();
            }
        });
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();


    }
  /*  private void showEmptyView() {

        int uyu = expense.size();*/

       /* if (expense.size() < 0) {
            this.recyclerView.setVisibility(View.GONE);
            findViewById(R.id.openingImg).setVisibility(View.VISIBLE);

        } else {
            this.recyclerView.setVisibility(View.VISIBLE);
            findViewById(R.id.openingImg).setVisibility(View.GONE);
        }*/
   /*  if(uyu > 0)
     {
         this.recyclerView.setVisibility(View.GONE);
         findViewById(R.id.openingImg).setVisibility(View.VISIBLE);
     }else {
         this.recyclerView.setVisibility(View.VISIBLE);
         findViewById(R.id.openingImg).setVisibility(View.GONE);
     }*/



   private void  layoutAnimation(RecyclerView recyclerView){

        Context context = recyclerView.getContext();
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(context,R.anim.down_to_up);
        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();


       final LayoutAnimationController controller =
               AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_down_to_up);

       recyclerView.setLayoutAnimation(controller);
       recyclerView.getAdapter().notifyDataSetChanged();
       recyclerView.scheduleLayoutAnimation();
    }

}