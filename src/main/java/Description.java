public class Description {

    public String description;

    public Description() {
        description = "New mascot";
    }

    /**
     * Created a description for the Mascotmon based on its name.
     * @param name the name of the mascot.
     */
    public Description(Mascotmon.Name name) {
        String n = name.toString();
        if (n.equals("ALBERT")) {
            description = "The Alligator";
        } else if (n.equals("RALPHIE")) {
            description = "The Buffalo";
        } else if (n.equals("SPARKY")) {
            description = "The Sun Devil";
        } else if (n.equals("BULLY")) {
            description = "The Bull Dog";
        } else {
            description = "New mascot";
        }
    }
}
