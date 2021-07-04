import java.lang.Math;

/**
 *
 *
 * @author Armand Altiveros, from code provided in SER316 shell
 * @version 1.0
 */

public class BattleScenario {

    private Mascotmon defender;
    private Mascotmon attacker;
    private Stats mon1Stats;
    //SER316 TASK 2 SPOTBUGS FIX
    private Environment battleWeather;

    public BattleScenario(Mascotmon m1, Mascotmon m2) {
        setAttacker(m1);
        setDefender(m2);
    } 

    /**
     * Sets environment of the battlefield, and sets buff/debuff modifiers for all Mascotmons on the
     * field. If the Mascotmon's Type is buffed by the environment,they receive a 25% multiplier to
     * their attack and defense stat. If the Mascotmon's Type is debuffed by the environment, they
     * receive a reduction of 25% to their attack and defense stat.
     * @param weather is the weather enum to use from Environment class
     */
    public void setEnvironment(Environment.Weather weather) {
        battleWeather = new Environment(weather);
    }

    //changed initiateBattle() from void, so that it will return a Mascotmon object so that I can
    // test this method as well

    /**
     * Initiates a battle.
     * @return the Mascotmon that won the battle
     */
    public Mascotmon initiateBattle() {

        // initiate stats for mon1 and mon2
        mon1Stats = new Stats(attacker.getName());
        //SER316 TASK 2 SPOTBUGS FIX
        System.out.println("Woooo: " + mon1Stats.getHealth());

        System.out.println("\nWelcome everyone to the Mascotmon training arena!");
        System.out.println("It is a " + battleWeather.getWeather().toString().toLowerCase()
                + " day here at Frank Kush Field");
        System.out.println("Today, on the attacking team we have " + attacker.getName() + " " +
                attacker.getDescription());
        System.out.println("Their opponent, on the defending team is " + defender.getName() + " " +
                defender.getDescription());
        System.out.println(defender.getName() + " prepares for the incoming attack");

        Mascotmon winner = fight();
        System.out.println(winner.getName() + " has won with " + winner.getStats().getHealth() + " health left");
        return winner; //I added a return statement
    }

    /**
     * Sample fight scenario of two rounds.
     * Each Mascotmon uses one random attack per round; this attack multiplier is used to calculate 
     * damage output against opposing mascotmon. 
     */
    public Mascotmon fight() {
        int round = 1;
        double damage1;
        double damage2;
        Attack attack1;
        Attack attack2;
        Mascotmon winner = null;

        while (winner == null) {
            round++;
            //Mon 1's turn:
            winner = makeOneAttack(round);
            reverseRoles();
        } //end while
        return winner;
    }

    /**
     * performs one attack and defense. Helper method for fight.
     */

    public Mascotmon makeOneAttack(int round) {
        double damage;
        Attack attack;
        System.out.println("\n" + attacker.getName() + " launches an attack against " + defender.getName() + "!");
        //used the constructor for Attack class rather than attack() from class Mascotmon to
        // make the method deterministic for testing
        attack = new Attack(Constants.TESTING_DAMAGE_VALUE, "Ground");

        //Calculate damage:
        damage = calculateDamage(attack, attacker, defender);
        System.out.println(damage + " damage dealt");

        //Adjust mon2's health:
        defender.getStats().setHealth(defender.getStats().getHealth() - damage);
        System.out.println(defender.getName() + " has " + defender.getStats().getHealth() + " health left");
        //Battle terminating condition:
        if (defender.getStats().getHealth() <= Constants.K_O) {
            System.out.println(defender.getName() + " has fainted in round " + round/2);
            return attacker;
        }
        return null;
    }

    public void reverseRoles(){
        Mascotmon temp = attacker;
        attacker = defender;
        defender = temp;
    }

    public void setAttacker(Mascotmon m) {
        attacker = m;
    }

    public void setDefender(Mascotmon m) {
        defender =  m;
    }

    /**
     * TO DO: Implement for Assignment 3
     * This method implements the calculation of damage for one specific attack.
     * One monster attacks with the given damage, the dealt damage is then calculated through
     * (pAttackDamage * attacker.attack * attacker.weatherBonus * attacker.typeBonus) -
               (defender.stats.defense * defender.weatherBonus * defender.typeBonus)
     * If the initial pAttackDamage is 0, then the damage dealt is 0. If the totalDamage calculated
     * is negative, the totalDamage dealt should be 1. Any positive value is the total damage
     * dealt. Weather bonus: see the Environment which you can assume is correct. You need to
     * check though if the weather bonus is applied correctly, since maybe the method does not use
     * the environment correctly. or debuffed based on the weather. EG. fire monsters have a stat
     * advantage of +25% in sunny weather while they have a stat disadvantage of -25% in the rain.
     * If the attack chosen, matches the monsters Type, the attacker will get an extra 20% on its
     * attack.
     * Type bonus: Certain monsters have an attack bonus against others:
     *     Fire against Water: Water gains 25% while Fire looses 25%
     *     Fire against Ground: Fire gains 25% while Ground looses 25%
     *     Ground against Water: Ground gains 25% while Water looses 25%
     *     Normal mon: never gain any Type bonus and are weaker during droughts.
     * These bonuses do not stack up, they are just applied for every attack.
     * @param attack is the attack value given to the method where that attack value is based on
     *                the monsters damage value
     * @param attacker the attacking monster
     * @param defender the defending monster (the defending monster will never get damage)
     *                to calculate damage output.
     * @return total damage output
     */

    public double calculateDamage(Attack attack, Mascotmon attacker, Mascotmon defender) {

        double attackBonus = Constants.NO_BONUS;
        //set Type bonus for both monsters
        attacker.setTypeBonuses(defender);
        //set weather bonus for both monsters
        attacker.setWeatherBonus(battleWeather);
        defender.setWeatherBonus(battleWeather);
        //set attack bonus
        if (attacker.getType().compareTo(attack.getType()) == 0) {
            attackBonus = Constants.ATTACK_BONUS;
        }
        //check for "None" attack
        if (attack.getType().compareTo("None") == Constants.NONE_ATTACK) {
            return Constants.NONE_ATTACK;
        }
        //calculate and return the damage
        double skirmish;
        skirmish = Math.round(attack.getDamage() * attackBonus * attacker.getTypeBonus() *
                attacker.getWeatherBonus() - defender.getStats().getDefense() * defender.getTypeBonus() *
                defender.getWeatherBonus());
        if (skirmish < 0) {
            return Constants.MIN_ATTACK_DAMAGE;
        }
        return skirmish;
    }

}