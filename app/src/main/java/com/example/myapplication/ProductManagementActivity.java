package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductManagementActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_management);

        recyclerView = findViewById(R.id.recyclerViewProductManagement);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();

        productList.add(new Product("Wedding Frog", "Women", 1949, "Perfect for parties.", R.drawable.dress_3));
        productList.add(new Product("Classic Black Suit", "Men", 1008, "Formal & stylish.", R.drawable.suit_black));
        productList.add(new Product("Red Floral dress", "Women", 1039, "Light and breezy.", R.drawable.sample_dress));
        productList.add(new Product("Denim Jacket", "Men", 500, "Stylish & comfortable.", R.drawable.jacket_denim));
        productList.add(new Product("Wedding saree", "Women", 1000, "Perfect for traditional", R.drawable.saree_1));
        productList.add(new Product("T-Shirt", "Men", 500, "Perfect for summer.", R.drawable.t_shirt));

        ProductAdapter adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);
    }
}
