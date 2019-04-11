package eic.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Sessionitems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long itemId;
	private long sessionId;
	private String itemType;
	private String itemDescription;
	private int intensityLevel;

	public Sessionitems(long sessionId, String itemType, String itemDescription, int intensityLevel) {
		super();
		this.sessionId = sessionId;
		this.itemType = itemType;
		this.itemDescription = itemDescription;
		this.intensityLevel = intensityLevel;
	}

	// getters and setters
	public long getItemId() {
		return itemId;
	}

	public long getSessionId() {
		return sessionId;
	}

	public String getItemType() {
		return itemType;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public int getIntensityLevel() {
		return intensityLevel;
	}

	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void setIntensityLevel(int intensityLevel) {
		this.intensityLevel = intensityLevel;
	}

	@Override
	public String toString() {
		return "Sessionitems [itemId=" + itemId + ", sessionId=" + sessionId + ", itemType=" + itemType
				+ ", itemDescription=" + itemDescription + ", intensityLevel=" + intensityLevel + "]";
	}
	
}
