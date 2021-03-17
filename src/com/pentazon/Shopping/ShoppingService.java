package com.pentazon.Shopping;

import com.pentazon.Customers.Buyer;
import com.pentazon.Customers.Customer;
import com.pentazon.exceptions.CheckOutException;

public interface ShoppingService {

    public Order checkOut(Buyer buyer) throws CheckOutException;

}
