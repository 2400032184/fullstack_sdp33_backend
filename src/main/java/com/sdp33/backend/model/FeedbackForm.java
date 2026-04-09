package com.sdp33.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "feedback_form")
public class FeedbackForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String starCategories; // JSON string

    @Lob
    private String options; // JSON string

    public FeedbackForm() {}

    public FeedbackForm(String starCategories, String options) {
        this.starCategories = starCategories;
        this.options = options;
    }

    public Long getId() { return id; }

    public String getStarCategories() { return starCategories; }
    public void setStarCategories(String starCategories) { this.starCategories = starCategories; }

    public String getOptions() { return options; }
    public void setOptions(String options) { this.options = options; }
}