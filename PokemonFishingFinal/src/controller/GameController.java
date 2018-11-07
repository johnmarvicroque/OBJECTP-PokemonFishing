package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Calendar;
import model.Driver;
import model.Locale;
import model.Player;
import model.RNG;
import model.Locales.FS;
import model.Locales.LOR;
import model.Locales.MC;
import model.Locales.R119;
import model.Locales.UC;

public class GameController {
	
	@FXML private Button up,down,left,right,fish,shopBtn,cancel;
	@FXML private ImageView player,shopWindow;
	@FXML private Label fame,money,MsgBox,day,movesLeft,castsLeft,total;
	@FXML private ImageView capturedPokemon;
	@FXML private TextField shopField;
	@FXML private ComboBox<String> shopCombo;
	private boolean bHasMoved = false;
	private double x;
	private double y;
	private Driver d;
	private Locale currentMap;

	
	public void setDriver(Driver d) {
		this.d = d;
	}
	Player p;
	
	public void setPlayer(Player p) {
		this.p = p;
	}
	public Player getPlayer() {
		return this.p;
	}
	
	public boolean isbHasMoved() {
		return bHasMoved;
	}
	public void setbHasMoved(boolean bHasMoved) {
		this.bHasMoved = bHasMoved;
	}
	
	@FXML
	public void cancel() {
		shopCombo.setVisible(false);
		shopBtn.setVisible(false);
		shopWindow.setVisible(false);
		cancel.setVisible(false);
		shopField.setVisible(false);
	}
	
	@FXML
	public void buyItem() {
		int choice=Integer.parseInt(shopField.getText());
		currentMap.getPort().showShop(p, choice);
		update();
		
		
		}
	
	@FXML public void viewEquips() {
		
		
		int sum1 = p.getBackpack().getrRod().geteRateChanger() + p.getBackpack().getrRod().getLure().getnEncounterAdder() 
		+ p.getBackpack().getrRod().getReel().getnEncounterAdder();
		int sum2 = p.getBackpack().getrRod().getcRateChanger() + p.getBackpack().getrRod().getLure().getnCatchAdder()
		+ p.getBackpack().getrRod().getLine().getnCatchAdder() + p.getBackpack().getrRod().getReel().getnCatchAdder();
		total.setText("ERate:" + Integer.toString(sum1)+ " "+"CRate"+Integer.toString(sum2));
		
	}
	
	@FXML
	public void openShop() {
		if(currentMap.getArea()[p.getnRow()][p.getnColumn()] == 'P') {
		shopCombo.getItems().addAll(	
				"-----------Boats----------",
				"1.SpeedBoat 10 moves  3500",
				"2.SharpedoBoat 15 moves 5000",
				"3.AquaEngine %50 on gas! 1000",
				"----------TackleBox-------",
				"4.GoodTackleBox 8 casts 1500",
				"5.SupertackleBox 10 casts 2000",
				"6.MasterTackleBox 15 casts 2500",
				"-------------Rods---------",
				"7.GoodRod %10 ERate %5CRate 3000",
				"8.SuperRod %15 ERate %20CRate 8000",
				"9.MasterRod %20 ERate %40CRate 20000",
				"----------Rod-Upgrades---",
				"10.GreatLure %5ERate %5CRate 500",
				"11.UltraLure %10ERate 5%CRate 700",
				"12.MasterLure %30ERate 7%CRate 900",
				"13.GreatLine %10CRate    700",
				"14.UltraLine %15CRate    800",
				"15.MasterLine %25CRate   900",
				"16.GreatReel %10ERate %10CRate  800",
				"17.UltraReel %18ERate %18CRate  950",
				"18.MasterReel %21ERate %21CRate 1000"
				);
		shopCombo.setVisible(true);
		shopBtn.setVisible(true);
		shopWindow.setVisible(true);
		shopField.setVisible(true);
		cancel.setVisible(true);
	
		}
	}
	
