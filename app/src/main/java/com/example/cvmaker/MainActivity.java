package com.example.cvmaker;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button create,old;
    final DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,InputActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.old).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(helper.getcheck()) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }else {

                    Toast.makeText(MainActivity.this, "NO CV Found", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    }
