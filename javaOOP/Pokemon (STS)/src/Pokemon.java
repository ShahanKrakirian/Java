package com.shahan.pokemon;

public class Pokemon {
	private static int pokemonCount = 0;
	private String name;
	private int health; 
	private String type;
	
	//Constructor 
	public Pokemon(String nameGiven, int healthGiven, String typeGiven) {
		name = nameGiven;
		health = healthGiven;
		type = typeGiven;
		pokemonCount += 1;
	}

	public static void setPokemonCount(int pokemonCount) {
		Pokemon.pokemonCount = pokemonCount;
	}

	//Getters
	public static int getPokemonCount() {
		return pokemonCount;
	}
	
	public String getName() {
		System.out.println("Name: " + name);
		return name;
	}
	
	public int getHealth() {
		System.out.println("Current health: " + health);
		return health;
	}
	
	public String getType() {
		System.out.println("Type: " + type);
		return type;
	}
	
	//Setters
	public void setName(String newName) {
		System.out.println("Changing name from " + name + " to " + newName);
		name = newName;
	}
	
	public void setHealth(int newHealth) {
		System.out.println("Changing health from " + health + " to " + newHealth);
		health = newHealth;
	}
	
	public void setType(String newType) {
		System.out.println("Changing type from " + type + " to " + newType);
		type = newType;
	}
	
}
