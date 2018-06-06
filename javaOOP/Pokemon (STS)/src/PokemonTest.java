package com.shahan.pokemon;

public class PokemonTest {

	public static void main(String[] args) {
		
		Pokedex pokedex = new Pokedex();
		
		Pokemon pokemon1 = pokedex.createPokemon("Charmander", 40, "Fire");
		Pokemon pokemon2 = pokedex.createPokemon("Bulbasaur", 50, "Grass");
		Pokemon pokemon3 = pokedex.createPokemon("Squirtle", 45, "Water");
		
		pokedex.attackPokemon(pokemon1);
		pokedex.attackPokemon(pokemon2);
		pokedex.attackPokemon(pokemon3);
		
		pokedex.pokemonInfo(pokemon1);
		pokedex.pokemonInfo(pokemon2);
		pokedex.pokemonInfo(pokemon3);

	}

}
