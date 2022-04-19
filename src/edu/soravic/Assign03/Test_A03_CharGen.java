package edu.soravic.Assign03;
// NOTE: CHANGE realemj to YOUR SITNETID!!!
import edu.soravic.Testing.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_A03_CharGen {

    private void compareEachLine(String actual, String expected, String typeData) {
        // Split each string
        String [] actualList = actual.split("\n");
        String [] expectedList = expected.split("\n");

        for(int i = 0; i < expectedList.length; i++) {
                String a = "";
                if(i < actualList.length) {
                a = actualList[i];
                }
                String e = expectedList[i];
                a = a.trim();
                e = e.trim();
                Assert.assertEquals(a, e, typeData + " Line " + i + ": output not the same!\n");
        }            
    }

    @Test()
    public void testMain() {

        String [] allInputs = {
                """
                41
                RANGER
                WIZARD
                WARRIOR
                PEASANT
                HALFING
                """
                ,
                """
                41
                WIZARD
                WARRIOR
                RANGER
                PEASANT
                HALFING
                """
                ,
                """
                87
                RANGER
                WIZARD
                WARRIOR
                PEASANT
                GHOST
                """,
                """
                29
                RANGER RANGER RANGER RANGER RANGER RANGER RANGER
                BOB
                """,
                """
                29
                ranger Ranger rAnGeR Wizard WArrior pEASAnt
                BOB
                """
        };

        GeneralTesting.OutPack [] correctOutputs = {
                // Error cases
                new GeneralTesting.OutPack(
                        """
                        Enter seed:
                        Enter class:
                        CLASS: RANGER
                        STRENGTH: 69
                        WISDOM: 68
                        Enter class:
                        CLASS: WIZARD
                        STRENGTH: 48
                        WISDOM: 95
                        Enter class:
                        CLASS: WARRIOR
                        STRENGTH: 85
                        WISDOM: 11
                        Enter class:
                        CLASS: PEASANT
                        STRENGTH: 16
                        WISDOM: 38
                        Enter class:
                        """,
                        """
                        UNKNOWN CLASS: HALFING
                        """),

                new GeneralTesting.OutPack(
                        """
                        Enter seed:
                        Enter class:
                        CLASS: WIZARD
                        STRENGTH: 19
                        WISDOM: 68
                        Enter class:
                        CLASS: WARRIOR
                        STRENGTH: 98
                        WISDOM: 45
                        Enter class:
                        CLASS: RANGER
                        STRENGTH: 85
                        WISDOM: 61
                        Enter class:
                        CLASS: PEASANT
                        STRENGTH: 16
                        WISDOM: 38
                        Enter class:
                        """,
                        """                        
                        UNKNOWN CLASS: HALFING
                        """),

                new GeneralTesting.OutPack(
                        """
                        Enter seed:
                        Enter class:
                        CLASS: RANGER
                        STRENGTH: 96
                        WISDOM: 70
                        Enter class:
                        CLASS: WIZARD
                        STRENGTH: 13
                        WISDOM: 98
                        Enter class:
                        CLASS: WARRIOR
                        STRENGTH: 63
                        WISDOM: 14
                        Enter class:
                        CLASS: PEASANT
                        STRENGTH: 28
                        WISDOM: 25
                        Enter class:
                        """,
                        """
                        UNKNOWN CLASS: GHOST
                        """),
                new GeneralTesting.OutPack(
                        """
                        Enter seed:
                        Enter class:
                        CLASS: RANGER
                        STRENGTH: 75
                        WISDOM: 54
                        Enter class:
                        CLASS: RANGER
                        STRENGTH: 90
                        WISDOM: 86
                        Enter class:
                        CLASS: RANGER
                        STRENGTH: 70
                        WISDOM: 55
                        Enter class:
                        CLASS: RANGER
                        STRENGTH: 54
                        WISDOM: 96
                        Enter class:
                        CLASS: RANGER
                        STRENGTH: 70
                        WISDOM: 82
                        Enter class:
                        CLASS: RANGER
                        STRENGTH: 60
                        WISDOM: 56
                        Enter class:
                        CLASS: RANGER
                        STRENGTH: 60
                        WISDOM: 78
                        Enter class:
                        """,
                        """
                        UNKNOWN CLASS: BOB
                        """),

                new GeneralTesting.OutPack(
                        """
                        Enter seed:
                        Enter class:
                        CLASS: RANGER
                        STRENGTH: 75
                        WISDOM: 54
                        Enter class:
                        CLASS: RANGER
                        STRENGTH: 90
                        WISDOM: 86
                        Enter class:
                        CLASS: RANGER
                        STRENGTH: 70
                        WISDOM: 55
                        Enter class:
                        CLASS: WIZARD
                        STRENGTH: 4
                        WISDOM: 96
                        Enter class:
                        CLASS: WARRIOR
                        STRENGTH: 70
                        WISDOM: 32
                        Enter class:
                        CLASS: PEASANT
                        STRENGTH: 10
                        WISDOM: 6
                        Enter class:
                        """,
                        """
                        UNKNOWN CLASS: BOB
                        """),
        };

        for(int i = 0; i < allInputs.length; i++) {
            // Start redirect
            GeneralTesting.StreamPack.getInstance().start(allInputs[i]);

            // Call main
            CharGen.main(null);

            // Stop redirect
            GeneralTesting.OutPack programOutput = GeneralTesting.StreamPack.getInstance().stop();
            
            // Compare to correct result            
            try {
                compareEachLine(programOutput.getStdOut(), correctOutputs[i].getStdOut(), "STDOUT");
                compareEachLine(programOutput.getStdErr(), correctOutputs[i].getStdErr(), "STDERR");
            }
            catch(Error e) {
                // OK, specific error
                e.printStackTrace();                
                // So give us the full view as well
                try {                    
                    Assert.assertEquals(programOutput, correctOutputs[i]);
                }
                catch(Error f) {
                    System.err.println("FULL OUTPUT:");
                    f.printStackTrace();
                    throw f;
                }
            }
        }
    }
}
