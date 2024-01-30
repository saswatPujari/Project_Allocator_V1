package com.crudapp.respository;

import com.crudapp.entity.User;
import java.util.List;

public class UserRepository extends BaseRepository {
    
    public void save(User user) {
    	getEntityManager().persist(user);
    }

    public User findById(Long id) {
        return getEntityManager().find(User.class, id);
    }

    public void update(User user) {
    	getEntityManager().merge(user);
    }

    public void delete(User user) {
    	getEntityManager().remove(user);
    }

	public List<User> findAll() {
        return getEntityManager().createQuery("SELECT u FROM User u", User.class).getResultList();
    }
}

