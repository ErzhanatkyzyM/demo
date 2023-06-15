package springboot.demo.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.demo.entities.Course;
import springboot.demo.exception.CourseNotFoundException;
import springboot.demo.repositories.CourseRepositories;
import springboot.demo.services.CourseService;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepositories courseRepositories;

    @Override
    public Course addCourse(Course course) {
        return courseRepositories.save(course);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepositories.findAll();
    }

    @Override
    public Course getCourse(Long id) {
        Course course = courseRepositories.findById(id).orElseThrow(() -> new CourseNotFoundException("User not found: " + id));
        return course;
    }

    @Override
    public void deleteCourse(Course course) {
    courseRepositories.delete(course);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepositories.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        courseRepositories.findById(course.getId()).orElseThrow(()-> new CourseNotFoundException("User not found: " + course.getId()));
        return courseRepositories.save(course);}
}
