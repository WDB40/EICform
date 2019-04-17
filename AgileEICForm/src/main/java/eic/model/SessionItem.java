package eic.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SESSIONITEMS")
public class SessionItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ITEM_ID")
	private long itemId;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="SESSION_ID")
	private Session session;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ITEM_TYPE")
	private Category category;
	
	@Column(name="ITEM_DESC")
	private String itemDescription;
	
	@Column(name="INTENSITY_LEVEL")
	private int intensityLevel;

	public SessionItem(Session session, Category category, String itemDescription, int intensityLevel) {
		super();
		this.session = session;
		this.category = category;
		this.itemDescription = itemDescription;
		this.intensityLevel = intensityLevel;
	}

	// getters and setters
	public long getItemId() {
		return itemId;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public int getIntensityLevel() {
		return intensityLevel;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void setIntensityLevel(int intensityLevel) {
		this.intensityLevel = intensityLevel;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Sessionitems [itemId=" + itemId + ", session=" + session + ", category=" + category
				+ ", itemDescription=" + itemDescription + ", intensityLevel=" + intensityLevel + "]";
	}
	
}
