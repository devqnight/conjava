package back.conjugaison.conjugate;

public class Verb1stGroup extends Verb {

    public static final String END = "er";

    public Verb1stGroup(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    @Override
    public String ending1stPersonSingular() {
        return "e";
    }

    @Override
    public String ending1stPersonPlural() {
        return "ons";
    }

    @Override
    public String endingPastParticipate() {
        return "é";
    }
    
}
