package edu.soravic.Assign05;

public class CharImage {
    private int rowCnt;
    private int colCnt;
    private char fillChar;
    private char charArr[][];    
    



    public CharImage (int rowCnt, int colCnt, char fillChar) {

        this.rowCnt = rowCnt;
        this.colCnt = colCnt;
        this.fillChar = fillChar;

        charArr = new char[rowCnt][colCnt];

        for (int i =0;i < rowCnt;i++) {
            for (int j=0; j < colCnt;j++) {
                charArr[i][j] = fillChar;
            }
        }
    }

    public void clear() {
        for (int i =0;i < rowCnt;i++) {
            for (int j=0; j < colCnt;j++) {
                charArr[i][j] = fillChar;
            }
        }
    }

    public int getRowCnt() {
        return rowCnt;
    }

    public int getColCnt() {
        return colCnt;
    }

    public boolean isValidPosition(int row, int col) {
        boolean test;

        if ((row >= 0 && row < rowCnt) && (col >= 0 && col < colCnt)){
            test = true;
        }
        else {
            test = false;
        }

        return test;
    }

    public char getPos(int row, int col) {
        char pos;

        if ((row >= 0 && row < rowCnt) && (col >= 0 && col < colCnt)){
            pos = charArr[row][col];
        }
        else {
            pos = ' ';
        }

        return pos;
    }

    public boolean setPos (int row, int col, char c) {
        if ((row >= 0 && row < rowCnt) && (col >= 0 && col < colCnt)) {
            charArr[row][col] = c;
            return true;
        }
        else{
            return false;
        }

    }

    public String toString () {
        String s;

        s = rowCnt + " x " + colCnt + " CharImage (default: " + fillChar + ")";
        return s;
    }

    public String getMapString() {
        String s = "";

        for (int i=0; i < rowCnt;i++) {
            for ( int j=0; j < colCnt;j++) {
                s += charArr[i][j];
            }
            s += "\n";
        }

        return s;
    }
    
}