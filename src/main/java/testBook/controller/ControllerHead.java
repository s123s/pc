package testBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import testBook.model.*;
import testBook.service.*;

/**
 * Created by yasha on 04.12.2016.
 */
@Controller
public class ControllerHead {

    private WorkplaceService workplaceService;
    private WpService wpService;
    private ComputerService computerService;
    private UserService userService;
    private MonitorService monitorService;
    private PrinterService printerService;
    private UpsService upsService;
    private OsService osService;
    private ThddService thddService;
    private TramService tramService;
    private TprocService tprocService;
    private TmotherService tmotherService;
    private ProducerService producerService;

    @Autowired
    @Qualifier(value="producerService")
    public void setProducerService(ProducerService producerService){
        this.producerService = producerService;
    }


    @Autowired
    @Qualifier(value="workplaceService")
    public void setWorkplaceService(WorkplaceService workplaceService){
        this.workplaceService = workplaceService;
    }

    @Autowired
    @Qualifier(value="tmotherService")
    public void setTmotherService(TmotherService tmotherService){
        this.tmotherService = tmotherService;
    }

    @Autowired
    @Qualifier(value="tprocService")
    public void setTprocService(TprocService tprocService){
        this.tprocService = tprocService;
    }

    @Autowired
    @Qualifier(value="tramService")
    public void setTramService(TramService tramService){
        this.tramService = tramService;
    }

    @Autowired
    @Qualifier(value="thddService")
    public void setThddService(ThddService thddService){
        this.thddService = thddService;
    }

    @Autowired
    @Qualifier(value="printerService")
    public void setPrinterService(PrinterService printerService){
        this.printerService = printerService;
    }

    @Autowired
    @Qualifier(value="upsService")
    public void setUpsService(UpsService upsService){
        this.upsService = upsService;
    }

    @Autowired
    @Qualifier(value="osService")
    public void setOSService(OsService osService){
        this.osService = osService;
    }


    @Autowired
    @Qualifier(value = "monitorService")
    public void setMonitorService(MonitorService monitorService){this.monitorService = monitorService;}

    @Autowired
    @Qualifier(value = "userService")
    public void setUserService(UserService userService){this.userService = userService;}

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

    //Producer
    @RequestMapping(value="/producer")
    public String listProducer(Model model){
        model.addAttribute("producer", new Producer());
        model.addAttribute("listProducer", this.producerService.listProducer());
        return "producer";
    }

    @RequestMapping(value="/addProducer")
    public String addProducer(@ModelAttribute("producer") Producer producer, Model model) {
        this.producerService.addProducer(producer);
        model.addAttribute("listProducer", this.producerService.listProducer());
        return "producer";
    }
    @RequestMapping("removeProducer/{id}")
    public String removeProducer(@PathVariable("id") Long id){
        this.producerService.removeProducer(id);
        return "redirect:/producer";
    }
    @RequestMapping(value="editProducer/{id}")
    public String editProducer(@PathVariable("id") Long id, Model model) {
        model.addAttribute("producer", this.producerService.getProducerById(id));
       /* System.out.println(this.printerService.getPrinterById(id));*/
        return "/editProducer";
    }

    @RequestMapping(value="/updateProducer" /*method=RequestMethod.POST*/)
    public String updateProducer(@ModelAttribute("producer") Producer producer){
        this.producerService.updateProducer(producer);
        return "redirect:/producer";
    }


//ram
    @RequestMapping(value="/ram")
    public String listRsm(Model model){
        model.addAttribute("tram", new Tram());
        model.addAttribute("listTram", this.tramService.listTram());
        return "ram";
    }

    @RequestMapping(value="/addRam")
    public String addHdd(@ModelAttribute("tram") Tram tram, Model model) {
        this.tramService.addTram(tram);
        model.addAttribute("listTram", this.tramService.listTram());
        return "ram";
    }
    @RequestMapping("removeRam/{id}")
    public String removeRam(@PathVariable("id") Long id){
        this.tramService.removeTram(id);
        return "redirect:/ram";
    }

    @RequestMapping(value="/hdd")
    public String listHdd(Model model){
        model.addAttribute("thdd", new Thdd());
        model.addAttribute("listThdd", this.thddService.listThdd());
        return "hdd";
    }

