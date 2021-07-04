public class RalphieMon extends Mascotmon {

    public RalphieMon() {
        name = "RALPHIE";
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
        Attack attack = null;;
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
        System.out.println(name.toString().toLowerCase() + desc);
        return attack;
    }

    /**
     * @see Mascotmon#setTypeBonuses(Mascotmon)
     */

    @Override
    public void setTypeBonuses(Mascotmon opponent) {
        if (opponent.type.compareTo("Fire") == 0) {
            this.typeBonus = Constants.DEBUFF;
            opponent.typeBonus = Constants.BONUS;
        } else if (opponent.type.compareTo("Water") == 0) {
            this.typeBonus = Constants.BONUS;
            opponent.typeBonus = Constants.DEBUFF;
        }
    }
}
