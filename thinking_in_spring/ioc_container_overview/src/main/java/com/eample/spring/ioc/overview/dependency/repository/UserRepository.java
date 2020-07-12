package com.eample.spring.ioc.overview.dependency.repository;

import com.eample.spring.ioc.overview.dependency.domin.User;

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
