package model;
// Treasure Class Which helps the player gain more money by finding it in the area, 
// Treasure will be stored in the player's Backpack as an array List and will be sold in the Port
public class Treasure {
	private String sItemName;	// Treasure Name
	private int nSuccessRate;	// Treasure CatchRate
	private int nPrice;			// Treasure Price
	private int nEncounterRate; // Treasure Encounter Rate

	// Constructor of the Treasure Class
	public Treasure(String TreasureName) {
		this.setsItemName(TreasureName);
		setnSuccessRate(100);
		setnEncounterRate(25);
		
		if(TreasureName.equals("Pearl"))
			this.setnPrice(1000);
		else if(TreasureName.equals("Stardust"))
			this.setnPrice(2500);
		else if(TreasureName.equals("BigPearl"))
			this.setnPrice(3000);
		else if(TreasureName.equals("Nugget"))
			this.setnPrice(4500);
		else if(TreasureName.equals("BigNugget"))
			this.setnPrice(10000);
	}
	// Getters and Setters for each attribute	
	public String getsItemName() {
		return sItemName;
	}
	public void setsItemName(String sItemName) {
		this.sItemName = sItemName;
	}
	public int getnSuccessRate() {
		return nSuccessRate;
	}
	public void setnSuccessRate(int nSuccessRate) {
		this.nSuccessRate = nSuccessRate;
	}
	
	public int getnEncounterRate() {
		return nEncounterRate;
	}

	public void setnEncounterRate(int nEncounterRate) {
		this.nEncounterRate = nEncounterRate;
	}

	public int getnPrice() {
		return nPrice;
	}
	public void setnPrice(int nPrice) {
		this.nPrice = nPrice;
	}
}