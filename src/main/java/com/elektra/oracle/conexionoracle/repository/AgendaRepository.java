package com.elektra.oracle.conexionoracle.repository;


//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.elektra.oracle.conexionoracle.entity.Agenda;

@Repository("agendaReposritory")
public interface AgendaRepository extends CrudRepository<Agenda, Long> {

}





