package com.example.measure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnForm1 = (Button)findViewById(R.id.formula1);
        btnForm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent form1Intent = new Intent(getApplicationContext(), Formula1.class);
                startActivity(form1Intent);
            }
        });

        Button btnForm2 = (Button) findViewById(R.id.formula2);
        btnForm2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent form2Intent = new Intent(getApplicationContext(), Formula2.class);
                startActivity(form2Intent);
            }
        }));
    }


}
