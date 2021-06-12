public class Type {

    String type;

    public Type() {
        type = "Normal";
    }

    /**
     * Constructor of Type objects.
     * @param name name of the mascot who's type we are getting.
     */

    public Type(Mascotmon.Name name) {
        if (name.equals(Mascotmon.Name.ALBERT)) {
            type = "Water";
        } else if (name.equals(Mascotmon.Name.RALPHIE)) {
            type = "Ground";
        } else if (name.equals(Mascotmon.Name.SPARKY)) {
            type = "Fire";
        } else {
            type = "Normal";
        }
    }
}
