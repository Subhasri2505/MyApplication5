package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    ImageView imageProduct;
    TextView textName, textCategory, textPrice, textDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        imageProduct = findViewById(R.id.imageProductDetail);
        textName = findViewById(R.id.textProductNameDetail);
        textCategory = findViewById(R.id.textProductCategoryDetail);
        textPrice = findViewById(R.id.textProductPriceDetail);
        textDescription = findViewById(R.id.textProductDescriptionDetail);

        // Get data from Intent
        String name = getIntent().getStringExtra("name");
        String category = getIntent().getStringExtra("category");
        double price = getIntent().getDoubleExtra("price", 0);
        String description = getIntent().getStringExtra("description");
        int imageResId = getIntent().getIntExtra("image", R.drawable.ic_placeholder);

        // Set data to views
        textName.setText(name);
        textCategory.setText("Category: " + category);
        textPrice.setText("Price: ₹" + price);
        textDescription.setText(description);
        imageProduct.setImageResource(imageResId);
    }
}
