package com.crudapp.respository;

import com.crudapp.entity.Device;
import java.util.List;

public class DeviceRepository extends BaseRepository {
    
    public void save(Device device) {
        getEntityManager().persist(device);
    }

    public Device findById(Long id) {
        return getEntityManager().find(Device.class, id);
    }

    public void update(Device device) {
    	getEntityManager().merge(device);
    }

    public void delete(Device device) {
    	getEntityManager().remove(device);
    }

    public List<Device> findAll() {
        return getEntityManager().createQuery("SELECT d FROM Device d", Device.class).getResultList();
    }
}

