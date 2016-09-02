package de.punkt.myaktion.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.punkt.myaktion.data.AktionListProducer;
import de.punkt.myaktion.model.Aktion;

@SessionScoped
@Named
public class AktionEditController implements Serializable {

	private static final long serialVersionUID = 9049238986592472016L;
	
	@Inject
	private AktionListProducer aktionListProducer;
	
	public enum Mode{
		EDIT, ADD
	};

	private Mode mode;
	private Aktion aktion;	
	
	private Mode getMode(){
		return mode;
	}
	
	public Aktion getAktion(){
		return aktion;
	}
	
	public void setAktionToEdit(Mode mode, Aktion aktion){
		this.mode = mode;
		this.aktion = aktion;
	}
	
	public void setAktionToEdit(Mode mode){		
		setAktionToEdit(mode, new Aktion());
	}
	
	public String doSave(){
		if(getMode() == Mode.ADD){
			aktionListProducer.getAktionen().add(aktion);
		}
		return Pages.AKTION_LIST;
	}
	
	public String doCancel(){
		return Pages.AKTION_LIST;
	}
	
	public String getTitle(){
		return getMode() == Mode.EDIT ? "Aktion editieren" : "Neue Aktion anlegen";
	}
}









































