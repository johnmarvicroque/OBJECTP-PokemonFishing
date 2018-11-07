package model.Locales;

import model.Locale;
import model.Player;
import model.Pokemon;
import model.Treasure;
import model.Pokemons.Magikarp;
import model.Pokemons.RedGyarados;
import model.Pokemons.Staryu;
import model.Pokemons.Tentacool;

public class LOR extends Locale {
	private static char [][] area = new char[][] {
			{'U','U','U','U','U','U','U','U','U','U','U'},
			{'U','U','U','V','V','V','V','V','V','U','U'},
			{'U','U','V','V','D','D','D','D','D','U','U'},
			{'U','U','V','D','S','S','T','S','D','V','U'},
			{'U','V','D','D','S','S','S','S','D','V','U'},
			{'U','V','S','S','S','P','S','D','D','V','U'},
			{'U','V','D','D','S','S','S','D','D','V','U'},
			{'U','V','D','D','D','S','D','D','D','V','U'},
			{'U','V','V','D','D','D','D','D','V','V','U'},
			{'U','U','U','V','V','V','V','V','L','U','U'},
			{'U','U','U','U','U','U','U','U','U','U','U'}
		};;
	private Pokemon pokemon;// Attribute to set the Pokemon/Legendary Pokemon depending on the area/grid
	private Treasure treasure;
	Player playerStats;
	public LOR() {
		super(area);
		
		this.setsMapName("Lake Of Rage");
		this.setrPokemonHasBeenCaught(false);
		this.setFishingBadge("ScaleBadge");
		
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
			pokemon = new Magikarp();
		}
		else if(area[x][y] == 'D') {
			pokemon = new Tentacool();
		}
		else if(area[x][y] == 'V' ) {
			pokemon = new Staryu();
		}
	}
	// sets the pokemon in the legendary tile
	public void setLegendary(int x, int y) {
		if(area[x][y] == 'L') {
			pokemon = new RedGyarados();
			
		}
	}
	// sets the tile pokemon in the treasure tile
	public void setTreasure(int x, int y) {
		if(area[x][y] == 'T' ) {
			treasure = new Treasure("Pearl");
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
