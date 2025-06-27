package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Product> productList;
    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerViewProducts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample product list
        List<Product> allProducts = new ArrayList<>();
        allProducts.add(new Product("Wedding Frog", "Women", 1949, "Perfect for parties.", R.drawable.dress_3));
        allProducts.add(new Product("Classic Black Suit", "Men", 1008, "Formal & stylish.", R.drawable.suit_black));
        allProducts.add(new Product("Red Floral dress", "Women", 1039, "Light and breezy.", R.drawable.sample_dress));
        allProducts.add(new Product("Denim Jacket", "Men", 500, "Stylish & comfortable.", R.drawable.jacket_denim));
        allProducts.add(new Product("Wedding Saree", "Women", 1000, "Perfect for traditional events.", R.drawable.saree_1));
        allProducts.add(new Product("T-Shirt", "Men", 500, "Perfect for summer.", R.drawable.t_shirt));

        String categoryFilter = getIntent().getStringExtra("category_name");

        productList = new ArrayList<>();
        if (categoryFilter != null) {
            for (Product p : allProducts) {
                if (categoryFilter.equalsIgnoreCase(p.getCategory())) {
                    productList.add(p);
                }
            }
        } else {
            productList = allProducts;
        }

        adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // You can remove this method entirely if no products will be added dynamically.
    }
}
