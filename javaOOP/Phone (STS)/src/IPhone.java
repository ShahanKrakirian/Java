package com.shahan.phone;

public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
    	String currVersionNumber = this.getVersionNumber();
        String currRingTone = this.getRingTone();
        return "iPhone" + currVersionNumber + " says " + currRingTone;
    }
    @Override
    public String unlock() {
        return "Unlocking via facial recognition";
    }
    @Override
    public void displayInfo() {
        String currVersionNumber = this.getVersionNumber();
        String currCarrier = this.getCarrier();
        System.out.println("iPhone " + currVersionNumber + " from " + currCarrier);
    }
}

