package edu.soravic.Assign04;

public class BusinessCard{
    private String business;
    private String [] lines;
    private char bound;

    public BusinessCard(String name, String [] sloganLines, char boundaryChar)
    {
        business = name;
        setSlogan(sloganLines);
        bound = boundaryChar;
    }
    public String getName()
    {
        return business;
    }
    public char getBoundaryChar()
    {
        return bound;
    }
    public String getSlogan()
    {
        String slogan = "";
        for(int i = 0; i < lines.length; i++)
        {
            slogan += lines[i] + "\n";
        }
        return slogan;
    }
    public void setName(String name)
    {
        business = name;
    }

    public void setBoundaryChar(char boundaryChar)
    {
        bound = boundaryChar; 
    }

    public void setSlogan(String [] sloganLines)
    {
        lines = new String[sloganLines.length];
        for(int i = 0; i < sloganLines.length; i++)
            lines[i] = sloganLines[i];
    }

    private String row (char boundary) {
        String s = "";
        for (int i=0;i < 42; i++) {
            s += boundary;
        }

        return s;
    }

    private String addSpace() {
        String s = " ";

        return s;
    }

    public String toString() {
        String finishCard = "";
        char boundary = bound;
        int counter = 0;

            //first line of card
            finishCard += row(boundary) + "\n";

            //second line of card
            finishCard +=boundary + " " + business;
            for (int i=0; i< 39-business.length();i++) {
                finishCard += " ";
            }

            //third line of card
            finishCard += boundary + "\n" + boundary ;
            for (int i=0; i< 40;i++) {
                finishCard += " ";
            }
                        
            //4,5,6,7 line of for the slogan
            for (int i=0; i < lines.length;i++) {
                finishCard += boundary + "\n" + boundary + " " + lines[i];
                    for (int j=0; j < 39-lines[i].length();j++) {
                        finishCard += addSpace();
                    }
                    counter++;
            }
            while (counter != 4) {
                finishCard += boundary + "\n" + boundary + " ";
                for (int i=0; i < 39;i++) {
                    finishCard += addSpace();
                }
                counter++;
            }

            finishCard += boundary + "\n";

            //eigth line of card
            finishCard += row(boundary) + "\n";

        return finishCard;
    }
}

