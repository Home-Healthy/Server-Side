package com.acme.homehealthy.Meeting.resource;

import com.acme.homehealthy.Meeting.domain.model.Rutine;
import com.acme.homehealthy.Meeting.domain.model.Training;

public class RoutineTrainingResource {
    private int routineTrainingId;
    private Training training;
    private Rutine rutine;


    public int getRoutineTrainingId() {
        return routineTrainingId;
    }

    public RoutineTrainingResource setRoutineTrainingId(int routineTrainingId) {
        this.routineTrainingId = routineTrainingId;
        return this;
    }

    public Training getTraining() {
        return training;
    }

    public RoutineTrainingResource setTraining(Training training) {
        this.training = training;
        return this;
    }

    public Rutine getRutine() {
        return rutine;
    }

    public RoutineTrainingResource setRutine(Rutine rutine) {
        this.rutine = rutine;
        return this;
    }
}
