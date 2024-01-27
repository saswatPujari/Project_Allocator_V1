package com.crudapp.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.crudapp.entity.Activity;
import com.crudapp.respository.ActivityRepository;

import java.util.List;

@Path("/activities")
public class ActivityResource {

    private ActivityRepository activityRepository = new ActivityRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Activity getActivityById(@PathParam("id") Long id) {
        return activityRepository.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createActivity(Activity activity) {
        activityRepository.save(activity);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateActivity(@PathParam("id") Long id, Activity activity) {
        activity.setId(id); // Ensure the provided ID matches the resource ID
        activityRepository.update(activity);
    }

    @DELETE
    @Path("/{id}")
    public void deleteActivity(@PathParam("id") Long id) {
        Activity activity = activityRepository.findById(id);
        activityRepository.delete(activity);
    }
}

