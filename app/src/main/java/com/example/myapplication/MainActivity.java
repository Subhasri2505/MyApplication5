package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageView navIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.toolbar);
        navIcon = findViewById(R.id.nav_icon);

        setSupportActionBar(toolbar);

        // Custom navigation icon click opens drawer
        navIcon.setOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        // Handle navigation menu item clicks
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                } else if (id == R.id.nav_category) {
                    startActivity(new Intent(MainActivity.this, CategoryActivity.class));
                } else if (id == R.id.nav_product) {
                    startActivity(new Intent(MainActivity.this, ProductManagementActivity.class));
                } else if (id == R.id.nav_demo_product_detail) {
                    Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
                    intent.putExtra("name", "Sample Dress");
                    intent.putExtra("category", "Women");
                    intent.putExtra("price", 1099.0);
                    intent.putExtra("description", "Elegant and comfortable. Perfect for all occasions.");
                    intent.putExtra("image", R.drawable.sample_dress); // make sure this drawable exists
                    startActivity(intent);
                } else if (id == R.id.nav_logout) {
                    Toast.makeText(MainActivity.this, "Logging Out", Toast.LENGTH_SHORT).show();
                    finish(); // or redirect to login
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
