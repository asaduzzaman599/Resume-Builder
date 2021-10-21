package com.example.cvmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Update extends AppCompatActivity {

    TextView name,jobTitle,phone,email,birthDay,schl,clg,versity,skill,experience,nationality;

    String[] arrOfInfo;

    Intent in = getIntent();
    //   Bitmap b = in.getBooleanArrayExtra("Info");

    final DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name = findViewById(R.id.uname);
        jobTitle = findViewById(R.id.ujbt);
        email = findViewById(R.id.uemail);
        phone = findViewById(R.id.uphone);
        birthDay=findViewById(R.id.ubirthday);
        nationality = findViewById(R.id.unation);
        schl = findViewById(R.id.uschool);
        clg = findViewById(R.id.ucollege);
        versity = findViewById(R.id.uversity);
        skill = findViewById(R.id.uskills);
        experience = findViewById(R.id.uexperience);


//////////////////Set TEXT //////////////////

        String s = helper.getContacts();
        arrOfInfo = s.split(";");
        name.setText(arrOfInfo[0]);
        jobTitle.setText(arrOfInfo[1]);
        email.setText(arrOfInfo[2]);
        phone.setText(arrOfInfo[3]);
        birthDay.setText(arrOfInfo[4]);
        nationality.setText(arrOfInfo[5]);
        schl.setText(arrOfInfo[6]);
        clg.setText(arrOfInfo[7]);
        versity.setText(arrOfInfo[8]);
        skill.setText(arrOfInfo[9]);
        experience.setText(arrOfInfo[10]);/*
        image2 = findViewById(R.id.image2);*/

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!name.getText().toString().isEmpty() && !birthDay.getText().toString().isEmpty() && !jobTitle.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !phone.getText().toString().isEmpty() && !nationality.getText().toString().isEmpty() && !schl.getText().toString().isEmpty() && !clg.getText().toString().isEmpty() && !versity.getText().toString().isEmpty() && !skill.getText().toString().isEmpty() && !experience.getText().toString().isEmpty()) {
                    if (dateChecker(birthDay.getText().toString())) {
                        if (helper.insert(name.getText().toString(), jobTitle.getText().toString(), email.getText().toString(), birthDay.getText().toString(), phone.getText().toString(), nationality.getText().toString(), schl.getText().toString(), clg.getText().toString(), versity.getText().toString(), skill.getText().toString(), experience.getText().toString()/*,bytes*/)) {
                            Toast.makeText(Update.this, "Updated", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Update.this, "NOT Updated", Toast.LENGTH_LONG).show();
                        }
                        Intent intent = new Intent(Update.this, MainActivity2.class);
                        startActivity(intent);


                    } else {
                        birthDay.setError("Ivaild Date");
                    }
                } else{

                    name.setError("Fill It");
                    jobTitle.setError("Fill It");
                    email.setError("Fill It");
                    phone.setError("Fill It");
                    birthDay.setError("Fill It");
                    nationality.setError("Fill It");
                    schl.setError("Fill It");
                    clg.setError("Fill It");
                    versity.setError("Fill It");
                    skill.setError("Fill It");
                    experience.setError("Fill It");
                }
            }
        });

        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(Update.this, MainActivity2.class);
                startActivity(in);


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