package springboot.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "course_name")
    private String fullName;

    @ManyToMany(mappedBy = "courses")
    private List<User> users;
}
