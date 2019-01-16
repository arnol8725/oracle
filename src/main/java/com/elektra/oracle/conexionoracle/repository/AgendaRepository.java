package com.elektra.oracle.conexionoracle.repository;


import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.elektra.oracle.conexionoracle.entity.Agenda;

@Repository("agendaReposritory")
public interface AgendaRepository extends CrudRepository<Agenda, Long> {
	
	@Procedure(name = "detAgendaProcedure")
    List<Agenda> detAgendaProcedures(@Param("idSS") Long idSS);

}





