package com.fivefour.homeexpense;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VersionActivity extends AppCompatActivity {
   // Dialog dialog;
    Button version_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version);

       /* dialog= new Dialog(this);
        dialog.setContentView(R.layout.activity_version);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.R.color.transparent));*/
        version_ok =(Button)findViewById(R.id.versionok);
        version_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

    }
}