package com.sdp33.backend.service;

import com.sdp33.backend.model.FeedbackForm;
import com.sdp33.backend.repository.FeedbackFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedbackFormService {

    @Autowired
    private FeedbackFormRepository repo;

    // Save or update (only one form needed)
    public FeedbackForm saveForm(FeedbackForm form) {
        repo.deleteAll(); // keep only one form
        return repo.save(form);
    }

    public FeedbackForm getForm() {
        Optional<FeedbackForm> form = repo.findAll().stream().findFirst();
        return form.orElse(null);
    }
}