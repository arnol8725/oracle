package com.elektra.oracle.conexionoracle.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.elektra.oracle.conexionoracle.dao.Consultas;
import com.elektra.oracle.conexionoracle.entity.Agenda;
import com.elektra.oracle.conexionoracle.entity.Respuesta;
import com.elektra.oracle.conexionoracle.repository.AgendaRepository;

import com.elektra.oracle.conexionoracle.services.AgendaServices;

@Service("agendaServiceImpl")
public class AgendaServiceImpl implements AgendaServices {
	private static final Log LOG = LogFactory.getLog(AgendaServiceImpl.class);
	
	/*@Autowired
    DataSource dataSource;
	*/
	/*@PersistenceContext
    private EntityManager entityManager;*/
	
	@Autowired
	private Consultas consulta;
	
	@Autowired
    @Qualifier("agendaReposritory")
	private AgendaRepository agendaRepository;
	
	@Override
	public List<Agenda> listAllContacts() {
		// TODO Auto-generated method stub
		agendaRepository.findAll();
		return (List<Agenda>) agendaRepository.findAll();
	}

	@Override
	public void saveContacts(Agenda a) {
		// TODO Auto-generated method stub
		
		agendaRepository.save(a);
	}

	@Override
	public Respuesta listTodosContacts() {
		Respuesta salida = new Respuesta();
		List<Agenda> det = new ArrayList<Agenda>();
		salida.detAgenda = new ArrayList<Agenda>();
		// TODO Auto-generated method stub
		try {
			/*det=  consulta.listTodosContactsFuncion();
			LOG.info("funcion =" +det.size());*/
			salida.detAgenda = consulta.listTodosContacts();
		}catch ( HibernateException e) {
			// TODO: handle exception
			LOG.info("error =" +e.getMessage().toString());
			salida.error=true;
			salida.mensaje="Error al consultar informacion";
		}
		
		return salida;
	}
	
	

}
