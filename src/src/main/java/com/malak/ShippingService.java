package com.malak;

import java.util.List;

public class ShippingService {

    public ShippingService() {}

    public void ship(Shippable item, String address) {
        System.out.println("Shipping " + item.getTitle() + " at " + address);
    }
}
