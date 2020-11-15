package com.example.train.aop;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.matcher.ElementMatchers;
import org.apache.log4j.Appender;


import java.lang.reflect.Method;

public class SchoolByteBuddyProxy {

    public static void main(String[] args) throws Exception {
        proxyDing_interface();

    }

    /**
     * 代理类的方法
     * @throws Exception
     */
    public static void proxyDing() throws Exception{
        Method method = ISchool.class.getMethod("ding");
        School proxy = new ByteBuddy()
                .subclass(School.class)
                .method(ElementMatchers.named("ding"))
                .intercept(MethodDelegation.to(SchoolProxy.class))
                .make()
                .load(Thread.currentThread().getContextClassLoader())
                .getLoaded()
                .newInstance();

        proxy.ding();
    }


    /**
     * 代理类的方法
     * @throws Exception
     */
    public static void proxyDing_interface() throws Exception{
        Method method = ISchool.class.getMethod("ding");
        ISchool proxy = new ByteBuddy()
                .subclass(School.class).implement(ISchool.class)
                .method(ElementMatchers.named("ding"))
                .intercept(MethodDelegation.to(SchoolProxy.class))
                .make()
                .load(Thread.currentThread().getContextClassLoader())
                .getLoaded()
                .newInstance();

        proxy.ding();
    }
}
