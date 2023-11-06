package com.sk26.springboot.tutorial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotBlank(message = "Please add Department Name")
    @Length(message = "Department Name length should be between 2 to 20", min = 2, max = 20)
    // @Email
    // @Size
    // @Positive
    // @Negative
    // @PositiveOrZero
    // @NegativeOrZero
    // @Past
    // @PastOrPresent
    // @Future
    // @FutureOrPresent
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
