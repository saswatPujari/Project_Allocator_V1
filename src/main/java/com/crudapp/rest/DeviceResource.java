package com.crudapp.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.crudapp.entity.Device;
import com.crudapp.respository.DeviceRepository;

import java.util.List;

@Path("/devices")
public class DeviceResource {

    private DeviceRepository deviceRepository = new DeviceRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Device getDeviceById(@PathParam("id") Long id) {
        return deviceRepository.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createDevice(Device device) {
        deviceRepository.save(device);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDevice(@PathParam("id") Long id, Device device) {
        device.setId(id); // Ensure the provided ID matches the resource ID
        deviceRepository.update(device);
    }

    @DELETE
    @Path("/{id}")
    public void deleteDevice(@PathParam("id") Long id) {
        Device device = deviceRepository.findById(id);
        deviceRepository.delete(device);
    }
}

