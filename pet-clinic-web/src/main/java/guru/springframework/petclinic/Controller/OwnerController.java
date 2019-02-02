package guru.springframework.petclinic.Controller;

import guru.springframework.petclinic.DAO.OwnerDAO;
import guru.springframework.petclinic.model.Owner;
import guru.springframework.petclinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;


@RequestMapping("/owners")
@Controller
public class OwnerController {

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
        public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId){
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(this.ownerService.findById(ownerId));
        return mav;
    }

}




