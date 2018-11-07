package model;
import java.util.ArrayList;

import controller.GameController;
import javafx.fxml.FXMLLoader;

public class Player {
	private String sName;
	private int nFame;
	private int nCash;
	private int nRow;
	private int nColumn;
	private Backpack backpack;
	private RNG rng;
	private ArrayList<ArrayList<Pokemon>> caughtPokemon;
	private ArrayList<String> fishingBadges; 
	
	public Player(String sName) {
		FXMLLoader loader = new FXMLLoader();
		GameController gc = loader.getController();
		this.sName = sName;
		this.nCash = 0;
		this.nFame = 0;
		this.nRow = 0;
		this.nColumn = 0;
		this.backpack = new Backpack();
		this.rng = new RNG();
		caughtPokemon = new ArrayList<ArrayList<Pokemon>>();
		ArrayList<Pokemon> Pokemon1 = new ArrayList<Pokemon>();
		ArrayList<Pokemon> Pokemon2 = new ArrayList<Pokemon>();
		ArrayList<Pokemon> Pokemon3 = new ArrayList<Pokemon>();
		ArrayList<Pokemon> LegendaryPokemon = new ArrayList<Pokemon>();
		fishingBadges = new ArrayList<String>();
		caughtPokemon.add(Pokemon1);
		caughtPokemon.add(Pokemon2);
		caughtPokemon.add(Pokemon3);
		caughtPokemon.add(LegendaryPokemon);
	}
	
	public void encounterPokemon(Pokemon pokemon, Locale map) {
		int totalFame = 0;
		if(rng.generator(pokemon.getnEncounterRate(), this.getBackpack().getrRod().geteRateChanger())){
			
			System.out.println("You have Encountered a "+ pokemon.getsPokemonName());
			if(rng.generator(pokemon.getnCatchRate(), this.getBackpack().getrRod().getcRateChanger()))
			{
				this.deductFameReward(map.getPokemon());
				this.addCaughtPokemon(pokemon);
				totalFame = this.getnFame() + noNegativeFameDeduct(map.getPokemon());
				this.setnFame(totalFame);
				System.out.println(map.getPokemon().getsPokemonName()+" captured!");
				if(map.getArea()[this.getnRow()][this.getnColumn()] == 'L' && !map.isrPokemonHasBeenCaught()) {
					
					map.setrPokemonHasBeenCaught(true);
				}
				
				if(this.nFame > 100)
					this.nFame = 100;
			}
			else System.out.println("But "+map.getPokemon().getsPokemonName()+" got away!");
		}
		else
			System.out.println("You have encountered nothing!!!");
	}
	
	public void encounterTreasure(Treasure treasure, Locale map) {	
		System.out.println(treasure.getnEncounterRate());
		if(rng.generator(treasure.getnEncounterRate(), this.getBackpack().getrRod().geteRateChanger())){
			System.out.println("You Have Encountered the "+ map.getTreasure().getsItemName());
			if(rng.generator(treasure.getnSuccessRate(), this.getBackpack().getrRod().getcRateChanger())) {
				this.getBackpack().addTreasure(treasure);
				System.out.println("You Got the "+ map.getTreasure().getsItemName());
			}
			else
				System.out.println("But you failed to get it");
		}
		else
			System.out.println("You have encountered nothing!!!");	
	}
	
	public void deductFameReward(Pokemon pokemon) {
		if(pokemon.getDepthEncountered().equals("Shallow")) {
			pokemon.setnFameDeduct(caughtPokemon.get(0).size() * 2);	
		}
		if(pokemon.getDepthEncountered().equals("Deep")) {
			pokemon.setnFameDeduct(caughtPokemon.get(1).size() * 5);
		}
		if(pokemon.getDepthEncountered().equals("VeryDeep")) {
			pokemon.setnFameDeduct(caughtPokemon.get(2).size() * 10);
		}
	}
	
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getnFame() {
		return nFame;
	}
	public void setnFame(int nFame) {
		this.nFame = nFame;
	}
	public int getnCash() {
		return nCash;
	}
	public void setnCash(int nCash) {
		this.nCash = nCash;
	}
	public int getnRow() {
		return nRow;
	}
	public void setnRow(int nRow) {
		this.nRow = nRow;
	}
	public int getnColumn() {
		return nColumn;
	}
	public void setnColumn(int nColumn) {
		this.nColumn = nColumn;
	}
	public Backpack getBackpack() {
		return backpack;
	}
	public ArrayList<ArrayList<Pokemon>> getCaughtPokemon() {
		return caughtPokemon;
	}
	public ArrayList<String> getFishingBadges() {
		return fishingBadges;
	}
	public int countFishingBadges() {
		return fishingBadges.size();
	}
	
	public void addFishingBadge(String fishingBadge) {
		fishingBadges.add(fishingBadge);
	}

	public void addCaughtPokemon(Pokemon pokemon) {
		if(pokemon.getDepthEncountered().equals("Shallow"))
			caughtPokemon.get(0).add(pokemon);	
		if(pokemon.getDepthEncountered().equals("Deep"))
			caughtPokemon.get(1).add(pokemon);
		if(pokemon.getDepthEncountered().equals("VeryDeep"))
			caughtPokemon.get(2).add(pokemon);
		if(pokemon.getDepthEncountered().equals("Legendary"))
			caughtPokemon.get(3).add(pokemon);		
	}	
	// Needed for the Deduction of the fame that the pokemon gives
	public int noNegativeFameDeduct(Pokemon pokemon) {
		int answer = pokemon.getnPokemonFame() - pokemon.getnFameDeduct();
		if(answer > 0){
			return answer;
		}
		return 0;
	}
	
	
	public void resetStats() {
		this.nFame = 0;
	}
	
	public void removePokemons() {
		this.caughtPokemon = null;
		caughtPokemon = new ArrayList<ArrayList<Pokemon>>();
		ArrayList<Pokemon> Pokemon1 = new ArrayList<Pokemon>();
		ArrayList<Pokemon> Pokemon2 = new ArrayList<Pokemon>();
		ArrayList<Pokemon> Pokemon3 = new ArrayList<Pokemon>();
		ArrayList<Pokemon> LegendaryPokemon = new ArrayList<Pokemon>();
		caughtPokemon.add(Pokemon1);
		caughtPokemon.add(Pokemon2);
		caughtPokemon.add(Pokemon3);
		caughtPokemon.add(LegendaryPokemon);
	}
}
