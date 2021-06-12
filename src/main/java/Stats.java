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

    public Stats(Mascotmon.Name name) {
        switch (name) {
            case ALBERT:
                attack = 60;
                defense = 40;
                health = 100;
                break;
            case RALPHIE:
                attack = 30;
                defense = 65;
                health = 105;
                break;
            case SPARKY:
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

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }
}
