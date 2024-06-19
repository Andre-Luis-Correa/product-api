package com.example.productsapiexample.exception.type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityWasNotFoundException extends RuntimeException {

    private String message;

    public EntityWasNotFoundException(String className, Long id){
        super();
        this.message = "Não foi possível encontrar " + className + " com id: " + id;
    }
}
