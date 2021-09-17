package com.acme.homehealthy.Meeting.controller;


import com.acme.homehealthy.Meeting.domain.model.RoutineTraining;
import com.acme.homehealthy.Meeting.domain.model.Training;
import com.acme.homehealthy.Meeting.domain.service.RoutineTrainingService;
import com.acme.homehealthy.Meeting.domain.service.TrainingService;
import com.acme.homehealthy.Meeting.resource.RoutineTrainingResource;
import com.acme.homehealthy.Meeting.resource.SaveRoutingTrainingResource;
import com.acme.homehealthy.Meeting.resource.SaveTrainingResource;
import com.acme.homehealthy.Meeting.resource.TrainingResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoutineTrainingController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private RoutineTrainingService _routineTrainingService;

    private RoutineTraining convertToEntity(SaveRoutingTrainingResource resource){
        return mapper.map(resource, RoutineTraining.class);
    }
    private RoutineTrainingResource convertToResource(RoutineTraining entity){
        return mapper.map(entity,RoutineTrainingResource.class);
    }

    @Operation(summary="Assing training to routine", description="Assing training to  routine", tags = {"training routine"})
    @PostMapping("/routines/{routineId}/training/{TrainingId}")
    public RoutineTraining assingUserToSubscription(@RequestParam(name="routineId") Long routineId, @RequestParam(name="TrainingId") int trainingId){
        return _routineTrainingService.assignRoutinesToTraining(routineId,trainingId);
    }


    @Operation(summary="Get all the trainings to an espesific routine", description="get training related to a routine", tags = {"training routine"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description="All subscriptions returned", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description="Subscription Not Found", content = @Content(mediaType = "application/json"))
    })
    @RequestMapping(value = "/routines/{routineId}", method = RequestMethod.GET)
    public Page<RoutineTraining>  getAllTrainingsByRoutineId(@PathVariable(name="routineId") Long routineId, Pageable pageable){
       List<RoutineTraining> routineTrainingList  =  new ArrayList<>(_routineTrainingService.getAllTrainingsByRoutineId(routineId ,pageable)
               .getContent());
       int trainingsCount = routineTrainingList.size();
       return new PageImpl<>(routineTrainingList, pageable, trainingsCount);
    }




}
