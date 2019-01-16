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

import com.elektra.oracle.conexionoracle.entity.Agenda;
import com.elektra.oracle.conexionoracle.repository.AgendaRepository;

import com.elektra.oracle.conexionoracle.services.AgendaServices;

@Service("agendaServiceImpl")
public class AgendaServiceImpl implements AgendaServices {
	private static final Log LOG = LogFactory.getLog(AgendaServiceImpl.class);
	
	/*@Autowired
    DataSource dataSource;
	*/
	@PersistenceContext
    private EntityManager entityManager;
	
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
	public List<Agenda> listTodosContacts() {
		List<Agenda> det = new ArrayList<Agenda>();
		// TODO Auto-generated method stub
		try {
			
			LOG.info("El valor del stored");
			 //det = agendaRepository.detAgendaProcedures(new Long(1));
			
			StoredProcedureQuery query = entityManager
				    .createStoredProcedureQuery("ARNOL.PAAGENDA.GETAGENDA")
				    .registerStoredProcedureParameter(1, Long.class,
				         ParameterMode.IN)
				    .registerStoredProcedureParameter(2, Class.class,
				         ParameterMode.REF_CURSOR)
				    .setParameter(1, 1L);
				 
				query.execute();
				
				
				List<Object[]> postComments = query.getResultList();
				
				Object[] postAndComment = postComments.get(0);
				LOG.info("El valor del stored"+ postAndComment[1].toString());
				//Agenda post = (Agenda) postAndComment[0];
				
			//det.add(post);
			LOG.info("det =" +postAndComment);			
			
			//getListAgenda
		}catch ( HibernateException e) {
			// TODO: handle exception
			LOG.info("error =" +e.getMessage().toString());
		}
		
		return det;
	}
	
	

}
