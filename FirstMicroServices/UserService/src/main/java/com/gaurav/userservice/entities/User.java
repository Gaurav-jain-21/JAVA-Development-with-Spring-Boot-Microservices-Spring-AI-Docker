package com.gaurav.userservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="micro_users")
public class User {
    @Id
    @Column(name="id")
    private String userId;
    private String name;
    private String email;
    private String about;

    @Transient
    private List<Rating> ratings;

}
