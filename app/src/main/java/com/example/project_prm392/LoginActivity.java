package com.example.project_prm392;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText editTextUsername, editTextPassword;
    Button buttonLogin;
    SQLiteHelper dbHelper;

    private void bindingView(){
        editTextUsername = findViewById(R.id.signupname);
        editTextPassword = findViewById(R.id.confirmpass);
        buttonLogin = findViewById(R.id.btnsignup);
//        buttonRegister = findViewById(R.id.buttonRegister);
    }

    private void bindingAction(){
        dbHelper = new SQLiteHelper(this);
        buttonLogin.setOnClickListener(this::onbuttonLoginClick);
//        buttonRegister.setOnClickListener(this::onbuttonRegisterClick);

    }

    public void onSignUpClick(View view){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private void onbuttonLoginClick(View view) {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username=? AND password=?", new String[]{username, password});
            if (cursor.moveToFirst()) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
            cursor.close();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        bindingView();
        bindingAction();
    }
}