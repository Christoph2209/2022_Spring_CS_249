package edu.soravic.Assign07;
import java.io.PrintWriter;
import java.util.*;

public class TreasureMap extends CharImage{
    protected int row;
    protected int col;

    public TreasureMap(int rowCnt, int colCnt, char fillChar)
    {
        super(rowCnt,colCnt,fillChar);
    }

    public void clear()
    {
        row = 0;
        col = 0;
        super.clear();
    }

    public int getCurRow(){
        return row;
    }

    public int getCurCol(){
        return col;
    }

    public void setCurRow(int row){
        this.row = row;
    }

    public void setCurCol(int col){
        this.col = col;
    }

    public void parseDirection(String dirLine) throws TreasureMapException
    {
        try{
            Scanner order = new Scanner(dirLine);
            String dir = order.next();
            int amount = order.nextInt();
            int nRow=0
            int nCol=0
            switch(dir){
                case "north" : dir = "north";
                    nRow = row - amount;
                case "south" : dir = "south";
                    nRow = row + amount;
                case "west" : dir = "west";
                    nCol = col - amount;
                case "east" : dir = "east";
                    nCol = col + amount;
                default: dir = "BAD COMMAND!";
            }
            int minRow = row - amount;
            int maxRow = row + amount;
            int minCol = col - amount;
            int maxCol = col + amount;
            for (int i = minRow; i <= maxRow; i++)
            {

            }

            setPos(row, col, '.');
            order.close();
        }
        catch(Exception e)
        {
            throw new TreasureMapException("YE CANNOT MOVE SO!", e);
        }
    }


    public void loadInstructions(String filename) throws TreasureMapException{
        try{
            Scanner file = new Scanner(filename);
            while(file.hasNextLine())
            {
                String a = file.nextLine();
                parseDirection(a);
            }
            file.close();
            setPos(row, col,'x');
        }
        catch(Exception e)
        {
           clear();
           throw new TreasureMapException("YE CANNOT READ THIS MAP!", e);
        }
    }

    public void saveMap(String filename) throws TreasureMapException{
        try{
            PrintWriter file = new PrintWriter(filename);
            file.print(getMapString());
            file.close();
        }
        catch (Exception e)
        {
            throw new TreasureMapException("SUCH TREASURE NEED BE SECRET!", e);
        }
    }

}




