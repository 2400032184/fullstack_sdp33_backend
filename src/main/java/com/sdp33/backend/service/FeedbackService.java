package com.sdp33.backend.service;

import com.sdp33.backend.model.Feedback;
import com.sdp33.backend.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository repo;

    // ✅ SAVE FEEDBACK (with timestamp)
    public Feedback saveFeedback(Feedback feedback) {
        feedback.setSubmittedAt(java.time.LocalDateTime.now());
        return repo.save(feedback);
    }

    // ✅ GET ALL FEEDBACKS (admin)
    public List<Feedback> getAllFeedbacks() {
        return repo.findAll();
    }

    // ✅ GET USER FEEDBACKS (history)
    public List<Feedback> getFeedbacksByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    // ✅ DELETE ALL FEEDBACKS OF USER
    public void deleteFeedbacksByUser(Long userId) {
        repo.deleteByUserId(userId);
    }

    // ✅ NEW: DELETE SINGLE FEEDBACK (admin)
    public void deleteFeedbackById(Long id) {
        repo.deleteById(id);
    }
}