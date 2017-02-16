package testBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import testBook.model.Wp;
import testBook.service.WpService;

/**
 * Created by yasha on 04.12.2016.
 */
@Controller
public class ControllerBook {
    private WpService wpService;


    @Autowired
    @Qualifier(value = "wpService")
    public void setWpService(WpService wpService){
        this.wpService = wpService;
    }


    @RequestMapping(value = "/wp")
    public String listWp(Model model){
      model.addAttribute("wp", new Wp());
        model.addAttribute("listWp", this.wpService.listWp());
        return "wp";
    }


    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value="/login-failure")
    public String loginFailure() {
        return "accesDenied";
    }
   /* @RequestMapping(value="autor/{autor_id}", method = RequestMethod.GET)
public String getAutorById(@PathVariable("autor_id") Long id, Model model){
        model.addAttribute("autork",this.autorService.getAutorById(id).getName());
        return "redirect:/books";*/

}
