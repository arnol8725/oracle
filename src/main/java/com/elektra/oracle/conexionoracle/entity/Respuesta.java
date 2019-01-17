package com.elektra.oracle.conexionoracle.entity;

import java.io.Serializable;
import java.util.List;


public class Respuesta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean error;
	public String mensaje;
	public List<Agenda> detAgenda;
			
	public Respuesta() {
		super();
		// TODO Auto-generated constructor stub
		this.error= false;
		this.mensaje= "";
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public List<Agenda> getDetAgenda() {
		return detAgenda;
	}
	public void setDetAgenda(List<Agenda> detAgenda) {
		this.detAgenda = detAgenda;
	}
	
}
