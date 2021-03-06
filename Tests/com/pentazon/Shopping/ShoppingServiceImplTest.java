package com.pentazon.Shopping;

import com.pentazon.Customers.Address;
import com.pentazon.Customers.Buyer;
import com.pentazon.Customers.Customer;
import com.pentazon.Payments.PaymentCard;
import com.pentazon.Product.ProductDataBase;
import com.pentazon.exceptions.CheckOutException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.*;

class ShoppingServiceImplTest {
    private ShoppingService shoppingService;
    private Buyer dozie;

    @BeforeEach
    void setUp() {
        shoppingService = new ShoppingServiceImpl();
        ProductDataBase products = new ProductDataBase();
        dozie = new Buyer();
        PaymentCard fbnVisa = new PaymentCard("123456", "Don Dozie",
                LocalDate.of(2025, 1, 1));
        dozie.getCards().add(fbnVisa);
        Cart dozieCart = new Cart();

        dozieCart.addToCart(products.getMockProducts().get("AD001"), 5);
        dozieCart.setPaymentCard(dozie.getCards().get(0));
        Address home = new Address();
        home.setHouseNumber(6);
        home.setStreet("Aso Rock Avenue");
        home.setCity("Abuja");
        dozie.getAddresses().add(home);
        dozieCart.setDeliveryAddress(dozie.getAddresses().get(0));
        dozie.setCart(dozieCart);
    }

    @Test
    void checkOutWithNullBuyer() {
        assertThrows(CheckOutException.class, () -> shoppingService.checkOut(null));
    }

    @Test
    void checkOutWithNullCart() {
        dozie.setCart(new Cart());
        assertThrows(CheckOutException.class, () -> shoppingService.checkOut(dozie));

    }

    @Test
    void checkOutWithEmptyCart() {
        dozie.setCart(new Cart());
        assertThrows(CheckOutException.class, () -> shoppingService.checkOut(dozie));
    }

    @Test
    void checkOutWithNullPaymentCard() {
        dozie.setCards(null);
        assertThrows(CheckOutException.class, () -> shoppingService.checkOut(dozie));
    }

    @Test
    void checkOutWithNoPaymentCard() {
        dozie.setCards(Collections.emptyList());
        assertThrows(CheckOutException.class, () -> shoppingService.checkOut(dozie));
    }

    @Test
    void checkOut() {
        try {
            Address deliveryAddress = dozie.getCart().getDeliveryAddress();
            Map<String , Item> cartItems = dozie.getCart().getItems();
            Order dozieOrder = shoppingService.checkOut(dozie);
            assertNotNull(dozieOrder);
            assertEquals(cartItems,dozieOrder.getOrderItems());
           assertNull(dozie.getCart());
            assertTrue(dozieOrder.isPaid());

        } catch (CheckOutException e) {
            e.printStackTrace();
        }

    }
}