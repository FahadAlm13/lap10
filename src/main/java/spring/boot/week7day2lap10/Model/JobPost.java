package spring.boot.week7day2lap10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_post")
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Title cannot be null")
    @Size(min = 5, message = "Title must be more than 4 characters")
    @Column(columnDefinition = "varchar(50) not null")
    private String title;

    @NotEmpty(message = "Description cannot be null")
    @Column(columnDefinition = "text not null")
    private String description;

    @NotEmpty(message = "Location cannot be null")
    @Column(columnDefinition = "varchar(50) not null")
    private String location;

    @NotNull(message = "Salary cannot be null")
//    @Column(columnDefinition = "double not null check(salary >= 0)")
    @Column(columnDefinition = "double not null ")
    private Double salary;

    @NotNull
    @Column(columnDefinition = "datetime not null")
    private String postingDate;
}
