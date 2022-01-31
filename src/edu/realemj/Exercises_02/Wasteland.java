package edu.realemj.Exercises_02;

public class Wasteland {
    public static void main(String [] args) {
        NPC bob = new NPC();
        NPC sue = new NPC(93, 61, 'F');
        // CAN'T DO THIS: NPC joe = new NPC(56, 34);

        bob.setHealth(70);
        int bh = bob.getHealth();
        System.out.println(bh);

        // Person <-- Human <-- NPC
        //Person p = new NPC();
        //p = new Human();
        // LOTS OF CODE LATER...
        //if(p instanceof NPC) {
        //    NPC n = (NPC)p;
        //}
        

    }    
}
