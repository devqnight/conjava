package back.conjugaison.conjugate;

public class Verb3rdGroupOudre extends Verb{
    private static final String END = "oudre"; 

    public Verb3rdGroupOudre(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    @Override
    protected String endingPlural(){
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

    //@Override
    //protected String ending1stPersonPlural() {
    //    return endingPlural() + ENDING_1ST_PERSON_PLURAL;
    //}

    @Override
    protected String ending2ndPersonPlural() {
        return endingPlural() + ENDING_2ND_PERSON_PLURAL;
    }

    @Override
    protected String ending3rdPersonPlural() {
        return endingPlural() + ENDING_3RD_PERSON_PLURAL;
    }

    @Override
    protected String endingPastParticipate() {
        return "out";
    }

}
