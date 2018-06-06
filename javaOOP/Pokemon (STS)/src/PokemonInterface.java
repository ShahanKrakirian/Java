package com.shahan.pokemon;

public interface PokemonInterface {
	
	Pokemon createPokemon(String name, int health, String type);
	
	void attackPokemon(Pokemon attackedPokemon);
	
	String pokemonInfo(Pokemon specificPokemon);
}
