package com.example.spring.ioc.overview.domin;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:04 on 2020/7/14
 * @version V0.1
 * @classNmae AbnormalBean
 */
public class AbnormalBean  {

    private String beanName;


    public AbnormalBean(String beanName){
        System.out.println("create AbnormalBean");
        this.beanName =beanName;
    }

    @Override
    public String toString() {
        return beanName.toString();
    }
}
