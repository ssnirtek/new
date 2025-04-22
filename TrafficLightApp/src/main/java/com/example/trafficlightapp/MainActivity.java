package com.example.trafficlightapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private View redLight, yellowLight, greenLight;
    private int state = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redLight = findViewById(R.id.redLight);
        yellowLight = findViewById(R.id.yellowLight);
        greenLight = findViewById(R.id.greenLight);
        Button button = findViewById(R.id.button);

        if (savedInstanceState != null) {
            state = savedInstanceState.getInt("lightState", 0);
        }

        updateLights();

        button.setOnClickListener(v -> {
            state = (state + 1) % 5;
            updateLights();
        });
    }

    private void updateLights() {
        redLight.setBackgroundColor(Color.DKGRAY);
        yellowLight.setBackgroundColor(Color.DKGRAY);
        greenLight.setBackgroundColor(Color.DKGRAY);

        switch (state) {
            case 0:
                redLight.setBackgroundColor(Color.RED);
                break;
            case 1:
                yellowLight.setBackgroundColor(Color.YELLOW);
                break;
            case 2:
                greenLight.setBackgroundColor(Color.GREEN);
                break;
            case 3:
                yellowLight.setBackgroundColor(Color.YELLOW);
                break;
            case 4:
                redLight.setBackgroundColor(Color.RED);
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("lightState", state);
    }
}
