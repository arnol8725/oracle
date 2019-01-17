package com.elektra.oracle.conexionoracle.entity;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.elektra.oracle.conexionoracle.service.impl.AgendaServiceImpl;
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class MyJobTwo extends QuartzJobBean{
	private static final Log LOG = LogFactory.getLog(AgendaServiceImpl.class);
	
	public static final String COUNT = "count";
	   Respuesta resp = new Respuesta();	
	@Autowired
    @Qualifier("agendaServiceImpl")
	private AgendaServiceImpl agendaServiceImpl;
	
	private String name;
        protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
    	   JobDataMap dataMap = ctx.getJobDetail().getJobDataMap();
    	   int cnt = dataMap.getInt(COUNT);
	   JobKey jobKey = ctx.getJobDetail().getKey();
	   System.out.println(jobKey+": "+name+": "+ cnt);
	   cnt++;
	   LOG.info("det " + det().detAgenda.size());
	   dataMap.put(COUNT,cnt );
        }
	public void setName(String name) {
		this.name = name;
	}
	
	public Respuesta det() {
		Respuesta resp = new Respuesta();
		 LOG.info("antes agendaServiceImpl.listTodosContacts()");
			resp.detAgenda = agendaServiceImpl.listAllContacts();
			LOG.info("paso agendaServiceImpl.listTodosContacts()");
			return resp;
	}
}
