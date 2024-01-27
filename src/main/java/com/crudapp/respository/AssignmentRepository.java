package com.crudapp.respository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.crudapp.entity.Assignment;

import java.util.List;

public class AssignmentRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Assignment assignment) {
        entityManager.persist(assignment);
    }

    public Assignment findById(Long id) {
        return entityManager.find(Assignment.class, id);
    }

    @Transactional
    public void update(Assignment assignment) {
        entityManager.merge(assignment);
    }

    @Transactional
    public void delete(Assignment assignment) {
        entityManager.remove(assignment);
    }

    public List<Assignment> findAll() {
        return entityManager.createQuery("SELECT a FROM Assignment a", Assignment.class).getResultList();
    }
}

