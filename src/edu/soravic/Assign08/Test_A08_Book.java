package edu.soravic.Assign08;
//NOTE: CHANGE realemj to YOUR SITNETID!!!
import edu.soravic.Testing.GeneralTesting;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Test_A08_Book {

    @Test()
    public void testInheritsItem() {
        Book item = new Book();
        Assert.assertTrue(item instanceof Item);
    }

    @Test()
    public void testConstructorAndData() {
        // No-arg
        Book item = new Book();
        Assert.assertEquals(item.getID(), "");
        Assert.assertEquals(item.getValue(), 0);
        Assert.assertEquals(item.getSkill(), "");

        // Arg constructor
        item = new Book("BARNACLES", 1560, "programming");
        Assert.assertEquals(item.getID(), "BARNACLES");
        Assert.assertEquals(item.getValue(), 1560);
        Assert.assertEquals(item.getSkill(), "programming");
    }

    @Test()
    public void testGetSetID() {
        Book item1 = new Book("BOB", 197, "cooking");
        Book item2 = new Book("JOE", 903, "flying");
        Assert.assertEquals(item1.getID(), "BOB");
        Assert.assertEquals(item2.getID(), "JOE");

        item1.setID("FRANK");
        item2.setID("WILLIAM");
        Assert.assertEquals(item1.getID(), "FRANK");
        Assert.assertEquals(item2.getID(), "WILLIAM");
    }

    @Test()
    public void testGetSetValue() {
        Book item1 = new Book("TEST", 197, "dancing");
        Book item2 = new Book("TEST", 903, "singing");
        Assert.assertEquals(item1.getValue(), 197);
        Assert.assertEquals(item2.getValue(), 903);

        item1.setValue(345);
        item2.setValue(724);
        Assert.assertEquals(item1.getValue(), 345);
        Assert.assertEquals(item2.getValue(), 724);
    }

    @Test()
    public void testGetSetSkill() {
        Book item1 = new Book("BOB", 197, "yodeling");
        Book item2 = new Book("JOE", 903, "courage");
        Assert.assertEquals(item1.getSkill(), "yodeling");
        Assert.assertEquals(item2.getSkill(), "courage");

        item1.setSkill("gardening");
        item2.setSkill("skiing");
        Assert.assertEquals(item1.getSkill(), "gardening");
        Assert.assertEquals(item2.getSkill(), "skiing");
    }

    @Test()
    public void testToString() {
        Book item1 = new Book("FORK", 197, "karate");
        Book item2 = new Book("SPOON", 903, "poetry");

        Assert.assertEquals(item1.toString(), "FORK with value 197, enhances karate");
        Assert.assertEquals(item2.toString(), "SPOON with value 903, enhances poetry");

        item1.setID("FRANK");
        item2.setID("WILLIAM");
        item1.setValue(345);
        item2.setValue(724);
        item1.setSkill("gardening");
        item2.setSkill("skiing");

        Assert.assertEquals(item1.toString(), "FRANK with value 345, enhances gardening");
        Assert.assertEquals(item2.toString(), "WILLIAM with value 724, enhances skiing");
    }

    @Test()
    public void testImplementsLoadable() {
        Book thing = new Book();
        Assert.assertTrue(thing instanceof Loadable);
    }

    @Test()
    public void testRead() {
        Book thing = new Book();
        thing.setSkill("gardening");

        // Start redirect
        GeneralTesting.StreamPack.getInstance().start("");
        thing.read();
        GeneralTesting.OutPack programOutput = GeneralTesting.StreamPack.getInstance().stop();

        // Compare to correct result
        Assert.assertEquals(programOutput,
                new GeneralTesting.OutPack(
                        "Skill gardening increased!\n",
                        ""));

        // Try another
        thing.setSkill("skiing");

        // Start redirect
        GeneralTesting.StreamPack.getInstance().start("");
        thing.read();
        programOutput = GeneralTesting.StreamPack.getInstance().stop();

        // Compare to correct result
        Assert.assertEquals(programOutput,
                new GeneralTesting.OutPack(
                "Skill skiing increased!\n",
                        ""));
    }

    @Test()
    public void testLoad() {
        // Good load
        Scanner input = new Scanner("CHRISTMAS_TREE 97 cheer");
        Book thing = new Book();
        boolean allGood = true;
        try {
            thing.load(input);
        }
        catch(Exception e) {
            allGood = false;
        }

        Assert.assertTrue(allGood, "Should NOT throw exception!");
        Assert.assertEquals(thing.getID(), "CHRISTMAS_TREE");
        Assert.assertEquals(thing.getValue(), 97);
        Assert.assertEquals(thing.getSkill(), "cheer");

        // Bad load
        input = new Scanner("CHRISTMAS_TREE");
        allGood = true;
        try {
            thing.load(input);
        }
        catch(Exception e) {
            allGood = false;
            Assert.assertTrue(e instanceof GameFileException);
            Assert.assertEquals(e.getMessage(), "Error loading Book");
            Assert.assertNotNull(e.getCause());

            Assert.assertEquals(thing.getID(), "");
            Assert.assertEquals(thing.getValue(), 0);
            Assert.assertEquals(thing.getSkill(), "");
        }

        Assert.assertFalse(allGood, "SHOULD throw exception!");

        // Another bad load
        thing.setID("BARNACLES");
        thing.setValue(567);
        thing.setSkill("skiing");
        input = new Scanner("CHRISTMAS_TREE LOTS");
        allGood = true;
        try {
            thing.load(input);
        }
        catch(Exception e) {
            allGood = false;
            Assert.assertTrue(e instanceof GameFileException);
            Assert.assertEquals(e.getMessage(), "Error loading Book");
            Assert.assertNotNull(e.getCause());

            Assert.assertEquals(thing.getID(), "");
            Assert.assertEquals(thing.getValue(), 0);
            Assert.assertEquals(thing.getSkill(), "");
        }

        Assert.assertFalse(allGood, "SHOULD throw exception!");

        // Yet another bad load
        thing.setID("BARNACLES");
        thing.setValue(567);
        thing.setSkill("skiing");
        input = new Scanner("CHRISTMAS_TREE 7");
        allGood = true;
        try {
            thing.load(input);
        }
        catch(Exception e) {
            allGood = false;
            Assert.assertTrue(e instanceof GameFileException);
            Assert.assertEquals(e.getMessage(), "Error loading Book");
            Assert.assertNotNull(e.getCause());

            Assert.assertEquals(thing.getID(), "");
            Assert.assertEquals(thing.getValue(), 0);
            Assert.assertEquals(thing.getSkill(), "");
        }

        Assert.assertFalse(allGood, "SHOULD throw exception!");
    }
}
