package com.gaurav.security1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@NoArgsConstructor
@ToString
@Entity(name="patient")
public class Patient {
    @Id
    private int id;
    private String name;
    private String gender;
    private String bloodGroup;
}
