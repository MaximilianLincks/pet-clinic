package com.dscsag.petclinic.services.map;

import com.dscsag.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    Long ownerId = 1L;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetMapService(new PetTypeMapService()));
        ownerMapService.save(Owner.builder().id(ownerId).build());
    }

    @Test
    void testFindAll() {
        Set<Owner> owners = ownerMapService.findAll();

        assertEquals(1,owners.size());
    }

    @Test
    void testFindById() {
        Owner owner = ownerMapService.findById(ownerId);

        assertEquals(ownerId,owner.getId());
    }

    @Test
    void testSave() {
        Long otherId = 2L;
        ownerMapService.save(Owner.builder().id(otherId).build());

        assertEquals(2,ownerMapService.findAll().size());
    }

    @Test
    void saveWithoutId(){
        Owner owner = ownerMapService.save(new Owner());

        assertEquals(2,ownerMapService.findAll().size());
        assertNotNull(owner.getId());
    }

    @Test
    void testDeleteById() {
        Owner owner = ownerMapService.save(new Owner());

        ownerMapService.deleteById(ownerId);

        assertEquals(1,ownerMapService.findAll().size());
        assertNull(ownerMapService.findById(ownerId));

        ownerMapService.deleteById(owner.getId());
        assertEquals(0,ownerMapService.findAll().size());


    }

    @Test
    void testDelete() {
        Owner owner = ownerMapService.save(new Owner());

        ownerMapService.delete(owner);

        assertEquals(1,ownerMapService.findAll().size());
        assertFalse(ownerMapService.findAll().contains(owner));
    }

    @Test
    void findByLastName() {
        String lastName = "Smith";
        Owner owner = ownerMapService.save(Owner.builder().lastName(lastName).build());
        assertEquals(lastName,ownerMapService.findByLastName(lastName).getLastName());
    }



}