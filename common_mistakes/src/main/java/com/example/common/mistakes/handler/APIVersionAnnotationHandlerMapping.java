package com.example.common.mistakes.handler;

import com.example.common.mistakes.annotation.APIVersion;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:08 on 2020/5/19
 * @version V0.1
 * @classNmae APIVersionAnnotationHandlerMapping
 */
public class APIVersionAnnotationHandlerMapping extends RequestMappingHandlerMapping {

    /**
     * 处理controller 上有APIVersion注解的接口
     *
     * @param beanType
     * @return
     */
    @Override
    protected boolean isHandler(Class beanType) {
        return AnnotatedElementUtils.hasAnnotation(beanType, Controller.class);
    }

    @Override
    protected void registerHandlerMethod(Object handler, Method method, RequestMappingInfo mapping) {
        //类上的APIVersion注解
        Class controllerClass = method.getDeclaringClass();
        //方法上的APIVersion注解
        APIVersion apiVersion = AnnotationUtils.findAnnotation(controllerClass, APIVersion.class);
        APIVersion methodAnnotation = AnnotationUtils.findAnnotation(method, APIVersion.class);
        //以方法上的注解优先
        if (methodAnnotation != null) {
            apiVersion = methodAnnotation;
        }
        String[] urlPatterns = apiVersion == null ? new String[0] : apiVersion.value();
        PatternsRequestCondition apiPattern = new PatternsRequestCondition(urlPatterns);
        PatternsRequestCondition oldPattern = mapping.getPatternsCondition();
        PatternsRequestCondition updatedFinalPattern = apiPattern.combine(oldPattern);
        //重新构建RequestMappingInfo
        mapping = new RequestMappingInfo(mapping.getName(),
                updatedFinalPattern, mapping.getMethodsCondition(),
                mapping.getParamsCondition(), mapping.getHeadersCondition(),
                mapping.getConsumesCondition(), mapping.getProducesCondition(),
                mapping.getCustomCondition());
        mapping.getHeadersCondition();
        super.registerHandlerMethod(handler, method, mapping);
    }
}
