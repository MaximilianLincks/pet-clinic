package com.dscsag.controllers;

import com.dscsag.petclinic.model.Owner;
import com.dscsag.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

        List<Owner> results = ownerService.findAllByLastNameLike(owner.getLastName());

        if(results.isEmpty()){
            result.rejectValue("lastName","notFound","notFound");
            return "owners/findOwners";
        }else if(results.size() == 1){
            owner = results.get(0);
            return String.format("redirect:/owners/%s",owner.getId());
        }else {
            model.addAttribute("selections",results);
            return "owners/ownersList";
        }
    }
}
