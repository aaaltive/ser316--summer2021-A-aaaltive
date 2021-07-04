public class CustomMon extends Mascotmon {

    public CustomMon(String name) {
        this.name = name;
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

        System.out.println(name.toString().toLowerCase() + desc);
        return attack;
    }

    /**
     * @see Mascotmon#setTypeBonuses(Mascotmon)
     */

    @Override
    public void setTypeBonuses(Mascotmon opponent) {
        this.typeBonus = Constants.NO_BONUS;
    }

}
