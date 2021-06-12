import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

//import main.java.BearWorkshop;

import static org.junit.Assert.*;

/**
 * The provided black box test class with some additional test written by me.
 *
 * @author Armand Altiveros, from code provided in SER316 shell
 * @version 1.0
 */

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

    /**
     * Sparky (70) v Ralphie (65) in neutral with Ground (EC1)
     * @throws Exception
     */
    @Test
    public void SvsRNeutralGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    SvsRNeutralGround");

        fight1.setEnvironment(Environment.Weather.NEUTRAL);
        Attack attack = new Attack(70, "Ground");

        //Calculation: 70 * 1 * 1.25 * 1 - 65 * .75 *1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(39, damage, 0.2);
    }

    /**
     * Albert (60) v Bully (40) rainy with ground (EC2)
     * @throws Exception
     */
    @Test
    public void AvsBRainyGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    AvsBRainyGround");

        fight1.setEnvironment(Environment.Weather.RAINY);
        Attack attack = new Attack(60, "Ground");

        //Calculation: 60 * 1 * 1.25 * 1 - 40 * 1 * 1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(35, damage, 0.2);
    }

    /**
     * Ralphie (30) v Bully (40) in drought with Water (EC3)
     * @throws Exception
     */
    @Test
    public void RvsBDroughtWater() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    RvsBDroughtWater");

        fight1.setEnvironment(Environment.Weather.DROUGHT);
        Attack attack = new Attack(30, "Water");

        //Calculation: 30 * 1 * 1.25 * 1 - 40 * .75 * 1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(8, damage, 0.2);
    }

    /**
     * Sparky (70) v Ralphie (65) in sunny with ground (EC4)
     * @throws Exception
     */
    @Test
    public void SvsRSunnyGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    SvsRSunnyGround");

        fight1.setEnvironment(Environment.Weather.SUNNY);
        Attack attack = new Attack(70, "ground");

        //Calculation: 70 * 1 * 1.25 * 1.25 - 65 * .75 * 1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(61, damage, 0.2);
    }

    /**
     * Ralphie (30) v Albert (40) in drought with ground (EC5)
     * @throws Exception
     */
    @Test
    public void RvsADroughtGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    RvsADroughtGround");

        fight1.setEnvironment(Environment.Weather.DROUGHT);
        Attack attack = new Attack(30, "Ground");

        //Calculation: 30 * 1.2 * 1.25 * 1.25 - 40 * .75 * 1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(26, damage, 0.2);
    }


    /**
     * Albert (60) v Sparky (40) in rainy with fire (EC6)
     * @throws Exception
     */
    @Test
    public void AvsSRainyFire() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    AvsSRainyFire");

        fight1.setEnvironment(Environment.Weather.RAINY);
        Attack attack = new Attack(60, "Fire");

        //Calculation: 60 * 1 * 1.25 * 1.25 - 40 * .75 * .75

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(71, damage, 0.2);
    }

    /**
     * Albert (60) v Bully (40) in neutral with Water (EC7)
     * @throws Exception
     */
    @Test
    public void AvsBNeutralWater() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    AvsBNeutralWater");

        fight1.setEnvironment(Environment.Weather.NEUTRAL);
        Attack attack = new Attack(60, "Water");

        //Calculation: 60 * 1.2 * 1 * 1 - 40 * 1 * 1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(32, damage, 0.2);
    }

    /**
     * Sparky (70) v Ralphie (65) neutral with fire (EC8)
     * @throws Exception
     */
    @Test
    public void SvsRNeutralFire() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    SvsRNeutralFire");

        fight1.setEnvironment(Environment.Weather.NEUTRAL);
        Attack attack = new Attack(70, "Fire");

        //Calculation: 70 * 1.2 * 1.25 * 1 - 65 * .75 * 1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(56, damage, 0.2);
    }

    /**
     * Sparky (70) v Bully (40) Sunny with Fire (EC9)
     * @throws Exception
     */
    @Test
    public void SvsBSunnyFire() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    SvsBSunnyFire");

        fight1.setEnvironment(Environment.Weather.SUNNY);
        Attack attack = new Attack(70, "Fire");

        //Calculation: 70 * 1.2 * 1.25 * 1 - 40 * 1 * 1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(65, damage, 0.2);
    }

    /**
     * Albert (60) v Bully (40) in netral with ground (EC10)
     * @throws Exception
     */
    @Test
    public void AvsBNeutralGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    AvsBNeutralGround");

        fight1.setEnvironment(Environment.Weather.NEUTRAL);
        Attack attack = new Attack(60, "Ground");

        //Calculation: 60 * 1 * 1 * 1 - 40 * 1 *1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(20, damage, 0.2);
    }

    /**
     * Sparky (70) v Bully (40) sunny with Ground (EC11)
     * @throws Exception
     */
    @Test
    public void SvsBSunnyGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    SvsBSunnyGround");

        fight1.setEnvironment(Environment.Weather.SUNNY);
        Attack attack = new Attack(70, "Ground");

        //Calculation: 70 * 1 * 1.25 * 1 - 40 * 1 * 1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(48, damage, 0.2);
    }

    /**
     * Sparky (70) v Bully (40) in drought with ground(EC12)
     * @throws Exception
     */
    @Test
    public void SvsBDroughtGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    SvsBDroughtGround");

        fight1.setEnvironment(Environment.Weather.DROUGHT);
        Attack attack = new Attack(70, "Ground");

        //Calculation: 70 * 1 * 1 * 1 - 40 * .75 * 1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(40, damage, 0.2);
    }

    /**
     * Albert (60) v Bully (40) in Rainy with Water (EC13)
     * @throws Exception
     */
    @Test
    public void AvsBRAinyWater() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    AvsBRAinyWater");

        fight1.setEnvironment(Environment.Weather.RAINY);
        Attack attack = new Attack(60, "Water");

        //Calculation: 60 * 1.2 * 1.25 * 1 - 40 * 1 *1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(50, damage, 0.2);
    }

    /**
     * Bully (40) v Sparky (40) in sunny with no attack (EC14)
     * @throws Exception
     */
    @Test
    public void BvsSNeutralNone() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    BvsSNeutralNone");

        fight1.setEnvironment(Environment.Weather.NEUTRAL);
        Attack attack = new Attack(0, "None");

        //Calculation: 0 * 1 * 1 * 1 - 40 * 1 * 1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(0, damage, 0.2);
    }

    /**
     * Albert (60) v Ralphie (65) in sunny with fire(EC15)
     * @throws Exception
     */
    @Test
    public void AvsRSunnyFire() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    AvsRSunnyFire");

        fight1.setEnvironment(Environment.Weather.SUNNY);
        Attack attack = new Attack(60, "Fire");

        //Calculation: 60 * 1 * .75 * .75 - 65 * 1.25 *1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(1, damage, 0.2);
    }

    /**
     * Ralphie (30) v Albert (40) in sunny with Normal(EC16)
     * @throws Exception
     */
    @Test
    public void RvsASunnyNormal() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    RvsASunnyNormal");

        fight1.setEnvironment(Environment.Weather.SUNNY);
        Attack attack = new Attack(30, "Normal");

        //Calculation: 30 * 1 * 1.25 * 1 - 40 * .75 * .75

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(15, damage, 0.2);
    }

    /**
     * Ralphie (30) v Sparky (40) in sunny with normal (EC17)
     * @throws Exception
     */
    @Test
    public void RvsSSunnyNormal() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    RvsSSunnyNormal");

        fight1.setEnvironment(Environment.Weather.SUNNY);
        Attack attack = new Attack(30, "Normal");

        //Calculation: 30 * 1 * .75 * 1 - 40 * 1.25 * 1.25

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(1, damage, 0.2);
    }

    /**
     * Sparky (70) v Bully (40) in drought with Fire(EC18)
     * @throws Exception
     */
    @Test
    public void SvsBDroughtFire() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    SvsBDroughtFire");

        fight1.setEnvironment(Environment.Weather.DROUGHT);
        Attack attack = new Attack(70, "Fire");

        //Calculation: 70 * 1.2 * 1 * 1 - 40 * .75 * 1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(54, damage, 0.2);
    }

    /**
     * Sparky (70) v Ablert (40) in sunny with ground (BA1)
     * @throws Exception
     */
    @Test
    public void SvsASunnyGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    SvsASunnyGround");

        fight1.setEnvironment(Environment.Weather.SUNNY);
        Attack attack = new Attack(70, "Ground");

        //Calculation: 70 * 1 * 1.25 * .75 - 40 * .75 * 1.25

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(29, damage, 0.2);
    }

    /**
     * Bully(-1) v Sparky (40) netraul with ground (BA2)
     * @throws Exception
     */
    @Test
    public void BvsSNeutralGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    BvsSNeutralGround");

        fight1.setEnvironment(Environment.Weather.NEUTRAL);
        Attack attack = new Attack(-1, "Ground");

        //Calculation: -1 * 1 * 1 * 1 - 40 * 1 * 1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(1, damage, 0.2);
    }

    /**
     * Bully(200) v Sparky (40) neutral with ground (BA3)
     * @throws Exception
     */
    @Test
    public void B200vsSNeutralGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    BvsSNeutralGround");

        fight1.setEnvironment(Environment.Weather.NEUTRAL);
        Attack attack = new Attack(200, "Ground");

        //Calculation: 200 * 1 * 1 * 1 - 40 * 1 * 1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(160, damage, 0.2);
    }

    /**
     * Albert (60) v Albert (40) in sunny with ground (BA4)
     * @throws Exception
     */
    @Test
    public void AvsASunnyGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    AvsASunnyGround");

        fight1.setEnvironment(Environment.Weather.SUNNY);
        Attack attack = new Attack(60, "Ground");

        //Calculation: 60 * 1 * .75 * 1 - 40 * .75 * 1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(15, damage, 0.2);
    }

    /**
     * Bully (40) v Bully (40) in neutral with Ground(BA5)
     * @throws Exception
     */
    @Test
    public void BvsBNeutralGround() throws Exception {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    BvsBNeutralGround");

        fight1.setEnvironment(Environment.Weather.NEUTRAL);
        Attack attack = new Attack(40, "Ground");

        //Calculation: 40 * 1 * 1 * 1 - 40 * 1 * 1

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(0, damage, 0.2);
    }

}