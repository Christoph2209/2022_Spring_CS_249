package edu.soravic.Assign08;

public class GameFileException extends Exception {
    public GameFileException(String message){
        super(message);
    }    
    public GameFileException(String message, Exception e){
        super(message, e);
    }
}
