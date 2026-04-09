package com.sdp33.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sdp33.backend.model.Course;
import com.sdp33.backend.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin("*")
public class CourseController {

    @Autowired
    private CourseService service;

    // 🔹 Get all courses (USER uses this)
    @GetMapping
    public List<Course> getAllCourses() {
        return service.getAllCourses();
    }

    // 🔹 Add course (ADMIN)
    @PostMapping
    public Course addCourse(@RequestBody Course c) {
        return service.addCourse(c);
    }

    // 🔹 Delete course (ADMIN)
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
    }

    // 🔹 Update course (ADMIN)
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course c) {
        return service.updateCourse(id, c);
    }
    
}