package com.example.common.mistakes.handler;

import com.example.common.mistakes.annotation.APIVersion;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.condition.HeadersRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:48 on 2020/5/19
 * @version V0.1
 * @classNmae ApiVersionHeaderHandlerMapping
 */
public class ApiVersionHeaderHandlerMapping extends RequestMappingHandlerMapping {


    @Override
    protected boolean isHandler(Class beanType) {
        return AnnotatedElementUtils.hasAnnotation(beanType, Controller.class);
    }
    @Override
    protected void registerHandlerMethod(Object handler, Method method, RequestMappingInfo mapping) {

        Class controllerClass = method.getDeclaringClass();
        Parameter[] params = method.getParameters();
        APIVersion apiVersion = AnnotationUtils.findAnnotation(controllerClass, APIVersion.class);
        APIVersion methodAnnotation = AnnotationUtils.findAnnotation(method, APIVersion.class);
        //以方法上的注解优先
        if (methodAnnotation != null) {
            apiVersion = methodAnnotation;
        }
//        boolean defineVersion = false;
//        String version = null;
//        for (Parameter param:params){
//            RequestHeader requestHeader = AnnotationUtils.findAnnotation(param, RequestHeader.class);
//            if(requestHeader!=null){
//                String headerName=requestHeader.name();
//                if("version".equals(headerName)){
//                    defineVersion =true;
//                    break;
//                }
//            }
//        }
        String[]  versions = null;
        if(apiVersion==null){
            versions = new String[0];
        }else{
            List<String> vlist = Arrays.asList(apiVersion.value()).stream().map(v -> "version=".concat(v)).collect(Collectors.toList());
            versions = new String[vlist.size()];
            vlist.toArray(versions);
        }
        HeadersRequestCondition requestCondition = new HeadersRequestCondition(versions);
        HeadersRequestCondition oldRequestCondition = mapping.getHeadersCondition();
        HeadersRequestCondition updatedRequestCondition = oldRequestCondition.combine(requestCondition);
//        PatternsRequestCondition updatedFinalPattern = apiPattern.combine(oldPattern);
        //重新构建RequestMappingInfo
        mapping = new RequestMappingInfo(mapping.getName(),
                mapping.getPatternsCondition(), mapping.getMethodsCondition(),
                mapping.getParamsCondition(), updatedRequestCondition,
                mapping.getConsumesCondition(), mapping.getProducesCondition(),
                mapping.getCustomCondition());
        mapping.getHeadersCondition();
        super.registerHandlerMethod(handler, method, mapping);
    }
}
