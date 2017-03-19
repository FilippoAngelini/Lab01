package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	
	private List<String> elenco;
		
	public Parole() {
		//TODO
		elenco = new LinkedList <String>();
	}
	
	public void addParola(String p) {
		//TODO
		int i = 0;
		
		for(i=0; i<10000;i++)
			elenco.add("" + p + Integer.toString(i));
		//elenco.add(p);
	}
	
	public List<String> getElenco() {
		//TODO
		Collections.sort(elenco, new ComparatoreDiParoleInOrdineAlfabetico());
		return elenco;
	}
	
	public void reset() {
		elenco.clear();
	}
	
	public void cancellaParola(String p){
		/*int i =0;
		for(String s : elenco){
			if(s.compareTo(p)==0)
				elenco.remove(i);
			i++;
		}*/
		elenco.remove(p);
		
	}

}
