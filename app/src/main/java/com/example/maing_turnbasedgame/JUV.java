package com.example.maing_turnbasedgame;

public class JUV {
    private int b_health = 1000;
    private int b_mana = 50;
    private int health = 1000;
    private int mana = 50;
    private int minDamage = 75;
    private int maxDamage = 100;
    private int skilldamage =300;

    public JUV(){}

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }
    public int getMana() { return mana; }
    public void setMana(int mana) { this.mana = mana; }
    public int getMinDamage() { return minDamage; }
    public int getMaxDamage() { return maxDamage; }
    public int getSkilldamage() { return skilldamage; }
    public void reset() { health = b_health; mana = b_mana;}
}
