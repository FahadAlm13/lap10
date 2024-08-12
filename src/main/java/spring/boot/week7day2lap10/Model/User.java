package spring.boot.week7day2lap10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min = 4,message = " Name must be more than 4 characters.")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Name must contain only characters")
    @Column(columnDefinition = "varchar(30) not null ")
    private String name;

    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email shouldn't be empty")
    @Column(columnDefinition = "varchar(50) not null unique")
    private String email;

    @NotEmpty(message = "Password cannot be null")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @NotNull(message = "Age cannot be null")
    @Positive
    @Min(value = 22, message = "Age must be more than 21")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotNull(message = "Role cannot be null")
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$", message = "Role must be either 'JOB_SEEKER' or 'EMPLOYER'")
//    @Column(columnDefinition = "varchar(10) not null check(role In('JOB_SEEKER','EMPLOYER')")
    @Column(columnDefinition = "varchar(10) not null")
    private String role;
}
