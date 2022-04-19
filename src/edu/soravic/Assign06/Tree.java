package edu.soravic.Assign06;

public class Tree extends Giant {
    public Tree()
    {

    }

    public Tree (String name){
        super(name);
    }

    public String toString()
    {
    String n = super.toString() + " of the trees";
    return n;
    }



    public String speak()
    {
        return "<rustling>";
    }
}
