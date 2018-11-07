package model.Upgrades;

import model.RodCustomizations;

public class Line extends RodCustomizations{
	public void setLine(String sLineName) {
		if(sLineName.equals("GreatLine")) {
			this.setsCustName("GreatLine");
			this.setnEncounterAdder(0);
			this.setnCatchAdder(10);
		}
		else if(sLineName.equals("UltraLine")) {
			this.setsCustName("UltraLine");
			this.setnEncounterAdder(0);
			this.setnCatchAdder(15);
		}
		else if(sLineName.equals("MasterLine")) {
			this.setsCustName("MasterLine");
			this.setnEncounterAdder(0);
			this.setnCatchAdder(25);
		}
	}
}
