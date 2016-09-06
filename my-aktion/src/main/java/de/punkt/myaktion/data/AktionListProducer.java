package de.punkt.myaktion.data;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import de.punkt.myaktion.model.Aktion;
import de.punkt.myaktion.util.Events.Added;
import de.punkt.myaktion.util.Events.Deleted;
import de.punkt.myaktion.services.AktionService;

@SessionScoped
@Named
public class AktionListProducer implements Serializable {

	private static final long serialVersionUID = 5223838882539790728L;	
	private List<Aktion> aktionen;
	
	@Inject
	private AktionService aktionService;
	
	@PostConstruct
	public void init(){
		aktionen = aktionService.getAllAktionen();
	}
	
//	public AktionListProducer() {
//		aktionen = createMockAktionen();
//	}
	
	public void onAktionAdded(@Observes @Added Aktion aktion){
		getAktionen().add(aktion);
	}
	
	public void onAktionDeleted(@Observes @Deleted Aktion aktion){
		getAktionen().remove(aktion);
	}
	
	@Produces	
	public List<Aktion> getAktionen() {
		return aktionen;
	}
	
//	public List<Aktion> createMockAktionen() {
//		
//		//------- Spende 1
//		Spende spende1 = new Spende();
//		spende1.setSpenderName("Heinz SChmidt");
//		spende1.setBetrag(20d);
//		spende1.setQuittung(true);
//		spende1.setStatus(Status.UEBERWIESEN);
//		spende1.setKonto(new Konto(spende1.getSpenderName(), "XXX Bank", "123456", "87654321"));
//		
//		//------- Spende 1
//		Spende spende2 = new Spende();
//		spende2.setSpenderName("Karl Meier");
//		spende2.setBetrag(30d);
//		spende2.setQuittung(false);
//		spende2.setStatus(Status.In_BEARBEITUNG);
//		spende2.setKonto(new Konto(spende2.getSpenderName(), "YYY Bank", "654321", "86427531"));
//		
//		List<Spende> spenden = new LinkedList<>();
//		spenden.add(spende1);
//		spenden.add(spende2);
//		
//		
//		//------- Aktion 1
//		Aktion aktion1 = new Aktion();
//		aktion1.setName("Trikots for A-Jugend");
//		aktion1.setSpendenZiel(1000d);
//		aktion1.setBisherGespendet(258d);
//		aktion1.setSpendenBetrag(20d);
//		aktion1.setId(1L);
//		aktion1.setKonto(new Konto("Max Mustermann", "ABC Bank", "100200300", "12345678"));		
//		aktion1.setSpenden(spenden);
//		
//		//------- Aktion 2
//		Aktion aktion2 = new Aktion();
//		aktion2.setName("Rollstuhl für Maria");
//		aktion2.setSpendenZiel(2500d);
//		aktion2.setBisherGespendet(742d);
//		aktion2.setSpendenBetrag(25d);
//		aktion2.setId(2L);
//		aktion2.setKonto(aktion1.getKonto());		
//		aktion2.setSpenden(spenden);
//		
//		
//		List<Aktion> ret  = new LinkedList<>();
//		ret.add(aktion1);
//		ret.add(aktion2);
//		return ret;
//	}
	

}























