package com.crudapp.respository;

import com.crudapp.entity.Project;
import java.util.List;

public class ProjectRepository extends BaseRepository{
    
    public void save(Project project) {
        getEntityManager().persist(project);
    }

    public Project findById(Long id) {
        return getEntityManager().find(Project.class, id);
    }

    public void update(Project project) {
    	getEntityManager().merge(project);
    }

    public void delete(Project project) {
    	getEntityManager().remove(project);
    }

    public List<Project> findAll() {
        return getEntityManager().createQuery("SELECT p FROM Project p", Project.class).getResultList();
    }
}

