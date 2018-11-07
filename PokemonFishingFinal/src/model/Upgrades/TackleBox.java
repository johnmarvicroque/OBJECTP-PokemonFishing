package model.Upgrades;
// TackleeBox Class
public class TackleBox {
	private int nCasts;		// Will Determine how many times you can fish/cast your line
	private String sTboxName;	// Is the Name of the TackleBox of the Player
	
	//Constructor of the TackleBox
	public TackleBox() {
		this.setsTboxName("BasicTackleBox");
		this.setnCasts(5);
	}
	// Getters And Setters
	public int getnCasts() {
		return nCasts;
	}
	public void setnCasts(int nCasts) {
		this.nCasts = nCasts;
	}
	public String getsTboxName() {
		return sTboxName;
	}
	public void setsTboxName(String sTbox) {
		this.sTboxName = sTbox;
	}
	// deducts amount of casts when fishing
	public void deductnCasts(int value) {
		nCasts -= value;
	}
	// sets amount of casts you can do per day depending on The tackle box
	public void initializeCasts() {
		if(sTboxName.equals("BasicTackleBox")) {
			this.setnCasts(5);
		}
		else if(sTboxName.equals("GoodTackleBox")) {
			this.setnCasts(8);
		}
		else if(sTboxName.equals("SuperTackleBox")) {
			this.setnCasts(10);
		}
		else if(sTboxName.equals("MasterTackleBox")) {
			this.setnCasts(15);
		}
	}
}