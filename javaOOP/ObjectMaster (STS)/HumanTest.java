package com.shahan.objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		Human human1 = new Human();
		Human human2 = new Human();
		
		human1.attack(human2);
		System.out.println("Resulting health: " + human2.health);
		
		Samurai sam1 = new Samurai();
		Samurai sam2 = new Samurai();
		
		sam1.howMany();
		sam2.meditate();
		
		System.out.println("Sam2 health: " + sam2.health);
		
		sam1.deathBlow(sam2);
		System.out.println("Sam2 health after death blow: " + sam2.health);
		
		Wizard wiz1 = new Wizard();
		Wizard wiz2 = new Wizard();

		System.out.println("Wiz2 health before fireball: " + wiz2.health);
		wiz1.fireball(wiz2);
		System.out.println("Wiz2 health after fireball: " + wiz2.health);
		wiz2.heal(wiz2);
		System.out.println("Wiz2 health after heal: " + wiz2.health);
	}
}
