package com.crudapp.respository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.crudapp.entity.Device;

import java.util.List;

public class DeviceRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Device device) {
        entityManager.persist(device);
    }

    public Device findById(Long id) {
        return entityManager.find(Device.class, id);
    }

    @Transactional
    public void update(Device device) {
        entityManager.merge(device);
    }

    @Transactional
    public void delete(Device device) {
        entityManager.remove(device);
    }

    public List<Device> findAll() {
        return entityManager.createQuery("SELECT d FROM Device d", Device.class).getResultList();
    }
}

