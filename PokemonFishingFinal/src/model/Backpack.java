package model;
import java.util.ArrayList;

import model.Upgrades.Boat;
import model.Upgrades.Rod;
import model.Upgrades.TackleBox;

public class Backpack {
	private Boat bBoat;
	private TackleBox tbTbox;
	private Rod rRod;
	private ArrayList<Treasure> treasure;
	
	public Backpack() {
		bBoat = new Boat();
		tbTbox = new TackleBox();
		rRod = new Rod();
		treasure = new ArrayList<Treasure>();
	}
	

	public void addTreasure(Treasure treasure) {
			this.treasure.add(treasure);
	}

	public Boat getbBoat() {
		return bBoat;
	}

	public TackleBox getTbTbox() {
		return tbTbox;
	}

	public Rod getrRod() {
		return rRod;
	}

	public ArrayList<Treasure> getTreasure() {
		return treasure;
	}
	
}
