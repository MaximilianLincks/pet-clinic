package com.dscsag.petclinic.services;

import com.dscsag.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long>{
    default Owner findByLastName(String lastName) {
        return findAll().
                stream().
                filter(owner -> owner.getLastName().equals(lastName)).
                findFirst().
                orElse(null);
    }
}
