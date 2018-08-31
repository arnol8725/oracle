package com.elektra.oracle.conexionoracle;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.elektra.oracle.conexionoracle.entity.Agenda;
import com.elektra.oracle.conexionoracle.repository.AgendaRepository;
import com.elektra.oracle.conexionoracle.service.impl.AgendaServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConexionoracleApplicationTests {
	private static final Log LOG = LogFactory.getLog(ConexionoracleApplicationTests.class);
	
	@Autowired
    @Qualifier("agendaServiceImpl")
	private AgendaServiceImpl agendaServiceImpl;

	@Test
	public void contextLoads() {
		
		try {
			LOG.info("contextLoads" );
			
			Agenda a= new Agenda();
			a.nombre="Elektra";
			a.apellidoPat="Elektra";
			a.apellidoMat="Elektra";
			a.celular="Elektra";
			a.email="Elektra";
			a.telefono="Elektra";
			LOG.info("Antes de guardar" );
			
			//agendaServiceImpl.saveContacts(a);
			
		List<Agenda> det=agendaServiceImpl.listAllContacts();
		LOG.info("Size" );
		LOG.info(det.size() );
		LOG.info(det.toString() );
		}catch(Exception e) {
			String msg="" +e.getMessage();
		}
	}
	
	
	
	

}
