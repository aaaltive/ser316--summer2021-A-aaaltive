public class BattleScenario {

    private Mascotmon mon1;
    private Mascotmon mon2;
    private Stats mon1Stats;
    private Stats mon2Stats;
    private Environment battleWeather;

    public BattleScenario(Mascotmon pMon1, Mascotmon pMon2) {
        setMon1(pMon1);
        setMon2(pMon2);
    } 

    /**
     * Sets environment of the battlefield, and sets buff/debuff modifiers for all Mascotmons on the
     * field. If the Mascotmon's type is buffed by the environment,they receive a 25% multiplier to
     * their attack and defense stat. If the Mascotmon's type is debuffed by the environment, they
     * receive a reduction of 25% to their attack and defense stat.
     * @param pWeather is the weather enum to use from Environment class
     */
    public void setEnvironment(Environment.Weather pWeather) {
        battleWeather = new Environment(pWeather);
    }

    public void initiateBattle() {

        // initiate stats for mon1 and mon2
        mon1Stats = new Stats(mon1.getName());
        mon2Stats = new Stats(mon2.getName());
        System.out.println("Woooo: " + mon1Stats.getHealth());

        System.out.println("\nWelcome everyone to the Mascotmon training arena!");
        System.out.println("It is a " + battleWeather.getWEATHER().toString().toLowerCase()
                + " day here at Frank Kush Field");
        System.out.println("Today, on the attacking team we have " + mon1.getName() + " " +
                mon1.getDescription());
        System.out.println("Their opponent, on the defending team is " + mon2.getName() + " " +
                mon2.getDescription());
        System.out.println(mon2.getName() + " prepares for the incoming attack");

        Mascotmon winner = fight();
        System.out.println(winner.getName() + " has won with " + winner.getStats().getHealth() + " health left");
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

        while (true) {
            //Mon 1's turn:
            System.out.println("\n" + mon1.getName() + " launches an attack against " + mon2.getName() + "!");
            attack1 = mon1.attack();

            //Calculate damage:
            damage1 = calculateDamage(attack1, mon1, mon2);
            System.out.println(damage1 + " damage dealt");

            //Adjust mon2's health:
            mon2.getStats().setHealth(mon2.getStats().getHealth() - damage1);
            System.out.println(mon2.getName() + " has " + mon2.getStats().getHealth() + " health left");

            //Battle terminating condition:
            if (mon2.getStats().getHealth() <= 0.0){
                System.out.println(mon2.getName() + " has fainted in round " + round);
                return mon1;
            }

            //Mon 2's turn:
            System.out.println("\n" + mon2.getName()  + " launches an attack against " + mon1.getName() + "!");
            attack2 = mon2.attack();

            //Calculate damage:
            damage2 = calculateDamage(attack2, mon2, mon1);
            System.out.println(damage2 + " damage dealt");

            //Adjust mon1's health:
            mon1.getStats().setHealth(mon1.getStats().getHealth() - damage2);
            System.out.println(mon1.getName() + " has " + mon1.getStats().getHealth() + " health left");

            //Battle terminating condition:
            if (mon1.getStats().getHealth() <= 0.0){
                System.out.println(mon1.getName() + " has fainted in round " + round);
                return mon2;
            }
            round++;
        } //end while
    }


    public void setMon1(Mascotmon pMon){
        mon1 = pMon;
    }


    public void setMon2(Mascotmon pMon){
        mon2 =  pMon;
    }


     /**
      * TO DO: Implement for Assignment 3
      * This method implements the calculation of damage for one specific attack.
      * One monster attacks with the given damage, the dealt damage is then calculated through
      * (pAttackDamage * pAttacker.attack * pAttacker.weatherBonus * pAttacker.typeBonus) -
                (pDefender.getStats().defense * pDefender.weatherBonus * pDefender.typeBonus)
      * If the initial pAttackDamage is 0, then the damage dealt is 0. If the totalDamage calculated
      * is negative, the totalDamage dealt should be 1. Any positive value is the total damage dealt.
      * Weather bonus: see the Environment which you can assume is correct. You need to check though if the weather bonus is applied 
      * correctly, since maybe the method does not use the environment correctly. 
      * or debuffed based on the weather. EG. fire monsters have a stat advantage of +25% in sunny weather
      * while they have a stat disadvantage of -25% in the rain.
      * If the attack chosen, matches the monsters type, the attacker will get an extra 20% on its attack.
      * Type bonus: Certain monsters have an attack bonus against others:
      *     Fire against Water: Water gains 25% while Fire looses 25%
      *     Fire against Ground: Fire gains 25% while Ground looses 25%
      *     Ground against Water: Ground gains 25% while Water looses 25%
      *     Normal mon: never gain any type bonus and are weaker during droughts.
      * These bonuses do not stack up, they are just applied for every attack. 
      * @param pAttack is the attack value given to the method where that attack value is based on the 
      *                 monsters damage value
      * @param pAttacker the attacking monster
      * @param pDefender the defending monster (the defending monster will never get damage)
      * to calculate damage output.
      * @return total damage output
      */
    public double calculateDamage(Attack pAttack, Mascotmon pAttacker, Mascotmon pDefender) {
        return Math.round(pAttack.getDamage() * 0.2);
    }

}