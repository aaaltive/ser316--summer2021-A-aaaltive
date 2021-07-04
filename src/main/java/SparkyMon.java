public class SparkyMon extends Mascotmon{

    public SparkyMon() {
        name = "SPARKY";
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
        System.out.println(name.toString().toLowerCase() + desc);
        return attack;
    }

    /**
     * @see Mascotmon#setTypeBonuses(Mascotmon)
     */

    @Override
    public void setTypeBonuses(Mascotmon opponent) {
        if (opponent.type.compareTo("Water") == 0) {
            this.typeBonus = Constants.DEBUFF;
            opponent.typeBonus = Constants.BONUS;
        } else if (opponent.type.compareTo("Ground") == 0) {
            this.typeBonus = Constants.BONUS;
            opponent.typeBonus = Constants.DEBUFF;
        }
    }
}
