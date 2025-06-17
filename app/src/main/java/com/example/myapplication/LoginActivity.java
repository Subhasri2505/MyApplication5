package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin;

    private FirebaseAuth mAuth;
    private SharedPreferences sharedPreferences;

    private static final String PREF_NAME = "AdminLoginPrefs";
    private static final String KEY_LOGGED_IN = "isLoggedIn";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        // Check if user is already logged in
        if (sharedPreferences.getBoolean(KEY_LOGGED_IN, false)) {
            // Directly go to HomeActivity
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        // Link UI elements
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Handle login button click
        buttonLogin.setOnClickListener(view -> {
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                return;
            }

            // Attempt Firebase login
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            // Save login status in SharedPreferences
                            sharedPreferences.edit().putBoolean(KEY_LOGGED_IN, true).apply();

                            // Go to HomeActivity using Intent
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish(); // Close login page so user can't go back
                        } else {
                            Toast.makeText(this, "Login failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        });
    }
}
