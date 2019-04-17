package eic.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import eic.model.Category;
import eic.model.Session;
import eic.model.SessionItem;
import eic.repository.SessionItemRepository;
import eic.repository.SessionRepository;

@Controller
public class WebController {
	
	@Autowired
	SessionItemRepository sessionItemRepo;
	
	@Autowired
	SessionRepository sessionRepo;
	
	@GetMapping("/addSessionItem")
	public String addSessionItemForm(Model model) {
		
		model.addAttribute("sessions", sessionRepo.findAll());
		
		return "createSessionItem";
	}
	
	@PostMapping("/addSessionItem")
	public String addSessionItem(Model model){
		
		Session session = new Session("Other Thing", LocalDate.now());
		sessionRepo.save(session);
		
		/*
		Session session = sessionRepo
							.findById(1l)
							.orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + 1));
		
		SessionItem sessionItem = new SessionItem(session, Category.THOUGHTS, "A thought", 2);
		
		sessionItemRepo.save(sessionItem);
		
		*/
		return "viewAllForms";
	}
	
	@GetMapping("/inputSession")
	public String inputSession(Model model) {
		Session s = new Session();
		model.addAttribute("newSession", s);
		return "input";
		
	}
	
}
