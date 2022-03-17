package com.dscsag.petclinic.services.springdatajpa;

import com.dscsag.petclinic.model.Owner;
import com.dscsag.petclinic.repos.OwnerRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    @Mock
    OwnerRepo repo;

    @InjectMocks
    OwnerJpaService ownerService;

    Set<Owner> owners;

    Long ownerId = 666L;
    String lastName = "DoomGuy";

    Owner doomGuy;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        doomGuy = Owner.builder().id(ownerId).lastName(lastName).build();

        owners.add(Owner.builder().id(1L).build());
        owners.add(doomGuy);
        owners.add(Owner.builder().id(2L).build());
    }

    //Other methods are implemented and provided by the spring runtime
    //therefore they can't be tested with mocks

    @Test
    void findByLastName() {
        when(repo.findAll()).then(invocationOnMock -> owners);

        assertEquals(doomGuy,ownerService.findByLastName(lastName));
    }
}