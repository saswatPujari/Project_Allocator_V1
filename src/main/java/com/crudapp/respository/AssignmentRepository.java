package com.crudapp.respository;

import com.crudapp.entity.Assignment;
import java.util.List;

public class AssignmentRepository extends BaseRepository {
    
    public void save(Assignment assignment) {
        getEntityManager().persist(assignment);
    }

    public Assignment findById(Long id) {
        return getEntityManager().find(Assignment.class, id);
    }

    public void update(Assignment assignment) {
    	getEntityManager().merge(assignment);
    }

    public void delete(Assignment assignment) {
    	getEntityManager().remove(assignment);
    }

    public List<Assignment> findAll() {
        return getEntityManager().createQuery("SELECT a FROM Assignment a", Assignment.class).getResultList();
    }
}

