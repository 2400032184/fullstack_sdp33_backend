package com.sdp33.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdp33.backend.model.Course;
import com.sdp33.backend.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public Course addCourse(Course c) {
        return repo.save(c);
    }

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public void deleteCourse(Long id) {
        repo.deleteById(id);
    }

    public Course updateCourse(Long id, Course updated) {
        Course c = repo.findById(id).orElseThrow();

        c.setTitle(updated.getTitle());
        c.setInstructor(updated.getInstructor());
        c.setDuration(updated.getDuration());

        return repo.save(c);
    }
}