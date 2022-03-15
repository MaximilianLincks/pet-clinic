package com.dscsag.petclinic.bootstrap;

import com.dscsag.petclinic.model.*;
import com.dscsag.petclinic.services.OwnerService;
import com.dscsag.petclinic.services.PetTypeService;
import com.dscsag.petclinic.services.SpecialtyService;
import com.dscsag.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//when context is created alle CommandLineRunner Beans are executed
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(petTypeService.findAll().isEmpty()){
            loadOwnersAndPets();
            loadVets();
        }

    }

    private void loadOwnersAndPets() {
        PetType cat = new PetType();
        cat.setName("Cat");

        petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Dog");

        petTypeService.save(dog);

        System.out.println("Loaded PetTypes...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickelel ");
        owner1.setCity("Miami");
        owner1.setTelephone("348293427399");

        Pet mikesCat = new Pet();
        mikesCat.setPetType(cat);
        mikesCat.setOwner(owner1);
        mikesCat.setName("Rasputin");
        mikesCat.setBirthDate(LocalDate.now().minusYears(2));
        owner1.getPets().add(mikesCat);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Gleanne");
        owner2.setAddress("123 Brickelel ");
        owner2.setCity("Miami");
        owner2.setTelephone("348293427399");

        Pet fionasDog = new Pet();
        fionasDog.setName("Thomas");
        fionasDog.setBirthDate(LocalDate.now().minusMonths(7));
        fionasDog.setPetType(dog);
        fionasDog.setOwner(owner2);
        owner2.getPets().add(fionasDog);
        ownerService.save(owner2);

        System.out.println("Loaded owners");
    }

    private void loadVets() {
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        specialtiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        specialtiesService.save(surgery);

        vet1.getSpecialties().add(radiology);
        vet1.getSpecialties().add(surgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        specialtiesService.save(dentistry);

        vet2.getSpecialties().add(dentistry);

        vetService.save(vet2);

        System.out.println("Loaded vets");
    }


}
