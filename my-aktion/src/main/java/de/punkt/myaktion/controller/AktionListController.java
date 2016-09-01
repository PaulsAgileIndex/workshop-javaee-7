package de.punkt.myaktion.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.punkt.myaktion.model.Aktion;

@SessionScoped
@Named
public class AktionListController implements Serializable {

	private static final long serialVersionUID = 1452550355094408745L;
	
	public String doAddAktion() {
		System.out.println("Add Aktion");
		return Pages.AKTION_EDIT;
	}
	
	public String doEditAktion(Aktion aktion) {
		System.out.println("Edit Aktion " +aktion);
		return Pages.AKTION_EDIT;
	}

	public String doEditSpendeForm(Aktion aktion) {
		System.out.println("Edit Spende Form " +aktion);
		return Pages.SPENDE_FORM_EDIT;
	}
	
	public String doListSpende(Aktion aktion) {
		System.out.println("List Spende " +aktion);
		return Pages.SPENDE_LIST;
	}
	
	public void doDeleteAktion(Aktion aktion) {
		System.out.println("Aktion löschen noch nicht implementiert " +aktion);
	}
}
