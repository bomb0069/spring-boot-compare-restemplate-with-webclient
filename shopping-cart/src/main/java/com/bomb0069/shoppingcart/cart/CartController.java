package com.bomb0069.shoppingcart.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    private ProductGatewayWithRestemplate productWithRest;

    @Autowired
    private ProductGatewayWithWebClient productWithWeb;

    @GetMapping("/rest/{id}")
    public CartResponse getCartWithRest(@PathVariable int id) {
        CartResponse cartResponse = new CartResponse(id);

        Product book = productWithRest.getProduct(1);
        cartResponse.addProduct(book);

        Product comic = productWithRest.getProduct(2);
        cartResponse.addProduct(comic);

        return cartResponse;
    }

    @GetMapping("/web/{id}")
    public CartResponse getCartWithWeb(@PathVariable int id) {
        CartResponse cartResponse = new CartResponse(id);

        Product book = productWithWeb.getProduct(1);
        cartResponse.addProduct(book);

        Product comic = productWithWeb.getProduct(2);
        cartResponse.addProduct(comic);

        return cartResponse;
    }
}
