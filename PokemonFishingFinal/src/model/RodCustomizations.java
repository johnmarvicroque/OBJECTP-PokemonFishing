package model;

public abstract class RodCustomizations {
	private String sCustName;
	private int nEncounterAdder;
	private int nCatchAdder;
	
	public String getsCustName() {
		return sCustName;
	}
	public void setsCustName(String sCustName) {
		this.sCustName = sCustName;
	}
	public int getnEncounterAdder() {
		return nEncounterAdder;
	}
	public void setnEncounterAdder(int nEncounterAdder) {
		this.nEncounterAdder = nEncounterAdder;
	}
	public int getnCatchAdder() {
		return nCatchAdder;
	}
	public void setnCatchAdder(int nCatchAdder) {
		this.nCatchAdder = nCatchAdder;
	}
}
