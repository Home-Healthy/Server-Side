package com.acme.homehealthy.Meeting.domain.repository;

import com.acme.homehealthy.Meeting.domain.model.Training;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {

    Training findById(int trainingId);


}
