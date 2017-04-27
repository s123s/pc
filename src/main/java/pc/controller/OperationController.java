package pc.controller;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonView;

import pc.jackson.View;
import pc.model.TypeHdd;
import pc.model.TypeRam;
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


	@RequestMapping(value = "wp_table")
	public String listWp(ModelMap model) {
		/*User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();*/

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
	public OperationStatus saveEditedHddType(@RequestBody TypeHdd typeHdd) {
		return mainService.getTypeHddDao().update(typeHdd);
	}	
	
	@RequestMapping(value = "/type_hdd/create",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus createHddType(@RequestBody TypeHdd typeHdd) {
        return mainService.getTypeHddDao().create(typeHdd);
	}	
	
	@RequestMapping(value = "/type_hdd/delete",  method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	//@JsonView(View.REST.class)
	public void deleteTypeHdd(@RequestBody TypeHdd typeHdd) {
	//	mainService.getTypeHddDao().markDeleted(typeHdd.getIdTypeHdd());

	//	return "redirect:/books";
				//new OperationStatus(false);
		mainService.getTypeHddDao().delete(typeHdd.getIdTypeHdd());
	}
	
	

	@RequestMapping(value = "/type_ram")
	public String listTypeRam(ModelMap model) {
		model.addAttribute("typeRams", mainService.getTypeRamDao().readAll());
		model.addAttribute("typeRamSpecs", mainService.getTypeRamSpecDao().readAll());
		return "type_ram";
	}
	

	@RequestMapping(value = "/type_ram/save_edited",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus saveEditedRamType(@RequestBody TypeRam typeRam) {
		return mainService.getTypeRamDao().update(typeRam);
	}	
	
	@RequestMapping(value = "/type_ram/create",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@JsonView(View.REST.class)
	public OperationStatus createRamType(@RequestBody TypeRam typeRam) {
        return mainService.getTypeRamDao().create(typeRam);
	}	
	
	@RequestMapping(value = "/type_ram/delete",  method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteTypeRam(@RequestBody TypeRam typeRam) {
	//	mainService.getTypeHddDao().markDeleted(typeHdd.getIdTypeHdd());

	//	return "redirect:/books";
				//new OperationStatus(false);
		mainService.getTypeRamDao().delete(typeRam.getIdTypeRam());
	}
	

	  
/*	@RequestMapping(value = "/save_edited",  method = RequestMethod.POST)
	public String saveEditedBook(@ModelAttribute("book") Book book) {
		System.out.println("saveEditedBook "+book.getName());
		bookService.update(book);

		return "redirect:/books";
	}
	}*/
/*
	@RequestMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") int id, Model model) {
		bookService.markDeleted(id);

		return "redirect:/books";
	}
	
	
	
	@Autowired(required = true)
	@Qualifier(value = "bookService")
	public void setBookService(BookServiceImpl bookService) {
		this.bookService = bookService;
	}
*/
}
