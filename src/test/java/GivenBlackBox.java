import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//import main.java.BearWorkshop;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GivenBlackBox {
    private Class<BattleScenario> classUnderTest;

    @SuppressWarnings("unchecked")
    public GivenBlackBox(Object classUnderTest) {
        this.classUnderTest = (Class<BattleScenario>) classUnderTest;
    }

    @Parameters
    public static Collection<Object[]> courseGradesUnderTest() {
        Object[][] classes = {
                {BattleScenario1.class},
                {BattleScenario2.class},
                {BattleScenario3.class},
                {BattleScenario4.class},
                {BattleScenario5.class}

        };
        return Arrays.asList(classes);
    }

    private BattleScenario createBattleScenario(Mascotmon a, Mascotmon d) throws Exception {
        Constructor<BattleScenario> constructor = classUnderTest.getConstructor(Mascotmon.class, Mascotmon.class);
        System.out.println(constructor);
        return constructor.newInstance(a, d);
    }

    
    @Before
    public void setUp() throws Exception {
        
    }

    @After
    public void tearDown() throws Exception {
    }

    // sample test

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception 
     */
    /*
    @Test
    public void BvsRSunnyGround() throws Exception {
        
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        
        BattleScenario fight1 = createBattleScenario(attacker1, defender1); 
        System.out.println("    BvsRSunnyGround");
        
        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(80, "Ground");
        
        //Calculation: 80 * 1 * 1 - 65 * 1 *1
        // 80 put into attack manually, no weather bonuses on either side, Ralphi has 65 defense
        
        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(15, damage, 0.2);
    }
    */

    /**
     * Ralphie (30) v Albert (40) in drought with ground (BA1)
     * @throws Exception
     */
    @Test
    public void RvsADroughtGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    RvsADroughtGround");

        fight1.setEnvironment(Environment.Weather.drought);
        Attack attack = new Attack(30, "Ground");

        //Calculation: 30 * 1.2 * 1.25 * 1.25 - 40 * .75 * 1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(26, damage, 0.2);
    }

    /**
     * Sparky (70) v Ralphie (65) in sunny with ground (BA2)
     * @throws Exception
     */
    @Test
    public void SvsRSunnyGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    SvsRSunnyGround");

        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(70, "ground");

        //Calculation: 70 * 1 * 1.25 * 1.25 - 65 * .75 * 1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(61, damage, 0.2);
    }
    /**
     * Albert (60) v Sparky (40) rainy with fire (BA3)
     * @throws Exception
     */
    @Test
    public void AvSRainyFire() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    AvSRainyFire");

        fight1.setEnvironment(Environment.Weather.rainy);
        Attack attack = new Attack(60, "Fire");

        //Calculation: 60 * 1 * 1.25 * 1.25 - 40 * .75 * .75

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(71, damage, 0.2);
    }

    /**
     * Battle between Bully and Ralphie on a drought day with ground attack
     * @throws Exception
     */
    @Test
    public void BvsRDroughtGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    RvsBDroughtGround");

        fight1.setEnvironment(Environment.Weather.drought);
        Attack attack = new Attack(80, "Ground");

        //Calculation: 80 * 1 * .75 * 1 - 65 * 1.25 *1
        // 80 put into attack manually, Bully gets (-) bonus for weather, no attack bonuses or type bonus
        // Ralphie gets no bonus for defense

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(1, damage, 0.2);
    }

    /**
     * Battle between Albert and Albert on a sunny day with ground attack
     * @throws Exception
     */
    @Test
    public void AvsASunnyGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    AvsASunnyGround");

        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(60, "Ground");

        //Calculation: 60 * .75 * 1 * 1 - 40 * .75 *1
        // 60 put into attack manually, Albert gets bonus for weather, no attack bonuses or type bonus

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(15, damage, 0.2);
    }

        /**
         * Battle between Sparky and Sparky on a sunny day with ground attack
         * @throws Exception
         */
        @Test
        public void SvsSSunnyGround() throws Exception {

            Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
            Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);

            BattleScenario fight1 = createBattleScenario(attacker1, defender1);
            System.out.println("    SvsSSunnyGround");

            fight1.setEnvironment(Environment.Weather.sunny);
            Attack attack = new Attack(70, "Ground");

            //Calculation: 70 * 1 * 1.25 * 1 - 40 * 1.25 *1
            // 80 put into attack manually, Albert gets bonus for weather, no attack bonuses or type bonus

            double damage = fight1.calculateDamage(attack, attacker1, defender1);
            System.out.println("         Damage dealt: " + damage);
            assertEquals(38, damage, 0.2);
        }

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception
     */

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception
     */

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception
     */

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception
     */

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception
     */

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception
     */

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception
     */

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception
     */

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception
     */

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception
     */

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception
     */

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception
     */

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception
     */

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception
     */
}