package com.example.spring.ioc.overview.container;

import com.example.spring.ioc.overview.domin.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

/**
 * <p><b>Description:</b>
 * IOC 容器
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:15 on 2020/7/13
 * @version V0.1
 * @classNmae IocContainer
 */
@Configuration
public class IocContainer {

    public static void main(String[] args) {

        applicationLoadBean();
    }

    private static void applicationLoadBean() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(IocContainer.class);
        applicationContext.refresh();
        User user = applicationContext.getBean(User.class);

        applicationContext.close();
        System.out.println(user);
    }

    private static void beanFactoryLoadBean() {
        DefaultListableBeanFactory listableBeanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(listableBeanFactory);
        String location = "/META-INF/dependency-injection-context.xml";
        Resource resource = xmlBeanDefinitionReader.getResourceLoader().getResource(location);

        int count = xmlBeanDefinitionReader.loadBeanDefinitions(resource);
        User user1 = (User) listableBeanFactory.getBean("user1");
        System.out.println("found " + count + " beans");
        System.out.println("found user1 " + user1);
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(2);
        user.setName("Jesse2");
        return new User();
    }


}
