package com.example.common.mistakes.register;

import com.example.common.mistakes.handler.ApiVersionHeaderHandlerMapping;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:17 on 2020/5/19
 * @version V0.1
 * @classNmae APIVersionRegistion
 */
@Configuration
public class APIVersionHeaderRegistion implements WebMvcRegistrations {
    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new ApiVersionHeaderHandlerMapping();
    }
}
