package com.sdp33.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String username; // 🔥 ADD THIS

    private String course;

    private String instructor;

    @Lob
    private String starRatings;

    @Lob
    private String options;

    @Lob
    private String improvement;

    private LocalDateTime submittedAt;

    public Feedback() {}

    public Feedback(Long userId, String username, String course, String instructor,
                    String starRatings, String options, String improvement) {

        this.userId = userId;
        this.username = username; // 🔥 ADD THIS
        this.course = course;
        this.instructor = instructor;
        this.starRatings = starRatings;
        this.options = options;
        this.improvement = improvement;
        this.submittedAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() { return id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUsername() { return username; } // 🔥 ADD
    public void setUsername(String username) { this.username = username; } // 🔥 ADD

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    public String getStarRatings() { return starRatings; }
    public void setStarRatings(String starRatings) { this.starRatings = starRatings; }

    public String getOptions() { return options; }
    public void setOptions(String options) { this.options = options; }

    public String getImprovement() { return improvement; }
    public void setImprovement(String improvement) { this.improvement = improvement; }

    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }
}