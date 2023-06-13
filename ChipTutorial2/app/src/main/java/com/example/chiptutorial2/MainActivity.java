package com.example.chiptutorial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.google.android.material.chip.Chip;

public class MainActivity extends AppCompatActivity {

    Chip chip, chip2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chip = findViewById(R.id.chip);
        chip2 = findViewById(R.id.chip2);


        // click on this button and it closes
        chip.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chip.setVisibility(View.GONE);
            }
        });

        chip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chip2.setChecked(true);
                chip2.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.purple_200)));
            }

        });
        chip2.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chip2.setChecked(false);
                chip2.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.purple_500)));

            }
        });


    }
}