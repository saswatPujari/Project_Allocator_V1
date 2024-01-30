package com.crudapp.respository;

import com.crudapp.entity.Activity;
import java.util.List;

public class ActivityRepository  extends BaseRepository{
    
    public void save(Activity activity) {
    	getEntityManager().persist(activity);
    }

    public Activity findById(Long id) {
        return getEntityManager().find(Activity.class, id);
    }

    public void update(Activity activity) {
    	getEntityManager().merge(activity);
    }

    public void delete(Activity activity) {
    	getEntityManager().remove(activity);
    }

    public List<Activity> findAll() {
        return getEntityManager().createQuery("SELECT a FROM Activity a", Activity.class).getResultList();
    }
}


