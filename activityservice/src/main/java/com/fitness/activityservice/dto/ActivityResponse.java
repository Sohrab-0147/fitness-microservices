package com.fitness.activityservice.dto;

import com.fitness.activityservice.entity.ActivityType;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.Map;


@Data

public class ActivityResponse {

    private String id;
    private String userId;
    private ActivityType type;
    private Integer duration;
    private Instant startTime;
    private Integer caloriesBurned;
    private Instant createdAt;
    private Instant updatedAt;
    private Map<String,Object> additionalMetrics;

}
