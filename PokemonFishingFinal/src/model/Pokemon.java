package model;
//Pokemon class
public abstract class Pokemon {
	private String sPokemonName;
	private int nPokemonFame;
	private int nCatchRate;
	private int nEncounterRate;
	private int nFameDeduct;
	private String depthEncountered;
	
	//Getters and Setters for every attribute
	public Pokemon(String sPokemonName,int nPokemonFame,int nFameDeduct,int nCatchRate,int nEncounterRate,String depthEncountered) {
		this.sPokemonName = sPokemonName;
		this.nPokemonFame = nPokemonFame;
		this.nFameDeduct = nFameDeduct;
		this.nCatchRate = nCatchRate;
		this.nEncounterRate = nEncounterRate;
		this.depthEncountered = depthEncountered;
	}
	public void setnFameDeduct(int nFameDeduct) {
		this.nFameDeduct = nFameDeduct;
	}
	public String getsPokemonName() {
		return sPokemonName;
	}
	
	public int getnPokemonFame() {
		return nPokemonFame;
	}
	
	public int getnFameDeduct() {
		return nFameDeduct;
	}

	
	public int getnCatchRate() {
		return nCatchRate;
	}
	
	public int getnEncounterRate() {
		return nEncounterRate;
	}
	
	public String getDepthEncountered() {
		return depthEncountered;
	}
	
}
