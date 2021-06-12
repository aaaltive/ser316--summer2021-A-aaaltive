/**
 * Class sets up a Type object that is held by a mascotmon.
 *
 * @author Armand Altiveros, from code provided in SER316 shell
 * @version 1.0
 */

public class Type {

    private String type;

    /**
     * Default constructor for the Type objects.
     */

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

    /**
     * Getter method for type attribute.
     * @return string representing the type.
     */

    public String getType() {
        return type;
    }
}
