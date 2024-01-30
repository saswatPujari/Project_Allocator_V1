package com.crudapp.respository;

import com.crudapp.entity.Address;
import java.util.List;

public class AddressRepository extends BaseRepository{
    
    public void save(Address address) {
    	getEntityManager().persist(address);
    }

    public Address findById(Long id) {
        return getEntityManager().find(Address.class, id);
    }

    public void update(Address address) {
    	getEntityManager().merge(address);
    }

    public void delete(Address address) {
    	getEntityManager().remove(address);
    }

    public List<Address> findAll() {
        return getEntityManager().createQuery("SELECT a FROM Address a", Address.class).getResultList();
    }
}

