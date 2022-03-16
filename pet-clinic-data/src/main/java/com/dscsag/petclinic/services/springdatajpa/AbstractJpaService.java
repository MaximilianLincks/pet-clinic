package com.dscsag.petclinic.services.springdatajpa;

import com.dscsag.petclinic.model.BaseEntity;
import com.dscsag.petclinic.services.CrudService;
import com.dscsag.petclinic.utils.CollectionUtils;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public abstract class AbstractJpaService<T extends BaseEntity, ID extends Long, REPO extends CrudRepository<T , ID>> implements CrudService<T, ID> {

    protected final REPO repo;

    @Override
    public Set<T> findAll() {
        return CollectionUtils.iterableToCollection(repo.findAll(),new HashSet<>());
    }

    @Override
    public T findById(ID id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public T save(T t) {
        return repo.save(t);
    }

    @Override
    public void delete(T t) {
        repo.delete(t);
    }

    @Override
    public void deleteById(ID id) {
        repo.deleteById(id);
    }

}
