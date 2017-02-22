package testBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import testBook.model.Computer;
import testBook.model.Wp;
import testBook.service.ComputerService;
import testBook.service.WpService;

/**
 * Created by yasha on 04.12.2016.
 */
@Controller
public class ControllerBook {

    private WpService wpService;
    private ComputerService computerService;

    @Autowired
    @Qualifier(value = "wpService")
    public void setWpService(WpService wpService){
        this.wpService = wpService;
    }

    @Autowired
    @Qualifier(value = "computerService")
    public void setComputerService(ComputerService computerService){
        this.computerService = computerService;
    }

    @RequestMapping(value="/computer")
    public String listComputer(Model model){
        model.addAttribute("computer", new Computer());
        model.addAttribute("listComputer", this.computerService.listComputer());
        return "computer";
    }

    @RequestMapping(value = "/wp")
    public String listWp(Model model){
      model.addAttribute("wp", new Wp());
        model.addAttribute("listWp", this.wpService.listWp());
        return "wp";
    }
    /*@RequestMapping(value="/computer")
    public String Computer(){
        return "computer";
    }*/
    @RequestMapping(value="/addComputer")
    public String addComputer(@ModelAttribute("computer") Computer computer, Model model) {
        this.computerService.addComputer(computer);
        model.addAttribute("listComputer", this.computerService.listComputer());
        return "computer";
    }
    @RequestMapping("remove/{id}")
    public String removeComputer(@PathVariable("id") Long id){
        this.computerService.removeComputer(id);
        return "redirect:/computer";
    }

   /* @RequestMapping(value="edit/{id}")
    public String editComputer(@PathVariable("id") Long id, Model model){
        model.addAttribute("computer", this.computerService.getComputerById(id));
        return "/computer";
    }
    @RequestMapping(value="/update")
    public String updateComputer(@ModelAttribute("computer") Computer computer){
        this.computerService.updateComputer(computer);
        return "redirect:/computer";
    }*/dwww

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
