package com.elektra.oracle.conexionoracle.controler;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.elektra.oracle.conexionoracle.entity.Agenda;
import com.elektra.oracle.conexionoracle.service.impl.AgendaServiceImpl;



@CrossOrigin()
@org.springframework.web.bind.annotation.RestController
@RequestMapping(value="/rest",method={RequestMethod.OPTIONS,RequestMethod.GET,RequestMethod.POST} )
public class RestController {
	private static final Log LOG = LogFactory.getLog(RestController.class);
	@Autowired
    @Qualifier("agendaServiceImpl")
	private AgendaServiceImpl agendaServiceImpl;
	
	@CrossOrigin
	@GetMapping("/contactosAgenda")	
	public ResponseEntity<List<Agenda>> checkRest(){
		List<Agenda> lista = agendaServiceImpl.listAllContacts();
		return new ResponseEntity<List<Agenda>>(lista,HttpStatus.OK);
	}
	
	 @RequestMapping(value = "/addAgenda", method = {RequestMethod.POST,RequestMethod.OPTIONS})
	    public ResponseEntity<List<Agenda>> createContacto(@RequestBody Agenda agenda,    UriComponentsBuilder ucBuilder) {
	     
		 LOG.info("method addContact" + " -- params "+ agenda.toString());
		 try {
			 agendaServiceImpl.saveContacts(agenda);
		 }catch(Exception e) {
			 
			 String mensaje = "Error al insertar";
			 LOG.info("method addContact" + " error "+ e.getMessage());
		 }
		 	
	      	 
	        List<Agenda> lista = agendaServiceImpl.listAllContacts();
			return new ResponseEntity<List<Agenda>>(lista,HttpStatus.OK);
	    }

}
