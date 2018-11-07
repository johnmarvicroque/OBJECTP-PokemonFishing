package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;

/*
 * Controller Package 
 * Title Controller-Methods for TitleScreen.fxml
 */

public class TitleController {
	@FXML
	public Button startbtn;//Start button fx:id
	
	private Driver d;
	
	public void setDriver(Driver d) {
		this.d = d;
	}
	
/*
 *  clickstart()
 * transitions from title screen to character creation
 */
	@FXML
	public void clickstart(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		
    	loader.setLocation(Driver.class.getResource("/view/CharacterCreation.fxml"));
    	AnchorPane CharacterCreate;
    	CharacterCreate = (AnchorPane) loader.load();
		
    	CharacterCreateController  ccController = loader.getController(); 
        ccController.setDriver(d);
    	
		Scene scene1 = new Scene(CharacterCreate,510.0,410.0);
	
		d.getWindow().setScene(scene1);
		
		d.getWindow().show();
		
	}
	
}
