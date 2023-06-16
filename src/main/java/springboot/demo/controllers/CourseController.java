package springboot.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.demo.entities.Course;
import springboot.demo.exception.CourseAlreadyExistsException;
import springboot.demo.exception.CourseNotFoundException;
import springboot.demo.services.impl.CourseServiceImpl;

import java.util.List;

@RestController
public class CourseController {

    private final CourseServiceImpl courseService;

    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @PostMapping(path = "/addCourse")
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        try {
            Course addedCourse = courseService.addCourse(course);
            return ResponseEntity.ok("Course added successfully " + addedCourse);
        } catch (CourseAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping(path = "/getAllCourse")
    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping(path = "/getCourse/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        try {
            Course course = courseService.getCourse(id);
            return ResponseEntity.ok(course);
        } catch (CourseNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @RequestMapping(path = "/deleteCourse", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCourse(@RequestParam(name = "id") Long id) {
        Course course = courseService.getCourse(id);
        if (course != null) {
            courseService.deleteCourse(course);
            return ResponseEntity.ok("Course successful deleted ");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the course");
        }
    }

    @PutMapping("/updateCourse")
    public ResponseEntity<String> updateCourse(@RequestParam(name = "id") Long id,
                                               @RequestParam(name = "course_name", defaultValue = "Course Item") String name) {
        Course course = courseService.getCourse(id);
        if (course != null) {
            course.setFullName(name);
            courseService.updateCourse(course);
            return ResponseEntity.ok("Course update successfully ");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while update the course");
        }
    }
}
