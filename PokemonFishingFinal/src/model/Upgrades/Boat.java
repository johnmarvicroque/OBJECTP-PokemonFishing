package model.Upgrades;
// This Class is what the Player is using for him to move on the area in the Locale which is stored in the class Backpack
public class Boat {
	private String sBoatName;	// Boat Name
	private float fMoves;	// Moves of the boat (Can be halved)
	private boolean bHasAquaEngine; // If True fMoves will be halved
	
//Constructor of the Boat
	public Boat() {
		this.setsBoatName("RowBoat");
		this.setfMoves(5);
		this.bHasAquaEngine = false;
	}
// Getters And Setters
	public String getsBoatName() {
		return sBoatName;
	}
	public void setsBoatName(String sBoat) {
		this.sBoatName = sBoat;
	}
	public float getfMoves() {
		return fMoves;
	}
	public void setfMoves(float fMoves) {
		this.fMoves = fMoves;
	}
	
	public boolean isbHasAquaEngine() {
		return bHasAquaEngine;
	}

	public void setbHasAquaEngine(boolean bHasAquaEngine) {
		this.bHasAquaEngine = bHasAquaEngine;
	}

	
//If The Boat has an Aqua Engine(bHasAquaEngine == TRUE) Moves will be .5
	public void deductnMoves() {
		if(!bHasAquaEngine)
			fMoves --;
		else
			fMoves -=0.5;
	}
	
//Will Initialize the number of moves depending on the Boat Name
	public void initializeMoves() {
		if(sBoatName.equals("RowBoat")) {
			this.setfMoves(5);
		}
		else if(sBoatName.equals("SpeedBoat")) {
			this.setfMoves(10);
		}
		else if(sBoatName.equals("SharpedoBoat")) {
			this.setfMoves(15);
		}
		
	}
}