package com.crudapp.respository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.crudapp.entity.Project;

import java.util.List;

public class ProjectRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Project project) {
        entityManager.persist(project);
    }

    public Project findById(Long id) {
        return entityManager.find(Project.class, id);
    }

    @Transactional
    public void update(Project project) {
        entityManager.merge(project);
    }

    @Transactional
    public void delete(Project project) {
        entityManager.remove(project);
    }

    public List<Project> findAll() {
        return entityManager.createQuery("SELECT p FROM Project p", Project.class).getResultList();
    }
}

