package edu.soravic.Assign06;

public class Ent extends Tree {
    public Ent()
    {

    }
    
    public Ent(String name)
    {
        super(name);
    }
    public String toString()
    {
        String n = "Ent "+ super.toString();
        return n;
    }
    public String speak()
    {
        return "HOOM";
    }
    
}
