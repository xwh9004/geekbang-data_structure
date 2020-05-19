package com.example.common.mistakes.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:24 on 2020/5/7
 * @version V0.1
 * @classNmae TestController
 */
@Slf4j
@RequestMapping("test")
@RestController
public class TestController {
    @GetMapping
    public void test() {

    }
}