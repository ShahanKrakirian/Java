package com.shahan.objectmaster;

public class Human {
	protected int strength; 
	protected int intelligence;
	protected int stealth;
	protected int health;
	
	public Human() {
		strength = 3;
		stealth = 3;
		intelligence = 3;
		health = 100;
		}
	
	public void attack(Human personAttacked) {
		System.out.println("Attacking another human with " + this.strength + " strength.");
		personAttacked.health -= this.strength;
	}
	
	
}
