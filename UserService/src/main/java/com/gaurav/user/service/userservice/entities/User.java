package com.gaurav.user.service.userservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "micro_users")
public class User {
    @Id
    @Column(name="id")
    private String userId;
    private String name;
    private String email;
    private String about;

}
