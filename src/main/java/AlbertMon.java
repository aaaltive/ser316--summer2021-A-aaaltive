import java.util.concurrent.ThreadLocalRandom;

public class AlbertMon extends Mascotmon{

    /**
     * The constructor.
     */

    public AlbertMon() {
        name = "ALBERT";
        setType();
        setStats();
        setDescription();
    }

    /**
     * @see Mascotmon#attack()
     */

    @Override
    public Attack attack() {
        double attackDamage = 0;
        int attackNumber = getAtackNumber();

        String desc = "";
        Attack attack = null;
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

        System.out.println(name.toString().toLowerCase() + desc);
        return attack;
    }

    /**
     * @see Mascotmon#setTypeBonuses(Mascotmon)
     */

    @Override
    public void setTypeBonuses(Mascotmon opponent) {
        if (opponent.type.compareTo("Ground") == 0) {
            this.typeBonus = Constants.DEBUFF;
            opponent.typeBonus = Constants.BONUS;
        } else if (opponent.type.compareTo("Fire") == 0) {
            this.typeBonus = Constants.BONUS;
            opponent.typeBonus = Constants.DEBUFF;
        }
    }

}
