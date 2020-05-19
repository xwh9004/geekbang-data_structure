package com.example.common.mistakes.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:54 on 2020/5/7
 * @version V0.1
 * @classNmae UserEntity
 */
@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;

    public UserEntity() {
    }

    public UserEntity(String name) {
        this.name = name;
    }
}