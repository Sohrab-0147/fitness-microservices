package com.fitness.activityservice.dto;

import com.fitness.activityservice.entity.ActivityType;
import lombok.Data;

import java.time.Instant;
import java.util.Map;

@Data

public class ActivityRequest {
    private String userId;
    private ActivityType type;
    private Integer duration;
    private Integer caloriesBurned;
    private Instant startTime;
    private Map<String, Object> additionalMetrics;





}
