package back.conjugaison.conjugate;

public class Verb3rdGroupOudre extends Verb{
    private static final String END = "oudre"; 

    public Verb3rdGroupOudre(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    private String endingPlural(){
        return "olv";
    }

    @Override
    protected String ending1stPersonSingular() {
        return "ous";
    }

    @Override
    protected String ending2ndPersonSingular() {
        return ending1stPersonSingular();
    }

    @Override
    protected String ending3rdPersonSingular() {
        return "out";
    }

    @Override
    protected String ending1stPersonPlural() {
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
        return "out";
    }

}
