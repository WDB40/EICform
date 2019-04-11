package eic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eic.model.Session;

@Controller
public class WebController {
	
	@GetMapping("/addSessionItem")
	public String addSessionItem(Model model) {
		
		return "createSessionItem";
	}
	
	@GetMapping("/inputSession")
	public String inputSession(Model model) {
		Session s = new Session();
		model.addAttribute("newSession", s);
		return "input";
		
	}
	
}
