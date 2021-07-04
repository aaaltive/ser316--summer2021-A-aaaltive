public class MascotmonFactory {

    /**
     * This method is the getter for a new Mascotmon in the factory, tells the factory which
     * constructor to call.
     * @param name String, the name of the monster
     * @return Mascotmon the one made by the factory
     */
    public Mascotmon getMascotmon(String name) {
        switch (name) {
            case "ALBERT":
                return new AlbertMon();
            case "RALPHIE":
                return new RalphieMon();
            case "SPARKY":
                return new SparkyMon();
            default:
                return new CustomMon(name);
        }
    }
}
