package edu.soravic.Assign08;
//NOTE: CHANGE realemj to YOUR SITNETID!!!
import edu.soravic.Testing.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.*;

public class Test_A08_CavernGame {

    @Test()
    public void testMain() throws IOException {

        String [] allInputs = {
                "A08_Level_1.txt\n",
                "A08_Level_2.txt\n",
                "A08_Level_3.txt\n",
                "A08_Level_4.txt\n",
                "A08_BadBook.txt\n",
                "A08_BadCreature.txt\n",
                "A08_BadItem.txt\n"
        };

        GeneralTesting.OutPack [] correctOutputs = {
                new GeneralTesting.OutPack(
                        "Enter level filename:\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..S...........................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "............R.................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "\n" +
                                "CREATURES:\n" +
                                "Skeleton at 3,2\n" +
                                "Rat at 6,12\n" +
                                "INVENTORY:\n",
                        ""),
                new GeneralTesting.OutPack(
                        "Enter level filename:\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..S...........................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "...............R..............\n" +
                                "..............................\n" +
                                "...R..........................\n" +
                                "....S.........................\n" +
                                "..............................\n" +
                                "\n" +
                                "CREATURES:\n" +
                                "Skeleton at 4,2\n" +
                                "Rat at 7,15\n" +
                                "Rat at 9,3\n" +
                                "Skeleton at 10,4\n" +
                                "INVENTORY:\n",
                        ""),
                new GeneralTesting.OutPack(
                        "Enter level filename:\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "\n" +
                                "CREATURES:\n" +
                                "INVENTORY:\n" +
                                "CUP with value 5\n" +
                                "TOME_OF_MAGIC with value 120, enhances sorcery\n" +
                                "FORK with value 7\n",
                        ""),

                new GeneralTesting.OutPack(
                        "Enter level filename:\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                ".......S......................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                ".........R....................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "............R.................\n" +
                                "..S...........................\n" +
                                "\n" +
                                "CREATURES:\n" +
                                "Rat at 10,12\n" +
                                "Skeleton at 3,7\n" +
                                "Rat at 7,9\n" +
                                "Skeleton at 11,2\n" +
                                "INVENTORY:\n" +
                                "GROGNAK_COMIC with value 170, enhances courage\n" +
                                "SPOON with value 2\n" +
                                "TAO_OF_PROGRAMMING with value 25, enhances wisdom\n",
                        ""),

                new GeneralTesting.OutPack(
                        "Enter level filename:\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "............R.................\n" +
                                "..............................\n" +
                                "\n" +
                                "CREATURES:\n" +
                                "Rat at 10,12\n" +
                                "INVENTORY:\n",
                        "Game File Error: Error loading Book\n"),

                new GeneralTesting.OutPack(
                        "Enter level filename:\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                ".......S......................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "............R.................\n" +
                                "..............................\n" +
                                "\n" +
                                "CREATURES:\n" +
                                "Rat at 10,12\n" +
                                "Skeleton at 3,7\n" +
                                "INVENTORY:\n" +
                                "GROGNAK_COMIC with value 170, enhances courage\n",
                        "Game File Error: Error loading Creature\n"),

                new GeneralTesting.OutPack(
                        "Enter level filename:\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                ".......S......................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                ".........R....................\n" +
                                "..............................\n" +
                                "..............................\n" +
                                "............R.................\n" +
                                "..............................\n" +
                                "\n" +
                                "CREATURES:\n" +
                                "Rat at 10,12\n" +
                                "Skeleton at 3,7\n" +
                                "Rat at 7,9\n" +
                                "INVENTORY:\n" +
                                "GROGNAK_COMIC with value 170, enhances courage\n",
                        "Game File Error: Error loading Item\n"),

        };

        for(int i = 0; i < allInputs.length; i++) {

            // Start redirect
            GeneralTesting.StreamPack.getInstance().start(allInputs[i]);

            // Call main
            CavernGame.main(null);

            // Stop redirect
            GeneralTesting.OutPack programOutput = GeneralTesting.StreamPack.getInstance().stop();

            // Compare to correct result
            Assert.assertEquals(programOutput, correctOutputs[i]);
        }
    }
}
