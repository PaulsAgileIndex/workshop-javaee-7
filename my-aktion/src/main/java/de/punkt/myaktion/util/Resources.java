package de.punkt.myaktion.util;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import de.punkt.myaktion.util.Events.Added;
import de.punkt.myaktion.util.Events.MyRequest;

public class Resources {

	
	@Produces
	public Logger produceLog(InjectionPoint ip){
		return Logger.getLogger(ip.getMember().getDeclaringClass().getName());
	}
	
//	@Produces
//	public Logger produceLog(){
//		return Logger.getLogger("MyLogger");
//	}
	
	@Produces
	@RequestScoped
	public FacesContext produceFacesContext(){
		return FacesContext.getCurrentInstance();
	}

	@Produces
	@RequestScoped
	@MyRequest
	public HttpServletRequest produceRequest(){
		return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
}
