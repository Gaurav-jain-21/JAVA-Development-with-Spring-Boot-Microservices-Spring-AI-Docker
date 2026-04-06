package com.gaurav.patientservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36)
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    @Email
    @Column(unique=true)
    private String email;

    @NotNull
    private String address;

    @NotNull
    private LocalDate registeredDate;

    @NotNull
    private LocalDate date_of_birth;
}
