package edu.soravic.Assign06;

public class Troll extends Giant {

    public Troll ()
    {

    }

    public Troll(String name)
    {
        super(name);
    }
    public String toString()
    {
        String n = "Troll " + super.toString();
        return n;
    }
    public String cook()
    {
        return "Mutton again...";
    }


}
