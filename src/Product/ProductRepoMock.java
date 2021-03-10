package Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductRepoMock {
    private List<Product> mockProducts;

    public  ProductRepoMock(){
        mockProducts = new ArrayList<>();
        Product plantainChips = new Product( "Adunni chips", "Savour plantain Chips",new BigDecimal(12));
        plantainChips.setProductId("AD001");
        mockProducts.add(plantainChips);


        Product noseMasks = new Product();
        noseMasks.setProductId("AD002");
        noseMasks.setName("Bomu e nose mask");
        noseMasks.setDescription("Best in class nose masks");
        noseMasks.setPrice(new BigDecimal(4500));
        mockProducts.add(noseMasks);


        Product shirt = new Product("vintage shirt", "Vintage versace shirt", new BigDecimal(5000));
        shirt.setProductId("AD003");
        mockProducts.add(shirt);

    }

    public List<Product> getMockProducts(){
        return mockProducts;
    }

    public  void  setMockProducts(List<Product> mockProducts){
        this.mockProducts = mockProducts;
    }

    public Product getProductById(String Id){
        Product result = null;

        return result;
    }

}
