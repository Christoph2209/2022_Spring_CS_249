package edu.soravic.Assign06;

public class Huorn extends Tree {
    public Huorn()
    {

    }

    public Huorn(String name)
    {
        super(name);
    }
    public String toString()
    {
        String n = "Huorn " + super.toString();
        return n;
    }

    public String speak()
    {
        return "<angry rustling>";
    }
}
