package com.example.common.mistakes.service;

import com.example.common.mistakes.aop.Metrics;
import com.example.common.mistakes.entity.UserEntity;
import com.example.common.mistakes.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:53 on 2020/5/7
 * @version V0.1
 * @classNmae UserService
 */
@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Transactional
    @Metrics(ignoreException = true) //启用方法监控
    public void createUser(UserEntity entity) {
        userRepository.save(entity);
        if (entity.getName().contains("test"))
            throw new RuntimeException("invalid username!");
    }

    public int getUserCount(String name) {
        return userRepository.findByName(name).size();
    }
}