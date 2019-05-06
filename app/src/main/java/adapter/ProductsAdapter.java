package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignment3_SadikshyaShres.DetailsActivity;
import com.example.assignment3_SadikshyaShres.R;

import java.util.List;

import model.Product;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder> {
    Context mContext;
    List<Product> productList;

    public ProductsAdapter(Context mContext, List<Product> productList) {
        this.mContext = mContext;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product,viewGroup,false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder productsViewHolder, int i) {
        final Product product = productList.get(i);
        productsViewHolder.imgClothe.setImageResource(Integer.parseInt(product.getImageName()));
        productsViewHolder.tvName.setText(product.getProductName());
        productsViewHolder.tvPrice.setText(product.getProductPrice());

        productsViewHolder.imgClothe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtra("imagename", Integer.parseInt(product.getImageName()));
                intent.putExtra("productname", product.getProductName());
                intent.putExtra("productprice", product.getProductPrice());
                intent.putExtra("productdesc", product.getProductDetails());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public class ProductsViewHolder extends RecyclerView.ViewHolder{
        ImageView imgClothe;
        TextView tvName, tvPrice;
        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);

            imgClothe=itemView.findViewById(R.id.imgClothe);
            tvName=itemView.findViewById(R.id.tvName);
            tvPrice=itemView.findViewById(R.id.tvPrice);

        }
    }


}
