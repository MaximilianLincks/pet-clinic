package com.dscsag.petclinic.services.map;

import com.dscsag.petclinic.model.BaseEntity;
import com.dscsag.petclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService <T extends BaseEntity, ID extends Long>  implements CrudService<T , ID> {
    protected Map<Long, T> map = new HashMap<>();

    public Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    public T findById(ID id){
        return map.get(id);
    }

    public T save(T t){
        if(t == null) throw new RuntimeException("Null cant be saved in AbstractMapService");
        if(t.getId() == null){
            t.setId(getNextId());
        }
        return map.put(t.getId(),t);
    }

    public void deleteById(ID id){
        map.remove(id);
    }

    public void delete(T t){
        map.entrySet().removeIf(entry -> entry.getValue().equals(t));
    }

    private Long getNextId(){
        return map.isEmpty() ? 1L : Collections.max(map.keySet()) + 1;
    }
}
