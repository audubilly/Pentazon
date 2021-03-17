package com.pentazon.Product;

import com.pentazon.exceptions.ProductNotFoundExceptions;

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
}
