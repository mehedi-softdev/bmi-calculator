package com.mehedidev.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etWeightInKg, etHeightInFit, etHeightInInch;
    private TextView tvOutput;
    private Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // linking
        etWeightInKg = findViewById(R.id.etWeightInKg);
        etHeightInFit = findViewById(R.id.etHeightInFit);
        etHeightInInch = findViewById(R.id.etHeightInInch);
        tvOutput = findViewById(R.id.tvOutput);
        btnCalc = findViewById(R.id.btnCalc);

    }

    @Override
    protected void onStart() {
        super.onStart();
        btnCalc.setOnClickListener(view -> setBtnCalcEvent());
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void setBtnCalcEvent() {
//        fetching all videos
        String weightStr = etWeightInKg.getText().toString();
        String heightInFitStr = etHeightInFit.getText().toString();
        String heightInInchStr = etHeightInInch.getText().toString();

        if(weightStr.isEmpty()) weightStr = "0";
        if(heightInFitStr.isEmpty()) heightInFitStr = "0";
        if(heightInInchStr.isEmpty()) heightInInchStr = "0";


//        setting weight and height
        double weight = Double.parseDouble(weightStr);
//        formula to convert fit and inch value to meter
        /**
         * 1 fit = 12 inch
         * then sum total inch value
         * then convert inch to meter
         * 1 inch = 0.0254
         */
        double heightInMeter = ((Double.parseDouble(heightInFitStr) * 12 ) +
                                Double.parseDouble(heightInInchStr)) * 0.0254;

        try {
//            number format class for displaying decimal value in 2 decimal place
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMinimumIntegerDigits(2);
            numberFormat.setMaximumFractionDigits(2);
//      displaying output
            double bmi = (weight/(Math.pow(heightInMeter, 2)));
            tvOutput.setText("YOUR BMI IS : " + numberFormat.format(bmi));
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Please insert correct values!", Toast.LENGTH_SHORT).show();
        }


    }
}