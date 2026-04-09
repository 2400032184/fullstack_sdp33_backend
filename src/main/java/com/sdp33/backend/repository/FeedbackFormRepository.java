package com.sdp33.backend.repository;

import com.sdp33.backend.model.FeedbackForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackFormRepository extends JpaRepository<FeedbackForm, Long> {
}