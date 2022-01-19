package myPackage.exam.colections;

import java.util.UUID;

public class Car {
    private boolean isExclusive; //true or false
    private int yearOfProduction; // eg 2021, 2015 etc
    private int levelOfEquipment; // 3 > 2 > 1, higher then better
    private UUID id;
    private double value; // how much does it cost for client

    public Car(boolean isExclusive, int yearOfProduction, int levelOfEquipment, UUID id, double value){
        this.isExclusive = isExclusive;
        this.yearOfProduction = yearOfProduction;
        this.levelOfEquipment = levelOfEquipment;
        this.id = id;
        this.value = value;
    }

    public boolean isExclusive() {
        return isExclusive;
    }

    public void setExclusive(boolean exclusive) {
        isExclusive = exclusive;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getLevelOfEquipment() {
        return levelOfEquipment;
    }

    public void setLevelOfEquipment(int levelOfEquipment) {
        this.levelOfEquipment = levelOfEquipment;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return String.format("Is exclusive: %s; Year of the production: %s; Level of equipment: %s; Id: %s; Value: %s",
                isExclusive(), getYearOfProduction(), getLevelOfEquipment(), getId(), getValue());
    }

    //todo dodaj wszystkie brakujące metody do klasy aby móc jej używać w zadaniu Task2

}
