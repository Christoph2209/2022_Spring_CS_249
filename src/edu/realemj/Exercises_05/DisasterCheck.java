package edu.realemj.Exercises_05;

public class DisasterCheck {
    public static void main(String [] args) {
        Disaster disaster = Disaster.WAGON_AXLE_BROKEN;

        if(disaster == Disaster.LOST_FOOD) {
            System.out.println("We're going to STARVE!");
        }

        
        // ORIGINAL SYNTAX
        switch(disaster) {
            case LOST_FOOD:                
                System.out.println("No food!");
                break;
            case CHOLERA:
            case DYSENTERY: 
                System.out.println("You're sick!");
                break;
            case WAGON_AXLE_BROKEN:
            case WAGON_WHEEL_BROKEN: 
                System.out.println("Can't move!");
                break;
            default:
                System.out.println("All good!");
                break;
        }

        // NEW SYNTAX
        switch(disaster) {
            case LOST_FOOD -> System.out.println("No food!");              
            case CHOLERA, DYSENTERY -> System.out.println("You're sick!");            
            case WAGON_AXLE_BROKEN, WAGON_WHEEL_BROKEN -> {
                System.out.println("Can't move!");
                System.out.println("Wagon busted!");
            }
            default -> System.out.println("All good!");                
        }   
        
        // SWITCH EXPRESSION
        int totalFood = 100;
        boolean canMove = true;

        String statusReport = switch(disaster) {
            case LOST_FOOD -> {
                totalFood -= 10;
                yield "Lost food! Total food is now " + totalFood;
            }
            case CHOLERA, DYSENTERY -> "You're sick!";
            case WAGON_AXLE_BROKEN, WAGON_WHEEL_BROKEN -> {
                canMove = false;
                yield "Wagon broken!";
            }
            default -> "All good!";
        };

        System.out.println("STATUS: " + statusReport);
        //System.out.println("Can move? " + canMove);
        System.out.println(canMove ? "Can move!" : "We're stuck!");
    }
    
}
