package com.example.assignment3_SadikshyaShres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class AddProductActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etProductName, etProductPrice, etImageName, etDescription;
    private Button btnAddProduct, btnReturnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        etProductName = findViewById(R.id.etProductName);
        etProductPrice = findViewById(R.id.etProductPrice);
        etImageName = findViewById(R.id.etImageName);
        etDescription = findViewById(R.id.etDescription);
        btnAddProduct = findViewById(R.id.btnAddProduct);
        btnReturnBack = findViewById(R.id.btnReturnBack);

        btnAddProduct.setOnClickListener(this);
        btnReturnBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
    if(v.getId()==R.id.btnReturnBack){
        Intent intent = new Intent(AddProductActivity.this, DashboardActivity.class);
        startActivity(intent);
    } else if (v.getId()==R.id.btnAddProduct){
        AddItem();
    }
    }

    private void AddItem(){
        String productname = "productname";
        String productprice = "productprice";
        String imagename = "imagename";
        String productdesc = "productdesc";

        try{
            PrintStream printStream = new PrintStream(openFileOutput("Products", MODE_PRIVATE | MODE_APPEND));
            printStream.println(etProductName.getText().toString()+"->"+etProductPrice.getText().toString()+"->"+etImageName.getText().toString()+"->"+etDescription.getText().toString());
            Toast.makeText(this, "Saved to"+getFilesDir(), Toast.LENGTH_LONG).show();
        } catch (IOException e){
            Log.d("Online Clothe Store","Error: "+e.toString());
            e.printStackTrace();
        }
    }
}
