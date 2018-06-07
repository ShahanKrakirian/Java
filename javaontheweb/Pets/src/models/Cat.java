package com.shahan.pets.models;

public class Cat extends Animal{

	public Cat(String name, String breed, int weight) {
		super(name, breed, weight);
	}
	
	public String showAffection() {
		
		String currName = this.getName();
		String currBreed = this.getBreed();
		
		return "Your " + currBreed + " cat, " + currName + ", looked at you with some affection. You then realize it's lunchtime.";
	}

}
