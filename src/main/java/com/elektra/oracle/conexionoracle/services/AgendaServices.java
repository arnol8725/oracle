package com.elektra.oracle.conexionoracle.services;

import java.util.List;

import com.elektra.oracle.conexionoracle.entity.Agenda;
import com.elektra.oracle.conexionoracle.entity.Respuesta;



public interface AgendaServices {
	
	public abstract List<Agenda> listAllContacts();
	
	public abstract Respuesta listTodosContacts();
	
	public abstract void saveContacts(Agenda a);

}
