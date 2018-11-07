package model.Locales;

import model.Locale;
import model.Player;
import model.Pokemon;
import model.Treasure;
import model.Pokemons.Chinchou;
import model.Pokemons.Kyogre;
import model.Pokemons.Relicanth;
import model.Pokemons.Wailmer;

public class MC extends Locale{
	private static char [][] area= new char[][] {
			{'U','V','V','D','V','L','V','V','V','V','U'},
			{'U','V','D','S','D','V','V','V','V','V','U'},
			{'U','D','S','U','S','D','D','D','D','D','U'},
			{'U','S','U','U','U','S','D','D','D','D','U'},
			{'U','D','S','U','S','D','D','S','D','D','U'},
			{'U','D','D','S','D','D','S','U','T','D','U'},
			{'U','D','D','D','D','S','U','U','U','S','U'},
			{'U','D','D','T','S','S','S','U','S','D','U'},
			{'U','D','D','S','S','S','S','S','D','D','U'},
			{'U','D','D','S','S','S','S','S','D','D','U'},
			{'U','D','D','S','S','P','S','S','D','D','U'}
		};;
	private Pokemon pokemon;// Attribute to set the Pokemon/Legendary Pokemon depending on the area/grid
	private Treasure treasure;
	Player playerStats;
	public MC(String locale) {
		super(area);
		
		this.setsMapName(locale);
		this.setrPokemonHasBeenCaught(false);
		this.setFishingBadge("LegendBadge");
	}
	
	public void setBackToPort(Player player) {
		int i = 0;
		int j = 0;
		for(i = 0; i < 11; i++) {
			for(j = 0; j < 11; j++) {
				if(area[i][j] == 'P') {
					player.setnRow(i);
					player.setnColumn(j);
				}
			}
		}
	}
	
	public void printLocation(Player player) {
		int i = 0;
		int j = 0;
		char tile = 0;
		for(i = 0; i < 11; i++) {
			for(j = 0; j < 11; j++) {
				if(i == player.getnRow() && j == player.getnColumn()) {
					System.out.print(" C");
					tile = area[i][j];
				}
				else
					System.out.print(" "+area[i][j]);
			}
			System.out.println();
			}
		switch(tile) {
		case 'P':
			System.out.println("You are on the Port!");
			break;
		case 'S':
			System.out.println("You are on Shallow Water!");
			break;
		case 'D':
			System.out.println("You are on Deep Water!");
			break;
		case 'V':
			System.out.println("You are on Very Deep Water!");
			break;
		case 'L':
			System.out.println("You are on the Legendary Tile!");
			break;
		case 'T':
			System.out.println("You are on the Treasure Tile!");
			break;
		}
	}

	public void setPokemon(int x, int y) {
		if(area[x][y] == 'S') {
			pokemon = new Chinchou();
		}
		else if(area[x][y] == 'D') {
			pokemon = new Wailmer();
		}
		else if(area[x][y] == 'V' ) {
			pokemon = new Relicanth();
		}
	}
	// sets the pokemon in the legendary tile
	public void setLegendary(int x, int y) {
		if(area[x][y] == 'L') {
			pokemon = new Kyogre();
		}
	}
	// sets the tile pokemon in the treasure tile
	public void setTreasure(int x, int y) {
		if(area[x][y] == 'T' ) {
			treasure = new Treasure("BigNugget");
		}
	}
	
	public char[][] getArea() {
		return area;
	}
	public Pokemon getPokemon() {
		return pokemon;
	}
	public Treasure getTreasure() {
		return treasure;
	}
}
