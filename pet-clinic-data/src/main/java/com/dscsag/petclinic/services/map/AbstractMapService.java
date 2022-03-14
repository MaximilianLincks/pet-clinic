package com.dscsag.petclinic.services.map;

import com.dscsag.petclinic.model.BaseEntity;
import com.dscsag.petclinic.model.Owner;
import com.dscsag.petclinic.services.CrudService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService <T extends BaseEntity<ID>, ID>  implements CrudService<T , ID> {
    protected Map<ID, T> map = new HashMap<>();

    public Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    public T findById(ID id){
        return map.get(id);
    }

    public T save(T t){
        map.put(t.getId(),t);
        return t;
    }

    public void deleteById(ID id){
        map.remove(id);
    }

    public void delete(T t){
        map.entrySet().removeIf(entry -> entry.getValue().equals(t));
    }
}
