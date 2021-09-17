package com.acme.homehealthy.Meeting.resource;

public class SaveRoutingTrainingResource {
    private int routineId;
    private int trainingId;

    public int getRoutineId() {
        return routineId;
    }

    public SaveRoutingTrainingResource setRoutineId(int routineId) {
        this.routineId = routineId;
        return this;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public SaveRoutingTrainingResource setTrainingId(int trainingId) {
        this.trainingId = trainingId;
        return this;
    }
}
