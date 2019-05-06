package com.example.assignment3_SadikshyaShres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import adapter.ProductsAdapter;
import model.Product;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button btnProduct;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.recyclerView);
        productList = new ArrayList<>();
        Readfromfile();

        btnProduct = findViewById(R.id.btnProduct);
        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddProductActivity.class);
                startActivity(intent);
            }
        });

        ProductsAdapter productsAdapter = new ProductsAdapter(this, productList);
        recyclerView.setAdapter(productsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void Readfromfile(){
        try{
            FileInputStream fis = openFileInput("Products");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line="";

            while ((line=br.readLine())!=null){
                String[] parts = line.split("->");
                Product product = new Product();
                product.setProductName(parts[0]);
                product.setProductPrice(parts[1]);
                int img = getResources().getIdentifier(parts[2], "drawable", getPackageName());
                product.setImageName(Integer.toString(img));
                product.setProductDetails(parts[3]);

                productList.add(product);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    }


