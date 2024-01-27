package com.crudapp.respository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.crudapp.entity.Activity;

import java.util.List;

public class ActivityRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Activity activity) {
        entityManager.persist(activity);
    }

    public Activity findById(Long id) {
        return entityManager.find(Activity.class, id);
    }

    @Transactional
    public void update(Activity activity) {
        entityManager.merge(activity);
    }

    @Transactional
    public void delete(Activity activity) {
        entityManager.remove(activity);
    }

    public List<Activity> findAll() {
        return entityManager.createQuery("SELECT a FROM Activity a", Activity.class).getResultList();
    }
}


