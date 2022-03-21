package com.dscsag.petclinic.services;

import com.dscsag.petclinic.model.Owner;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface OwnerService extends CrudService<Owner,Long>{
    default Owner findByLastName(String lastName) {
        return findAll().
                stream().
                filter(owner -> Objects.nonNull(owner.getLastName())).
                filter(owner -> owner.getLastName().equals(lastName)).
                findFirst().
                orElse(null);
    }

    default List<Owner> findAllByLastNameLike(String lastName) {
        return findAll().stream()
                .filter(owner -> owner.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

}
