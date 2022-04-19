package edu.soravic.Assign07;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class TreasureMap extends CharImage{
    int row;
    int col;

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
            int nRow=0;
            int nCol=0;
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
                for(int j = minCol; j <= maxCol; j++)
                {
                    setPos(i,j,'.');
                }
            }

            setCurRow(nRow);
            setCurCol(nCol);
            order.close();
        }
        catch(Exception e)
        {
            new TreasureMapException("YE CANNOT MOVE SO!", e);
        }
    }


    public void loadInstructions(String filename) throws TreasureMapException{
        try{
            
            Scanner in = new Scanner(new File(filename));
            while(in.hasNextLine())
            {
                String a = in.nextLine();
                parseDirection(a);
            }
            in.close();
            setPos(row, col,'x');
        }
        catch(Exception e)
        {
            clear();
            new TreasureMapException("YE CANNOT READ THIS MAP!", e);
        }
    }

    public void saveMap(String filename) throws TreasureMapException{
        try{
            PrintWriter file = new PrintWriter(new File(filename));
            file.print(getMapString());
            file.close();
        }
        catch (Exception e)
        {
            new TreasureMapException("SUCH TREASURE NEED BE SECRET!", e);
        }
    }

}




