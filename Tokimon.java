package com.cmpt213.tokimon;



public class Tokimon {
    private String name;
    private String type;
    private float height;
    private float weight;
    private int strength;

    public Tokimon(String name, String type, float height, float weight) {
        this.name = name;
        this.type = type;
        this.height = height;
        this.weight = weight;
    }

    public String toString(){
        return getClass().getName() +  "[Name:" + name + ", Type:" + type + ", Height:" + height + ", Weight:" + weight + ", Strength:" + strength + "]";
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}