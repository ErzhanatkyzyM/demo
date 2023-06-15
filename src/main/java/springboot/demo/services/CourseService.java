package springboot.demo.services;

import springboot.demo.entities.Course;

import java.util.List;

public interface CourseService {

    Course addCourse(Course course);

    List<Course> getAllCourse();

    Course getCourse(Long id);

    void deleteCourse(Course course);

    Course saveCourse(Course course);

    Course updateCourse(Course course);



}
