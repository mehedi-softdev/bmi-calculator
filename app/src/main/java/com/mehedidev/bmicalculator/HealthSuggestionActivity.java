package com.mehedidev.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HealthSuggestionActivity extends AppCompatActivity {
    private SwitchCompat swGenderMale, swGenderFemale;
    private TextView tvSuggestionOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_suggestion);
//        getting instance
        swGenderMale = findViewById(R.id.swGenderMale);
        swGenderFemale = findViewById(R.id.swGenderFemale);
        tvSuggestionOutput = findViewById(R.id.tvSuggestionOutput);

    }

    @Override
    protected void onStart() {
        super.onStart();
        this.suggestionViewer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Stay Happy! Bye Bye.", Toast.LENGTH_SHORT).show();
    }

//    suggestion viewer functions
    private void suggestionViewer() {
//        switch handler
        swGenderMale.setOnCheckedChangeListener((compoundButton, b) -> {
            if(swGenderFemale.isChecked()) {
                swGenderFemale.setChecked(false);
            }
        });
        swGenderFemale.setOnCheckedChangeListener((compoundButton, b) -> {
            if(swGenderMale.isChecked()) {
                swGenderMale.setChecked(false);
            }
        });
    }
}