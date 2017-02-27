package pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pc.service.WpService;

@Controller
public class MainController {
	private WpService wpService;

@RequestMapping(value = "wp_table")
public String listWp(ModelMap model) {
	/*User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();*/

	model.addAttribute("wps", wpService.readAll());
	return "wp_table";
}

@Autowired(required = true)
public void setWpSummViewService(WpService wpService) {
	this.wpService = wpService;
}


}