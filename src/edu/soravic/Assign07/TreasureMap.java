package edu.soravic.Assign07;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class TreasureMap extends CharImage{
    private int row;
    private int col;

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

    public void setCurRow(int nrow){
        row = nrow;
    }

    public void setCurCol(int ncol){
        col = ncol;
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
                    break;
                case "south" : dir = "south";
                    nRow = row + amount;
                    break;
                case "west" : dir = "west";
                    nCol = col - amount;
                    break;
                case "east" : dir = "east";
                    nCol = col + amount;
                    break;
                default: dir = "BAD COMMAND!";
                    break;
            }
            int minRow = row - nRow;
            int maxRow = row + nRow;
            int minCol = col - nCol;
            int maxCol = col + nCol;
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




