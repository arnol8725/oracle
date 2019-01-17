package com.elektra.oracle.conexionoracle.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.validator.internal.util.privilegedactions.GetResolvedMemberMethods;
import org.springframework.stereotype.Component;

import com.elektra.oracle.conexionoracle.entity.Agenda;
import com.elektra.oracle.conexionoracle.service.impl.AgendaServiceImpl;

@Component 
public class Consultas {
	private static final Log LOG = LogFactory.getLog(AgendaServiceImpl.class);
	@PersistenceContext
    private EntityManager entityManager;
	
	
	
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
				
				
				List<Agenda> postComments = query.getResultList();
				LOG.info("El valor del stored" + postComments.size());
				det =postComments;
				
			/*Asi podriamos obtener los datos uno a uno */	
			/*	Object[] postAndComment = postComments.get(0);
				LOG.info("El valor del stored"+ postAndComment[1].toString());*/
				//Agenda post = (Agenda) postAndComment[0];
				
			//det.add(post);
			//LOG.info("det =" +det.size());			
			
			//getListAgenda
		}catch ( HibernateException e) {
			// TODO: handle exception
			LOG.info("error =" +e.getMessage().toString());
		}
		
		return det;
	}
	
	public List<Agenda> listTodosContactsFuncion() {
		List<Agenda> det = new ArrayList<Agenda>();
		// TODO Auto-generated method stub
		try {
			
			LOG.info("El valor del stored");
			 //det = agendaRepository.detAgendaProcedures(new Long(1));
			
			det = entityManager
					.createNamedQuery("fn_post_and_comments",Agenda.class)				  
					.setParameter(1, 0)
				    .getResultList();
			
			/*List<Object[]> dets=  (List<Object[]>) entityManager
				    .createNativeQuery(
				        "SELECT ARNOL.PAAGENDA.FN_GETAGENDA(:postId) FROM DUAL"
				    )
				    .setParameter("postId", 1L)
				    .getResultList();
			
			LOG.info("El valor del stored" +dets.size());*/
			
			
				//query.execute();
				
			
			
		}catch ( HibernateException e) {
			// TODO: handle exception
			LOG.info("error =" +e.getMessage().toString());
		}
		
		return det;
	}
	
	
}
