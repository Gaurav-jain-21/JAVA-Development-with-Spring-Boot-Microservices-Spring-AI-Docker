package com.gaurav.firstproject.model;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class Alien {
    private int id;
    private String name;
    private String tech;

}
