package model.Upgrades;

import model.RodCustomizations;

public class Lure extends RodCustomizations{
	public void setLure(String sLureName) {
		if(sLureName.equals("GreatLure")) {
			this.setsCustName("GreatLure");
			this.setnEncounterAdder(5);
			this.setnCatchAdder(5);
		}
		else if(sLureName.equals("UltraLure")) {
			this.setsCustName("UltraLure");
			this.setnEncounterAdder(10);
			this.setnCatchAdder(5);
		}
		else if(sLureName.equals("MasterLure")) {
			this.setsCustName("MasterLure");
			this.setnEncounterAdder(30);
			this.setnCatchAdder(7);
		}
	}
}
