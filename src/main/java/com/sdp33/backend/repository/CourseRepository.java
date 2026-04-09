package com.sdp33.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sdp33.backend.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}