package com.example.measure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Formula1 extends AppCompatActivity {

    double diameter, radius, capacity, height, circumf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula1);

        final Spinner spinner1 = (Spinner) findViewById(R.id.spinnerHeight);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.units, android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        final Spinner spinner2 = (Spinner) findViewById(R.id.spinnerCircumf);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.units, android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        final Spinner spinner3 = (Spinner) findViewById(R.id.spinnerRes);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,R.array.units, android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

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
                if((heightText.getText().toString().trim().length()>0) && (circumfText.getText().toString().trim().length()>0)) {
                    height = Double.parseDouble(heightText.getText().toString());
                    circumf = Double.parseDouble(circumfText.getText().toString());
                    String unit1 = spinner1.getSelectedItem().toString();
                    String unit2 = spinner2.getSelectedItem().toString();
                    String unit3 = spinner3.getSelectedItem().toString();
                    if(unit1.equals("mm")){
                        height = height/10;
                    }
                    if(unit2.equals("mm")){
                        circumf = circumf/10;
                    }

                    diameter = circumf/3.14;
                    radius = diameter/2;
                    capacity = 3.14*radius*radius*height;
                    capacity /= 1000;
                    if(unit3.equals("mm")){
                        diameter *= 10;
                        radius *= 10;
                    }
                    String dia = "Diameter = "+ String.format("%.3g", diameter) + " " + unit3;
                    String rad = "Radius = "+ String.format("%.3g", radius) + " "+ unit3;
                    String cap = "Capacity = "+ String.format("%.3g", capacity) + " L";


                    cons1.setVisibility(View.VISIBLE);
                    cons2.setVisibility(View.VISIBLE);
                    cons3.setVisibility(View.VISIBLE);
                    cons4.setVisibility(View.VISIBLE);
                    textDiameter.setText(dia);
                    textRadius.setText(rad);
                    textCapacity.setText(cap);
                }
                else {
                    String msg = "Enter Height and Circumference!!";
                    Toast toast;
                    toast = Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

    }






}
