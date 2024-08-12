package com.example.lap10.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "title should be not empty")
    @Size(min = 4,message = "title must be more than 4 characters")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;

    @NotEmpty(message = "description should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String description;

    @NotEmpty(message = "location should be not empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String location;

    @NotNull(message = "salary should be not null")
    @Column(columnDefinition = "int not null")
    @Positive(message = "salary must be positive number")
    private int salary;

    @NotNull(message = "postingDate should be Not Null!")
    @JsonFormat(pattern ="yyyy-MM-dd")
    @PastOrPresent
    private LocalDate postingDate;


}
