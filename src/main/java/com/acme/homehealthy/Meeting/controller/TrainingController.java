package com.acme.homehealthy.Meeting.controller;

import com.acme.homehealthy.Meeting.domain.model.Training;
import com.acme.homehealthy.Meeting.domain.service.TrainingService;
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
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TrainingController {

    @Autowired
    private TrainingService _trainingService;

    @Autowired
    private ModelMapper mapper;

    private Training convertToEntity(SaveTrainingResource trainingResource){
        return mapper.map(trainingResource, Training.class);
    }

    private TrainingResource convertToResource(Training entity){
        return mapper.map(entity,TrainingResource.class);
    }

    @Operation(summary="Get all", description="Get all the trainings", tags = {"trainings"} )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description="All trainings returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/trainings")
    public Page<TrainingResource> getAllTrainings (Pageable pageable){
        List<TrainingResource> trainings = _trainingService.getAllTrainings(pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        int trainingsCount = trainings.size();
        return new PageImpl<>(trainings, pageable, trainingsCount);
    }


    @Operation(summary="Save new training", description="Save training", tags = {"trainings"} )
    @PostMapping("/trainings")
    public TrainingResource createSubscription(@Valid @RequestBody SaveTrainingResource resource){
        return convertToResource(_trainingService.createTraining(convertToEntity(resource)));
    }


}
