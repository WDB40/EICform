package eic.controller;

import java.time.LocalDate;

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
								 @RequestParam String submit,
								 Model model){
		String page;
		Session session = sessionRepo
							.findById(sessionId)
							.orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + sessionId));
		
		SessionItem sessionItem = new SessionItem(session, category, description, intensity);
		
		sessionItemRepo.save(sessionItem);
		
		model.addAttribute("sessions", sessionRepo.findAll());
		
		if(submit.equals("Add and Exit")) {
			page = "viewAllForms";
		} else {
			page = "createSessionItem";
		}
		
		return page;
	}
	
	@GetMapping("/inputSession")
	public String inputSession(Model model) {
		Session sessions = new Session();
		model.addAttribute("newSession", sessions);
		return "createSession";
	}
	
	@PostMapping("/inputSession")
	public String inputSession(@RequestParam String promptingEvent,
							   @RequestParam LocalDate eventDate,
							   Model model) {
		
		Session session = new Session(promptingEvent,eventDate);
		model.addAttribute("newSession", sessionRepo.findAll());
		sessionRepo.save(session);
		return "createSessionItem";
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
