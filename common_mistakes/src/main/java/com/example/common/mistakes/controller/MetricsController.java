package com.example.common.mistakes.controller;

import com.example.common.mistakes.aop.Metrics;
import com.example.common.mistakes.entity.UserEntity;
import com.example.common.mistakes.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:52 on 2020/5/7
 * @version V0.1
 * @classNmae MetricsController
 */
@Slf4j
@RestController //自动进行监控
@RequestMapping("metricstest")
@Metrics(logParameters = false, logReturn = false) //改动点1
public class MetricsController {
    @Autowired
    private UserService userService;
    @GetMapping("transaction")
    public int transaction(@RequestParam("name") String name) {
        try {
            userService.createUser(new UserEntity(name));
        } catch (Exception ex) {
            log.error("create user failed because {}", ex.getMessage());
        }
        return userService.getUserCount(name);
    }
}