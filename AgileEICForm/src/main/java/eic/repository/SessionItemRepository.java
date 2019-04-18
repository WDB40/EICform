package eic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eic.model.Session;
import eic.model.SessionItem;

@Repository
public interface SessionItemRepository extends JpaRepository<SessionItem, Long> { 
	
	public List<SessionItem> findBySession(Session session);
}
