package com.shahan.phone;

public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
    	String currVersionNumber = this.getVersionNumber();
        String currRingTone = this.getRingTone();
        return "Galaxy " + currVersionNumber + " says " + currRingTone;
    }
    @Override
    public String unlock() {
        return "Unlocking via fingerprint";
    }
    @Override
    public void displayInfo() {
    	String currVersionNumber = this.getVersionNumber();
        String currCarrier = this.getCarrier();
        System.out.println("Galaxy " + currVersionNumber + " from " + currCarrier);    
    }
}

