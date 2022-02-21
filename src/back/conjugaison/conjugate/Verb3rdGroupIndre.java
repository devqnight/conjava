package back.conjugaison.conjugate;

public class Verb3rdGroupIndre extends Verb {
    private static final String END = "indre"; 

    public Verb3rdGroupIndre(String verb) {
        this.init(verb, END);
        this.end = END;
    }
    
    private String endingPlural(){
        return "ign";
    }

    @Override
    protected String ending1stPersonSingular() {
        return "ins";
    }

    @Override
    protected String ending2ndPersonSingular() {
        return ending1stPersonSingular();
    }

    @Override
    protected String ending3rdPersonSingular() {
        return "int";
    }

    @Override
    public String ending1stPersonPlural() {
        return endingPlural() + Verb.ENDING_1ST_PERSON_PLURAL;
    }

    @Override
    protected String ending2ndPersonPlural() {
        return endingPlural() + Verb.ENDING_2ND_PERSON_PLURAL;
    }

    @Override
    protected String ending3rdPersonPlural() {
        return endingPlural() + Verb.ENDING_3RD_PERSON_PLURAL;
    }

    @Override
    protected String endingPastParticipate() {
        return "int";
    }

}
