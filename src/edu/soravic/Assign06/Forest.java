package edu.soravic.Assign06;
import java.util.ArrayList;

public class Forest {
    ArrayList <Giant> gi = new ArrayList<>();
    public Giant createGiant(String name, String typeName)
    {
        if (name.length() == 0)
        {
            return null;
        }
        switch(typeName){
            case "GIANT": typeName = "GIANT";
                 Giant g = new Giant(name);
                 return g;
            case "TROLL": typeName = "TROLL";
                 Troll tr = new Troll(name);
                 return tr;
            case "TREE": typeName = "TREE";
                 Tree t = new Tree(name);
                 return t;
            case "ENT": typeName = "ENT";
                Ent e = new Ent(name);
                return e;
            case "HUORN": typeName = "HUORN";
                Huorn h = new Huorn(name);
                return h;
            default: typeName = "INVALID NAME";
                return null;
            }        
        
    }
    public boolean addGiant(String name, String nameType)
    {
        createGiant(name, nameType);
        boolean val = true;
        if(createGiant(name,nameType) != null)
        {
            gi.add(createGiant(name,nameType));
            val = true;
        }
        else
        {
            val = false;
        }

        return val;
        
    }

    public Giant getGiant(int index)
    {
        Giant gia = new Giant();
        if(index >= 0 && index < gi.size())
        {
            gia = gi.get(index);
        }
        else{
            gia = null;
        }
        return gia;
    }

    public void printAllGiants() {
        System.out.println("ALL GIANTS:");
        for (Giant x: gi) {
            System.out.println("- " + x.toString());
        }
    }

    public void printAllTrees()
    {
        System.out.println("ALL TREES:");
        for (Giant x: gi) 
        {
            if(x instanceof Tree)
            {
                System.out.println("- " + ((Tree)x).toString() + ": "+ ((Tree)x).speak());
            }
        }
    }

    public void printAllTrolls()
    {
        System.out.println("ALL TROLLS:");
        for (Giant x: gi) {
            if(x instanceof Troll)
            {
                System.out.println("- " + ((Troll)x).toString() + ": "+ ((Troll)x).cook());
            }
        }
    }
}




