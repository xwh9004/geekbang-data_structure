package com.example.common.mistakes.repository;

import com.example.common.mistakes.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:54 on 2020/5/7
 * @version V0.1
 * @classNmae UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByName(String name);
}