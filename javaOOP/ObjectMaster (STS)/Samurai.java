package com.shahan.objectmaster;

public class Samurai extends Human{
	public static int howManySamurai = 0;

	public Samurai() {
		health = 200;
		howManySamurai += 1;
	}
	
	public void deathBlow(Human attackedHuman) {
		System.out.println("A wild blow by the samurai's eyelash is too much for the human to bear.");
		attackedHuman.health = 0;
	}
	
	public void meditate() {
		System.out.println("A calm mind is a calm soul. Plus half current health.");
		this.health += this.health/2;
	}
	
	public void howMany() {
		System.out.println("Total number of samurai: " + howManySamurai);
	}
}
