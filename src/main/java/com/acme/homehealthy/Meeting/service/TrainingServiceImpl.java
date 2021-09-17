package com.acme.homehealthy.Meeting.service;

import com.acme.homehealthy.Meeting.domain.model.Training;
import com.acme.homehealthy.Meeting.domain.repository.TrainingRepository;
import com.acme.homehealthy.Meeting.domain.service.TrainingService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TrainingServiceImpl  implements TrainingService {

    @Autowired
    private TrainingRepository _trainingRepository;

    @Override
    public Training createTraining(Training training) {
        return _trainingRepository.save(training);
    }

    @Override
    public Training updateTraining(int trainingId, Training training) {
        Training newTraining = _trainingRepository.findById(trainingId);
        if (newTraining == null)
            throw new ResourceNotFoundException("Training", "Id", trainingId);
        newTraining.setName(training.getName());
        newTraining.setDescription(training.getDescription());
        return _trainingRepository.save(newTraining);


    }

    @Override
    public Page<Training> getAllTrainings(Pageable pageable) {
        return _trainingRepository.findAll(pageable);
    }
}
