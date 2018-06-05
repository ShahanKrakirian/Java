package zookeeperpackage;

public class Bat extends Mammal{
	
	//Constructor
	public Bat() {
		energyLevel = 300;
	}
	
	public Bat fly() {
		System.out.println("WHOOOOOOOOOSH. Lost 50 energy.");
		this.energyLevel -= 50;
		return this;
	}
	
	public Bat eatHumans() {
		System.out.println("What did the bat say to the human? Nothing, it was chewing him. +25 Energy.");
		this.energyLevel += 25;
		return this;
	}
	
	public Bat attackTown() {
		System.out.println("Towns don't taste as good. I mean, fire!");
		this.energyLevel -= 100;
		return this;
	}
	
}
