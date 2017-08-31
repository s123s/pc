package pc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pc.service.MainService;

@Controller
public class MainController {

	@RequestMapping(value = "/index",  method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	@RequestMapping(value = "/",  method = RequestMethod.GET)
	public String index1() {
		return "index";
	}
}