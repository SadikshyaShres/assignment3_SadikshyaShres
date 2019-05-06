package com.example.assignment3_SadikshyaShres;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    ImageView imgProduct;
    TextView tvNameLarge, tvPriceLarge, tvProductDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imgProduct=findViewById(R.id.imgProduct);
        tvNameLarge=findViewById(R.id.tvNameLarge);
        tvPriceLarge=findViewById(R.id.tvPriceLarge);
        tvProductDetails=findViewById(R.id.tvProductDetails);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
        imgProduct.setImageResource(bundle.getInt("imagename"));
        tvNameLarge.setText(bundle.getString("productname"));
        tvPriceLarge.setText(bundle.getString("productprice"));
        tvProductDetails.setText(bundle.getString("productdesc"));
        }

    }
}
