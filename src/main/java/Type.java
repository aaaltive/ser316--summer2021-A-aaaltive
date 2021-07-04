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

    public Type(String name) {
        if (name.compareTo("ALBERT") == 0) {
            type = "Water";
        } else if (name.compareTo("RALPHIE") == 0) {
            type = "Ground";
        } else if (name.compareTo("SPARKY") == 0) {
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
