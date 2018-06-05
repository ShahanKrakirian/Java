package zookeeperpackage;

public class Mammal {
	
	public int energyLevel = 100;
	
	//Constructor
	public Mammal() {}
	
	public int displayEnergy() {
		System.out.println("Current energy level: " + energyLevel);
		return energyLevel;
	}
}
