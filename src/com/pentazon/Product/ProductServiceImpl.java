package com.pentazon.Product;

import com.pentazon.ProductExceptions;

public class ProductServiceImpl implements ProductService{

    private  ProductRepoMock productRepo = new ProductRepoMock();

    /**
     *
     * @param productId
     * @return
     */
    @Override
    public Product findProductById(String productId) throws ProductExceptions {
        return productRepo.getProductById(productId);
    }
}
