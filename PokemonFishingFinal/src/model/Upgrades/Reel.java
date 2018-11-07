package model.Upgrades;

import model.RodCustomizations;

public class Reel extends RodCustomizations{
	public void setReel(String sReelName) {
		if(sReelName.equals("GreatReel")) {
			this.setsCustName("GreatReel");
			this.setnEncounterAdder(10);
			this.setnCatchAdder(10);
		}
		else if(sReelName.equals("UltraReel")) {
			this.setsCustName("UltraReel");
			this.setnEncounterAdder(18);
			this.setnCatchAdder(18);
		}
		else if(sReelName.equals("MasterReel")) {
			this.setsCustName("MasterReel");
			this.setnEncounterAdder(21);
			this.setnCatchAdder(21);
		}
	}
}
