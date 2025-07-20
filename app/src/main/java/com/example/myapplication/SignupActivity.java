package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class SignupActivity extends AppCompatActivity {

    private EditText editTextFullName, editTextEmail, editTextPassword, editTextConfirmPassword;
    private Button buttonSignup;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextFullName = findViewById(R.id.editTextFullName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignup = findViewById(R.id.buttonSignup);

        buttonSignup.setOnClickListener(v -> {
            String FullName = editTextFullName.getText().toString().trim();
            String Email = editTextEmail.getText().toString().trim();
            String Password = editTextPassword.getText().toString().trim();

            if (FullName.isEmpty() || Email.isEmpty() || Password.isEmpty()) {
                Toast.makeText(this, "Please enter the detail", Toast.LENGTH_SHORT).show();
            }

            HashMap<String, Object> users = new HashMap<>();
            users.put("Name", FullName);
            users.put("Email", Email);
            users.put("Password", Password);

            db.collection("user")
                    .add(users)
                    .addOnSuccessListener(documentReference -> {
                        Toast.makeText(this, "User registered successfully", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e ->
                            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show()
                    );
    //private void clearFeilds() {
                //editTextEmail.setText("");
                //editTextFullName.setText("");
                //editTextPassword.setText("");
           // }
    })
    ;}
}