package model;

import java.io.IOException;

import controller.TitleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Driver extends Application {
	private AnchorPane Title;
	Stage s;
	
    public static void main(String[] args) 
    {
    	
        launch(args);
        
    }
 
    public void start(Stage window) throws IOException 
    {
    	s = window;
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Driver.class.getResource("/view/TitleScreen.fxml"));
  
    	Title = (AnchorPane) loader.load();
		
		Scene scene = new Scene(Title,510.0,410.0);
		s.setScene(scene);
    	
    	TitleController tc = loader.getController();
    	tc.setDriver(this);
    	
    	s.setResizable(false);
        s.setTitle("Pokemon Fishing");
        s.show();
    }
    
    public Stage getWindow() {
    	return s;
    }  
}
