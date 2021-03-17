package com.pentazon.Product;

import com.pentazon.exceptions.ProductNotFoundExceptions;

import java.util.Map;

public class ProductServiceImpl implements ProductService{

    private ProductDataBase productRepo = new ProductDataBase();

    /**
     *
     * @param productId
     * @return
     */
    @Override
    public Product findProductById(String productId) throws ProductNotFoundExceptions {
        return productRepo.getProductById(productId);
    }

    @Override
    public Map<String, Product> getAllProducts() {
        return productRepo.getMockProducts();
    }

    @Override
    public boolean addProduct(Product product) throws ProductNotFoundExceptions {

        boolean result = this.isValidProduct(product);
        productRepo.getMockProducts().put(product.getProductId(), product);

            return true;
    }
    @Override
    public boolean removeProduct(Product product) throws ProductNotFoundExceptions {
        return false;
    }

    public  boolean isValidProduct(Product product) throws ProductNotFoundExceptions{
            if(product == null){
                throw new ProductNotFoundExceptions("Cannot add a null product");
            }
            if(product.getName() == null || product.getName().equals(" ")){
                throw new ProductNotFoundExceptions("Cannot add a null product");
            }
            if(product.getPrice() == null){
                throw new ProductNotFoundExceptions("Every product needs a price");
            }

            return true;
        }
    }

