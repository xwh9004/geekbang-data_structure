package com.example.spring.ioc.overview.domin;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:32 on 2020/7/14
 * @version V0.1
 * @classNmae UseBean
 */
public class UseBean {
    private AbnormalBean bean;

    public void setBean(AbnormalBean bean) {
        this.bean = bean;
    }

    public AbnormalBean getBean() {
        return bean;
    }
}