	@FXML
	public void fish(ActionEvent event) throws IOException {
	
	if (p.getBackpack().getTbTbox().getnCasts() > 0)
		{
		if(currentMap.getArea()[p.getnRow()][p.getnColumn()] == 'L') {
			if(currentMap.getArea()[p.getnRow()][p.getnColumn()] == 'L') {
				if(p.getnFame() >= 100  && !currentMap.isrPokemonHasBeenCaught()) {
					p.getBackpack().getTbTbox().deductnCasts(1);
					currentMap.setLegendary(p.getnRow(),p.getnColumn());
					
					p.encounterPokemon(currentMap.getPokemon(), currentMap);
					MsgBox.setText("Congratulations you caught " + currentMap.getPokemon().getsPokemonName() + "!!!");
					System.out.println("Congratulations you caught " + currentMap.getPokemon().getsPokemonName() + "!!!");
					if(currentMap.getPokemon().getsPokemonName().equals("RGyarados")) {
						System.out.println("You may now move on to Route119 or Marine Cave");
					}
					else if(currentMap.getPokemon().getsPokemonName().equals("Lapras")) {
						MsgBox.setText("You may now move on to Fiore's Sea");
						System.out.println("You may now move on to Fiore's Sea");
					}
					p.addFishingBadge(currentMap.getFishingBadge());
					System.out.println("You Got the " + currentMap.getFishingBadge());
					this.currentMap.setrPokemonHasBeenCaught(true);
					endDay();
					leaveLocale();
				}
				else {
					System.out.println("You don't Have enough Fame!!!");
					MsgBox.setText("You don't Have enough Fame!!!");}
			}
		}
			
		else if(currentMap.getArea()[p.getnRow()][p.getnColumn()] == 'T') {
			p.getBackpack().getTbTbox().deductnCasts(1);
			currentMap.setTreasure(p.getnRow(),p.getnColumn());
			
			p.encounterTreasure(currentMap.getTreasure(), currentMap);
		}
		else if(currentMap.getArea()[p.getnRow()][p.getnColumn()] != 'P') {	
			p.getBackpack().getTbTbox().deductnCasts(1);
			currentMap.setPokemon(p.getnRow(),p.getnColumn());
			encounterPokemon();
		}

		else {
			MsgBox.setText("Hey! You can't Cast yur line in the Port!!! -,-");
			System.out.println("Hey! You can't Cast yur line in the Port!!! -,-");
		}
		update();
		}
	else endDay();
	}
	
