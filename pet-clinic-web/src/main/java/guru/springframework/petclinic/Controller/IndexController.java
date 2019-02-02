package guru.springframework.petclinic.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"","/","/index.html","index"})
 public String index(){
     return "index";
 }

}
