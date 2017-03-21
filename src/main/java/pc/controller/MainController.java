package pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pc.service.TypeHddService;
import pc.service.WpService;

@Controller
public class MainController {
	private WpService wpService;
	private TypeHddService typeHddService;

	@RequestMapping(value = "wp_table")
	public String listWp(ModelMap model) {
		/*User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();*/

		model.addAttribute("wps", wpService.readAll());
		return "wp_table";
	}

	@RequestMapping(value = "type_hdd")
	public String listTypeHdd(ModelMap model) {
		model.addAttribute("typeHddService", typeHddService.readAll());
		return "type_hdd";
	}

@Autowired(required = true)
public void setWpSummViewService(WpService wpService) {
	this.wpService = wpService;
}


}