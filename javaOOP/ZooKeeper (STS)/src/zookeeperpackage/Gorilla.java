package zookeeperpackage;

public class Gorilla extends Mammal{
	
	//Constructor
	public Gorilla() {}
	
	public Gorilla throwSomething() {
		System.out.println("Threw a pebble to display masculinity. -5 Energy.");
		this.energyLevel -= 5;
		return this;
	}
	
	public Gorilla eatBananas() {
		System.out.println("MMMmmmmm. Tastes like chicken. Wait...........     +10 Energy.");
		this.energyLevel += 10;
		return this;
	}
	
	public Gorilla climb() {
		System.out.println("Expended energy to reach a higher elevation on some arbitrary surfaces that allowed for a mildly safe ascent. -10 Energy.");
		this.energyLevel -= 10;
		return this;
	}
}
