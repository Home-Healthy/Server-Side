package com.acme.homehealthy.Meeting.domain.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Optional;


@Entity
@Table(name = "routine_trainings")
public class RoutineTraining {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int routineTrainingId;



    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "rutine_id", nullable = false)
    private Rutine rutine;

    public int getRoutineTrainingId() {
        return routineTrainingId;
    }

    public void setRoutineTrainingId(int routineTrainingId) {
        this.routineTrainingId = routineTrainingId;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Rutine getRutine() {
        return rutine;
    }

    public void setRutine(Optional<Rutine> rutine) {
        rutine.ifPresent(value -> this.rutine = value);
    }

    public RoutineTraining() {
    }

    public RoutineTraining(int routineTrainingId, Training training, Rutine rutine) {
        this.routineTrainingId = routineTrainingId;
        this.training = training;
        this.rutine = rutine;
    }

    public RoutineTraining(int routineTrainingId) {
        this.routineTrainingId = routineTrainingId;
    }
}
