package back.conjugaison.conjugate;

public class Verb3rdGroupEttre extends Verb{
    private static final String END = "ettre"; 

    public Verb3rdGroupEttre(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    @Override
    protected String ending1stPersonSingular() {
        return "ets";
    }

    @Override
    protected String ending1stPersonPlural() {
        return "ettons";
    }

    @Override
    protected String endingPastParticipate() {
        return "is";
    }
}
