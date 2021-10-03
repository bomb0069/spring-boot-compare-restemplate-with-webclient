package com.bomb0069.shoppingcart.cart;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Service
public class ProductGatewayWithWebClient {

    @Autowired
    private WebClient client;

    public Product getProduct(int id) {

        Mono<Product> productMono = client.get().uri("/api/v1/product/" + id)
                .exchangeToMono(
                    result -> {
                        return result.bodyToMono(Product.class);
                    }
                );

        return productMono.block();
    }
}
