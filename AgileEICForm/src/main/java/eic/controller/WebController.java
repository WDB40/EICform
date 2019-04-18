package eic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String addSessionItem(@RequestParam Long sessionId, 
								 @RequestParam Category category,
								 @RequestParam String description,
								 @RequestParam Integer intensity,
								 Model model){
		
		Session session = sessionRepo
							.findById(sessionId)
							.orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + sessionId));
		
		SessionItem sessionItem = new SessionItem(session, category, description, intensity);
		
		sessionItemRepo.save(sessionItem);
		
		
		return "viewAllForms";
	}
	
	@GetMapping("/inputSession")
	public String inputSession(Model model) {
		Session s = new Session();
		model.addAttribute("newSession", s);
		return "input";
		
	}
	
	@GetMapping("/viewSessions")
	public String viewSessionsForm(Model model) {
		
		model.addAttribute("sessions", sessionRepo.findAll());
		
		return "viewAllForms";
	}
	
	@GetMapping("/viewSession")
	public String viewSession(@RequestParam Long sessionId,Model model) {
		
		Session session = sessionRepo
				.findById(sessionId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + sessionId));
		
		model.addAttribute("sessionItems", sessionItemRepo.findBySession(session));
		model.addAttribute("sessions", sessionRepo.findAll());
		
		return "viewAllForms";
	}
	
}
