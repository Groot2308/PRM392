package com.example.project_prm392;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private void bindingView(){


    }

    private void bindingAction(){
        buttonCalculateBMI.setOnClickListener(this::onbuttonCalculateBMIClick);
        
    }

    private void onbuttonCalculateBMIClick(View view) {
        String heightStr = editTextHeight.getText().toString();
        String weightStr = editTextWeight.getText().toString();
        if (heightStr.isEmpty() || weightStr.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            float height = Float.parseFloat(heightStr) / 100;
            float weight = Float.parseFloat(weightStr);
            bmi = weight / (height * height);
            Toast.makeText(MainActivity.this, "Your BMI is: " + bmi, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        bindingView();
        bindingAction();
    }
}