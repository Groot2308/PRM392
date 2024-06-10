package com.example.project_prm392.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_prm392.R;

public class MainActivity extends AppCompatActivity {

    private Button btnstart, btnstart2;

    private void bindingView(){
        btnstart = findViewById(R.id.btnStart);
        btnstart2 = findViewById(R.id.btnStart2);

    }

    private void bindingAction(){
        btnstart.setOnClickListener(this::onbtnstartClick);
        btnstart2.setOnClickListener(this::onbtnstart2Click);


    }

    private void onbtnstart2Click(View view) {
        Intent intent = new Intent(this, Detail2Activity.class );
        startActivity(intent);
    }

    private void onbtnstartClick(View view) {
        Intent intent = new Intent(this, ExerciseScreen.class );
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        bindingView();
        bindingAction();

    }

    public void beforage18(View view) {
        Intent intent = new Intent(this,ExerciseScreen.class );
        startActivity(intent);
    }

    public void afterage18(View view) {
        Intent intent = new Intent(this,Detail2Activity.class );
        startActivity(intent);
    }
}