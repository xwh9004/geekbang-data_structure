package com.example.common.mistakes.controller;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:18 on 2020/5/19
 * @version V0.1
 * @classNmae APIVersionController
 */

import com.example.common.mistakes.annotation.APIVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class APIVersionController {


//    @GetMapping( value = {"/com.example.gateway/user","/com.example.gateway/users"} )
//    @APIVersion( "v4" )
//    public int right4() {
//        return 4;
//    }
    @APIVersion( "v4" )
    @GetMapping( value = {"/api/user"} )
    public int right4() {
        return 4;
    }
    @APIVersion( "v5" )
    @GetMapping( value = {"/api/user"} )
    public int right5() {
        return 5;
    }
}
