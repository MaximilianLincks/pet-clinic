package com.dscsag.controllers;

import com.dscsag.petclinic.model.Owner;
import com.dscsag.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

//    @GetMapping({"","/","index","index.html"})
//    public String listOwners(Model model){
//
//        model.addAttribute("owners",ownerService.findAll());
//
//        return "owners/index";
//    }

    @GetMapping({"/find","/find/"})
    public String findOwners(Model model){
        model.addAttribute("owner",new Owner());
        return "owners/findOwners";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable long ownerId){
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

    @GetMapping("")
    public String processFindForm(Owner owner, BindingResult result, Model model){
        if(owner.getLastName() == null) owner.setLastName("");

        List<Owner> results = ownerService.findAllByLastNameContaining(owner.getLastName().toLowerCase());

        if(results.isEmpty()){
            result.rejectValue("lastName","notFound","notFound");
            return "owners/findOwners";
        }else if(results.size() == 1){
            owner = results.get(0);
            return String.format("redirect:/owners/%s",owner.getId());
        }else {
            model.addAttribute("selections",results);
            return "/owners/ownersList";
        }
    }

    @GetMapping("/new")
    public String initCreationForm(Model model){
       model.addAttribute("owner",new Owner());
       return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result){
        if(result.hasErrors()){
            return "owners/createOrUpdateForm";
        }else{
            ownerService.save(owner);
            return String.format("redirect:/owners/%s",owner.getId());
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model){
        model.addAttribute("owner",ownerService.findById(ownerId));
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, @PathVariable Long ownerId){
        if(result.hasErrors()){
            return "owners/createOrUpdateOwnerForm";
        }else {
            owner.setId(ownerId);
            ownerService.save(owner);
            return String.format("redirect:/owners/%s",owner.getId());
        }
    }
}
