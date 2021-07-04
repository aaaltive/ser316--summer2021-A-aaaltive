/**
 * Class sets up description objects that are held by Mascotmon.
 *
 * @author Armand Altiveros, from code provided in SER316 shell
 * @version 1.0
 */

public class Description {

    private String description;

    /**
     * The default constructor for a Description object.
     */

    public Description() {
        description = "New mascot";
    }

    /**
     * Created a description for the Mascotmon based on its name.
     * @param name the name of the mascot.
     */

    public Description(String name) {
        if (name.equals("ALBERT")) {
            description = "The Alligator";
        } else if (name.equals("RALPHIE")) {
            description = "The Buffalo";
        } else if (name.equals("SPARKY")) {
            description = "The Sun Devil";
        } else if (name.equals("BULLY")) {
            description = "The Bull Dog";
        } else {
            description = "New custom mascot";
        }
    }

    /**
     * Getter method for the description attribute.
     * @return a string representing this mascotmon's description.
     */
    public String getDescription() {
        return description;
    }
}
