package com.example.cvmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {
    boolean cv = true;
    Button perInfoBtn;
    EditText name,jobTitle,bday,phone,email,nationality;


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        final DatabaseHelper helper = new DatabaseHelper(this);

        name = findViewById(R.id.name);
        jobTitle = findViewById(R.id.jobTitle);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        bday=findViewById(R.id.bday);
        nationality = findViewById(R.id.nationality);

        findViewById(R.id.perInfoBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!name.getText().toString().isEmpty() && !jobTitle.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !phone.getText().toString().isEmpty() && !nationality.getText().toString().isEmpty()){
                    if(dateChecker(bday.getText().toString()) ){
                    String s= name.getText().toString()+ ":" + jobTitle.getText().toString() + ":" + email.getText().toString() +":" + bday.getText().toString() + ":" + phone.getText().toString()+ ":" + nationality.getText().toString();
                Intent intent = new Intent(InputActivity.this,Activity3.class);
                intent.putExtra("Info" , s);
                startActivity(intent);
                }else {


                        bday.setError("Invaild Date");
                }}else {

                    Toast.makeText(InputActivity.this, "Invaild ", Toast.LENGTH_LONG).show();
                    name.setError("Fill IT");
                    email.setError("Fill IT");
                    jobTitle.setError("Fill IT");
                    phone.setError("Fill IT");
                    nationality.setError("Fillup IT");
                    bday.setError("Fill IT");
                }
            }
        });

    }

    boolean dateChecker(String d){
        if(d.length() <10 || d.length()>10)return false;
        try
        {
            if(Integer.parseInt(d.substring(0,2)) < 32 && d.charAt(2)== '/'&&
                    Integer.parseInt(d.substring(3,5)) < 13 && d.charAt(5)== '/'&&
                    Integer.parseInt(d.substring(6,8)) < 2021){
                return true;
            }
        }

        catch(NumberFormatException e)
        { return false; }
        return false;
    }
}