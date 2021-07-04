import java.util.concurrent.ThreadLocalRandom;

/**
 * Class creates a Mascotmon that will be used in battle simulations.
 *
 * @author Armand Altiveros, from code provided in SER316 shell
 * @version 1.0
 */

public abstract class Mascotmon {
    protected String description;
    protected String type;
    protected String name;
    protected Stats stats;
    protected double weatherBonus = 1.0;
    protected double typeBonus = 1.0;
    protected int bufCounter = 0;

    /**
     * the default constructor.
     */

    public Mascotmon(){
    }

    protected void setType() {
        Type t = new Type(name);
        this.type = t.getType();
    }

    /**
     * getter method for type string.
     * @return string that represents type.
     */

    public String getType() {
        return type;
    }

    protected void setStats() {
        stats = new Stats(name);
        
        
    }

    protected void setDescription() {
        Description desc = new Description(name);
        this.description = desc.getDescription();
    }

    /**
     * Method randomly determines an attack to use based on the defending Mascotmon and
     * returns the base damage of the attack selected. The self-buff (attackNumber 0) can only be
     * used 3 times during a battle.
     * @return attack damage. You can assume that this method uses the values it is supposed to
     *     use and is correct.
     */
    public abstract Attack attack();

    /**
     * Helper that gets a random number for the attack method.
     * @return int, the number
     */

    protected int getAtackNumber(){
        int attackNumber = 0;

        while (true) {
            attackNumber = ThreadLocalRandom.current().nextInt(0, 4);
            if (attackNumber == 0 && bufCounter <= 2) {
                bufCounter++;
                break;
            } else if (attackNumber != 0) {
                break;
            }
        }
        return attackNumber;
    }

    /**
     * sets up the weather bonus variable for the mascotmon.
     * @param weather weather Type for this battle.
     */

    public void setWeatherBonus(Environment weather) {
        if (this.type.compareTo(weather.getBuffedType()) == 0) {
            this.weatherBonus = Constants.BONUS;
        } else if (this.type.compareTo(weather.getDebuffedType()) == 0) {
            this.weatherBonus = Constants.DEBUFF;
        }
    }

    /**
     * Sets the typeBonus variable for the mascotmon.
     * @param opponent the mascotmon that this one is fighting against.
     */

    public abstract void setTypeBonuses(Mascotmon opponent);

    /**
     * getter method for name.
     * @return the name of the monster
     */

    public String getName() {
        return name;
    }

    /**
     * getter method for description.
     * @return the description of the monster
     */

    public String getDescription() {
        return description;
    }

    /**
     * getter for mascotmon stats.
     * @return returns the stats object for mascotmon it is called on
     */

    public Stats getStats() {
        return stats;
    }

    /**
     * getter for attack bonus value.
     * @return returns the attack bonus for the mascotmon.
     */

    public double getTypeBonus() {
        return typeBonus;
    }

    /**
     * getter for the weatherBonus.
     * @return the value of the weather bonus for this mascotmon.
     */

    public double getWeatherBonus() {
        return weatherBonus;
    }

}
