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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Driver;
import model.Player;

public class MapSelectController {
	
	@FXML private Button LakeOfRage,UnionCave,Route119,FioreSea,MarineCave;
	@FXML private ImageView ScaleBadge,ShellBadge,CoralBadge,DropletBadge,LegendBadge,black;
	@FXML private Label dBox;
	
	private Driver d;
	
	public void setDriver(Driver d) {
		this.d = d;
	}
	
	 Player p;
	
	public void setPlayer(Player p) {
		this.p = p;
	}
	
	@FXML
	public void goArea(ActionEvent event) throws IOException {
	
		FXMLLoader loader = new FXMLLoader();
		if(event.getSource() == LakeOfRage) {
			if(p.getFishingBadges().contains("ScaleBadge"))
			{
				dBox.setText("You are already done here.");
			
			}
			else {
				loader.setLocation(Driver.class.getResource("/view/LakeOfRage.fxml"));	
				AnchorPane Map;
		    	Map = (AnchorPane) loader.load();
				Scene scene1 = new Scene(Map);
			    GameController gc = loader.getController();
			    gc.setDriver(d);
			    gc.setPlayer(p);
		
				d.getWindow().setScene(scene1);
				d.getWindow().show();
				
				gc.whatArea("LakeOfRage");
				}
			
			
		}
		else if(event.getSource() == UnionCave) {
		 			if(p.getFishingBadges().contains("ShellBadge"))
			{
				dBox.setText("You are already done here.");
				
				
			}
			else {loader.setLocation(Driver.class.getResource("/view/UnionCave.fxml"));
			AnchorPane Map;
	    	Map = (AnchorPane) loader.load();
			Scene scene1 = new Scene(Map);
		    GameController gc = loader.getController();
		    gc.setDriver(d);
		    gc.setPlayer(p);
			d.getWindow().setScene(scene1);
			d.getWindow().show();
			gc.whatArea("UnionCave");}
		}
		else if(event.getSource() == FioreSea) {
		
			for(int i = 0; i < p.getFishingBadges().size(); i++)
				if(p.getFishingBadges().get(i).equals("ShellBadge")) {
					if(p.getFishingBadges().contains("DropletBadge"))
					{
						dBox.setText("You are already done here.");
						
					}
					else {loader.setLocation(Driver.class.getResource("/view/Fiore'sSea.fxml"));
			
					AnchorPane Map;
			    	Map = (AnchorPane) loader.load();
					Scene scene1 = new Scene(Map);
				    GameController gc = loader.getController();
				    gc.setDriver(d);
				    gc.setPlayer(p);
					d.getWindow().setScene(scene1);
					d.getWindow().show();
					gc.whatArea("FioreSea");}
					}
			
				else dBox.setText("You need the Shell Badge to enter");
			
		}
		else if(event.getSource() == Route119) {
				for(int i = 0; i < p.getFishingBadges().size(); i++)
					if(p.getFishingBadges().get(i).equals("ScaleBadge")) {
						if(p.getFishingBadges().contains("CoralBadge"))
							dBox.setText("You are already done here.");
						
					
						else {
							loader.setLocation(Driver.class.getResource("/view/Route119.fxml"));
							AnchorPane Map;
					    	Map = (AnchorPane) loader.load();
							Scene scene1 = new Scene(Map);
						    GameController gc = loader.getController();
						    gc.setDriver(d);
						    gc.setPlayer(p);
							d.getWindow().setScene(scene1);
							d.getWindow().show();
							gc.whatArea("Route119");
					    }
						
					}
					else dBox.setText("You need the Scale Badge to enter");
				
			}
				
			
	
		else if(event.getSource() == MarineCave) {
			
			if(p.countFishingBadges() == 4) {
				if(p.getFishingBadges().contains("LegendBadge"))
				{
					dBox.setText("You are already done here.");
					
				}
				else {
					loader.setLocation(Driver.class.getResource("/view/MarineCave.fxml"));
					AnchorPane Map;
			    	Map = (AnchorPane) loader.load();
					Scene scene1 = new Scene(Map);
				    GameController gc = loader.getController();
				    gc.setDriver(d);
				    gc.setPlayer(p);
					d.getWindow().setScene(scene1);
					d.getWindow().show();
					gc.whatArea("Route119");
				    }
				}
				else dBox.setText("You need to 4 badges to enter");
			
		}

		}
	@FXML
	public void asdf() {
		black.setVisible(false);
		
		if(p.getFishingBadges().contains("ScaleBadge"))
			ScaleBadge.setOpacity(1);
		if(p.getFishingBadges().contains("ShellBadge"))
			ShellBadge.setOpacity(1);
		if(p.getFishingBadges().contains("CoralBadge"))
			CoralBadge.setOpacity(1);
		if(p.getFishingBadges().contains("DropletBadge"))
			DropletBadge.setOpacity(1);
		if(p.getFishingBadges().contains("LegendBadge"))
			LegendBadge.setOpacity(1);
	
	}
	
	@FXML
	public void initialize() {
		
	
		
	}
	

}
