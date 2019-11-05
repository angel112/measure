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

public class Formula2 extends AppCompatActivity {

    double thickness, outDiameter, inDiameter, workPressure, WP, eff = 0.8, fos = 5, tensileStrength = 55000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula2);

        final Spinner spinner1 = (Spinner) findViewById(R.id.spinnerThick);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        final Spinner spinner2 = (Spinner) findViewById(R.id.spinnerOutDia);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        final EditText thickText = (EditText) findViewById(R.id.editTextThickness);
        final EditText outDiaText = (EditText) findViewById(R.id.editTextOutDiam);
        final TextView textInDia = (TextView) findViewById(R.id.viewInDia);
        final TextView textWorkPres = (TextView) findViewById(R.id.viewWorkPres);
        final TextView textWP = (TextView) findViewById(R.id.viewWP);
        final ConstraintLayout cons1 = (ConstraintLayout) findViewById(R.id.cons1);
        final ConstraintLayout cons2 = (ConstraintLayout) findViewById(R.id.cons2);
        final ConstraintLayout cons3 = (ConstraintLayout) findViewById(R.id.cons3);
        final ConstraintLayout cons4 = (ConstraintLayout) findViewById(R.id.cons4);
        Button calculate = (Button) findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((thickText.getText().toString().trim().length() > 0) && (outDiaText.getText().toString().trim().length() > 0)) {
                    thickness = Double.parseDouble(thickText.getText().toString());
                    outDiameter = Double.parseDouble(outDiaText.getText().toString());
                    String unit1 = spinner1.getSelectedItem().toString();
                    String unit2 = spinner2.getSelectedItem().toString();
                    if (unit1.equals("mm")) {
                        thickness /= 10;
                    }
                    if (unit2.equals("mm")) {
                        outDiameter /= 10;
                    }

                    inDiameter = outDiameter - (2 * thickness);
                    workPressure = 2*(tensileStrength * thickness * eff) / (inDiameter * fos);
                    WP = workPressure / 14.22;

                    String iD = "Inner Diameter = " + String.format("%.5g", inDiameter) + " cm";
                    String wop = "Working Pressure = " + String.format("%.5g", workPressure) + " psi";
                    String wp = "WP = " + String.format("%.5g", WP) + " kg/cm";

                    cons1.setVisibility(View.VISIBLE);
                    cons2.setVisibility(View.VISIBLE);
                    cons3.setVisibility(View.VISIBLE);
                    cons4.setVisibility(View.VISIBLE);
                    textInDia.setText(iD);
                    textWorkPres.setText(wop);
                    textWP.setText(Html.fromHtml(wp + "<sup><small>2</small></sup>"));
                } else {
                    String msg = "Enter Thickness and Outer Diameter!!";
                    Toast toast;
                    toast = Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}


