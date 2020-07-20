package com.example.spring.ioc.overview.repository;

<<<<<<< HEAD:thinking_in_spring/ioc_container_overview/src/main/java/com/eample/spring/ioc/overview/dependency/repository/UserRepository.java
import com.eample.spring.ioc.overview.dependency.domin.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
=======
import com.example.spring.ioc.overview.domin.User;
>>>>>>> f5a6eb203a66bff9a06e96b24df561642d0b7b47:thinking_in_spring/ioc_container_overview/src/main/java/com/example/spring/ioc/overview/repository/UserRepository.java

import java.util.Collection;

public class UserRepository {

    private Collection<User> users;  //自定义bean

    private BeanFactory beanFactory; //内建非bean

    private ObjectFactory<ApplicationContext> objectFactory;
    private ObjectFactory<User> objectFactory1;


    public ObjectFactory<User> getObjectFactory1() {
        return objectFactory1;
    }

    public void setObjectFactory1(ObjectFactory<User> objectFactory1) {
        this.objectFactory1 = objectFactory1;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
    private Collection<User> users;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
