package eic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eic.model.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> { }
