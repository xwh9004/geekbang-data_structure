package com.eample.spring.ioc.overview.dependency.domin;

public class User {

    private long id;

    private String name;

    public User(){
//        System.out.println("create at "+System.currentTimeMillis());
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
