package com.example.project_prm392;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;
import java.util.ArrayList;

public class ItemDetailActivity extends AppCompatActivity {

    private int[] newArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
         });
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        SQLiteHelper dbHelper = new SQLiteHelper(this);
        List<Integer> exerciseIds = dbHelper.getAllExerciseIds();

        newArray = new int[exerciseIds.size()];
        for (int i = 0; i < exerciseIds.size(); i++) {
            newArray[i] = exerciseIds.get(i);
        }

    }

    public void Imagebtnonclicked(View view) {
        int viewId = view.getId();
        Log.d("Imagebtnonclicked", "View ID: " + viewId);
        if (viewId == R.id.boat_pose) {
            Intent intent = new Intent(this, Detail2Activity.class);
            startActivity(intent);
        }
    }
}