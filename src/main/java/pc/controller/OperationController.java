package pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pc.model.TypeHdd;
import pc.service.MainService;
import pc.service.OperaionStatus;

@Controller
//@RequestMapping(value = "")
public class OperationController {


	@Autowired(required = true)
	//@Qualifier(value = "mainService")	
	private MainService mainService;

	@RequestMapping(value = "wp_table")
	public String listWp(ModelMap model) {
		/*User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();*/

		model.addAttribute("wps", mainService.getWpDao().readAll());
		return "wp_table";
	}

	@RequestMapping(value = "/type_hdd")
	public String listTypeHdd(ModelMap model) {
		model.addAttribute("typeHdds", mainService.getTypeHddDao().readAll());
		return "type_hdd";
	}
	
	
	@RequestMapping(value = "/type_hdd/edit/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		//model.addAttribute("book", bookService.read(id));
		return "type_hdd/edit";
	}

	@RequestMapping(value = "/type_hdd/save_edited",  method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public OperaionStatus saveEditedBook(@RequestBody TypeHdd typeHdd) {
		return mainService.getTypeHddDao().update(typeHdd);
	}	
	
	
	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}

	  
/*	@RequestMapping(value = "/save_edited",  method = RequestMethod.POST)
	public String saveEditedBook(@ModelAttribute("book") Book book) {
		System.out.println("saveEditedBook "+book.getName());
		bookService.update(book);

		return "redirect:/books";
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