package Product;

import com.pentazon.Product.Product;
import com.pentazon.Product.ProductService;
import com.pentazon.Product.ProductServiceImpl;
import com.pentazon.exceptions.ProductNotFoundExceptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    ProductService productService;
    Product product;

    @BeforeEach
    void setUp() {
        productService = new ProductServiceImpl() ;
        product = new Product("TestProduct", "Product for testing purpose",new BigDecimal(50));


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findProduct(){
        Product product = null;
        try {
            product = productService.findProductById("AD001");
        } catch (ProductNotFoundExceptions productExceptions) {
            productExceptions.printStackTrace();
        }
        assertNotNull(product);

    }

    @Test
    void findProductWithInvalidID(){
//        com.pentazon.Product product = null;
//        try {
//            product = productService.findProductById("AD001");
//        } catch (ProductExceptions productExceptions) {
//            productExceptions.printStackTrace();
//        }
        assertThrows(ProductNotFoundExceptions.class,()->productService.findProductById("DUD008"));


    }
    @Test
    void addProductWithNullName(){
        assertThrows(ProductNotFoundExceptions.class,()->productService.addProduct(product));
    }

    @Test
    void addProductWithEmptyName(){
        product.setName(null);
        assertThrows(ProductNotFoundExceptions.class,()->productService.addProduct(product));
    }

    @Test
    void addProduct(){
        Map<String,Product> initialProducts = productService.getAllProducts();
        assertTrue(initialProducts.size()==3);

        try{
            boolean result = productService.addProduct(product);
            Map<String, Product> allProducts = productService.getAllProducts();
            assertTrue(result);
            assertTrue(allProducts.size()==4);
        }catch (ProductNotFoundExceptions e){
            e.printStackTrace();
        }
    }

    @Test
    void removeNullProducts(){
        assertThrows(ProductNotFoundExceptions.class,()->productService.addProduct(product));
    }

}