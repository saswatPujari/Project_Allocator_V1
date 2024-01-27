package com.crudapp.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.crudapp.entity.Address;
import com.crudapp.respository.AddressRepository;

import java.util.List;

@Path("/addresses")
public class AddressResource {

    private AddressRepository addressRepository = new AddressRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Address getAddressById(@PathParam("id") Long id) {
        return addressRepository.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createAddress(Address address) {
        addressRepository.save(address);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAddress(@PathParam("id") Long id, Address address) {
        address.setId(id); // Ensure the provided ID matches the resource ID
        addressRepository.update(address);
    }

    @DELETE
    @Path("/{id}")
    public void deleteAddress(@PathParam("id") Long id) {
        Address address = addressRepository.findById(id);
        addressRepository.delete(address);
    }
}

