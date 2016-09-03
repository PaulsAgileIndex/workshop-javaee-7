package de.punkt.myaktion.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.punkt.myaktion.controller.AktionEditController.Mode;
import de.punkt.myaktion.model.Aktion;

@SessionScoped
@Named
public class AktionListController implements Serializable {

	private static final long serialVersionUID = 1452550355094408745L;
	
	@Inject
	private AktionEditController aktionEditController;
	
	@Inject
	private SpendeListController spendeListController;
	
	@Inject 
	SpendeFormEditController spendeFromEditController;
	
	public String doAddAktion() {
		System.out.println("Add Aktion");
		aktionEditController.setAktionToEdit(Mode.ADD);
		return Pages.AKTION_EDIT;
	}
	
	public String doEditAktion(Aktion aktion) {
		System.out.println("Edit Aktion " +aktion);
		aktionEditController.setAktionToEdit(Mode.EDIT, aktion);
		return Pages.AKTION_EDIT;
	}

	public String doEditSpendeForm(Aktion aktion) {
		System.out.println("Edit Spende Form " +aktion);
		spendeFromEditController.setAktion(aktion);
		return Pages.SPENDE_FORM_EDIT;
	}
	
	public String doListSpende(Aktion aktion) {
		System.out.println("List Spende " +aktion);
		spendeListController.setAktion(aktion);
		return Pages.SPENDE_LIST;
	}
	
	public void doDeleteAktion(Aktion aktion) {
		System.out.println("Aktion löschen noch nicht implementiert " +aktion);
	}
}
