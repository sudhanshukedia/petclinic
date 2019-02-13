package guru.springframework.petclinic.Controller;

import guru.springframework.petclinic.model.Owner;
import guru.springframework.petclinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Set;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    public static  final String  VIEWS_OWNER_CREATE_OR_UPDATE_FORM ="owners/createOrUpdateOwnerForm";

    @Autowired
    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService){
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","/find","/find.html"})
    public String listOfOwner(Model model){

        Set<Owner> owners = ownerService.findAll();
        model.addAttribute("owners", owners);
        return "owners/find";
    }
    @GetMapping("/{ownerId}")
        public ModelAndView showOwner(@PathVariable  Long ownerId){
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(this.ownerService.findById(ownerId));
        return mav;
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable  Long ownerId, Model model){
        model.addAttribute(ownerService.findById(ownerId));
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, @PathVariable long ownerId){
        if(result.hasErrors()){
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }
        else{
            owner.setId(ownerId);
            Owner savedOwner = ownerService.save(owner);
            return "redirect/owners/" +savedOwner.getId();
        }

    }



    @GetMapping("/new")
    public String initCreationForm(Model model){
        Owner owner = new Owner();
        model.addAttribute("owner", owner);
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result){
        if(result.hasErrors())  {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }
        else {
            ownerService.save(owner);
            return "redirect:/owners/"  +owner.getId();
        }
    }


}




