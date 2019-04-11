package eic.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDateTime;

public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sessionId;
//	private Timestamp creationtime;
	private String promptingEvent;
	private LocalDateTime eventDate;
	
	public Session() {
		this.eventDate = LocalDateTime.now();
	}
	
	Session(String pe) {
		this.promptingEvent = pe;
	}

	Session(String pe, LocalDateTime ed) {
		this.promptingEvent = pe;
		this.eventDate = ed;
	}

	// getters and setters
	public long getSessionId() {
		return sessionId;
	}

	public String getPromptingEvent() {
		return promptingEvent;
	}

	public LocalDateTime getEventDate() {
		return eventDate;
	}

	public void setPromptingEvent(String promptingEvent) {
		this.promptingEvent = promptingEvent;
	}
	
	public void setEventDate(LocalDateTime ed) {
		this.eventDate = ed;
	}

	// helper methods
	@Override
	public String toString() {
		return "Session [promptingEvent=" + promptingEvent + ", eventDate=" + eventDate + "]";
	}
	
}
