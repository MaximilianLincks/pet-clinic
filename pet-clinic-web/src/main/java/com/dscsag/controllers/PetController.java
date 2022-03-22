package com.dscsag.controllers;

import com.dscsag.petclinic.model.Owner;
import com.dscsag.petclinic.model.Pet;
import com.dscsag.petclinic.model.PetType;
import com.dscsag.petclinic.services.OwnerService;
import com.dscsag.petclinic.services.PetService;
import com.dscsag.petclinic.services.PetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequiredArgsConstructor
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private final PetService petService;
    private final PetTypeService petTypeService;
    private final OwnerService ownerService;

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes(){
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") long ownerId){
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, Model model){
        Pet pet = new Pet();
        owner.getPets().add(pet);
        model.addAttribute("pet",pet);
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("pets/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, Model model){
        if(StringUtils.hasLength(pet.getName()) && pet.isNew() && !petService.findPetsOfOwnerByName(pet.getName(),pet.getOwner()).isEmpty()){
            result.rejectValue("name","duplicate","already exists");
        }
        owner.getPets().add(pet);
        if(result.hasErrors()) {
            model.addAttribute("pet",pet);
            return "pets/createOrUpdatePetForm";
        }else {
            petService.save(pet);
            return String.format("redirect:/owners/%s",owner.getId());
        }

    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable long petId, Model model){
        model.addAttribute(petService.findById(petId));
        return "pets/createOrUpdatePetForm";
    }


    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@Valid Pet pet,Owner owner,BindingResult result, Model model){
        if(result.hasErrors()){
            pet.setOwner(owner);
            owner.getPets().add(pet);
            model.addAttribute(pet);
            return "pets/createOrUpdatePetForm";
        }else {
            owner.getPets().add(pet);
            petService.save(pet);
            return String.format("redirect:/owners/%s",owner.getId());
        }
    }
}
