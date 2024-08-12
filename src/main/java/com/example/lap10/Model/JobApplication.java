package com.example.lap10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "userId should be not null")
    @Column(columnDefinition = "int not null")
    private int userId;

    @NotNull(message = "jobPostId should be not null")
    @Column(columnDefinition = "int not null")
    private int jobPostId;

}
