package com.example.cvmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView dname,jobTitle,dphone,demail,birthDay,schln,clgn,versityn,skilln,experiencen,dnationality;
    ImageView image2;

    String[] arrOfInfo;

    Intent in = getIntent();
 //   Bitmap b = in.getBooleanArrayExtra("Info");

    final DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       dname = findViewById(R.id.dname);
       jobTitle = findViewById(R.id.jbt);
        demail = findViewById(R.id.demail);
        dphone = findViewById(R.id.dphone);
        dnationality = findViewById(R.id.dnatonality);
        schln = findViewById(R.id.schln);
        clgn = findViewById(R.id.clgn);
        versityn = findViewById(R.id.versityn);
        skilln = findViewById(R.id.skilln);
        experiencen = findViewById(R.id.experincen);
        image2 = findViewById(R.id.image2);


      // final DatabaseHelper helper = new DatabaseHelper(this);

        String s = helper.getContacts();
        arrOfInfo = s.split(";");
        dname.setText(arrOfInfo[0]);
        jobTitle.setText(arrOfInfo[1]);
       demail.setText(arrOfInfo[2]);
        dphone.setText(arrOfInfo[3]);
        dnationality.setText(arrOfInfo[5]);
        schln.setText(arrOfInfo[6]);
        clgn.setText(arrOfInfo[7]);
        versityn.setText(arrOfInfo[8]);
        skilln.setText(arrOfInfo[9]);
        experiencen.setText(arrOfInfo[10]);/*
        image2 = findViewById(R.id.image2);*/


        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(MainActivity2.this, Update.class);
                    startActivity(intent);

            }
        });
        findViewById(R.id.createCv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, InputActivity.class);
                startActivity(intent);

            }
        });

        findViewById(R.id.pdf).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity2.this, "UNDER CONSTRUCTION", Toast.LENGTH_LONG).show();
            }
        });
    }
}