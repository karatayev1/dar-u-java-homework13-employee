package kz.dar.university.employeecoreapi.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
public class Employee {
    private String id;

    @NonNull //(message = "Name can not be empty")
    @Size(min = 2, max = 16, message = "Name must be in range 2 - 16")
    private String name;

    @NonNull
    private String surname;
    private String department;
    private String position;

    @Email
    private String email;
    private double salary;
}
