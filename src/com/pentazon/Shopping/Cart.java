package com.pentazon.Shopping;

import com.pentazon.Product.Product;
import com.pentazon.Product.ProductService;
import com.pentazon.Product.ProductServiceImpl;
import com.pentazon.ProductExceptions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Cart {
    private Logger logger = Logger.getLogger(Cart.class.getName());
    private Map<String, CartItem> items;
   private ProductService productService = new ProductServiceImpl();

    public Cart(){
        items = new HashMap<>();
        productService = new ProductServiceImpl() ;

    }

    public void addToCart(Product product){
        if(verifiedProduct(product)){
            CartItem item = items.get(product.getProductId());
            if(item == null){
                item = new CartItem(product);

            }
            item.addItems(BigInteger.ONE.intValue());
                this.items.put(product.getProductId(), item);
            }

        }



    public boolean verifiedProduct(Product product){
        boolean verified = false;
        if(product != null){
            try{
                Product verifiedProduct = productService.findProductById(product.getProductId());
                verified = true;
            }catch (ProductExceptions ignored){

            }
        }return verified;
    }

    public boolean removeFromCart(Product product){
        boolean removed = false;
        if(product != null){
            this.items.remove(product);
            removed = true;
        }
        return removed;
    }

    public List<Product> getProducts() {
        return items;
    }

    public void setProducts(List<Product> products) {
        this.items = products;
    }
}
