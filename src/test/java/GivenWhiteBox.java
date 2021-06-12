import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;


public class GivenWhiteBox {
    @Before
    public void setUp() throws Exception {
    }


    /**
     *This test will cover node test sequence <50, 61, 64, 74,> and edge test sequence <50, 61, 64, 79, 82, 61, 64, 74>
     */
    @Test
    public void BvsANeutral_AttackerShouldWin() {
        // One Student
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);
        
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
        // One Student
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        //Create First battle scenario with two mons
        BattleScenario fight1 = new BattleScenario(attacker1, defender1);
        //Set the weather
        fight1.setEnvironment(Environment.Weather.neutral);

        Mascotmon mon = fight1.initiateBattle();
        assertEquals(mon, defender1);
    }

}
