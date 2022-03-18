package com.example.pawsforperfection;

public class Pet {
    private String name;
    private double weight;
    private String specialInstructions;
    private String breed;

    public Pet(String name, double weight, String specialInstructions, String breed) {
        this.name = name;
        this.weight = weight;
        this.specialInstructions = specialInstructions;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
