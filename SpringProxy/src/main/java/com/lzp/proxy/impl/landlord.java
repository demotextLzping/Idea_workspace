package com.lzp.proxy.impl;

import com.lzp.proxy.rent;

public class landlord implements rent {
    @Override
    public void rentHouse() throws Exception {
        System.out.println("出租花园一号110号");
    }
}
