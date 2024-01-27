package com.crudapp.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.crudapp.entity.User;
import com.crudapp.respository.UserRepository;

import java.util.List;

@Path("/users")
public class UserResource {

    private UserRepository userRepository = new UserRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") Long id) {
        return userRepository.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(User user) {
        userRepository.save(user);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(@PathParam("id") Long id, User user) {
        user.setId(id); // Ensure the provided ID matches the resource ID
        userRepository.update(user);
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") Long id) {
        User user = userRepository.findById(id);
        userRepository.delete(user);
    }
}

