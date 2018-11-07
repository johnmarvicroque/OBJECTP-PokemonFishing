package model.Locales;

import model.Locale;
import model.Player;
import model.Pokemon;
import model.Treasure;
import model.Pokemons.Goldeen;
import model.Pokemons.Horsea;
import model.Pokemons.Lapras;
import model.Pokemons.Shelder;

public class UC extends Locale {
	private static char [][] area = new char[][] {
			{'U','U','U','U','U','L','U','U','U','U','U'},
			{'U','U','V','V','V','V','V','V','V','U','U'},
			{'U','V','V','V','V','V','V','V','V','V','U'},
			{'U','V','D','D','D','D','D','D','D','V','U'},
			{'U','D','D','D','D','D','D','T','D','D','U'},
			{'U','D','D','D','D','D','D','D','D','D','U'},
			{'U','D','S','S','S','S','S','S','S','D','U'},
			{'U','D','S','T','S','S','S','S','S','D','U'},
			{'U','S','S','S','S','S','S','S','S','S','U'},
			{'U','U','S','S','S','S','S','S','S','U','U'},
			{'U','U','U','U','U','P','U','U','U','U','U'}
		};
	private Pokemon pokemon;
	private Treasure treasure;
	Player playerStats;
	public UC(String locale) {
		super(area);
		
		this.setsMapName(locale);
		this.setrPokemonHasBeenCaught(false);
		this.setFishingBadge("ShellBadge");
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
			pokemon = new Goldeen();
		}
		else if(area[x][y] == 'D') {
			pokemon = new Shelder();
		}
		else if(area[x][y] == 'V' ) {
			pokemon = new Horsea();
		}
	}
	// sets the pokemon in the legendary tile
	public void setLegendary(int x, int y) {
		if(area[x][y] == 'L') {
			pokemon = new Lapras();
		}
	} 
	// sets the tile pokemon in the treasure tile
	public void setTreasure(int x, int y) {
		if(area[x][y] == 'T' ) {
			treasure = new Treasure("Stardust");
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
