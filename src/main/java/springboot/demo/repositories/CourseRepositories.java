package springboot.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springboot.demo.entities.Course;

import java.util.Optional;

@Transactional
@Repository
public interface CourseRepositories extends JpaRepository<Course, Long> {

}
