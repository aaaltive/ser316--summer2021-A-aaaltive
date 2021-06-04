import java.util.concurrent.ThreadLocalRandom;

public class Mascotmon {
    private String description;
    private String type;
    private Name name;
    private Stats stats;
    private double weatherBonus = 1.0;
    private double typeBonus = 1.0;
    private int buf_counter = 0;

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
        getType();
        setStats();
        setDescription();
    }

    public Mascotmon(Name name) {
        this.name = name;
        getType();
        setStats();
        setDescription();
    }

    private void getType() {
        type t = new type(name);
        this.type = t.getType();
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
     * @return attack damage
     * You can assume that this method uses the values it is supposed to use and is correct. 
     */
    public Attack attack() {
        double attack_Damage = 0;
        int attackNumber = 0;

        while (true) {
            attackNumber = ThreadLocalRandom.current().nextInt(0, 4);
            if (attackNumber == 0 && buf_counter <= 2) {
                buf_counter++;
                break;
            }
            else if (attackNumber != 0){
                break;
            }
        }

        String _desc= "";
        Attack attack = null;

        switch (name) {
            case ALBERT:
                if (attackNumber == 0) {
                    _desc = " uses Iron Scales, increasing defense stat by 10%";
                    stats.setDefense(stats.getDefense() * 1.10);
                    attack = new Attack(0, "None");
                } else if (attackNumber == 1) {
                    _desc = " uses Death Roll";
                    attack = new Attack(stats.getAttack(), "Ground");
                } else if (attackNumber == 2) {
                    _desc = " uses Chomp";
                    attack = new Attack(stats.getAttack(), "Normal");
                } else {
                    _desc = " uses Aqua Cannon";
                    attack = new Attack(stats.getAttack(), "Water");
                }
                break;
            case RALPHIE:
                if (attackNumber == 0) {
                    _desc = " uses Iron Hide, increasing defense stat by 10%";
                    stats.setDefense(stats.getDefense() * 1.10);
                    attack = new Attack(0, "None");
                } else if (attackNumber == 1) {
                    _desc = " uses Ground Stomp";
                    attack = new Attack(stats.getAttack(), "Ground");
                } else if (attackNumber == 2) {
                    _desc = " uses Headbutt";
                    attack = new Attack(stats.getAttack(), "Normal");
                } else {
                    _desc = " uses Flaming Horn";
                    attack = new Attack(stats.getAttack(), "Fire");
                }
                break;
            case SPARKY:
                if (attackNumber == 0) {
                    _desc = " uses Heat Up, increasing attack stat by 10%";
                    stats.setAttack(stats.getAttack() * 1.10);
                    attack = new Attack(0, "None");
                } else if (attackNumber == 1) {
                    _desc = " uses Inferno";
                    attack = new Attack(stats.getAttack(), "Fire");
                } else if (attackNumber == 2) {
                    _desc = " uses Quick Attack";
                    attack = new Attack(stats.getAttack(), "Normal");
                    System.out.println("Attack value: " + stats.getAttack());
                } else {
                    _desc = " uses Earthquake";
                    attack = new Attack(stats.getAttack(), "Ground");
                }
                break;
            case BULLY:
                if (attackNumber == 0) {
                    _desc = " uses Sleep, increasing health stat by 10%";
                    double health = stats.getHealth() * 1.10;
                    stats.setHealth(Math.round(health));
                    attack = new Attack(0, "None");
                } else if (attackNumber == 1) {
                    _desc = " uses Body Slam";
                    attack = new Attack(stats.getAttack(), "Normal");
                } else if (attackNumber == 2) {
                    _desc = " uses Splash";
                    attack = new Attack(stats.getAttack(), "Water");
                } else {
                    _desc = " uses Ground Pound";
                    attack = new Attack(stats.getAttack(), "Ground");
                }
        }
            
        System.out.println(name.toString().toLowerCase() + _desc);
        return attack;
    }

    public void setWeatherBonus(Environment weather) {
        if (this.type.compareTo(weather.getBuffedType())==0){
            this.weatherBonus = 1.25;
        }
        else if (this.type.compareTo(weather.getDebuffedType())==0){
            this.weatherBonus = .75;
        }
    }

    public void setTypeBonuses(Mascotmon m) {
        switch (this.type){
            case "Fire":
                if (m.type.compareTo("Water") == 0){
                    this.typeBonus = .75;
                    m.typeBonus = 1.25;
                }
                else if (m.type.compareTo("Ground") == 0){
                    this.typeBonus = 1.25;
                    m.typeBonus = .75;
                }
                break;
            case "Water":
                if (m.type.compareTo("Ground") == 0){
                    this.typeBonus = .75;
                    m.typeBonus = 1.25;
                }
                else if (m.type.compareTo("Fire") == 0){
                    this.typeBonus = 1.25;
                    m.typeBonus = .75;
                }
                break;
            case "Ground":
                if (m.type.compareTo("Fire") == 0){
                    this.typeBonus = .75;
                    m.typeBonus = 1.25;
                }
                else if (m.type.compareTo("Water") == 0){
                    this.typeBonus = 1.25;
                    m.typeBonus = .75;
                }
                break;
        }
    }
    
    public Name getName() {
        return name;
    }

    public Stats getStats() {
        return stats;
    }

    public String getDescription() {
        return description;
    }

    public enum Name {
        ALBERT, RALPHIE, SPARKY, BULLY
    }
}
