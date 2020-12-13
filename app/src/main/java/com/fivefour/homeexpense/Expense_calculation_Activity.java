package com.fivefour.homeexpense;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import static android.view.WindowManager.*;
import static java.util.Locale.*;

public class Expense_calculation_Activity extends AppCompatActivity {
   public TextView putdate, getdate, cal, sum, display_tot;
   public EditText hp_1, hp_2, hp_3, hp_4, hp_5, hp_6, hp_7, hp_8, hp_9, hp_10, hp_11, hp_12, hp_13, hp_14, hp_15, hp_16, hp_17;
    Button okbutton;
    public DatePickerDialog.OnDateSetListener mDateSetListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_calculation);

        getWindow().setSoftInputMode(
                LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        home_expense_total();

        putdate = (TextView) findViewById(R.id.putdate);
        getdate = (TextView) findViewById(R.id.getdate);
        display_tot = (TextView) findViewById(R.id.exp_total);

        hp_1 = (EditText) findViewById(R.id.exp_1);
        hp_2 = (EditText) findViewById(R.id.exp_2);
        hp_3 = (EditText) findViewById(R.id.exp_3);
        hp_4 = (EditText) findViewById(R.id.exp_4);
        hp_5 = (EditText) findViewById(R.id.exp_5);
        hp_6 = (EditText) findViewById(R.id.exp_6);
        hp_7 = (EditText) findViewById(R.id.exp_7);
        hp_8 = (EditText) findViewById(R.id.exp_8);
        hp_9 = (EditText) findViewById(R.id.exp_9);
        hp_10 = (EditText) findViewById(R.id.exp_10);
        hp_11 = (EditText) findViewById(R.id.exp_11);
        hp_12 = (EditText) findViewById(R.id.exp_12);
        hp_13 = (EditText) findViewById(R.id.exp_13);
        hp_14 = (EditText) findViewById(R.id.exp_14);
        hp_15 = (EditText) findViewById(R.id.exp_15);
        hp_16 = (EditText) findViewById(R.id.exp_16);
        hp_17 = (EditText) findViewById(R.id.exp_17);


        okbutton = (Button) findViewById(R.id.bt_ok);
        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* MyDatabaseHelper myDB = new MyDatabaseHelper(Expense_calculation_Activity.this);
                myDB.addExpense (getdate.getText().toString(),
                        Integer.valueOf(hp_1.getText().toString().trim()),
                        Integer.valueOf(hp_2.getText().toString().trim()),
                        Integer.valueOf(hp_3.getText().toString().trim()),
                        Integer.valueOf(hp_4.getText().toString().trim()),
                        Integer.valueOf(hp_5.getText().toString().trim()),
                        Integer.valueOf(hp_6.getText().toString().trim()),
                        Integer.valueOf(hp_7.getText().toString().trim()),
                        Integer.valueOf(hp_8.getText().toString().trim()),
                        Integer.valueOf(hp_9.getText().toString().trim()),
                        Integer.valueOf(hp_10.getText().toString().trim()),
                        Integer.valueOf(hp_11.getText().toString().trim()),
                        Integer.valueOf(hp_12.getText().toString().trim()),
                        Integer.valueOf(hp_13.getText().toString().trim()),
                        Integer.valueOf(hp_14.getText().toString().trim()),
                        Integer.valueOf(hp_15.getText().toString().trim()),
                        Integer.valueOf(hp_16.getText().toString().trim()),
                        Integer.valueOf(hp_17.getText().toString().trim()),
                        Integer.valueOf(display_tot.getText().toString().trim() ));*/
            }
        });


        putdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(Expense_calculation_Activity.this,
                        android.R.style.Theme_Material_Dialog_MinWidth,
                        mDateSetListner,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.R.color.transparent));
                dialog.show();
            }
        });
        mDateSetListner = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                ArrayList<String> monthname = new ArrayList<>();
                monthname.add("January");
                monthname.add("February");
                monthname.add("March");
                monthname.add("April");
                monthname.add("May");
                monthname.add("June");
                monthname.add("July");
                monthname.add("August");
                monthname.add("September");
                monthname.add("October");
                monthname.add("November");
                monthname.add("December");


                //  month=month+1;
                String getmonthname = "Select a Date";
                if (month == 0) {
                    getmonthname = monthname.get(0);
                    String date = year + "  " + getmonthname;
                    getdate.setText(date);
                } else if (month == 1) {

                    getmonthname = monthname.get(1);
                    String date = year + "  " + getmonthname;
                    getdate.setText(date);
                } else if (month == 1) {

                    getmonthname = monthname.get(1);
                    String date = year + "  " + getmonthname;
                    getdate.setText(date);
                } else if (month == 2) {

                    getmonthname = monthname.get(2);
                    String date = year + "  " + getmonthname;
                    getdate.setText(date);
                } else if (month == 3) {

                    getmonthname = monthname.get(3);
                    String date = year + "  " + getmonthname;
                    getdate.setText(date);
                } else if (month == 4) {

                    getmonthname = monthname.get(4);
                    String date = year + "  " + getmonthname;
                    getdate.setText(date);
                } else if (month == 5) {

                    getmonthname = monthname.get(5);
                    String date = year + "  " + getmonthname;
                    getdate.setText(date);
                } else if (month == 6) {

                    getmonthname = monthname.get(6);
                    String date = year + "  " + getmonthname;
                    getdate.setText(date);
                } else if (month == 7) {

                    getmonthname = monthname.get(7);
                    String date = year + "  " + getmonthname;
                    getdate.setText(date);
                } else if (month == 8) {

                    getmonthname = monthname.get(8);
                    String date = year + "  " + getmonthname;
                    getdate.setText(date);
                } else if (month == 9) {

                    getmonthname = monthname.get(9);
                    String date = year + "  " + getmonthname;
                    getdate.setText(date);
                } else if (month == 10) {

                    getmonthname = monthname.get(10);
                    String date = year + "  " + getmonthname;
                    getdate.setText(date);
                } else if (month == 11) {

                    getmonthname = monthname.get(11);
                    String date = year + "  " + getmonthname;
                    getdate.setText(date);
                }
            }
        };



    }

    public void home_expense_total() {

        cal = (TextView) findViewById(R.id.exp_calculate);
        sum = (TextView) findViewById(R.id.exp_total);

        hp_1 = (EditText) findViewById(R.id.exp_1);
        hp_2 = (EditText) findViewById(R.id.exp_2);
        hp_3 = (EditText) findViewById(R.id.exp_3);
        hp_4 = (EditText) findViewById(R.id.exp_4);
        hp_5 = (EditText) findViewById(R.id.exp_5);
        hp_6 = (EditText) findViewById(R.id.exp_6);
        hp_7 = (EditText) findViewById(R.id.exp_7);
        hp_8 = (EditText) findViewById(R.id.exp_8);
        hp_9 = (EditText) findViewById(R.id.exp_9);
        hp_10 = (EditText) findViewById(R.id.exp_10);
        hp_11 = (EditText) findViewById(R.id.exp_11);
        hp_12 = (EditText) findViewById(R.id.exp_12);
        hp_13 = (EditText) findViewById(R.id.exp_13);
        hp_14 = (EditText) findViewById(R.id.exp_14);
        hp_15 = (EditText) findViewById(R.id.exp_15);
        hp_16 = (EditText) findViewById(R.id.exp_16);
        hp_17 = (EditText) findViewById(R.id.exp_17);


        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int one, two;
                int three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0, ten = 0, eleven = 0,
                        twelve = 0, thirteen = 0, fourteen = 0, fifteen = 0, sixteen = 0, seventeen = 0, result;


                if (hp_1.getText().toString().equals("")) {
                    one = 0;
                } else {
                    one = Integer.parseInt(hp_1.getText().toString());
                }

                if (hp_2.getText().toString().equals("")) {
                    two = 0;
                } else {
                    two = Integer.parseInt(hp_2.getText().toString());
                }

                if (hp_3.getText().toString().equals("")) {
                    three = 0;
                } else {
                    three = Integer.parseInt(hp_3.getText().toString());
                }

                if (hp_4.getText().toString().equals("")) {
                    four = 0;
                } else {
                    four = Integer.parseInt(hp_4.getText().toString());
                }

                if (hp_5.getText().toString().equals("")) {
                    five = 0;
                } else {
                    five = Integer.parseInt(hp_5.getText().toString());
                }

                if (hp_6.getText().toString().equals("")) {
                    six = 0;
                } else {
                    six = Integer.parseInt(hp_6.getText().toString());
                }

                if (hp_7.getText().toString().equals("")) {
                    seven = 0;
                } else {
                    seven = Integer.parseInt(hp_7.getText().toString());
                }

                if (hp_8.getText().toString().equals("")) {
                    eight = 0;
                } else {
                    eight = Integer.parseInt(hp_8.getText().toString());
                }

                if (hp_9.getText().toString().equals("")) {
                    nine = 0;
                } else {
                    nine = Integer.parseInt(hp_9.getText().toString());
                }

                if (hp_10.getText().toString().equals("")) {
                    ten = 0;
                } else {
                    ten = Integer.parseInt(hp_10.getText().toString());
                }

                if (hp_11.getText().toString().equals("")) {
                    eleven = 0;
                } else {
                    eleven = Integer.parseInt(hp_11.getText().toString());
                }

                if (hp_12.getText().toString().equals("")) {
                    twelve = 0;
                } else {
                    twelve = Integer.parseInt(hp_12.getText().toString());
                }

                if (hp_13.getText().toString().equals("")) {
                    thirteen = 0;
                } else {
                    thirteen = Integer.parseInt(hp_13.getText().toString());
                }

                if (hp_14.getText().toString().equals("")) {
                    fourteen = 0;
                } else {
                    fourteen = Integer.parseInt(hp_14.getText().toString());
                }

                if (hp_15.getText().toString().equals("")) {
                    fifteen = 0;
                } else {
                    fifteen = Integer.parseInt(hp_15.getText().toString());
                }

                if (hp_16.getText().toString().equals("")) {
                    sixteen = 0;
                } else {
                    sixteen = Integer.parseInt(hp_16.getText().toString());
                }

                if (hp_17.getText().toString().equals("")) {
                    seventeen = 0;
                } else {
                    seventeen = Integer.parseInt(hp_17.getText().toString());
                }

                result = one + two + three + four + five + six + seven + eight + nine + ten + eleven + twelve + thirteen + fourteen + fifteen + sixteen + seventeen;
                sum.setText(String.valueOf(result + ""));
            }
        });


    }

}