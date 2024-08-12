package com.example.lap10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "name should be not empty")
    @Size(min = 4,message = "name must be more than 4 characters")
    @Pattern(regexp = "[A-Za-z]",message = "Must contain only characters no numbers")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String name;

    @NotEmpty(message = "Email should be not empty!")
    @Email(message = "Email must be valid email")
    @Column(columnDefinition = "varchar(20) unique")
    private String email;


    @NotEmpty(message = "password should be not Empty!")
    @Size(min = 6,message = "have to be more than 6 , must have characters and digits")
    @Pattern(regexp = "(^(?:(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*)[^\\s]{8,}$)",message = "")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @NotNull(message = "age should be not null")
    @Positive(message = " age must be a positive number")
    @Column(columnDefinition = "int not null")
    @Min(21)
    private int age;


    @NotEmpty(message = "role should be not empty!")
    @Pattern(regexp="^(JOB_SEEKER|EMPLOYER)$",message = "Role must to be JOB_SEEKER or EMPLOYER")
    @Column(columnDefinition = "varchar(20) check(role='JOB_SEEKER' or role='EMPLOYER')")
    private String role;



}
