/**
 * This is the Main class, the starting point for running the program.
 *
 * @author Armand Altiveros, from code provided in SER316 shell
 * @version 1.0
 */

public class Main {

    /**
     * The starting point for the program.
     * @param args arguments, probably none.
     */

    public static void main(String[] args) {

        MascotmonFactory factory = new MascotmonFactory();
        Mascotmon attacker1 = factory.getMascotmon("SPARKY");
        Mascotmon defender1 = factory.getMascotmon("ALBERT");
        Mascotmon attacker2 = factory.getMascotmon("BULLY");
        Mascotmon defender2 = factory.getMascotmon("RALPHIE");
        
        //Create First battle scenario with two mons
        BattleScenario fight1 = new BattleScenario(attacker1, defender1); 
        //Set the weather
        fight1.setEnvironment(Environment.Weather.SUNNY);
        //Initiate battle
        fight1.initiateBattle();
        System.out.println("This is the end of the training simulation");

        //Create Second battle scenario with two mons
        BattleScenario fight2 = new BattleScenario(attacker2, defender2); 
//        Set the weather
        fight2.setEnvironment(Environment.Weather.RAINY);
//        Initiate battle
        fight2.initiateBattle();
        System.out.println("This is the end of the training simulation");
    }
}
