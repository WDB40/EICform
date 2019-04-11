package eic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eic.model.Sessionitems;

@Repository
public interface SessionitemsRepository extends JpaRepository<Sessionitems, Long> { }
