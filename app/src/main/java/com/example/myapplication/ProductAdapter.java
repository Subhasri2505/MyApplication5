package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.textName.setText(product.getName());
        holder.textCategory.setText(product.getCategory());
        holder.textPrice.setText("₹" + product.getPrice());
        holder.textDescription.setText(product.getDescription());
        holder.imageProduct.setImageResource(product.getImageResId());

        // ➕ Add click listener to show product detail
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductDetailActivity.class);
            intent.putExtra("name", product.getName());
            intent.putExtra("category", product.getCategory());
            intent.putExtra("price", product.getPrice());
            intent.putExtra("description", product.getDescription());
            intent.putExtra("image", product.getImageResId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textCategory, textPrice, textDescription;
        ImageView imageProduct;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textCategory = itemView.findViewById(R.id.textCategory);
            textPrice = itemView.findViewById(R.id.textPrice);
            textDescription = itemView.findViewById(R.id.textDescription);
            imageProduct = itemView.findViewById(R.id.imageProduct);
        }
    }
}
