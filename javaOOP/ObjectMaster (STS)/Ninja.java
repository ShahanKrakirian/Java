package com.shahan.objectmaster;

public class Ninja extends Human{
	
	public Ninja() {
		health = 10;
	}
	
	public void steal(Human theftFrom) {
		System.out.println("Stealing health from another human...");
		this.health += this.stealth/2;
		theftFrom.health -= this.stealth/2;
	}
	
	public void runAway() {
		System.out.println("Running away hurts your pride. -10 Health.");
		this.health -= 10;
	}
}
