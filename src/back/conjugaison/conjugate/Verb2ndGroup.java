package back.conjugaison.conjugate;

public class Verb2ndGroup extends Verb{

    public static final String END = "ir";

    public Verb2ndGroup(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    @Override
    public String ending1stPersonSingular() {
        return "is";
    }

    @Override
    public String ending1stPersonPlural() {
        return "issons";
    }

    @Override
    public String endingPastParticipate() {
        return "i";
    }
}
