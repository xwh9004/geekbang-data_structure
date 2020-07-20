package com.example.spring.ioc.overview.domin;

import com.example.spring.ioc.overview.annotation.Super;

@Super
public class SuperUser extends User {

    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String
    toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
