package model;
// Locale class
public abstract class Locale {
	private String sMapName;// Map Name
	private Port port;//
	private boolean rPokemonHasBeenCaught;	
	private String fishingBadge;
	private char area[][];
	
	public Locale(char [][] a) {
		port = new Port();
		area = a;
	}
	public String getsMapName() {
		return sMapName;
	}
	public void setsMapName(String sMapName) {
		this.sMapName = sMapName;
	}

	public boolean isrPokemonHasBeenCaught() {
		return rPokemonHasBeenCaught;
	}
	public void setrPokemonHasBeenCaught(boolean rPokemonHasBeenCaught) {
		this.rPokemonHasBeenCaught = rPokemonHasBeenCaught;
	}
	public Port getPort() {
		return port;
	}
	public void setFishingBadge(String fishingBadge) {
		this.fishingBadge = fishingBadge;
	}
	public String getFishingBadge() {
		return fishingBadge;
	}
	
	public void setArea(char[][] area) {
		this.area = area;
	}
	
	public abstract void setBackToPort(Player player);
	public abstract void printLocation(Player player);
	public abstract char[][] getArea();
	public abstract Pokemon getPokemon();
	public abstract Treasure getTreasure();
	public abstract void setLegendary(int x, int y);
	public abstract void setPokemon(int x, int y);
	public abstract void setTreasure(int x, int y);
}