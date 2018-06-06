package com.shahan.pokemon;

public abstract class AbstractPokemon implements PokemonInterface{

	public Pokemon createPokemon(String nameGiven, int healthGiven, String typeGiven) {
		Pokemon created = new Pokemon(nameGiven, healthGiven, typeGiven);
		return created;
	}
	
	public void attackPokemon(Pokemon pokemonAttacked) {
		
		//Before attack
		int befAttack = pokemonAttacked.getHealth();
		System.out.println("Attacked a pokemon! It has " + befAttack + "health.");
		
		//After attack
		int currHealth = pokemonAttacked.getHealth();
		pokemonAttacked.setHealth(currHealth-10);

		System.out.println("It now has " + currHealth + " health.");
	}
	
	public abstract String pokemonInfo(Pokemon pokemon);
	
}
