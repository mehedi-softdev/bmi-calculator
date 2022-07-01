package com.mehedidev.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.mehedidev.bmicalculator.controller.HealthSuggestionModel;

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

        try {
            // exception
            Bundle b = getIntent().getExtras();
            double bmiVal = b.getDouble("bmi");
            this.suggestionViewer(bmiVal);
        }catch (Exception e) {
            tvSuggestionOutput.setTextColor(Color.RED);
            tvSuggestionOutput.setText("Sorry! something goes wrong with me!" +
                    " \tI can't provide you health suggestion right now. Try later!");

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Stay Happy! Bye Bye.", Toast.LENGTH_SHORT).show();
    }


//    suggestion viewer functions
    private void suggestionViewer(double bmiVal) {
//        switch handler
        final double bmiValFinal = bmiVal;
        swGenderMale.setOnCheckedChangeListener((compoundButton, b) -> {
                if(b) {
                    if(swGenderFemale.isChecked())
                        swGenderFemale.setChecked(false);
//                    rest of the code
                    tvSuggestionOutput.setText(
                            maleSuggestion(bmiValFinal)
                    );
                }

        });
        swGenderFemale.setOnCheckedChangeListener((compoundButton, b) -> {
            if(b) {
                if(swGenderMale.isChecked())
                    swGenderMale.setChecked(false);
//                rest of the code
                tvSuggestionOutput.setText(
                        femaleSuggestion(bmiValFinal)
                );
            }

        });
    }
//    related with suggestion viewer ( for male )
    private String maleSuggestion(double bmiVal) {
        String suggestion = "";

        if(bmiVal < HealthSuggestionModel.CORRECT_WEIGHT_MIN_VAL) {
            tvSuggestionOutput.setTextColor(Color.RED);
            // person is unhealthy
            suggestion = HealthSuggestionModel.suggestions[
                    HealthSuggestionModel.BAD_HEALTH
                    ];
        }
        else if(bmiVal >= HealthSuggestionModel.CORRECT_WEIGHT_MIN_VAL &&
                bmiVal <= HealthSuggestionModel.CORRECT_WEIGHT_MAX_VAL) {
            tvSuggestionOutput.setTextColor(Color.GREEN);
            suggestion = HealthSuggestionModel.suggestions[
                    HealthSuggestionModel.GOOD_HEALTH
                    ];
        }
        else if (bmiVal > HealthSuggestionModel.CORRECT_WEIGHT_MAX_VAL &&
                bmiVal <= HealthSuggestionModel.HIGH_WEIGHT_MAX_VAL) {
            tvSuggestionOutput.setTextColor(Color.GRAY);
            suggestion = HealthSuggestionModel.suggestions[
                    HealthSuggestionModel.FAT_HEALTH
                    ];
        }
        else if (bmiVal > HealthSuggestionModel.HIGH_WEIGHT_MAX_VAL) {
            tvSuggestionOutput.setTextColor(Color.MAGENTA);
            suggestion = HealthSuggestionModel.suggestions[
                    HealthSuggestionModel.VERY_FATTY_HEALTH
                    ];
        }
        return suggestion;
    }
    //    related with suggestion viewer ( for female )
    private String femaleSuggestion(double bmiVal) {
        String suggestion = "";

        if(bmiVal < HealthSuggestionModel.CORRECT_WEIGHT_MIN_VAL) {
            // person is unhealthy
            suggestion = HealthSuggestionModel.suggestions[
                    HealthSuggestionModel.BAD_HEALTH
                    ];
        }
        else if(bmiVal >= HealthSuggestionModel.CORRECT_WEIGHT_MIN_VAL &&
                bmiVal <= HealthSuggestionModel.CORRECT_WEIGHT_MAX_VAL) {
            suggestion = HealthSuggestionModel.suggestions[
                    HealthSuggestionModel.GOOD_HEALTH
                    ];
        }
        else if (bmiVal > HealthSuggestionModel.CORRECT_WEIGHT_MAX_VAL &&
                bmiVal <= HealthSuggestionModel.HIGH_WEIGHT_MAX_VAL) {
            suggestion = HealthSuggestionModel.suggestions[
                    HealthSuggestionModel.FAT_HEALTH
                    ];
        }
        else if (bmiVal > HealthSuggestionModel.HIGH_WEIGHT_MAX_VAL) {
            suggestion = HealthSuggestionModel.suggestions[
                    HealthSuggestionModel.VERY_FATTY_HEALTH
                    ];
        }
        return suggestion;
    }
}