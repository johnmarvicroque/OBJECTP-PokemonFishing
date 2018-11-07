package model.Upgrades;

import model.RodCustomizations;

//Rod class
public class Rod {
	
	private String sRodName; // What Rod the player owns
	private int eRateChanger;// Encounter Rate Changer
	private int cRateChanger;// Catch Rate Changer
	private RodCustomizations lure;
	private RodCustomizations line;
	private RodCustomizations reel;
	private boolean bHasLure;
	private boolean bHasLine;
	private boolean bHasReel;
	
	// Constructor of Rod
	public Rod() {
		this.eRateChanger = 0;
		this.cRateChanger = 0;
		this.setsRodName("OldRod");
		lure = new Lure();
		line = new Line();
		reel = new Reel();
		this.setbHasLure(false);
		this.setbHasLine(false);
		this.setbHasReel(false);
	}
	// Getters and Setters of each attribute	
	public int geteRateChanger() {
		return eRateChanger;
	}

	public void seteRateChanger(int eRateChanger) {
		this.eRateChanger = eRateChanger;
	}

	public int getcRateChanger() {
		return cRateChanger;
	}

	public void setcRateChanger(int cRateChanger) {
		this.cRateChanger = cRateChanger;
	}

	public String getsRodName() {
		return sRodName;
	}

	public void setsRodName(String sRodName) {
		this.sRodName = sRodName;
	}
	public RodCustomizations getLure() {
		return lure;
	}
	public RodCustomizations getLine() {
		return line;
	}
	public RodCustomizations getReel() {
		return reel;
	}
	public boolean isbHasLure() {
		return bHasLure;
	}
	public void setbHasLure(boolean bHasLure) {
		this.bHasLure = bHasLure;
	}
	public boolean isbHasLine() {
		return bHasLine;
	}
	public void setbHasLine(boolean bHasLine) {
		this.bHasLine = bHasLine;
	}
	public boolean isbHasReel() {
		return bHasReel;
	}
	public void setbHasReel(boolean bHasReel) {
		this.bHasReel = bHasReel;
	}
	public void setPokemonRates() {
		if(sRodName.equals("OldRod")) {
			this.eRateChanger = 0;
			this.cRateChanger = 0;
		}
		if(sRodName.equals("GoodRod")) {
			this.eRateChanger = 10;
			this.cRateChanger = 5;
		}
		if(sRodName.equals("SuperRod")) {
			this.eRateChanger = 15;
			this.cRateChanger = 20;
		}
		if(sRodName.equals("MasterRod")) {
			this.eRateChanger = 20;
			this.cRateChanger = 40;
		}
	}
}
