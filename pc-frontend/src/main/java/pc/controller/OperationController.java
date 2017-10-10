package pc.controller;

import java.util.Random;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonView;

import pc.jackson.View;
import pc.model.Computer;
import pc.model.Hdd;
import pc.model.Monitor;
import pc.model.Mother;
import pc.model.Os;
import pc.model.Printer;
import pc.model.Processor;
import pc.model.Ram;
import pc.model.TypeHdd;
import pc.model.TypeMother;
import pc.model.TypeProc;
import pc.model.TypeRam;
import pc.model.Ups;
import pc.model.User;
import pc.service.MainService;
import pc.service.OperationStatus;

@Controller
//@RequestMapping(value = "")
public class OperationController {


	@Autowired(required = true)
	//@Qualifier(value = "mainService")	
	private MainService mainService;

	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}
	

	@RequestMapping(value = "/errorPage")
	public String errorPage() {
		return "errorPage";
	}
	
	  @RequestMapping("ajax")
	    public ModelAndView helloAjaxTest() {
	        return new ModelAndView("ajax", "message", "Crunchify Spring MVC with Ajax and JQuery Demo..");
	    }
	 
	    @RequestMapping(value = "/ajaxtest",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody
	    String getTime() {
	 
	        Random rand = new Random();
	        float r = rand.nextFloat() * 100;
	        String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
	        System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + new Date().toString());
	        return result;
	    }

