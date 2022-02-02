package edu.realemj.Exercises_02;

public class NPC {
    private int health;
    private int strength;
    private char relationship;
    
    public NPC() {
        health = 100;
        strength = 50;
        relationship = 'N';
    }

    public NPC(int h, int s, char r) {
        //health = h;
        setHealth(h);
        strength = s;
        relationship = r;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int h) {
        health = h;
        //if(health < 0) {
        //    health = 0;
        //}
        health = Math.max(0, health);
    }
    
}
