package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {
    Button womenButton, menButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        womenButton = findViewById(R.id.buttonWomen);
        menButton = findViewById(R.id.buttonMen);

        womenButton.setOnClickListener(v -> {
            Intent intent = new Intent(CategoryActivity.this, HomeActivity.class);
            intent.putExtra("category_name", "Women");
            startActivity(intent);
        });

        menButton.setOnClickListener(v -> {
            Intent intent = new Intent(CategoryActivity.this, HomeActivity.class);
            intent.putExtra("category_name", "Men");
            startActivity(intent);
        });
    }
}