    @RequestMapping(value="/addHdd")
    public String addHdd(@ModelAttribute("thdd") Thdd thdd, Model model) {
        this.thddService.addThdd(thdd);
        model.addAttribute("listThdd", this.thddService.listThdd());
        return "hdd";
    }
    @RequestMapping("removeHdd/{id}")
    public String removeHdd(@PathVariable("id") Long id){
        this.thddService.removeThdd(id);
        return "redirect:/hdd";
    }


    @RequestMapping(value="/motherboard")
    public String listMotherboard(Model model){
        model.addAttribute("listProducer", this.producerService.listProducer());
        model.addAttribute("tmother", new Tmother());
        model.addAttribute("listTmother", this.tmotherService.listTmother());
        return "motherboard";
    }

    @RequestMapping(value="/addMotherboard")
    public String addMotherboard(@ModelAttribute("tmother") Tmother tmother, Model model) {
        this.tmotherService.addTmother(tmother);
        model.addAttribute("listTmother", this.tmotherService.listTmother());
        return "redirect:/motherboard";
    }
    @RequestMapping("removeMotherboard/{id}")
    public String removeMotherboard(@PathVariable("id") Long id){
        this.tmotherService.removeTmother(id);
        return "redirect:/motherboard";
    }
    @RequestMapping(value="editMotherboard/{id}")
    public String editMotherboard(@PathVariable("id") Long id, Model model) {
        model.addAttribute("tmother", this.tmotherService.getTmotherById(id));
         return "/editTmother";
    }

    @RequestMapping(value="/updateMotherboard" /*method=RequestMethod.POST*/)
    public String updateMotherboard(@ModelAttribute("tmother") Tmother tmother){
        this.tmotherService.updateTmother(tmother);
        return "redirect:/motherboard";
    }

//Processor
    @RequestMapping(value="/processor")
    public String listProcessor(Model model){
        model.addAttribute("tproc", new Tproc());
        model.addAttribute("listTproc", this.tprocService.listTproc());
        return "processor";
    }

    @RequestMapping(value="/addProcessor")
    public String addProcessor(@ModelAttribute("tproc") Tproc tproc, Model model) {
        this.tprocService.addTproc(tproc);
        model.addAttribute("listTproc", this.tprocService.listTproc());
        return "processor";
    }
    @RequestMapping("removeProcessor/{id}")
    public String removeProcessor(@PathVariable("id") Long id){
        this.tprocService.removeTproc(id);
        return "redirect:/processor";
    }
    @RequestMapping(value="editProcessor/{id}")
    public String editProcessor(@PathVariable("id") Long id, Model model) {
        model.addAttribute("tproc", this.tprocService.getTprocById(id));
       /* System.out.println(this.printerService.getPrinterById(id));*/
        return "/editProcessor";
    }

    @RequestMapping(value="/updateProcessor" /*method=RequestMethod.POST*/)
    public String updateProcessor(@ModelAttribute("tproc") Tproc tProc){
        this.tprocService.updateTproc(tProc);
        return "redirect:/processor";
    }
//Workplace
    @RequestMapping(value="/workplace")
    public String listWorkplace(Model model){
        model.addAttribute("workplace", new Workplace());
        model.addAttribute("listWorkplace", this.workplaceService.listWorkplace());
        return "workplace";
    }
//Ups
    @RequestMapping(value="/ups")
    public String listUps(Model model){
        model.addAttribute("ups", new Ups());
        model.addAttribute("listUps", this.upsService.listUps());
        return "ups";
    }
    @RequestMapping(value="/addUps")
    public String addUps(@ModelAttribute("ups") Ups ups, Model model) {
        this.upsService.addUps(ups);
        model.addAttribute("listUps", this.upsService.listUps());
        return "ups";
    }
    @RequestMapping(value="editUps/{id}")
    public String editUps(@PathVariable("id") Long id, Model model) {
        model.addAttribute("ups", this.upsService.getUpsById(id));
       /* System.out.println(this.printerService.getPrinterById(id));*/
        return "/editUps";
    }

