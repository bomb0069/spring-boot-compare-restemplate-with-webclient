package com.bomb0069.productservice.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private int delayTime = 500;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/product")
    public List<ProductResponse> getProducts() {
        try {
            sleep(delayTime);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }

        List<ProductResponse> productResponses = new ArrayList<>();

        ProductResponse book = new ProductResponse(1, "book", 250);
        ProductResponse comic = new ProductResponse(2, "comic", 50);
        ProductResponse note = new ProductResponse(3, "note", 35);
        ProductResponse gift = new ProductResponse(4, "gift", 299);

        productResponses.add(book);
        productResponses.add(comic);
        productResponses.add(note);
        productResponses.add(gift);
        return productResponses;
    }

    @GetMapping("/product/{id}")
    public ProductResponse getProduct(@PathVariable int id) {
        try {
            sleep(delayTime);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        return new ProductResponse(id, "book", 250);
    }

    @PostMapping("/delay")
    public int setDelay(@RequestParam int delayTime) {
        this.delayTime = delayTime;
        return delayTime;
    }
}
