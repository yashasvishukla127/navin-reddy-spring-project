package com.example.simpleWebApp.service;

import com.example.simpleWebApp.model.Product;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@SpringBootApplication
public class ProductService {

    List<Product> products = new ArrayList<>( Arrays.asList(
            new Product(101,"appil" , 90000),
            new Product(102,"samsungh",55000)
    ));


    public List <Product> getProducts(){
        return products;
    }

    public Product getProductById(int prodId) {
        return products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst().get();
    }
    
    public void addProduct (Product prod){
        products.add(prod);
    }

    public void updateProduct(Product prod) {
        int index =0;
        for(int i =0; i<products.size(); i++)
            if(products.get(i).getProdId() == prod.getProdId())
                index =  i;
        products.set(index ,prod);
    }

    public void deleteProduct(int prodId) {
        int index =0;
        for(int i =0; i<products.size(); i++)
            if(products.get(i).getProdId() == prodId)
                index =  i;
        products.remove(index);

    }


}
