public class Environment {

    Weather WEATHER;
    String buffedType;
    String debuffedType;
    double buffModifier;
    double debuffModifier;

    public Environment(){
        this(Weather.neutral);
    }

    public Environment(Weather weather) {
        this.WEATHER = weather;
        this.buffModifier = 1.25;
        this.debuffModifier = 0.75;
        switch (weather){
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

    public String GetBuffedType(){
        return buffedType;
    }

    public String getDebuffedType(){
        return debuffedType;
    }

    public enum Weather {
        sunny, rainy, drought, neutral
    }
}
