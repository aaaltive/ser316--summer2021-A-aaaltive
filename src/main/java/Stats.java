/**
 * Class sets up a stats object that is held by a mascotmon.
 *
 * @author Armand Altiveros, from code provided in SER316 shell
 * @version 1.0
 */

public class Stats {

    private double attack;
    private double defense;
    private double health;

    /**
     * Default constructor for the Stats objects.
     */

    public Stats() {
        attack = 50;
        defense = 50;
        health = 100;
    }

    /**
     * Constructor with param for the Stats objects.
     * @param name name of the mascotmon this stat is for.
     */

    public Stats(String name) {
        switch (name) {
            case "ALBERT":
                attack = 60;
                defense = 40;
                health = 100;
                break;
            case "RALPHIE":
                attack = 30;
                defense = 65;
                health = 105;
                break;
            case "SPARKY":
                attack = 70;
                defense = 40;
                health = 90;
                break;
            default:
                attack = 40;
                defense = 40;
                health = 110;
                break;
        }

    }

    /**
     * getter method for attack attribute.
     * @return a double representing the attack value.
     */

    public double getAttack() {
        return attack;
    }

    /**
     * Setter method for attack attribute.
     * @param attack the new value that attack should be set to.
     */

    public void setAttack(double attack) {
        this.attack = attack;
    }

    /**
     * Getter method for defence attribute.
     * @return a double representing the defense points.
     */

    public double getDefense() {
        return defense;
    }

    /**
     * Setter method for defense attribute.
     * @param defense the value that defence should be set to.
     */

    public void setDefense(double defense) {
        this.defense = defense;
    }

    /**
     * getter method for health attribute.
     * @return The value of heath attribute.
     */

    public double getHealth() {
        return health;
    }

    /**
     * Setter method for health attribute.
     * @param health The value that health should be set to.
     */

    public void setHealth(double health) {
        this.health = health;
    }
}