    @RequestMapping(value="/updateUps" /*method=RequestMethod.POST*/)
    public String updateUps(@ModelAttribute("ups") Ups ups){
        this.upsService.updateUps(ups);
        return "redirect:/ups";
    }
    @RequestMapping("removeUps/{id}")
    public String removeUps(@PathVariable("id") Long id){
        this.upsService.removeUps(id);
        return "redirect:/ups";
    }
//Printer
    @RequestMapping(value="/printers")
    public String listPrinter(Model model){
        model.addAttribute("printer", new Printer());
        model.addAttribute("listPrinter", this.printerService.listPrinter());
        return "printers";
    }
    @RequestMapping(value="/addPrinter")
    public String addPrinter(@ModelAttribute("printer") Printer printer, Model model) {
        this.printerService.addPrinter(printer);
        model.addAttribute("listPrinter", this.printerService.listPrinter());
        return "printers";
    }

    @RequestMapping(value="editPrinter/{id}")
    public String editPrinter(@PathVariable("id") Long id, Model model) {
        model.addAttribute("printer", this.printerService.getPrinterById(id));
       /* System.out.println(this.printerService.getPrinterById(id));*/
        return "/editPrinter";
    }

    @RequestMapping(value="/updatePrinter" /*method=RequestMethod.POST*/)
    public String updatePrinter(@ModelAttribute("printer") Printer printer){
        this.printerService.updatePrinter(printer);
        return "redirect:/printers";
    }

    @RequestMapping("removePrinter/{id}")
    public String removePrinter(@PathVariable("id") Long id){
        this.printerService.removePrinter(id);
        return "redirect:/printers";
    }
//User
    @RequestMapping(value="/user")
    public String listUser(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUser", this.userService.listUser());
        return "user";
    }
    @RequestMapping(value="/addUser")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        this.userService.addUser(user);
        model.addAttribute("listUser", this.userService.listUser());
        return "user";
    }
    @RequestMapping("removeUser/{id}")
    public String removeUser(@PathVariable("id") Long id){
        this.userService.removeUser(id);
        return "redirect:/user";
    }
    @RequestMapping(value="editUser/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));
        return "/editUser";
    }

    @RequestMapping(value="/updateUser" /*method=RequestMethod.POST*/)
    public String updateUser(@ModelAttribute("user") User user){
        this.userService.updateUser(user);
        return "redirect:/user";
    }

     //Monitor
     @RequestMapping(value="/monitor")
     public String listMonitor(Model model){
         model.addAttribute("monitor", new Monitor());
         model.addAttribute("listMonitor", this.monitorService.listMonitor());
         return "monitor";
     }

    @RequestMapping(value="/addMonitor")
    public String addMonitor(@ModelAttribute("monitor") Monitor monitor, Model model) {
        this.monitorService.addMonitor(monitor);
        model.addAttribute("listMonitor", this.monitorService.listMonitor());
        return "monitor";
    }
    @RequestMapping("removeMonitor/{id}")
    public String removeMonitor(@PathVariable("id") Long id){
        this.monitorService.removeMonitor(id);
        return "redirect:/monitor";
    }
    @RequestMapping(value="editMonitor/{id}")
    public String editMonitor(@PathVariable("id") Long id, Model model) {
        model.addAttribute("monitor", this.monitorService.getMonitorById(id));
        return "/editMonitor";
    }

    @RequestMapping(value="/updateMonitor" /*method=RequestMethod.POST*/)
    public String updateMonitor(@ModelAttribute("monitor") Monitor monitor){
        this.monitorService.updateMonitor(monitor);
        return "redirect:/monitor";
    }
    //Computer
    @RequestMapping(value="/computer")
    public String listComputer(Model model){
        model.addAttribute("computer", new Computer());
        model.addAttribute("listComputer", this.computerService.listComputer());
        model.addAttribute("listMotherNotComputer", this.tmotherService.listMotherNotComp());
        return "computer";
    }

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
    }*/


//WP
    @RequestMapping(value = "/wp")
    public String listWp(Model model){
        model.addAttribute("wp", new Wp());
        model.addAttribute("listWp", this.wpService.listWp());
        return "wp";
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
    }*/


//Security
    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value="/login-failure")
    public String loginFailure() {
        return "accesDenied";
    }

}
