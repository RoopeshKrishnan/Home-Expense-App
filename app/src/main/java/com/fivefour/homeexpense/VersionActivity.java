package com.fivefour.homeexpense;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class VersionActivity extends AppCompatActivity {

   Toolbar toolbar3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version);
        toolbar3 = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar3);
        getSupportActionBar().setTitle("Version");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}