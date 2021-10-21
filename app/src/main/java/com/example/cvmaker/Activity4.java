package com.example.cvmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity4 extends AppCompatActivity {
    EditText skills, xperience;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        Intent in = getIntent();
        s = in.getStringExtra("Info");
        skills = findViewById(R.id.skills);
        xperience = findViewById(R.id.xperience);
        findViewById(R.id.infoSubBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!skills.getText().toString().isEmpty() && !xperience.getText().toString().isEmpty()) {
                    s = s + ":" + skills.getText().toString() +
                            ":" + xperience.getText().toString() + ":";
                    Intent intent = new Intent(Activity4.this, Activity2.class);
                    intent.putExtra("Info", s);
                    startActivity(intent);

                }else {
                    skills.setError("Fill IT");
                    xperience.setError("Fill IT");
                }
            }
        });
    }
}