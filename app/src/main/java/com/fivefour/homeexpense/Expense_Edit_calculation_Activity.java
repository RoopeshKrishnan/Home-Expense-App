package com.fivefour.homeexpense;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Window;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Dialog;

import com.fivefour.homeexpense.db.Expense;
import com.fivefour.homeexpense.db.Expense_Dao;
import com.fivefour.homeexpense.model.Expense_VIewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;

import static android.graphics.PorterDuff.*;
import static android.text.TextUtils.*;
import static android.util.Log.*;
import static android.view.WindowManager.*;
import static android.widget.Toast.*;

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


    private Expense_Dao dao;
    private Expense_VIewModel expense_vIewModel;
    public TextView putdate, getdate, cal, sum, display_tot;
    public EditText hp_onne, hp_1, hp_2, hp_3, hp_4, hp_5, hp_6, hp_7, hp_8, hp_9, hp_10, hp_11, hp_12, hp_13, hp_14, hp_15, hp_16, hp_17;
    Toolbar toolbar;
    RecyclerView recyclerView;
    FloatingActionButton fab_expnese_action;
    public DatePickerDialog.OnDateSetListener mDateSetListner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_calculation);

        getWindow().setSoftInputMode(
                LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);




        putdate = (TextView) findViewById(R.id.putdate);
        getdate = (TextView) findViewById(R.id.getdate);
        display_tot = (TextView) findViewById(R.id.exp_total);

        hp_1 = (EditText) findViewById(R.id.exp_1);
        int maxLength=8;
        hp_1.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});


        hp_2 = (EditText) findViewById(R.id.exp_2);
        int maxLength2=8;
        hp_2.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength2)});


        hp_3 = (EditText) findViewById(R.id.exp_3);
        int maxLength3=8;
        hp_3.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength3)});


        hp_4 = (EditText) findViewById(R.id.exp_4);
        int maxLength4=8;
        hp_4.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength4)});


        hp_5 = (EditText) findViewById(R.id.exp_5);
        int maxLength5=8;
        hp_5.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength5)});


        hp_6 = (EditText) findViewById(R.id.exp_6);
        int maxLength6=8;
        hp_6.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength6)});


        hp_7 = (EditText) findViewById(R.id.exp_7);
        int maxLength7=8;
        hp_7.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength7)});


        hp_8 = (EditText) findViewById(R.id.exp_8);
        int maxLength8=8;
        hp_8.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength8)});


        hp_9 = (EditText) findViewById(R.id.exp_9);
        int maxLength9=8;
        hp_9.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength9)});


        hp_10 = (EditText) findViewById(R.id.exp_10);
        int maxLength10=8;
        hp_10.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength10)});


        hp_11 = (EditText) findViewById(R.id.exp_11);
        int maxLength11=8;
        hp_11.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength11)});


        hp_12 = (EditText) findViewById(R.id.exp_12);
        int maxLength12=8;
        hp_12.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength12)});


        hp_13 = (EditText) findViewById(R.id.exp_13);
        int maxLength13=8;
        hp_13.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength13)});


        hp_14 = (EditText) findViewById(R.id.exp_14);
        int maxLength14=8;
        hp_14.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength14)});


        hp_15 = (EditText) findViewById(R.id.exp_15);
        int maxLength15=8;
        hp_15.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength15)});


        hp_16 = (EditText) findViewById(R.id.exp_16);
        int maxLength16=8;
        hp_16.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength16)});


        hp_17 = (EditText) findViewById(R.id.exp_17);
        int maxLength17=8;
        hp_17.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength17)});


        getSupportActionBar().setHomeAsUpIndicator(R.drawable.bt_cancel);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.purple_700), PorterDuff.Mode.SRC_ATOP);


        Intent intent = getIntent();
        if (intent.hasExtra(key_id)) {
            setTitle("Edit");
            int againi;


            getdate.setText(intent.getStringExtra(key_year));


            int int1 = intent.getIntExtra(key_one, 0);
            String str1 = String.valueOf(int1);
            hp_1.setText(str1);

            int int2 = intent.getIntExtra(key_two, 0);
            String str2 = String.valueOf(int2);
            hp_2.setText(str2);

            int int3 = intent.getIntExtra(key_three, 0);
            String str3 = String.valueOf(int3);
            hp_3.setText(str3);

            int int4 = intent.getIntExtra(key_four, 0);
            String str4 = String.valueOf(int4);
            hp_4.setText(str4);

            int int5 = intent.getIntExtra(key_five, 0);
            String str5 = String.valueOf(int5
            );
            hp_5.setText(str5);

            int int6 = intent.getIntExtra(key_six, 0);
            String str6 = String.valueOf(int6);
            hp_6.setText(str6);

            int int7 = intent.getIntExtra(key_seven, 0);
            String str7 = String.valueOf(int7);
            hp_7.setText(str7);

            int int8 = intent.getIntExtra(key_eight, 0);
            String str8 = String.valueOf(int8);
            hp_8.setText(str8);

            int int9 = intent.getIntExtra(key_nine, 0);
            String str9 = String.valueOf(int9);
            hp_9.setText(str9);

            int int10 = intent.getIntExtra(key_ten, 0);
            String str10 = String.valueOf(int10);
            hp_10.setText(str10);

            int int11 = intent.getIntExtra(key_eleven, 0);
            String str11 = String.valueOf(int11);
            hp_11.setText(str11);

            int int12 = intent.getIntExtra(key_twelve, 0);
            String str12 = String.valueOf(int12);
            hp_12.setText(str12);

            int int13 = intent.getIntExtra(key_thirteen, 0);
            String str13 = String.valueOf(int13);
            hp_13.setText(str13);

            int int14 = intent.getIntExtra(key_fourteen, 0);
            String str14 = String.valueOf(int14);
            hp_14.setText(str14);

            int int15 = intent.getIntExtra(key_fifteen, 0);
            String str15 = String.valueOf(int15);
            hp_15.setText(str15);

            int int16 = intent.getIntExtra(key_sixteen, 0);
            String str16 = String.valueOf(int16);
            hp_16.setText(str16);

            int int17 = intent.getIntExtra(key_seventeen, 0);
            String str17 = String.valueOf(int17);
            hp_17.setText(str17);

            int inttot = intent.getIntExtra(key_total, 0);
            String strtot = String.valueOf(inttot);
            display_tot.setText(strtot);


        } else {
            setTitle("Enter Your Data");
        }

      /*  cancel_button =(Button)findViewById(R.id.cancel_button1_ae);
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cancelIntent = new Intent(Expense_Edit_calculation_Activity.this, MainActivity.class);
                startActivity(cancelIntent);
            }
        });*/
        fab_expnese_action = (FloatingActionButton) findViewById(R.id.fab_ok);
        fab_expnese_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Okbutton_Click_actions();

            }
        });


       /* okbutton = (Button) findViewById(R.id.bt_ok);
        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Okbutton_Click_actions();
            }
        });*/


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
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.R.color.white));
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


        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

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

                display_tot.setText(String.valueOf(one + two + three + four + five + six + seven + eight +
                        nine + ten + eleven + twelve + thirteen + fourteen + fifteen + sixteen + seventeen));


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        hp_1.addTextChangedListener(textWatcher);
        hp_2.addTextChangedListener(textWatcher);
        hp_3.addTextChangedListener(textWatcher);
        hp_4.addTextChangedListener(textWatcher);
        hp_5.addTextChangedListener(textWatcher);
        hp_6.addTextChangedListener(textWatcher);
        hp_7.addTextChangedListener(textWatcher);
        hp_8.addTextChangedListener(textWatcher);
        hp_9.addTextChangedListener(textWatcher);
        hp_10.addTextChangedListener(textWatcher);
        hp_11.addTextChangedListener(textWatcher);
        hp_12.addTextChangedListener(textWatcher);
        hp_13.addTextChangedListener(textWatcher);
        hp_14.addTextChangedListener(textWatcher);
        hp_15.addTextChangedListener(textWatcher);
        hp_16.addTextChangedListener(textWatcher);
        hp_17.addTextChangedListener(textWatcher);


    }

    // outside oncreate method


    private void Okbutton_Click_actions() {

        String year_name_holder = getdate.getText().toString();




     /*   int expense1 = Integer.parseInt(hp_1.getText().toString());
        String strexps1 = String.valueOf(expense1);
        int expenseTest = Integer.parseInt(hp_1.getText().toString());


        //int holdingone = Integer.parseInt(strexps1.toString());
       // hp_1.setText(str1);
        if(TextUtils.isEmpty(strexps1)){


          hp_1.setError("add data");

        }else {
             expenseTest = Integer.parseInt(hp_1.getText().toString());
        }
        int orginalstoree = expenseTest;
        Toast.makeText(Expense_Edit_calculation_Activity.this, orginalstoree+"haha", LENGTH_SHORT).show();

        // Log.d("MYINT", "value is" + orginalstoree);*/

        if (getdate.length() == 0) {
            filleverything();
        } else if (hp_1.length() == 0) {
            hp_1.setError("If nothing add 0");
            filleverything();

        }else if (hp_2.length() == 0) {
            hp_2.setError("If nothing add 0");

            filleverything();

        }else if (hp_3.length() == 0) {
            hp_3.setError("If nothing add 0");

            filleverything();

        }else if (hp_4.length() == 0) {
            hp_4.setError("If nothing add 0");


            filleverything();

        }else if (hp_5.length() == 0) {
            hp_5.setError("If nothing add 0");
            filleverything();


        }else if (hp_6.length() == 0) {
            hp_6.setError("If nothing add 0");
            filleverything();

        }else if (hp_7.length() == 0) {
            hp_7.setError("If nothing add 0");
            filleverything();

        }else if (hp_8.length() == 0) {
            hp_8.setError("If nothing add 0");
            filleverything();

        }else if (hp_9.length() == 0) {
            hp_9.setError("If nothing add 0");
            filleverything();

        }else if (hp_10.length() == 0) {
            hp_10.setError("If nothing add 0");
            filleverything();

        }else if (hp_11.length() == 0) {
            hp_11.setError("If nothing add 0");
            filleverything();

        }else if (hp_12.length() == 0) {
            hp_12.setError("If nothing add 0");
            filleverything();

        }else if (hp_13.length() == 0) {
            hp_13.setError("If nothing add 0");
            filleverything();

        }else if (hp_14.length() == 0) {
            hp_14.setError("If nothing add 0");
            filleverything();

        }else if (hp_15.length() == 0) {
            hp_15.setError("If nothing add 0");
            filleverything();

        }else if (hp_16.length() == 0) {
            hp_16.setError("If nothing add 0");
            filleverything();

        }else if (hp_17.length() == 0) {
            hp_17.setError("If nothing add 0");
            filleverything();

        }

        else {


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
            if (id != 1) {

                data.putExtra(key_id, id);
            }
            setResult(RESULT_OK, data);
            finish();

        }
    }

    public void filleverything(){

        Dialog dialog;
        dialog = new Dialog(Expense_Edit_calculation_Activity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fill_everything_dialogbox_layout);
        Button fillbt = dialog.findViewById(R.id.fill_ok_bt);
        fillbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}