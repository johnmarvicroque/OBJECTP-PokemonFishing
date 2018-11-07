package controller;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;
import model.Player;


/*
 * Controller for CharcterCreation.FXML
 */
public class CharacterCreateController {

	@FXML private TextField name;
	@FXML private Button accept;
	@FXML private Label eMsg;
	@FXML private ImageView dBox;
	
	private Driver d;
	
	public void setDriver(Driver d) {
		this.d = d;
	}

	


	@FXML
	public void addName(ActionEvent event) throws IOException {
		if((name.getText() == null || name.getText().trim().isEmpty()))
		{
			dBox.setVisible(true);
			eMsg.setVisible(true);
		}
		else {
			Player p = new Player(name.getText());
			System.out.println(p==null);

			FXMLLoader loader = new FXMLLoader();
			
	    	loader.setLocation(Driver.class.getResource("/view/MapSelect.fxml"));
	    	AnchorPane MapSelect;
	    	MapSelect = (AnchorPane) loader.load();
    	
			Scene scene1 = new Scene(MapSelect,510.0,410.0);
			
			MapSelectController msc = loader.getController();
			msc.setPlayer(p);
			msc.setDriver(d);
			
			
			d.getWindow().setScene(scene1);
			d.getWindow().show();
			
			}
	}
	@FXML
	public void initialize () {
		dBox.setVisible(false);
		eMsg.setVisible(false);
	}
	

	
}
