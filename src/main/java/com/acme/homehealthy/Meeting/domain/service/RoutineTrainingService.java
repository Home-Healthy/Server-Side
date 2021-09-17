package com.acme.homehealthy.Meeting.domain.service;

import com.acme.homehealthy.Meeting.domain.model.RoutineTraining;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoutineTrainingService {
    Page<RoutineTraining> getAllRoutinesTrainings(Pageable pageable);
    RoutineTraining assignRoutinesToTraining(Long routingId, int trainingId);
    RoutineTraining unassignRoutinesFromTraining(int routingId);
    Page<RoutineTraining>getAllTrainingsByRoutineId( Long routingId, Pageable pageable);
}
