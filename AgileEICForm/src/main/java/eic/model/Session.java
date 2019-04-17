package eic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SESSIONS")
public class Session {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SESSION_ID")
	private long sessionId;
	
//	private Timestamp creationtime;
	
	@Column(name="PROMPTING_EVENT")
	private String promptingEvent;
	
	@Column(name="EVENT_DATE")
	private LocalDate eventDate;
	
	public Session() {
		this.eventDate = LocalDate.now();
	}
	
	public Session(String pe) {
		this.promptingEvent = pe;
	}

	public Session(String pe, LocalDate ed) {
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

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setPromptingEvent(String promptingEvent) {
		this.promptingEvent = promptingEvent;
	}
	
	public void setEventDate(LocalDate ed) {
		this.eventDate = ed;
	}

	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId + ", promptingEvent=" + promptingEvent + ", eventDate=" + eventDate
				+ "]";
	}
}
