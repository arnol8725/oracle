package com.elektra.oracle.conexionoracle.services;

import java.util.List;

import com.elektra.oracle.conexionoracle.entity.Agenda;



public interface AgendaServices {
	
	public abstract List<Agenda> listAllContacts();
	
	public abstract List<Agenda> listTodosContacts();
	
	public abstract void saveContacts(Agenda a);

}
