package com.shahan.objectmaster;

public class Wizard extends Human{
	
	public Wizard() {
		health = 50;
		intelligence = 8;
	}
	
	public void heal(Human humanHealed) {
		System.out.println("Healing human by " + this.intelligence + " health.");
		humanHealed.health += this.intelligence;
	}
	
	public void fireball(Human humanAttacked) {
		System.out.println("Attacking human with a deadly fireball... health - " + this.intelligence*3);
		humanAttacked.health -= this.intelligence*3;
	}
}
