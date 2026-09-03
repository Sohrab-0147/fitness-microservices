package com.fitness.activityservice.controller;


import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.service.ActivityService;
import com.fitness.activityservice.service.UserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;
    private final UserValidationService userValidationService;
    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request){
        return ResponseEntity.ok(activityService.trackActivity(request));

    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivities(@RequestHeader("X-User-ID") String userId ){
        return ResponseEntity.ok(activityService.getUserActivities(userId));
    }
    @GetMapping("/{activityId}")
    public ResponseEntity<ActivityResponse> getActivityById(
            @PathVariable String activityId) {

        return ResponseEntity.ok(
                activityService.getActivityById(activityId)
        );
    }


    @GetMapping("/validate/{userId}")
    public ResponseEntity<Boolean> validateUser(
            @PathVariable String userId) {

        return ResponseEntity.ok(
                userValidationService.validateUser(userId)
        );
    }

}
