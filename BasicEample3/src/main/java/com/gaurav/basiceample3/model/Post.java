package com.gaurav.basiceample3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@NoArgsConstructor
@ToString
@Entity(name="post")
public class Post {
    @Id
    private int id;
    private String desc;
    private String profile;
    private List<String> techs;
}
