package springboot.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Roles> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Course> courses;

}
