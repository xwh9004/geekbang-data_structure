package com.example.spring.ioc.overview.repository;

import com.example.spring.ioc.overview.domin.User;

import java.util.Collection;

public class UserRepository {

    private Collection<User> users;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
