package back.conjugaison.conjugate;

public class Verb3rdGroupOudre extends Verb{
    private static final String END = "oudre"; 

    public Verb3rdGroupOudre(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    @Override
    protected String ending1stPersonSingular() {
        return "ous";
    }

    @Override
    protected String ending1stPersonPlural() {
        return "olvons";
    }

    @Override
    protected String endingPastParticipate() {
        return "out";
    }
}
