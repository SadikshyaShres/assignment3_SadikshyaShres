package model;

public class Product {
    String productName, productPrice, productDetails;
    String imageName;

    public Product(){}

    public Product(String productName, String productPrice, String productDetails, String imageName) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDetails = productDetails;
        this.imageName = imageName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
