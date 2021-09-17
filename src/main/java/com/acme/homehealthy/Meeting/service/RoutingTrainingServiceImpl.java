package com.acme.homehealthy.Meeting.service;

import com.acme.homehealthy.Meeting.domain.model.RoutineTraining;
import com.acme.homehealthy.Meeting.domain.model.Rutine;
import com.acme.homehealthy.Meeting.domain.model.Training;
import com.acme.homehealthy.Meeting.domain.repository.RutineRepository;
import com.acme.homehealthy.Meeting.domain.repository.RutineTrainingRespository;
import com.acme.homehealthy.Meeting.domain.repository.TrainingRepository;
import com.acme.homehealthy.Meeting.domain.service.RoutineTrainingService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoutingTrainingServiceImpl implements RoutineTrainingService {

    @Autowired
    private RutineTrainingRespository _routineTrainingRespository;

    @Autowired
    private RutineRepository _routineRespository;

    @Autowired
    private TrainingRepository _trainingRepository;


    @Override
    public Page<RoutineTraining> getAllRoutinesTrainings(Pageable pageable) {

        return _routineTrainingRespository.findAll(pageable);
    }

    @Override
    public RoutineTraining assignRoutinesToTraining(Long routingId, int trainingId) {

        Training existingTraining = _trainingRepository.findById(trainingId);
        Optional<Rutine> existingRoutine = _routineRespository.findById((long) routingId);
        if (!existingRoutine.isPresent())
            throw new ResourceNotFoundException("Routine", "Id", routingId);
        if(existingTraining ==  null)
            throw new ResourceNotFoundException("Training", "Id", trainingId);

        var routineTraining = new RoutineTraining();
        routineTraining.setRutine(existingRoutine);
        routineTraining.setTraining(existingTraining);
        return _routineTrainingRespository.save(routineTraining);

    }

    @Override
    public RoutineTraining unassignRoutinesFromTraining(int routingId) {
        return null;
    }

    @Override
    public Page<RoutineTraining> getAllTrainingsByRoutineId(Long routingId, Pageable pageable ) {
       /* var existingRoutine = _routineRespository.findById(routingId)
                .orElseThrow(()-> new ResourceNotFoundException("Routine", "Id", routingId));*/
        return _routineTrainingRespository.listByRoutineId(routingId, pageable);
    }
}
