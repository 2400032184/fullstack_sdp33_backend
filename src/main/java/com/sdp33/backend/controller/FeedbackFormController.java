package com.sdp33.backend.controller;

import com.sdp33.backend.model.FeedbackForm;
import com.sdp33.backend.service.FeedbackFormService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feedback-form")
@CrossOrigin(origins = "*")
public class FeedbackFormController {

    @Autowired
    private FeedbackFormService service;

    // ✅ Save form
    @PostMapping
    public ResponseEntity<?> saveForm(@RequestBody FeedbackForm form) {
        try {
            FeedbackForm saved = service.saveForm(form);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error saving form");
        }
    }

    // ✅ Get form
    @GetMapping
    public ResponseEntity<?> getForm() {
        FeedbackForm form = service.getForm();
        if (form == null) {
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(form);
    }
}