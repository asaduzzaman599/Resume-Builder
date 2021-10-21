package com.example.cvmaker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {
    Button submit;
    Bitmap bitmap;
    ImageView img;
    TextView temp;
    String s;
    String[] arrOfInfo;
    byte[] bytes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Intent in = getIntent();

        s = in.getStringExtra("Info");

        arrOfInfo = s.split(":");


        final DatabaseHelper helper = new DatabaseHelper(this);
        Toast.makeText(Activity2.this, "Take a Profile picture", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,0);
        try {

            img = (ImageView)findViewById(R.id.img);
        }catch (Exception e){
            Toast.makeText(Activity2.this, "Inserted", Toast.LENGTH_LONG).show();
        }


        findViewById(R.id.retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Activity2.this, "Take a Profile picture", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
                img = (ImageView)findViewById(R.id.img);
            }
        });


        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);


                if (helper.insert(arrOfInfo[0], arrOfInfo[1],arrOfInfo[2],arrOfInfo[3],arrOfInfo[4],arrOfInfo[5],arrOfInfo[6],arrOfInfo[7],arrOfInfo[8],arrOfInfo[9],arrOfInfo[10]/*, bytes*/)) {
                    Toast.makeText(Activity2.this, "Inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Activity2.this, "NOT Inserted", Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(Activity2.this,MainActivity2.class);
                intent.putExtra("Info","a");
                startActivity(intent);
            }
        });

    }

   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        bitmap =(Bitmap)data.getExtras().get("data");
       img.setImageBitmap(bitmap);
       ByteArrayOutputStream stream = new ByteArrayOutputStream();
       bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

       bytes = stream.toByteArray();
       //bitmap.recycle();

      /* Bitmap b  = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
       img.setImageBitmap(b);*/
    }
}