package com.fivefour.homeexpense.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "expense_table")
public class Expense {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Column_Year_month")
    private String yearmonth;

    @ColumnInfo(name = "Column_one")
    private int exp_one;

    @ColumnInfo(name = "Column_two")
    private int exp_two;

    @ColumnInfo(name = "Column_three")
    private int exp_three;

    @ColumnInfo(name = "Column_four")
    private int exp_four;

    @ColumnInfo(name = "Column_five")
    private int exp_five;

    @ColumnInfo(name = "Column_six")
    private int exp_six;

    @ColumnInfo(name = "Column_seven")
    private int exp_seven;

    @ColumnInfo(name = "Column_eight")
    private int exp_eight;

    @ColumnInfo(name = "Column_nine")
    private int exp_nine;

    @ColumnInfo(name = "Column_ten")
    private int exp_ten;

    @ColumnInfo(name = "Column_eleven")
    private int exp_eleven;

    @ColumnInfo(name = "Column_twelve")
    private int exp_twelve;

    @ColumnInfo(name = "Column_thirteen")
    private int exp_thirteen;

    @ColumnInfo(name = "Column_fourteen")
    private int exp_fourteen;

    @ColumnInfo(name = "Column_fifteen")
    private int exp_fifteen;

    @ColumnInfo(name = "Column_sixteen")
    private int exp_sixteen;

    @ColumnInfo(name = "Column_seventeen")
    private int exp_seventeen;


    @ColumnInfo(name = "Column_total")
    private int exp_total;

    public Expense(String yearmonth, int exp_one, int exp_two, int exp_three, int exp_four, int exp_five, int exp_six, int exp_seven, int exp_eight, int exp_nine, int exp_ten, int exp_eleven, int exp_twelve, int exp_thirteen, int exp_fourteen, int exp_fifteen, int exp_sixteen, int exp_seventeen, int exp_total) {
        this.yearmonth = yearmonth;
        this.exp_one = exp_one;
        this.exp_two = exp_two;
        this.exp_three = exp_three;
        this.exp_four = exp_four;
        this.exp_five = exp_five;
        this.exp_six = exp_six;
        this.exp_seven = exp_seven;
        this.exp_eight = exp_eight;
        this.exp_nine = exp_nine;
        this.exp_ten = exp_ten;
        this.exp_eleven = exp_eleven;
        this.exp_twelve = exp_twelve;
        this.exp_thirteen = exp_thirteen;
        this.exp_fourteen = exp_fourteen;
        this.exp_fifteen = exp_fifteen;
        this.exp_sixteen = exp_sixteen;
        this.exp_seventeen = exp_seventeen;
        this.exp_total = exp_total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYearmonth() {
        return yearmonth;
    }

    public void setYearmonth(String yearmonth) {
        this.yearmonth = yearmonth;
    }

    public int getExp_one() {
        return exp_one;
    }

    public void setExp_one(int exp_one) {
        this.exp_one = exp_one;
    }

    public int getExp_two() {
        return exp_two;
    }

    public void setExp_two(int exp_two) {
        this.exp_two = exp_two;
    }

    public int getExp_three() {
        return exp_three;
    }

    public void setExp_three(int exp_three) {
        this.exp_three = exp_three;
    }

    public int getExp_four() {
        return exp_four;
    }

    public void setExp_four(int exp_four) {
        this.exp_four = exp_four;
    }

    public int getExp_five() {
        return exp_five;
    }

    public void setExp_five(int exp_five) {
        this.exp_five = exp_five;
    }

    public int getExp_six() {
        return exp_six;
    }

    public void setExp_six(int exp_six) {
        this.exp_six = exp_six;
    }

    public int getExp_seven() {
        return exp_seven;
    }

    public void setExp_seven(int exp_seven) {
        this.exp_seven = exp_seven;
    }

    public int getExp_eight() {
        return exp_eight;
    }

    public void setExp_eight(int exp_eight) {
        this.exp_eight = exp_eight;
    }

    public int getExp_nine() {
        return exp_nine;
    }

    public void setExp_nine(int exp_nine) {
        this.exp_nine = exp_nine;
    }

    public int getExp_ten() {
        return exp_ten;
    }

    public void setExp_ten(int exp_ten) {
        this.exp_ten = exp_ten;
    }

    public int getExp_eleven() {
        return exp_eleven;
    }

    public void setExp_eleven(int exp_eleven) {
        this.exp_eleven = exp_eleven;
    }

    public int getExp_twelve() {
        return exp_twelve;
    }

    public void setExp_twelve(int exp_twelve) {
        this.exp_twelve = exp_twelve;
    }

    public int getExp_thirteen() {
        return exp_thirteen;
    }

    public void setExp_thirteen(int exp_thirteen) {
        this.exp_thirteen = exp_thirteen;
    }

    public int getExp_fourteen() {
        return exp_fourteen;
    }

    public void setExp_fourteen(int exp_fourteen) {
        this.exp_fourteen = exp_fourteen;
    }

    public int getExp_fifteen() {
        return exp_fifteen;
    }

    public void setExp_fifteen(int exp_fifteen) {
        this.exp_fifteen = exp_fifteen;
    }

    public int getExp_sixteen() {
        return exp_sixteen;
    }

    public void setExp_sixteen(int exp_sixteen) {
        this.exp_sixteen = exp_sixteen;
    }

    public int getExp_seventeen() {
        return exp_seventeen;
    }

    public void setExp_seventeen(int exp_seventeen) {
        this.exp_seventeen = exp_seventeen;
    }

    public int getExp_total() {
        return exp_total;
    }

    public void setExp_total(int exp_total) {
        this.exp_total = exp_total;
    }
}
