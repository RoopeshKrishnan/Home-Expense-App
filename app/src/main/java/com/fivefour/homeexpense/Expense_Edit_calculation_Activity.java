package com.fivefour.homeexpense;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.fivefour.homeexpense.model.Expense_VIewModel;

import java.util.ArrayList;
import java.util.Calendar;

import static android.view.WindowManager.*;

public class Expense_Edit_calculation_Activity extends AppCompatActivity {
    public static final String key_id = "com.fivefour.homeexpense.key_id";
    public static final String key_year = "com.fivefour.homeexpense.key_year";
    public static final String key_one = "com.fivefour.homeexpense.key_one";
    public static final String key_two = "com.fivefour.homeexpense.key_two";
    public static final String key_three = "com.fivefour.homeexpense.key_three";
    public static final String key_four = "com.fivefour.homeexpense.key_four";
    public static final String key_five = "com.fivefour.homeexpense.key_five";
    public static final String key_six = "com.fivefour.homeexpense.key_six";
    public static final String key_seven = "com.fivefour.homeexpense.key_seven";
    public static final String key_eight = "com.fivefour.homeexpense.key_eight";
    public static final String key_nine = "com.fivefour.homeexpense.key_nine";
    public static final String key_ten = "com.fivefour.homeexpense.key_ten";
    public static final String key_eleven = "com.fivefour.homeexpense.key_eleven";
    public static final String key_twelve = "com.fivefour.homeexpense.key_twelve";
    public static final String key_thirteen = "com.fivefour.homeexpense.key_thirteen";
    public static final String key_fourteen = "com.fivefour.homeexpense.key_fourteen";
    public static final String key_fifteen = "com.fivefour.homeexpense.key_fifteen";
    public static final String key_sixteen = "com.fivefour.homeexpense.key_sixteen";
    public static final String key_seventeen = "com.fivefour.homeexpense.key_sventeen";
    public static final String key_total = "com.fivefour.homeexpense.key_total";


    private Expense_VIewModel expense_vIewModel;
    public TextView putdate, getdate, cal, sum, display_tot;
    public EditText hp_onne, hp_1, hp_2, hp_3, hp_4, hp_5, hp_6, hp_7, hp_8, hp_9, hp_10, hp_11, hp_12, hp_13, hp_14, hp_15, hp_16, hp_17;
    Button okbutton;
    Toolbar toolbar;
    RecyclerView recyclerView;
    public DatePickerDialog.OnDateSetListener mDateSetListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_calculation);

        getWindow().setSoftInputMode(
                LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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



        getSupportActionBar().setHomeAsUpIndicator(R.drawable.bt_cancel);


        Intent intent = getIntent();



        if (intent.hasExtra(key_id))
        {
            setTitle("Edit");



          /*  EditText hp_srore_1 = (EditText) findViewById(R.id.exp_1);
            String sTextFromET = hp_srore_1.getText().toString();
            //int nIntFromET = new Integer(sTextFromET).intValue();*/



            getdate.setText(intent.getStringExtra(key_year));
           // String tou = hp_1.getText().toString();
            //String uu = intent.getIntExtra(key_five, 1);

          //  hp_5 = intent.getIntExtra(key_five, 1);


            //hp_1.setText(intent.getIntExtra(key_one, 0));
          /*  hp_1.setValue(intent.getIntExtra(key_one, 1));
            hp_2.setText(intent.getIntExtra(key_two, 1));
            hp_3.setText(intent.getIntExtra(key_three, 1));
            hp_4.setText(intent.getIntExtra(key_four, 1));
            hp_5.setText(intent.getIntExtra(key_five, 1));
            hp_6.setText(intent.getIntExtra(key_six, 1));
            hp_7.setText(intent.getIntExtra(key_seven, 1));
            hp_8.setText(intent.getIntExtra(key_eight, 1));
            hp_9.setText(intent.getIntExtra(key_nine, 1));
            hp_10.setText(intent.getIntExtra(key_ten, 1));
            hp_11.setText(intent.getIntExtra(key_eleven, 1));
            hp_12.setText(intent.getIntExtra(key_twelve, 1));
            hp_13.setText(intent.getIntExtra(key_thirteen, 1));
            hp_14.setText(intent.getIntExtra(key_fourteen, 1));
            hp_15.setText(intent.getIntExtra(key_fifteen, 1));
            hp_16.setText(intent.getIntExtra(key_sixteen, 1));
            hp_17.setText(intent.getIntExtra(key_seventeen, 1));
            display_tot.setText(intent.getIntExtra(key_total, 1));*/

        } else {
            setTitle("Enter Your Data");
        }



        home_expense_total();


        okbutton = (Button) findViewById(R.id.bt_ok);
        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Okbutton_Click_actions();
            }
        });


        putdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(Expense_Edit_calculation_Activity.this,
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

    // outside oncreate method

    //calculating expense
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


    private void Okbutton_Click_actions() {

        String year_name_holder = getdate.getText().toString();
        int expense1 = Integer.parseInt(hp_1.getText().toString());
        int expense2 = Integer.parseInt(hp_2.getText().toString());
        int expense3 = Integer.parseInt(hp_3.getText().toString());
        int expense4 = Integer.parseInt(hp_4.getText().toString());
        int expense5 = Integer.parseInt(hp_5.getText().toString());
        int expense6 = Integer.parseInt(hp_6.getText().toString());
        int expense7 = Integer.parseInt(hp_7.getText().toString());
        int expense8 = Integer.parseInt(hp_8.getText().toString());
        int expense9 = Integer.parseInt(hp_9.getText().toString());
        int expense10 = Integer.parseInt(hp_10.getText().toString());
        int expense11 = Integer.parseInt(hp_11.getText().toString());
        int expense12 = Integer.parseInt(hp_12.getText().toString());
        int expense13 = Integer.parseInt(hp_13.getText().toString());
        int expense14 = Integer.parseInt(hp_14.getText().toString());
        int expense15 = Integer.parseInt(hp_15.getText().toString());
        int expense16 = Integer.parseInt(hp_16.getText().toString());
        int expense17 = Integer.parseInt(hp_17.getText().toString());

        int expense_total = Integer.parseInt(display_tot.getText().toString());

        Intent data = new Intent();
        data.putExtra(key_year, year_name_holder);
        data.putExtra(key_one, expense1);
        data.putExtra(key_two, expense2);
        data.putExtra(key_three, expense3);
        data.putExtra(key_four, expense4);
        data.putExtra(key_five, expense5);
        data.putExtra(key_six, expense6);
        data.putExtra(key_seven, expense7);
        data.putExtra(key_eight, expense8);
        data.putExtra(key_nine, expense9);
        data.putExtra(key_ten, expense10);
        data.putExtra(key_eleven, expense11);
        data.putExtra(key_twelve, expense12);
        data.putExtra(key_thirteen, expense13);
        data.putExtra(key_fourteen, expense14);
        data.putExtra(key_fifteen, expense15);
        data.putExtra(key_sixteen, expense16);
        data.putExtra(key_seventeen, expense17);
        data.putExtra(key_total, expense_total);

        int id = getIntent().getIntExtra(key_id, -1);
        if (id != 1){

            data.putExtra(key_id,id);
        }
        setResult(RESULT_OK, data);
        finish();


    }

}