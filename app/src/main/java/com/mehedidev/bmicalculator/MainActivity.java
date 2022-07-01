package com.mehedidev.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etWeightInKg, etHeightInFit, etHeightInInch;
    private TextView tvOutput;
    private Button btnCalc, btnHealthSuggestion;
    private double bmi = 0d;

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
        btnHealthSuggestion = findViewById(R.id.btnHealthSuggestion);
        btnHealthSuggestion.setVisibility(View.INVISIBLE); // it should display after
                                                            // displaying bmi
                                                            // result
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnCalc.setOnClickListener(view -> setBtnCalcEvent());
        btnHealthSuggestion.setOnClickListener(view -> setBtnHealthSuggestionEvent());
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
        if(heightInFitStr.isEmpty()) heightInFitStr = "1"; // defaults if empty
        if(heightInInchStr.isEmpty()) heightInInchStr = "1";


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
            bmi = (weight/(Math.pow(heightInMeter, 2)));
            bmi = Double.parseDouble(numberFormat.format(bmi));

            // if success then displaying suggestion button
            if(bmi != 0 && Double.isFinite(bmi)) {
                // if zero then don't need to show suggestion button
                tvOutput.setText("YOUR BMI IS : " + bmi);
                btnHealthSuggestion.setVisibility(View.VISIBLE);
            }
            else {
                tvOutput.setText("Funny! You are not inserted correct values");
            }


        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Please insert correct values!", Toast.LENGTH_SHORT).show();
        }
    } // setBtnCalcEvent()

    private void setBtnHealthSuggestionEvent() {
//        passing bmi result to suggestion activity
        Intent intent = new Intent(MainActivity.this,
                HealthSuggestionActivity.class);
        Bundle b = new Bundle();
        b.putDouble("bmi", this.bmi);
        intent.putExtras(b);
        startActivity(intent);
    }
}