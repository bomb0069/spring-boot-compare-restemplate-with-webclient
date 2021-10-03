package com.bomb0069.shoppingcart.cart;

import java.util.ArrayList;
import java.util.List;

public class CartResponse {
    private int id;

    private List<Product> products = new ArrayList<>();

    private int total;

    public CartResponse() {
    }

    public CartResponse(int id) {
        this.id = id;
    }

    public void addProduct(Product product) {
        total = total + product.getPrice();
        products.add(product);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
