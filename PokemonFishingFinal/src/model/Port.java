package model;
import java.util.Scanner;

import model.Upgrades.Line;
import model.Upgrades.Lure;
import model.Upgrades.Reel;

//This class allows the player to interact with the port
public class Port {
	
	// Allows the player to sell his items automatically when in port.
	
	public void sellItems(Player player) {
		int i;
		int sum = 0;
		for(i = 0; i < player.getBackpack().getTreasure().size(); i++) {
			player.setnCash(player.getnCash() + player.getBackpack().getTreasure().get(i).getnPrice());
			sum += player.getBackpack().getTreasure().get(i).getnPrice();
		}
		System.out.println("You Sold "+ player.getBackpack().getTreasure().size()+" items for "+ sum);
		player.getBackpack().getTreasure().clear();
	}
	
	public void showShop(Player p, int Action) {
		
		
		switch(Action) {
		case 1:
			if(p.getnCash() >= 3500) {
				p.getBackpack().getbBoat().setsBoatName("SpeedBoat");
				p.setnCash(p.getnCash() - 3500);
				System.out.println(p.getBackpack().getbBoat().getsBoatName());
			}
			else
				System.out.println("You Don't Have Enough POKE DOLLARS!");
			break;
		case 2:
			if(p.getnCash() >= 5000) {
				p.getBackpack().getbBoat().setsBoatName("SharepedoBoat");
				p.setnCash(p.getnCash() - 5000);
			}
			else
				System.out.println("You Don't Have Enough POKE DOLLARS!");
			break;
		case 3:
			if(p.getnCash() >= 1500) {
				p.getBackpack().getbBoat().setbHasAquaEngine(true);
				p.setnCash(p.getnCash() - 1500);
			}
			else if(p.getBackpack().getbBoat().isbHasAquaEngine()) {
				System.out.println("You Already Have the Aqua Engine");
			}
			else
				System.out.println("You Don't Have Enough POKE DOLLARS!");
			break;
		case 4:
			if(p.getnCash() >= 1500) {
				p.getBackpack().getTbTbox().setsTboxName("GoodTackleBox");
				p.setnCash(p.getnCash() - 1500);
			}
			else
				System.out.println("You Don't Have Enough POKE DOLLARS!");
			break;
		case 5:
			if(p.getnCash() >= 2000) {
				p.getBackpack().getbBoat().setsBoatName("SuperTackleBox");
				p.setnCash(p.getnCash() - 2000);
			}
			else
				System.out.println("You Don't Have Enough POKE DOLLARS!");
			break;
		case 6:
			if(p.getnCash() >= 2500) {
				p.getBackpack().getbBoat().setsBoatName("MasterTackleBox");
				p.setnCash(p.getnCash() - 2500);
			}
			else
				System.out.println("You Don't Have Enough POKE DOLLARS!");
			break;
		case 7:
			if(p.getnCash() >= 3000) {
				p.getBackpack().getrRod().setsRodName("GoodRod");
				p.setnCash(p.getnCash() - 3000);
			}
			else
				System.out.println("You Don't Have Enough POKE DOLLARS!");
			break;
		case 8:
			if(p.getnCash() >= 8000) {
				p.getBackpack().getrRod().setsRodName("SuperRod");
				p.setnCash(p.getnCash() - 8000);
			}
			else
				System.out.println("You Don't Have Enough POKE DOLLARS!");
			break;
		case 9:
			if(p.getnCash() >= 20000) {
				p.getBackpack().getrRod().setsRodName("MasterRod");
				p.setnCash(p.getnCash() - 20000);
			}
			else
				System.out.println("You Don't Have Enough POKE DOLLARS!");
			break;
		case 10:
			if(p.getnCash() >= 500) {
				((Lure)p.getBackpack().getrRod().getLure()).setLure("GreatLure");
				p.setnCash(p.getnCash() - 500);
			}
			else
				System.out.println("You Don't Have Enough POKE DOLLARS!");
			break;
		case 11:
			if(p.getnCash() >= 700) {
				((Lure)p.getBackpack().getrRod().getLure()).setLure("UltraLure");
				p.setnCash(p.getnCash() - 700);
			}
			else
				System.out.println("You Don't Have Enough POKE DOLLARS!");
			break;
		case 12:
			if(p.getnCash() >= 900) {
				((Lure)p.getBackpack().getrRod().getLure()).setLure("MasterLure");
				p.setnCash(p.getnCash() - 900);
			}
			else
				System.out.println("You Don't Have Enough POKE DOLLARS!");
			break;
		case 13:
			if(p.getnCash() >= 700) {
				((Line)p.getBackpack().getrRod().getLine()).setLine("GreatLine");
				p.setnCash(p.getnCash() - 700);
			}
			else
				System.out.println("You Don't Have Enough POKE DOLLARS!");
			break;
		case 14:
			if(p.getnCash() >= 800) {
				((Line)p.getBackpack().getrRod().getLine()).setLine("UltraLine");
				p.setnCash(p.getnCash() - 800);
			}
			else
				System.out.println("You Don't Have Enough POKE DOLLARS!");
			break;
		case 15:
			if(p.getnCash() >= 900) {
				((Line)p.getBackpack().getrRod().getLine()).setLine("MasterLine");
				p.setnCash(p.getnCash() - 900);
			}
			else
				System.out.println("You Don't Have Enough POKE DOLLARS!");
			break;
		case 16:
			if(p.getnCash() >= 800) {
				((Reel)p.getBackpack().getrRod().getReel()).setReel("GreatReel");
				p.setnCash(p.getnCash() - 800);
			}
			else
				System.out.println("You Don't Have Enough POKE DOLLARS!");
			break;
		case 17:
			if(p.getnCash() >= 950) {
				((Reel)p.getBackpack().getrRod().getReel()).setReel("UltraReel");
				p.setnCash(p.getnCash() - 950);
			}
			else
				System.out.println("You Don't Have Enough POKE DOLLARS!");
			break;
		case 18:
			if(p.getnCash() >= 1000) {
				((Reel)p.getBackpack().getrRod().getReel()).setReel("MasterReel");
				p.setnCash(p.getnCash() - 1000);
			}
			else
				System.out.println("You Don't Have Enough POKE DOLLARS!");
			break;
		default:
			System.out.println("WRONG INPUT!!!");
	}
		p.getBackpack().getbBoat().initializeMoves();
		p.getBackpack().getTbTbox().initializeCasts();
		p.getBackpack().getrRod().setPokemonRates();
	}
}