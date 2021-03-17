package com.pentazon.Product;

import com.pentazon.exceptions.ProductNotFoundExceptions;

/**
 * provides services for dealing with products in pentazon
 */
public interface ProductService {

    /**
     * search for product with specified id
     * @param productId
     * @return product with specified Id
     */

    public Product findProductById(String productId) throws ProductNotFoundExceptions;
}
