package com.pentazon.Shopping;

import com.pentazon.Product.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    Cart cart;


    @BeforeEach
    void setUp() {
        cart = new Cart();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addToCart(){
        assertTrue(cart.getItems().isEmpty());
         Product plantainChips  = new Product("Adunni chips ", "Savoury PlantainChips", new BigDecimal(50));
         cart.addToCart(plantainChips);
         plantainChips.setProductId("AD001");
         cart.addToCart(plantainChips);
         assertFalse(cart.getItems().isEmpty());
         assertEquals(1,cart.getItems().size());
    }

    @Test
    void removeFromCart(){
        assertTrue(cart.getItems().isEmpty());
        Product plantainChips = new Product("Adunni Chips","Savoury plantainChips", new BigDecimal(100));
        plantainChips.setProductId("ADOO1");
        cart.addToCart(plantainChips);
       assertFalse(cart.getItems().isEmpty());
       assertEquals(1,cart.getItems().size());

       boolean result = cart.removeFromCart(plantainChips);
       assertTrue(result);
       assertTrue(cart.getItems().isEmpty());
    }

    @Test
    void calculateTotal(){
        assertTrue(cart.getItems().isEmpty());
        Product plantainChips = new Product("Adunni Chips","Savoury plantainChips", new BigDecimal(50));
        plantainChips.setProductId("ADOO1");
        cart.addToCart(plantainChips);

        Product shirt = new Product("Vintage shirts","Vintage versace shirts", new BigDecimal(5000));
        shirt.setProductId("AD003");
        cart.addToCart(shirt);
        assertFalse(cart.getItems().isEmpty());
        assertEquals(2,cart.getItems().size());
        BigDecimal cartTotal = cart.calculateTotal();
        assertEquals(5050,cartTotal.intValue());

        CartItem chipsItem = cart.getItems().get(plantainChips.getProductId());
        assertEquals(1,chipsItem.getQuantity());
        cart.addToCart(plantainChips,9);
        assertEquals(2,cart.getItems().size());
        chipsItem = cart.getItems().get(plantainChips.getProductId());
        assertEquals(10,chipsItem.getQuantity());

        boolean result = cart.removeFromCart(plantainChips);
        assertTrue(result);
        assertTrue(cart.getItems().isEmpty());
    }
}