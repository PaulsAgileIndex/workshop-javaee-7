package de.punkt.myaktion.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.punkt.myaktion.model.Aktion;
import de.punkt.myaktion.model.Spende.Status;

@SessionScoped
@Named
public class SpendeListController implements Serializable {

	private static final long serialVersionUID = -7284953161342744785L;
	private Aktion aktion;
	
	public Aktion getAktion(){
		return aktion;
	}
	
	public void setAktion(Aktion aktion){
		this.aktion = aktion;
	}
	
	public String doOk(){
		return Pages.AKTION_LIST;
	}
	
	public String convertStatus(Status status){
		switch (status){
		case UEBERWIESEN:
			return "überwiesen";
		case In_BEARBEITUNG:
			return "in Bearbeitung";
		default:
			return "";
		}
	}

}
