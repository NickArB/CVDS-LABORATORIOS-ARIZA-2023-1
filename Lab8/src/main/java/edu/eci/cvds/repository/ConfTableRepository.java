package edu.eci.cvds.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.eci.cvds.model.ConfTable;

@Repository
public interface ConfTableRepository extends JpaRepository<ConfTable, String> {

}