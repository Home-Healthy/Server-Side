package com.acme.homehealthy.Meeting.domain.service;

import com.acme.homehealthy.Meeting.domain.model.Training;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TrainingService  {

    Training createTraining(Training training);

    Training updateTraining(int trainingId, Training training);

    Page<Training> getAllTrainings(Pageable pageable);
}
