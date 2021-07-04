import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;

/**
 * The White Box Test class with whitebox tests.
 *
 * @author Armand Altiveros, from code provided in SER316 shell
 * @version 1.0
 */

public class GivenWhiteBox {
    @Before
    public void setUp() throws Exception {
    }


    /**
     *This test will cover node test sequence <50, 61, 64, 74,> and edge test sequence <50, 61, 64, 79, 82, 61, 64, 74>
     */
    @Test
    public void BvsANeutral_AttackerShouldWin() {
        MascotmonFactory factory = new MascotmonFactory();
        Mascotmon attacker1 = factory.getMascotmon("BULLY");
        Mascotmon defender1 = factory.getMascotmon("ALBERT");
        
        //Create First battle scenario with two mons
        BattleScenario fight1 = new BattleScenario(attacker1, defender1); 
        //Set the weather
        fight1.setEnvironment(Environment.Weather.SUNNY);
        
        Mascotmon mon = fight1.initiateBattle();
        assertEquals(mon, attacker1);
    }

    /**
     *This test will cover node test sequence < 50, 61, 64, 79, 82, 92> and edge test sequence <50, 61, 64, 79, 82, 92>
     */
    @Test
    public void SvsBullyNeutral_DefenderShouldWin() {
        MascotmonFactory factory = new MascotmonFactory();
        Mascotmon attacker1 = factory.getMascotmon("SPARKY");
        Mascotmon defender1 = factory.getMascotmon("BULLY");

        //Create First battle scenario with two mons
        BattleScenario fight1 = new BattleScenario(attacker1, defender1);
        //Set the weather
        fight1.setEnvironment(Environment.Weather.NEUTRAL);

        Mascotmon mon = fight1.initiateBattle();
        assertEquals(mon, defender1);
    }

}
