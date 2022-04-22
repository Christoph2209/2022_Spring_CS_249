package edu.soravic.Assign07;
import java.io.*;
import java.util.*;

public class TreasureMap extends CharImage{
    private int curRowCnt;
    private int curColCnt;

    public TreasureMap(int rowCnt, int colCnt, char fillChar)
    {
        super(rowCnt,colCnt,fillChar);
    }

    public void clear()
    {
        curRowCnt = 0;
        curColCnt = 0;
        super.clear();
    }

    public int getCurRow(){
        return curRowCnt;
    }

    public int getCurCol(){
        return curColCnt;
    }

    public void setCurRow(int nrow){
        curRowCnt = nrow;
    }

    public void setCurCol(int ncol){
        curColCnt = ncol;
    }

    public void parseDirection(String dirLine) throws TreasureMapException
    {
        try {

            Scanner input = new Scanner(dirLine);
    
            String direction = input.next();
            int offset = input.nextInt();
            int endRow = 0;
            int endCol = 0;
    
            switch (direction) {
                case "north":   endRow = curRowCnt - offset;
                                break; 
                case "south":   endRow = curRowCnt + offset;
                                break;
                case "west":    endCol = curColCnt - offset;
                                break;
                case "east":    endCol = curColCnt + offset;
                                break;
                default:        input.close();
                throw new TreasureMapException("BAD COMMAND!");

            }
            input.close();
            setCurRow(endRow);
            setCurCol(endCol);
            setPos(endRow, endCol, '.');
            }
            catch(Exception e) {
                throw new TreasureMapException("YE CANNOT MOVE SO!");
            }
        }



        public void loadInstructions(String filename) throws TreasureMapException {
            try {
                Scanner read = new Scanner(new File(filename));
    
                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    parseDirection(line);
                }
            setPos(getCurRow(), getCurCol(), 'X');
            read.close();
        }
            catch (Exception e) {
                clear();
                new TreasureMapException("YE CANNOT READ THIS MAP!", e);
            }
        }
    
        public void saveMap(String filename) throws TreasureMapException {
            try {
                PrintWriter writer = new PrintWriter(filename);
                writer.print(getMapString());
    
                writer.close();
    
            }
            catch (Exception e) {
                new TreasureMapException("SUCH TREASURE NEEDS BE SECRET!", e);
            }
        }

}




