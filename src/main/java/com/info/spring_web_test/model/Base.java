package com.info.spring_web_test.model;

import lombok.Data;

import java.util.UUID;

@Data
public abstract class Base {

    private String id;

    public Base(){
        id = UUID.randomUUID().toString();
    }
}
