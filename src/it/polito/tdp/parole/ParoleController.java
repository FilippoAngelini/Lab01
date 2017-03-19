package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;
import it.polito.tdp.parole.model.ParoleConArrayList;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco ;
	ParoleConArrayList elencoArray;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtPrestazioni"
    private TextArea txtPrestazioni; // Value injected by FXMLLoader
    
    String prestazioni = "";

    @FXML
    void doInsert(ActionEvent event) {
    	
    	long inizio = System.nanoTime();

    	elenco.addParola( txtParola.getText() );
    	
    	long tempoLinkedList = (System.nanoTime()) - inizio;
    	prestazioni += tempoLinkedList;
    	
    	String result = "" ;
    	
    	for(String p: elenco.getElenco())
    		result += p + "\n" ;
    	
    	txtResult.setText(result);
    	
    	inizio = System.nanoTime();
    	
    	elencoArray.addParola( txtParola.getText() );
    	
    	long tempoArrayList = (System.nanoTime()) - inizio;
    	//prestazioni += tempoArrayList;
    	prestazioni += "                        " + tempoArrayList /*(System.nanoTime() - inizio)*/;
    	
    	if(tempoLinkedList < tempoArrayList)
    		prestazioni += "           " + "Meglio LinkedList" +"\n";
    	else
    		prestazioni += "           " + "Meglio ArrayList" + "\n";
    	
    	txtPrestazioni.setText(prestazioni);
    	
    	txtParola.clear();
    	
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	
    	long inizio = System.nanoTime();
    	
    	elenco.reset() ;
    	
    	long tempoLinkedList = (System.nanoTime()) - inizio;
    	prestazioni += tempoLinkedList;
    	
    	inizio = System.nanoTime();
    	
    	elencoArray.reset();
    	
    	long tempoArrayList = (System.nanoTime()) - inizio;
    	//prestazioni += tempoArrayList;
    	prestazioni += "                        " + tempoArrayList /*(System.nanoTime() - inizio)*/;
    	
    	if(tempoLinkedList < tempoArrayList)
    		prestazioni += "           " + "Meglio LinkedList" +"\n";
    	else
    		prestazioni += "           " + "Meglio ArrayList" + "\n";
    	
    	txtPrestazioni.setText(prestazioni);
    	
    	txtResult.clear() ;

    }
    
    @FXML
    String getParolaSelezionata() {
    	return txtResult.getSelectedText();
    }
    
    @FXML
    void doDelete(ActionEvent event) {
    	
    	long inizio = System.nanoTime();
    	
    	elenco.cancellaParola(this.getParolaSelezionata());
    	
    	long tempoLinkedList = (System.nanoTime()) - inizio;
    	prestazioni += tempoLinkedList;
    	
    	inizio = System.nanoTime();
    	
    	elencoArray.cancellaParola(this.getParolaSelezionata());
    	
    	long tempoArrayList = (System.nanoTime()) - inizio;
    	//prestazioni += tempoArrayList;
    	prestazioni += "                        " + tempoArrayList /*(System.nanoTime() - inizio)*/;
    	
    	if(tempoLinkedList < tempoArrayList)
    		prestazioni += "           " + "Meglio LinkedList" +"\n";
    	else
    		prestazioni += "           " + "Meglio ArrayList" + "\n";
    	
    	txtPrestazioni.setText(prestazioni);
    	
    	String result = "" ;
    	
    	for(String p: elenco.getElenco())
    		result += p + "\n" ;
    	
    	txtResult.setText(result);
    	
    	txtParola.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";

        elenco = new Parole() ;
        elencoArray = new ParoleConArrayList();
        
    }
}
