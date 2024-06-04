package com.example.project_prm392;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        Intent intent = new Intent(this,Detail2Activity.class );
        startActivity(intent);
    }

    private void onbtnstartClick(View view) {
        Intent intent = new Intent(this,DetailActivity.class );
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
        Intent intent = new Intent(this,DetailActivity.class );
        startActivity(intent);
    }

    public void afterage18(View view) {
        Intent intent = new Intent(this,Detail2Activity.class );
        startActivity(intent);
    }
}