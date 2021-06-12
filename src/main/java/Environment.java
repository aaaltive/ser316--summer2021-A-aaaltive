public class Environment {

    private Weather WEATHER;
    private String buffedType;
    private String DebuffedType;
    private double buffModifier;
    private double debuffModifier;

    public Environment(){
        this(Weather.NEUTRAL);
    }

    public Environment(Weather weather) {
        this.WEATHER = weather;
        this.buffModifier = 1.25;
        this.debuffModifier = 0.75;
        switch (weather){
            case SUNNY:
               this.buffedType = "Fire";
               this.DebuffedType = "Water";
               break;
            case RAINY:
                this.buffedType = "Water";
                this.DebuffedType = "Fire";
                break;
            case DROUGHT:
                this.buffedType = "Ground";
                this.DebuffedType = "Normal";
                break;
            default:
                this.buffedType = "";
                this.DebuffedType = "";
                break;
        }
    }

    public String getBuffedType(){
        return buffedType;
    }

    public String getDebuffedType(){
        return DebuffedType;
    }

    public Weather getWEATHER() {
        return WEATHER;
    }

    public double getBuffModifier() {
        return buffModifier;
    }

    public double getDebuffModifier() {
        return debuffModifier;
    }

    public enum Weather {
        SUNNY, RAINY, DROUGHT, NEUTRAL
    }
}
