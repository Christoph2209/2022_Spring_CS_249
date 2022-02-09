package edu.realemj.Exercises_06;

public class Supplies {
    private int totalFood = 0;
    private int totalBullets = 0;
    private int totalAxles = 0;

    public int getTotalFood() { return totalFood; }
    public int getTotalBullets() { return totalBullets; }
    public int getTotalAxles() { return totalAxles; }

    public void setTotalFood(int food) { 
        totalFood = food; 
    }
    public void setTotalBullets(int bullets) {
        totalBullets = bullets;
    }
    public void setTotalAxles(int axles) {
        totalAxles = axles;
    }

    public void addFood(int food) {
        food = Math.max(0, food);
        totalFood += food;
    }

    public void addBullets(int bullets) {
        bullets = Math.max(0, bullets);
        totalBullets += bullets;
    }

    public void addAxles(int axles) {
        totalAxles += Math.max(0, axles);
    }

    public String toString() {
        String s = "";
        s += "** SUPPLIES **" + "\n";
        s += "Food: " + totalFood + "\n";
        s += "Bullets: " + totalBullets + "\n";
        s += "Axles: " + totalAxles + "\n";
        return s;
    }
    
}