	public void encounterPokemon() {
		int totalFame = 0;
		RNG rng= new RNG();
		
		if(rng.generator(currentMap.getPokemon().getnEncounterRate(), p.getBackpack().getrRod().geteRateChanger())){
			MsgBox.setText("You have Encountered a "+ currentMap.getPokemon().getsPokemonName());
			System.out.println("You have Encountered a "+ currentMap.getPokemon().getsPokemonName());
			if(rng.generator(currentMap.getPokemon().getnCatchRate(), p.getBackpack().getrRod().getcRateChanger()))
			{
				p.deductFameReward(currentMap.getPokemon());
				p.addCaughtPokemon(currentMap.getPokemon());
				totalFame = p.getnFame() + p.noNegativeFameDeduct(currentMap.getPokemon());
				p.setnFame(totalFame);
				MsgBox.setText(currentMap.getPokemon().getsPokemonName()+" captured!");
				fame.setText(Integer.toString(p.getnFame()));
				System.out.println(currentMap.getPokemon().getsPokemonName()+" captured!");
				if(currentMap.getArea()[p.getnRow()][p.getnColumn()] == 'L' && !currentMap.isrPokemonHasBeenCaught()) {
					
					currentMap.setrPokemonHasBeenCaught(true);
				}
				
				if(p.getnFame() > 100)
					p.setnFame(100);
			}
			else {MsgBox.setText("But "+currentMap.getPokemon().getsPokemonName()+" got away!");
				System.out.println("But "+currentMap.getPokemon().getsPokemonName()+" got away!");}
		}
		else {
			MsgBox.setText("You have encountered nothing!!!");
			System.out.println("You have encountered nothing!!!");}
	}
	
	


	
	public void leaveLocale() throws IOException {
		
		
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
	
	@FXML
	public void moveLeft()  {
		System.out.println(currentMap.getArea()[p.getnRow()][p.getnColumn()]);
		
		if(currentMap.getArea()[p.getnRow()][p.getnColumn()-1] == 'P') {
			if(this.goBacktoPort() == true) {
				endDay();
			}
		}
			
		else if(currentMap.getArea()[p.getnRow()][p.getnColumn()-1] != 'U'&& p.getBackpack().getbBoat().getfMoves() != 0) {
			System.out.println("here");
			player.setLayoutX(player.getLayoutX()-27);
			p.setnColumn(p.getnColumn() - 1 );
			update();
		}

	}
		
	@FXML
	public void moveRight()  {
		if(currentMap.getArea()[p.getnRow()][p.getnColumn() + 1] == 'P') {
			if(this.goBacktoPort() == true) {
				endDay();
			}
		}
		
		else if(currentMap.getArea()[p.getnRow()][p.getnColumn()+1] != 'U'&& p.getBackpack().getbBoat().getfMoves() != 0) {
		player.setLayoutX(player.getLayoutX()+27);
		p.setnColumn(p.getnColumn() + 1 );
		currentMap.printLocation(p);
		p.getBackpack().getbBoat().deductnMoves();
		update();
		
		}
	}
	@FXML
	public void moveUp(ActionEvent event)  {
		if(currentMap.getArea()[p.getnRow()-1][p.getnColumn()] == 'P') {
			if(this.goBacktoPort() == true) {
				endDay();
			}
		}
		else if(currentMap.getArea()[p.getnRow()-1][p.getnColumn()] != 'U'&& p.getBackpack().getbBoat().getfMoves() != 0) {
		player.setLayoutY(player.getLayoutY()-27);	
		p.setnRow( p.getnRow() - 1);
		currentMap.printLocation(p);
		p.getBackpack().getbBoat().deductnMoves();
		update();
		}
	}
	@FXML
	public void moveDown(ActionEvent event) {
		
		if(currentMap.getArea()[p.getnRow()+1][p.getnColumn()] == 'P') {
			if(this.goBacktoPort() == true) {
				endDay();
			}
		}
		else if(currentMap.getArea()[p.getnRow()+1][p.getnColumn()] != 'U'&& p.getBackpack().getbBoat().getfMoves() != 0) {
		player.setLayoutY(player.getLayoutY()+27);	
		p.setnRow(p.getnRow() + 1);
		currentMap.printLocation(p);
		System.out.println(p.getBackpack().getbBoat().getfMoves());
		System.out.println(p.getBackpack().getTbTbox().getnCasts());
		p.getBackpack().getbBoat().deductnMoves();
		update();
		
		}
	}
	
	
	public void whatArea(String sName) {
		
		if(sName.equals("LakeOfRage")) {
			LOR lake = new LOR();
			currentMap = lake;
			currentMap.setBackToPort(p);
			currentMap.printLocation(p);
			x = 158.0;
			y = 162.0;
			
		}
		else if(sName.equals("UnionCave")) {
			UC lake = new UC("UnionCave");
			currentMap = lake;
			currentMap.setBackToPort(p);
			currentMap.printLocation(p);
			x = 159.0;
			y = 284.0;
		}
		else if(sName.equals("Fiore'sSea")) {
			FS lake = new FS("Fiore'sSea");
			currentMap = lake;
			currentMap.setBackToPort(p);
			currentMap.printLocation(p);
			x = 29.0;
			y = 284.0;
			
		}
		else if(sName.equals("Route119")) {
			R119 lake = new R119("Route119");
			currentMap = lake;
			currentMap.setBackToPort(p);
			currentMap.printLocation(p);
			x=29.0;
			y=29.0;
		}
		else if(sName.equals("MarineCave")) {
			MC lake = new MC("MarineCave");
			currentMap = lake;
			currentMap.setBackToPort(p);
			currentMap.printLocation(p);
			x = 150.0;
			y = 272.0;
		}
			
	}
	
	public void endDay() {

		
		if(p.getBackpack().getTbTbox().getnCasts() == 0) 
			System.out.println("You have exhausted your TackleBox!!!");
		currentMap.setBackToPort(p);
		Calendar.nDays++;
		p.getBackpack().getbBoat().initializeMoves();
		p.getBackpack().getTbTbox().initializeCasts();
		p.getBackpack().getrRod().setPokemonRates();
		player.setLayoutX(x);
		player.setLayoutY(y);
		update();
			
		if(p.getBackpack().getTreasure().size() >= 1)
			currentMap.getPort().sellItems(p);
			money.setText(Integer.toString(p.getnCash()));
	}
	
	@FXML
	public void update () {
		fame.setText(Integer.toString(p.getnFame()));
		money.setText(Integer.toString(p.getnCash()));
		movesLeft.setText(Float.toString(p.getBackpack().getbBoat().getfMoves()));
		castsLeft.setText(Integer.toString(p.getBackpack().getTbTbox().getnCasts()));
		day.setText(Integer.toString(Calendar.nDays));
		viewEquips();

	}
	public boolean goBacktoPort() {
		
		boolean choice = false;
		choice = confirmbox.display("Port", "Go back to port?");
		if(choice) {
			endDay();
			this.bHasMoved = false;
			p.getBackpack().getbBoat().initializeMoves();
			p.getBackpack().getTbTbox().initializeCasts();
					  
			}
			
		return choice;
	}
}
