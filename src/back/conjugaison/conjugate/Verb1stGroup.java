package back.conjugaison.conjugate;

public class Verb1stGroup extends Verb {

    public static final String END = "er";

    public Verb1stGroup(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    @Override
    protected String ending1stPersonSingular() {
        return "e";
    }

    @Override
    protected String ending2ndPersonSingular() {
        return "es";
    }

    @Override
    protected String ending3rdPersonSingular() {
        return this.ending1stPersonSingular();
    }

    @Override
    protected String ending1stPersonPlural() {
        return Verb.ENDING_1ST_PERSON_PLURAL;
    }

    @Override
    protected String ending2ndPersonPlural() {
        return Verb.ENDING_2ND_PERSON_PLURAL;
    }

    @Override
    protected String ending3rdPersonPlural() {
        return Verb.ENDING_3RD_PERSON_PLURAL;
    }

    @Override
    protected String endingPastParticipate() {
        return "é";
    }


    
}
