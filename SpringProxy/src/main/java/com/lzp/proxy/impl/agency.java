package com.lzp.proxy.impl;

import com.lzp.proxy.rent;

public class agency implements rent {
    private landlord lord = new landlord();

    @Override
    public void rentHouse() throws Exception {
        System.out.println("收取房东的中介费");
        lord.rentHouse();
        System.out.println("收取租客的中介费");
    }
}