package com.mehedidev.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class FlashActivity extends AppCompatActivity {
    private ImageView btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        btnEnter = findViewById(R.id.btnEnter);
        btnEnter.setOnClickListener(view -> {
            startActivity(new Intent(FlashActivity.this, MainActivity.class));
        });
    }
}