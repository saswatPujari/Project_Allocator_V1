package com.crudapp.respository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.crudapp.entity.Address;

import java.util.List;

public class AddressRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Address address) {
        entityManager.persist(address);
    }

    public Address findById(Long id) {
        return entityManager.find(Address.class, id);
    }

    @Transactional
    public void update(Address address) {
        entityManager.merge(address);
    }

    @Transactional
    public void delete(Address address) {
        entityManager.remove(address);
    }

    public List<Address> findAll() {
        return entityManager.createQuery("SELECT a FROM Address a", Address.class).getResultList();
    }
}

