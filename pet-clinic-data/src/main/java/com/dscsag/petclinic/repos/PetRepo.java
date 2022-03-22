package com.dscsag.petclinic.repos;

import com.dscsag.petclinic.model.Owner;
import com.dscsag.petclinic.model.Pet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepo extends CrudRepository<Pet,Long> {
    @Query(value = "SELECT * FROM pets WHERE pets.name LIKE :petname AND pets.owner_Id = :ownerId",nativeQuery = true)
    List<Pet> findPetsOfOwnerByName(@Param("petname") String petName, @Param("ownerId") Long ownerId);
}
