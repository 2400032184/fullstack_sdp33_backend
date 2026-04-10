package com.sdp33.backend.controller;

import com.sdp33.backend.model.Feedback;
import com.sdp33.backend.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    // ✅ SAVE FEEDBACK
    @PostMapping
    public ResponseEntity<?> submitFeedback(@RequestBody Feedback feedback) {
        try {
            Feedback saved = service.saveFeedback(feedback);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error saving feedback");
        }
    }

    // ✅ GET ALL FEEDBACKS (admin)
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        return ResponseEntity.ok(service.getAllFeedbacks());
    }

    // ✅ GET USER FEEDBACKS
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Feedback>> getUserFeedbacks(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getFeedbacksByUser(userId));
    }

    // ✅ DELETE ALL USER FEEDBACKS
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<?> deleteUserFeedbacks(@PathVariable Long userId) {
        service.deleteFeedbacksByUser(userId);
        return ResponseEntity.ok("Deleted successfully");
    }

    // ✅ NEW: DELETE SINGLE FEEDBACK (admin)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedbackById(@PathVariable Long id) {
        service.deleteFeedbackById(id);
        return ResponseEntity.ok("Feedback deleted successfully");
    }
}