package com.shahan.pokemon;

public class Pokedex extends AbstractPokemon{
	
	public Pokedex() {};

	@Override
	public String pokemonInfo(Pokemon pokemon) {
		
		//Get info
		String currName = pokemon.getName();
		int currHealth = pokemon.getHealth();
		String currType = pokemon.getType();
		
		return "Pokemon Name: " + currName + " Health: " + currHealth + " Type: " + currType;
	}
	
}
