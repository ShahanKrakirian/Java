package com.shahan.pets.models;

public class Dog extends Animal implements Pet{
	
	public Dog(String name, String breed, int weight) {
		super(name, breed, weight);
	}

	public String showAffection() {
		
		String currName = this.getName();
		int currWeight = this.getWeight();
		
		if (currWeight < 30) {
			return currName + " hopped into your lap and cuddled with you!";
		}
		else {
			return currName + " curled up next to you!";
		}
	}
	
}
