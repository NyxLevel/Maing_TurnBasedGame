package com.example.maing_turnbasedgame;

public class GRF {
    private int b_health = 2000;
    private int b_mana = 10;
    private int health = 2000;
    private int mana = 10;
    private int minDamage = 100;
    private int maxDamage = 125;

    public GRF(){}

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }
    public int getMana() { return mana; }
    public int getMinDamage() { return minDamage; }
    public int getMaxDamage() { return maxDamage; }
    public void reset() { health = b_health; mana = b_mana;}
}
