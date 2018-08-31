package com.elektra.oracle.conexionoracle.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.elektra.oracle.conexionoracle.entity.Agenda;
import com.elektra.oracle.conexionoracle.repository.AgendaRepository;
import com.elektra.oracle.conexionoracle.services.AgendaServices;

@Service("agendaServiceImpl")
public class AgendaServiceImpl implements AgendaServices {
	private static final Log LOG = LogFactory.getLog(AgendaServiceImpl.class);
	
	
	@Autowired
    @Qualifier("agendaReposritory")
	private AgendaRepository agendaRepository;
	
	@Override
	public List<Agenda> listAllContacts() {
		// TODO Auto-generated method stub
		return (List<Agenda>) agendaRepository.findAll();
	}

	@Override
	public void saveContacts(Agenda a) {
		// TODO Auto-generated method stub
		
		agendaRepository.save(a);
	}
	
	

}
