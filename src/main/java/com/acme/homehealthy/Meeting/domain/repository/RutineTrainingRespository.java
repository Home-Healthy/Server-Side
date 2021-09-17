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

    @Query( value = "select * from routine_trainings rt where rt.rutine_id =?1" , nativeQuery = true)
    public Page<RoutineTraining> listByRoutineId(Long routineId, Pageable pageable);

}
