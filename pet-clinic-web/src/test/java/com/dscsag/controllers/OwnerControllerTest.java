package com.dscsag.controllers;

import com.dscsag.petclinic.model.Owner;
import com.dscsag.petclinic.services.OwnerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StreamUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;

    MockMvc mockMvc;

    Set<Owner> owners;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();


    }



    @Test
    void findOwner() throws Exception {
        mockMvc.perform(get("/owners/find"))
        .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"))
                .andExpect(model().attributeExists("owner"));

    }

    @Test
    void showOwner() throws Exception {
        when(ownerService.findById(any())).thenReturn(Owner.builder().id(1L).build());


        mockMvc.perform(get("/owners/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id",is(1L))));
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    void findFormReturnOwners(int amount) throws Exception {
        when(ownerService.findAllByLastNameLike(anyString())).thenReturn(owners.stream().limit(amount).collect(Collectors.toList()));

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/owners"));
        if(amount < 1){
            result
                    .andExpect(status().isOk())
                    .andExpect(view().name("owners/findOwners"));
        }else if(amount == 1){
            result
                    .andExpect(status().is3xxRedirection())
                    .andExpect(view().name(containsString("redirect:/owners/")));
        }else{
            result
                    .andExpect(status().isOk())
                    .andExpect(model().attributeExists("selections"))
                    .andExpect(view().name("owners/ownersList"));
        }
    }
}