package com.example.measure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Formula1 extends AppCompatActivity {

    double diameter, radius, capacity, height, circumf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula1);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinnerHeight);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.units, android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinnerCircumf);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.units, android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        final EditText heightText = (EditText) findViewById(R.id.editTextHeight);
        final EditText circumfText = (EditText) findViewById(R.id.editTextCircumf);
        final TextView textDiameter = (TextView) findViewById(R.id.viewDiameter);
        final TextView textRadius = (TextView) findViewById(R.id.viewRadius);
        final TextView textCapacity = (TextView) findViewById(R.id.viewCapacity);
        final ConstraintLayout cons1 = (ConstraintLayout) findViewById(R.id.cons1);
        final ConstraintLayout cons2 = (ConstraintLayout) findViewById(R.id.cons2);
        final ConstraintLayout cons3 = (ConstraintLayout) findViewById(R.id.cons3);
        final ConstraintLayout cons4 = (ConstraintLayout) findViewById(R.id.cons4);
        Button calculate = (Button) findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height = Double.parseDouble(heightText.getText().toString());
                circumf = Double.parseDouble(circumfText.getText().toString());
                diameter = circumf/3.14;
                diameter = Math.round(diameter * 100000d) / 100000d;
                radius = circumf/2;
                radius = Math.round(radius * 100000d) / 100000d;
                capacity = 3.14*radius*radius*height;
                capacity = Math.round(capacity * 100000d) / 100000d;
                String dia = "Diameter = "+ String.format("%.5g%n", diameter);
                String rad = "Radius = "+ radius;
                String cap = "Capacity = "+ capacity;

                cons1.setVisibility(View.VISIBLE);
                cons2.setVisibility(View.VISIBLE);
                cons3.setVisibility(View.VISIBLE);
                cons4.setVisibility(View.VISIBLE);
                textDiameter.setText(dia);
                textRadius.setText(rad);
                textCapacity.setText(cap);
            }
        });

    }






}
