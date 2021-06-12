/**
 *
 *
 * @author Armand Altiveros, from code provided in SER316 shell
 * @version 1.0
 */

public class Attack {

    private String type;
    private double damage;

    public Attack(double damage, String type) {
        this.type = type;
        this.damage = damage;
    }

    public double getDamage() {
        return damage;
    }

    /**
     * getter method for attack type.
     * @return sring representing the attack type.
     */

    public String getType() {
        return type;
    }
}