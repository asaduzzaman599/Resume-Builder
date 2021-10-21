package com.example.cvmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {
    EditText schl,clg,versity;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        Intent in = getIntent();
        s = in.getStringExtra("Info");
        schl = findViewById(R.id.schl);
        clg = findViewById(R.id.clg);
        versity = findViewById(R.id.versity);

        findViewById(R.id.eduInfoBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!schl.getText().toString().isEmpty() && !clg.getText().toString().isEmpty() && !versity.getText().toString().isEmpty()){

                    s = s + ":"+ schl.getText().toString()+
                            ":" + clg.getText().toString()+ ":" + versity.getText().toString();
                    Intent intent = new Intent(Activity3.this,Activity4.class);
                    intent.putExtra("Info",s);
                    startActivity(intent);
                }else{
                    schl.setError("Fill IT");
                    clg.setError("Fill IT");
                    versity.setError("Fill IT");
                }
            }
        });
    }
}