/*----wp_table----*/
	@RequestMapping(value = "wp_table")
	public String listWp(ModelMap model) {
		model.addAttribute("wps", mainService.getWpDao().readAll());
		return "wp_table";
	}

	@RequestMapping(value = "/type_hdd")
	public String listTypeHdd(ModelMap model) {
		model.addAttribute("typeHdds", mainService.getTypeHddDao().readAll());
		model.addAttribute("producers", mainService.getProducerDao().readAll());
		return "type_hdd";
	}
	
	@RequestMapping(value = "/type_hdd/save_edited",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus saveEditedTypeHdd(@RequestBody TypeHdd typeHdd) {
		return mainService.getTypeHddDao().update(typeHdd);
	}	
	
	@RequestMapping(value = "/type_hdd/create",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus createTypeHdd(@Valid @RequestBody TypeHdd typeHdd, BindingResult bindingResult) {
		
		//Если проверка значений не прошла
		if (bindingResult.hasErrors()) {
//			logger.info("Returning custSave.jsp page");
			return new OperationStatus(false);
		}
        return mainService.getTypeHddDao().create(typeHdd);
	}	
	
	@RequestMapping(value = "/type_hdd/delete",  method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteTypeHdd(@RequestBody TypeHdd typeHdd) {
		mainService.getTypeHddDao().delete(typeHdd.getIdTypeHdd());
	}
	
	
/*----type_ram----*/
	@RequestMapping(value = "/type_ram")
	public String listTypeRam(ModelMap model) {
		model.addAttribute("typeRams", mainService.getTypeRamDao().readAll());
		model.addAttribute("typeRamSpecs", mainService.getTypeRamSpecDao().readAll());
		return "type_ram";
	}

	@RequestMapping(value = "/type_ram/save_edited",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus saveEditedTypeRam(@RequestBody TypeRam typeRam) {
		return mainService.getTypeRamDao().update(typeRam);
	}	
	
	@RequestMapping(value = "/type_ram/create",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus createTypeRam(@RequestBody TypeRam typeRam) {
        return mainService.getTypeRamDao().create(typeRam);
	}	
	
	@RequestMapping(value = "/type_ram/delete",  method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteTypeRam(@RequestBody TypeRam typeRam) {
	//	mainService.getTypeHddDao().markDeleted(typeHdd.getIdTypeHdd());
		mainService.getTypeRamDao().delete(typeRam.getIdTypeRam());
	}

	
/*----type_proc----*/
	@RequestMapping(value = "/type_proc")
	public String listTypeProc(ModelMap model) {
		model.addAttribute("typeProcs", mainService.getTypeProcDao().readAll());
		model.addAttribute("producers", mainService.getProducerDao().readAll());
		return "type_proc";
	}

	@RequestMapping(value = "/type_proc/save_edited",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus saveEditedTypeProc(@RequestBody TypeProc typeProc) {
		return mainService.getTypeProcDao().update(typeProc);
	}	
	
	@RequestMapping(value = "/type_proc/create",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus createTypeProc(@RequestBody TypeProc typeProc) {
        return mainService.getTypeProcDao().create(typeProc);
	}	
	
	@RequestMapping(value = "/type_proc/delete",  method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteTypeProc(@RequestBody TypeProc typeProc) {
	//	mainService.getTypeHddDao().markDeleted(typeHdd.getIdTypeHdd());
		mainService.getTypeProcDao().delete(typeProc.getIdTypeProc());
	}
	

/*----type_mother----*/
	@RequestMapping(value = "/type_mother")
	public String listTypeMother(ModelMap model) {
		model.addAttribute("typeMothers", mainService.getTypeMotherDao().readAll());
		model.addAttribute("producers", mainService.getProducerDao().readAll());
		return "type_mother";
	}

	@RequestMapping(value = "/type_mother/save_edited",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus saveEditedTypeMother(@RequestBody TypeMother typeMother) {
		return mainService.getTypeMotherDao().update(typeMother);
	}	
	
	@RequestMapping(value = "/type_mother/create",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus createTypeMother(@RequestBody TypeMother typeMother) {
        return mainService.getTypeMotherDao().create(typeMother);
	}	
	
	@RequestMapping(value = "/type_mother/delete",  method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteTypeMother(@RequestBody TypeMother typeMother) {
	//	mainService.getTypeHddDao().markDeleted(typeHdd.getIdTypeHdd());
		mainService.getTypeMotherDao().delete(typeMother.getIdTypeMother());
	}
	  

/*----OS----*/
	@RequestMapping(value = "/os")
	public String listOs(ModelMap model) {
		model.addAttribute("oss", mainService.getOsDao().readAll());
		return "os";
	}

	@RequestMapping(value = "/os/save_edited",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus saveEditedOs(@RequestBody Os ups) {
		return mainService.getOsDao().update(ups);
	}	
	
	@RequestMapping(value = "/os/create",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus createOs(@RequestBody Os ups) {
        return mainService.getOsDao().create(ups);
	}	
	
	@RequestMapping(value = "/os/delete",  method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteOs(@RequestBody Os ups) {
	//	mainService.getTypeHddDao().markDeleted(typeHdd.getIdTypeHdd());
		mainService.getOsDao().delete(ups.getIdOs());
	}

/*----ups----*/
	@RequestMapping(value = "/ups")
	public String listUps(ModelMap model) {
		model.addAttribute("upss", mainService.getUpsDao().readAll());
		return "ups";
	}

	@RequestMapping(value = "/ups/save_edited",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus saveEditedUps(@RequestBody Ups ups) {
		return mainService.getUpsDao().update(ups);
	}	
	
	@RequestMapping(value = "/ups/create",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus createUps(@RequestBody Ups ups) {
        return mainService.getUpsDao().create(ups);
	}	
	
	@RequestMapping(value = "/ups/delete",  method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteUps(@RequestBody Ups ups) {
	//	mainService.getTypeHddDao().markDeleted(typeHdd.getIdTypeHdd());
		mainService.getUpsDao().delete(ups.getIdUps());
	}

/*----printer----*/
	@RequestMapping(value = "/printer")
	public String listPrinter(ModelMap model) {
		model.addAttribute("printers", mainService.getPrinterDao().readAll());
		return "printer";
	}

	@RequestMapping(value = "/printer/save_edited",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus saveEditedPrinter(@RequestBody Printer printer) {
		return mainService.getPrinterDao().update(printer);
	}	
	
	@RequestMapping(value = "/printer/create",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus createPrinter(@RequestBody Printer printer) {
        return mainService.getPrinterDao().create(printer);
	}	
	
	@RequestMapping(value = "/printer/delete",  method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deletePrinter(@RequestBody Printer printer) {
	//	mainService.getTypeHddDao().markDeleted(typeHdd.getIdTypeHdd());
		mainService.getPrinterDao().delete(printer.getIdPrinter());
	}
	
/*----monitor----*/
	@RequestMapping(value = "/monitor")
	public String listMonitor(ModelMap model) {
		model.addAttribute("monitors", mainService.getMonitorDao().readAll());
		model.addAttribute("producers", mainService.getProducerDao().readAll());
		return "monitor";
	}

	@RequestMapping(value = "/monitor/save_edited",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus saveEditedMonitor(@RequestBody Monitor monitor) {
		return mainService.getMonitorDao().update(monitor);
	}	
	
	@RequestMapping(value = "/monitor/create",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus createMonitor(@RequestBody Monitor monitor) {
        return mainService.getMonitorDao().create(monitor);
	}	
	
	@RequestMapping(value = "/monitor/delete",  method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteMonitor(@RequestBody Monitor monitor) {
	//	mainService.getTypeHddDao().markDeleted(typeHdd.getIdTypeHdd());
		mainService.getMonitorDao().delete(monitor.getIdMonitor());
	}
	
	
	
	/*----user----*/
	@RequestMapping(value = "/user")
	public String listUser(ModelMap model) {
		model.addAttribute("users", mainService.getUserDao().readAll());
		return "user";
	}

	@RequestMapping(value = "/user/save_edited",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus saveEditedUser(@RequestBody User user) {
		return mainService.getUserDao().update(user);
	}	
	
	@RequestMapping(value = "/user/create",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus createUser(@RequestBody User user) {
        return mainService.getUserDao().create(user);
	}	
	
	@RequestMapping(value = "/user/delete",  method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteUser(@RequestBody User user) {
	//	mainService.getTypeHddDao().markDeleted(typeHdd.getIdTypeHdd());
		mainService.getUserDao().delete(user.getIdUser());
	}
	
	/*----hdd----*/
	@RequestMapping(value = "/hdd")
	public String listHdd(ModelMap model) {
		model.addAttribute("hdds", mainService.getHddDao().readAll());
		model.addAttribute("typeHdds", mainService.getTypeHddDao().readAll());
		return "hdd";
	}

	@RequestMapping(value = "/hdd/save_edited",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus saveEditedHdd(@RequestBody Hdd hdd) {
		return mainService.getHddDao().update(hdd);
	}	
	
	@RequestMapping(value = "/hdd/create",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus createHdd(@RequestBody Hdd hdd) {
        return mainService.getHddDao().create(hdd);
	}	
	
	@RequestMapping(value = "/hdd/delete",  method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteHdd(@RequestBody Hdd hdd) {
	//	mainService.getTypeHddDao().markDeleted(typeHdd.getIdTypeHdd());
		mainService.getHddDao().delete(hdd.getIdHdd());
	}
	
	/*----ram----*/
	@RequestMapping(value = "/ram")
	public String listRam(ModelMap model) {
		model.addAttribute("rams", mainService.getRamDao().readAll());
		model.addAttribute("typeRams", mainService.getTypeRamDao().readAll());
		return "ram";
	}

	@RequestMapping(value = "/ram/save_edited",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus saveEditedRam(@RequestBody Ram ram) {
		return mainService.getRamDao().update(ram);
	}	
	
	@RequestMapping(value = "/ram/create",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus createRam(@RequestBody Ram ram) {
        return mainService.getRamDao().create(ram);
	}	
	
	@RequestMapping(value = "/ram/delete",  method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteRam(@RequestBody Ram ram) {
	//	mainService.getTypeRamDao().markDeleted(typeRam.getIdTypeRam());
		mainService.getRamDao().delete(ram.getIdRam());
	}
	
	
	/*----processor----*/
	@RequestMapping(value = "/processor")
	public String listProcessor(ModelMap model) {
		model.addAttribute("processors", mainService.getProcessorDao().readAll());
		model.addAttribute("typeProcs", mainService.getTypeProcDao().readAll());
		return "processor";
	}

	@RequestMapping(value = "/processor/save_edited",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus saveEditedProcessor(@RequestBody Processor processor) {
		return mainService.getProcessorDao().update(processor);
	}	
	
	@RequestMapping(value = "/processor/create",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus createProcessor(@RequestBody Processor processor) {
        return mainService.getProcessorDao().create(processor);
	}	
	
	@RequestMapping(value = "/processor/delete",  method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteProcessor(@RequestBody Processor processor) {
	//	mainService.getTypeProcessorDao().markDeleted(typeProcessor.getIdTypeProcessor());
		mainService.getProcessorDao().delete(processor.getIdProcessor());
	}

	/*----mother----*/
	@RequestMapping(value = "/mother")
	public String listMother(ModelMap model) {
		model.addAttribute("mothers", mainService.getMotherDao().readAll());
		model.addAttribute("typeMothers", mainService.getTypeMotherDao().readAll());
		return "mother";
	}

	@RequestMapping(value = "/mother/save_edited",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus saveEditedMother(@RequestBody Mother mother) {
		return mainService.getMotherDao().update(mother);
	}	
	
	@RequestMapping(value = "/mother/create",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus createMother(@RequestBody Mother mother) {
        return mainService.getMotherDao().create(mother);
	}	
	
	@RequestMapping(value = "/mother/delete",  method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteMother(@RequestBody Mother mother) {
	//	mainService.getTypeMotherDao().markDeleted(typeMother.getIdTypeMother());
		mainService.getMotherDao().delete(mother.getIdMother());
	}
	
	@RequestMapping(value = "/computer")
	@Transactional(readOnly=true)
	public String listComputer(ModelMap model) {
		model.addAttribute("computers", mainService.getComputerDao().readAll());
		model.addAttribute("typeComputers", mainService.getTypeComputerDao().readAll());
		model.addAttribute("freeMothers", mainService.getMotherDao().readAllFreeRows());
		model.addAttribute("freeProcessors", mainService.getProcessorDao().readAllFreeRows());
		return "computer";
	}
	
	@RequestMapping(value = "/computer/save_edited",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus saveEditedComputer(@RequestBody Computer computer) {
		return mainService.getComputerDao().update(computer);
	}	
	
	@RequestMapping(value = "/computer/create",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus createComputer(@RequestBody Computer computer) {
        return mainService.getComputerDao().create(computer);
	}	
	
	@RequestMapping(value = "/computer/delete",  method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteComputer(@RequestBody Computer computer) {
	//	mainService.getTypeComputerDao().markDeleted(typeComputer.getIdTypeComputer());
		mainService.getComputerDao().delete(computer.getIdComputer());
	}
		
}
