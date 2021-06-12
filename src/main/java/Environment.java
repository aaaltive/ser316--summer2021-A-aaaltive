public class Environment {

    Weather weather;
    String buffedType;
    String debuffedType;
    //SER316 TASK 2 SPOTBUGS FIX
    //SER316 TASK 2 SPOTBUGS FIX

    public Environment() {
        this(Weather.neutral);
    }

    /**
     * creates a weather type for a battle scenario and sets up the buffed and
     * debuffed types.
     * @param weather the weather type for the battle
     */

    public Environment(Weather weather) {
        this.weather = weather;
        //SER316 TASK 2 SPOTBUGS FIX
        //SER316 TASK 2 SPOTBUGS FIX
        switch (weather) {
            case sunny:
                this.buffedType = "Fire";
                this.debuffedType = "Water";
                break;
            case rainy:
                this.buffedType = "Water";
                this.debuffedType = "Fire";
                break;
            case drought:
                this.buffedType = "Ground";
                this.debuffedType = "Normal";
                break;
            default:
                this.buffedType = "";
                this.debuffedType = "";
                break;
        }
    }

    public String getBuffedType() {
        return buffedType;
    }

    public String getDebuffedType() {
        return debuffedType;
    }

    public enum Weather {
        sunny, rainy, drought, neutral
    }
}
