package com.eample.spring.ioc.overview.dependency.injection;

import com.eample.spring.ioc.overview.dependency.annotation.Super;
import com.eample.spring.ioc.overview.dependency.domin.User;
import com.eample.spring.ioc.overview.dependency.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class DependencyInjectionDemo {

    public static void main(String[] args) throws Exception {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");

        instanceLookup(beanFactory);

    }

    private static void instanceLookup(BeanFactory beanFactory) {
        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");

        System.out.println(userRepository.getUsers());
    }

    /**
     * 延迟查找  bean的创建时在容器初始化的时候
     *
     * @param beanFactory
     */
    private static void lazyLookup(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println(user);
    }

    private static void lookupBeansByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> map = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(map);
        }

    }
    private static void lookupBeansByAnnotatain(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, Object> map = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println(map);
        }

    }
}
