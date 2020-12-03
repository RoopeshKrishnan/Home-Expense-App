package com.fivefour.homeexpense;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import static java.util.Locale.*;

public class Expense_calculation_Activity extends AppCompatActivity {
    public TextView putdate, getdate;
    public DatePickerDialog.OnDateSetListener mDateSetListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_calculation);
        putdate = (TextView) findViewById(R.id.putdate);
        getdate = (TextView) findViewById(R.id.getdate);

        putdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(Expense_calculation_Activity.this,
                        android.R.style.Theme_Material_Light_NoActionBar,
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
                if (month == 0){
                    getmonthname = monthname.get(0);
                    String date = getmonthname + "/" + day + "/" + year;
                    getdate.setText(date);}else if (month==1){

                    getmonthname = monthname.get(1);
                    String date = getmonthname + "/" + day + "/" + year;
                    getdate.setText(date);
                }else if (month==1){

                    getmonthname = monthname.get(1);
                    String date = getmonthname + "/" + day + "/" + year;
                    getdate.setText(date);
                }else if (month==2){

                    getmonthname = monthname.get(2);
                    String date = getmonthname + "/" + day + "/" + year;
                    getdate.setText(date);
                }else if (month==3){

                    getmonthname = monthname.get(3);
                    String date = getmonthname + "/" + day + "/" + year;
                    getdate.setText(date);
                }else if (month==4){

                    getmonthname = monthname.get(4);
                    String date = getmonthname + "/" + day + "/" + year;
                    getdate.setText(date);
                }else if (month==5){

                    getmonthname = monthname.get(5);
                    String date = getmonthname + "/" + day + "/" + year;
                    getdate.setText(date);
                }else if (month==6){

                    getmonthname = monthname.get(6);
                    String date = getmonthname + "/" + day + "/" + year;
                    getdate.setText(date);
                }else if (month==7){

                    getmonthname = monthname.get(7);
                    String date = getmonthname + "/" + day + "/" + year;
                    getdate.setText(date);
                }else if (month==8){

                    getmonthname = monthname.get(8);
                    String date = getmonthname + "/" + day + "/" + year;
                    getdate.setText(date);
                }else if (month==9){

                    getmonthname = monthname.get(9);
                    String date = getmonthname + "/" + day + "/" + year;
                    getdate.setText(date);
                }else if (month==10){

                    getmonthname = monthname.get(10);
                    String date = getmonthname + "/" + day + "/" + year;
                    getdate.setText(date);
                }else if (month==11){

                    getmonthname = monthname.get(11);
                    String date = getmonthname + "/" + day + "/" + year;
                    getdate.setText(date);
                }
            }
        };

    }

}