package com.crudapp.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.crudapp.entity.Project;
import com.crudapp.respository.ProjectRepository;
import java.util.List;

@Path("/projects")
public class ProjectResource {

    private ProjectRepository projectRepository = new ProjectRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Project getProjectById(@PathParam("id") Long id) {
        return projectRepository.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createProject(Project project) {
        projectRepository.save(project);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProject(@PathParam("id") Long id, Project project) {
        project.setId(id); // Ensure the provided ID matches the resource ID
        projectRepository.update(project);
    }

    @DELETE
    @Path("/{id}")
    public void deleteProject(@PathParam("id") Long id) {
        Project project = projectRepository.findById(id);
        projectRepository.delete(project);
    }

}

