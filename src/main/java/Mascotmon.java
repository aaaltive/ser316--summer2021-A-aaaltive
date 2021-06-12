import java.util.concurrent.ThreadLocalRandom;

/**
 * Class creates a Mascotmon that will be used in battle simulations.
 *
 * @author Armand Altiveros, from code provided in SER316 shell
 * @version 1.0
 */

public class Mascotmon {
    private String description;
    private String type;
    private Name name;
    private Stats stats;
    private double weatherBonus = 1.0;
    private double typeBonus = 1.0;
    private int bufCounter = 0;

    /**
     * The constructor for a Mascotmon.
     */

    public Mascotmon() {
        int rand = ThreadLocalRandom.current().nextInt(0, 4);
        if (rand == 0) {
            name = Name.ALBERT;
        } else if (rand == 1) {
            name = Name.RALPHIE;
        } else if (rand == 2) {
            name = Name.SPARKY;
        } else {
            name = Name.BULLY;
        }
        setType();
        setStats();
        setDescription();
    }

    /**
     * constructor nor a Mascotmon with a name that is not set up in program.
     * @param name the name chosen to make a non-default monster.
     */

    public Mascotmon(Name name) {
        this.name = name;
        setType();
        setStats();
        setDescription();
    }

    private void setType() {
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

    private void setStats() {
        stats = new Stats(name);
        
        
    }

    private void setDescription() {
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
    public Attack attack() {
        double attackDamage = 0;
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

        String desc = "";
        Attack attack = null;

        switch (name) {
            case ALBERT:
                if (attackNumber == 0) {
                    desc = " uses Iron Scales, increasing defense stat by 10%";
                    stats.setDefense(stats.getDefense() * Constants.NO_ATTACK_MULTIPLIER);
                    attack = new Attack(0, "None");
                } else if (attackNumber == 1) {
                    desc = " uses Death Roll";
                    attack = new Attack(stats.getAttack(), "Ground");
                } else if (attackNumber == 2) {
                    desc = " uses Chomp";
                    attack = new Attack(stats.getAttack(), "Normal");
                } else {
                    desc = " uses Aqua Cannon";
                    attack = new Attack(stats.getAttack(), "Water");
                }
                break;
            case RALPHIE:
                if (attackNumber == 0) {
                    desc = " uses Iron Hide, increasing defense stat by 10%";
                    stats.setDefense(stats.getDefense() * Constants.NO_ATTACK_MULTIPLIER);
                    attack = new Attack(0, "None");
                } else if (attackNumber == 1) {
                    desc = " uses Ground Stomp";
                    attack = new Attack(stats.getAttack(), "Ground");
                } else if (attackNumber == 2) {
                    desc = " uses Headbutt";
                    attack = new Attack(stats.getAttack(), "Normal");
                } else {
                    desc = " uses Flaming Horn";
                    attack = new Attack(stats.getAttack(), "Fire");
                }
                break;
            case SPARKY:
                if (attackNumber == 0) {
                    desc = " uses Heat Up, increasing attack stat by 10%";
                    stats.setAttack(stats.getAttack() * Constants.NO_ATTACK_MULTIPLIER);
                    attack = new Attack(0, "None");
                } else if (attackNumber == 1) {
                    desc = " uses Inferno";
                    attack = new Attack(stats.getAttack(), "Fire");
                } else if (attackNumber == 2) {
                    desc = " uses Quick Attack";
                    attack = new Attack(stats.getAttack(), "Normal");
                    System.out.println("Attack value: " + stats.getAttack());
                } else {
                    desc = " uses Earthquake";
                    attack = new Attack(stats.getAttack(), "Ground");
                }
                break;
            case BULLY:
                if (attackNumber == 0) {
                    desc = " uses Sleep, increasing health stat by 10%";
                    double health = stats.getHealth() * Constants.NO_ATTACK_MULTIPLIER;
                    stats.setHealth(Math.round(health));
                    attack = new Attack(0, "None");
                } else if (attackNumber == 1) {
                    desc = " uses Body Slam";
                    attack = new Attack(stats.getAttack(), "Normal");
                } else if (attackNumber == 2) {
                    desc = " uses Splash";
                    attack = new Attack(stats.getAttack(), "Water");
                } else {
                    desc = " uses Ground Pound";
                    attack = new Attack(stats.getAttack(), "Ground");
                }
        }
            
        System.out.println(name.toString().toLowerCase() + desc);
        return attack;
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

    public void setTypeBonuses(Mascotmon opponent) {
        switch (this.type) {
            case "Fire":
                if (opponent.type.compareTo("Water") == 0) {
                    this.typeBonus = Constants.DEBUFF;
                    opponent.typeBonus = Constants.BONUS;
                } else if (opponent.type.compareTo("Ground") == 0) {
                    this.typeBonus = Constants.BONUS;
                    opponent.typeBonus = Constants.DEBUFF;
                }
                break;
            case "Water":
                if (opponent.type.compareTo("Ground") == 0) {
                    this.typeBonus = Constants.DEBUFF;
                    opponent.typeBonus = Constants.BONUS;
                } else if (opponent.type.compareTo("Fire") == 0) {
                    this.typeBonus = Constants.BONUS;
                    opponent.typeBonus = Constants.DEBUFF;
                }
                break;
            case "Ground":
                if (opponent.type.compareTo("Fire") == 0) {
                    this.typeBonus = Constants.DEBUFF;
                    opponent.typeBonus = Constants.BONUS;
                } else if (opponent.type.compareTo("Water") == 0) {
                    this.typeBonus = Constants.BONUS;
                    opponent.typeBonus = Constants.DEBUFF;
                }
                break;
            default:  //SER316 TASK 2 SPOTBUGS FIX
                this.typeBonus = Constants.NO_BONUS;  //SER316 TASK 2 SPOTBUGS FIX
        }
    }

    /**
     * getter method for name.
     * @return the name of the monster
     */

    public Name getName() {
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

    public enum Name {
        ALBERT, RALPHIE, SPARKY, BULLY
    }
}
