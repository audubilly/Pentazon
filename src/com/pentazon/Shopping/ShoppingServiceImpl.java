package com.pentazon.Shopping;

import com.pentazon.Customers.Buyer;
import com.pentazon.Payments.PayStack;
import com.pentazon.Payments.PaymentService;
import com.pentazon.exceptions.CheckOutException;

import java.time.LocalDate;

public class ShoppingServiceImpl implements ShoppingService{
    private PaymentService paymentService;


    public ShoppingServiceImpl(){
        paymentService = new PayStack();
    }


    @Override
    public  Order checkOut(Buyer buyer) throws  CheckOutException {
        this.isValidCheckOut(buyer);
        Order order = new Order();
        Cart buyerCart = buyer.getCart();
        boolean result = paymentService.pay(buyerCart.getPaymentCard(), buyerCart.getTotal());
        if (result) {
            order.setOrderItems(buyer.getCart().getItems());
            order.setPaid(result);
            order.setOrderDate(LocalDate.now());
            order.setOrderTotal(buyerCart.getTotal());
            order.setDeliveryAddress(buyerCart.getDeliveryAddress());
            buyer.setCart(null);
        }
        return order;
    }

    public boolean isValidCheckOut(Buyer buyer) throws CheckOutException {
        if(buyer == null){
            throw new CheckOutException("No buyer found at check out");
        }
        if(buyer.getCart() == null){
            //Todo log error
            throw new CheckOutException("No cart found at check out");
        }
        if(buyer.getCart().getItems().isEmpty()){
            //Todo log error
            throw new CheckOutException("Cart is Empty at check out");
        }
        if(buyer.getCards() == null || buyer.getCards().isEmpty()){

            //Todo log error
            throw  new CheckOutException("No payment cards found at check out");
        }
        return false;
    }
}
