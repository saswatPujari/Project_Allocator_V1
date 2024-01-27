package com.crudapp.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.crudapp.entity.Assignment;
import com.crudapp.respository.AssignmentRepository;

import java.util.List;

@Path("/assignments")
public class AssignmentResource {

    private AssignmentRepository assignmentRepository = new AssignmentRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Assignment getAssignmentById(@PathParam("id") Long id) {
        return assignmentRepository.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createAssignment(Assignment assignment) {
        assignmentRepository.save(assignment);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAssignment(@PathParam("id") Long id, Assignment assignment) {
        assignment.setId(id); // Ensure the provided ID matches the resource ID
        assignmentRepository.update(assignment);
    }

    @DELETE
    @Path("/{id}")
    public void deleteAssignment(@PathParam("id") Long id) {
        Assignment assignment = assignmentRepository.findById(id);
        assignmentRepository.delete(assignment);
    }
}

