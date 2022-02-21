package back.conjugaison.conjugate;

public class Verb3rdGroupIndre extends Verb {
    private static final String END = "indre"; 

    public Verb3rdGroupIndre(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    @Override
    public String ending1stPersonPlural() {
        return "ignons";
    }

    @Override
    protected String ending1stPersonSingular() {
        return "ins";
    }

    @Override
    protected String endingPastParticipate() {
        return "int";
    }
}
