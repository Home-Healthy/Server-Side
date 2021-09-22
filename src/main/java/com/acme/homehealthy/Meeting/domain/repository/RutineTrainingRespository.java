package com.acme.homehealthy.Meeting.domain.repository;

import com.acme.homehealthy.Meeting.domain.model.RoutineTraining;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RutineTrainingRespository extends JpaRepository<RoutineTraining, Integer> {

    @Query("SELECT rt FROM RoutineTraining rt WHERE rt.routineTrainingId = ?1")
    public List<RoutineTraining> listByRoutinTrainingId(int routineTrainingId);

    @Query("SELECT rt.rutine.id, rt.training.id, t.name FROM RoutineTraining rt LEFT JOIN Training t ON t.id = rt.training.id WHERE rt.rutine.id =?1")
    public Page<RoutineTraining> listByRoutineId(Long routineId, Pageable pageable);

}
