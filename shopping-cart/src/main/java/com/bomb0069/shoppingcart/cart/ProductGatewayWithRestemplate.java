package com.bomb0069.shoppingcart.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductGatewayWithRestemplate {

    @Autowired
    RestTemplate restTemplate;

    @Value("${PRODUCT_SERVICE:http://localhost:8080}")
    String url;

    public Product getProduct(int id) {
        return restTemplate.getForObject(url + "/api/v1/product/" + id, Product.class);
    }
}
