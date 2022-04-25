package edu.soravic.Assign08;
import java.io.*;
import java.util.*;

public class Item implements Loadable{
    protected String ID = "";
    protected int value = 0;
    public Item()
    {
        ID = "";
        value = 0;
    }

    public Item(String ID, int value){
        this.ID = ID;
        this.value = value;
    }


    public String getID(){
        return ID;
    }

    public int getValue(){
        return value;
    }
    public void setID(String id){
        ID = id;
    }
    public void setValue(int val){
        value = val;
    }

    public String toString()
    {
        String ret = ID + " with value " + value;
        return ret;
    }
    

    public void load(Scanner input) throws GameFileException{
        try{
            ID = input.nextLine();
            value = input.nextInt();
        }
        catch(Exception e){
            setID("");
            setValue(0);
            throw new GameFileException("Error loading Item",e);
        }

    }
}
