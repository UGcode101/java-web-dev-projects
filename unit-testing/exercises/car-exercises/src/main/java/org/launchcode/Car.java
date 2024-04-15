package org.launchcode;

public class Car {
    private String make;
    private String model;
    private int gasTankSize;
    private double gasTankLevel;
    private double milesPerGallon;
    private double odometer = 0;

    public Car(String make, String model, int gasTankSize, double milesPerGallon) {
        this.make = make;
        this.model = model;
        this.gasTankSize = gasTankSize;
        // Gas tank level defaults to a full tank
        this.gasTankLevel = gasTankSize;
        this.milesPerGallon = milesPerGallon;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGasTankSize() {
        return gasTankSize;
    }

    public void setGasTankSize(int gasTankSize) {
        this.gasTankSize = gasTankSize;
    }

    public double getGasTankLevel() {
        return gasTankLevel;
    }

    public void setGasTankLevel(double gasTankLevel) {
        if (gasTankLevel > this.gasTankSize) {
            throw new IllegalArgumentException("Gas tank level cannot exceed tank size.");
        }
        this.gasTankLevel = gasTankLevel;
    }

    public double getMilesPerGallon() {
        return milesPerGallon;
    }

    public void setMilesPerGallon(double milesPerGallon) {
        this.milesPerGallon = milesPerGallon;
    }

    public double getOdometer() {
        return odometer;
    }

    /**
     * Drive the car for a specified number of miles. If there isn't enough fuel, drive as far as the remaining fuel allows.
     * Update the fuel level accordingly and add the actual miles driven to the odometer.
     *
     * @param miles - the number of miles to drive
     */
    public void drive(double miles) {
        double maxDistance = this.milesPerGallon * this.gasTankLevel;
        double milesAbleToTravel = miles > maxDistance ? maxDistance : miles;
        double gallonsUsed = milesAbleToTravel / this.milesPerGallon;
        this.gasTankLevel -= gallonsUsed;
        this.odometer += milesAbleToTravel;
    }

    /**
     * Add gas to the car's tank.
     *
     * @param gallons - the amount of gas in gallons to add to the tank
     */
    public void addGas(int gallons) {
        if (gallons < 0) {
            throw new IllegalArgumentException("Cannot add a negative amount of gas.");
        }
        if (this.gasTankLevel + gallons > this.gasTankSize) {
            throw new IllegalArgumentException("Attempting to add more gas than the tank can hold.");
        }
        this.gasTankLevel += gallons;
    }
}

