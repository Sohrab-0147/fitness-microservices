package com.fitness.activityservice.repository;


import com.fitness.activityservice.entity.Activity;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Repository
public interface ActivityRepository extends MongoRepository<Activity, String> {
    // hibernate will generate a query for us;
    List<Activity> findByUserId(String userId);
}
