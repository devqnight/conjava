package back.conjugaison.conjugate;

public class Verb3rdGroupEttre extends Verb{
    private static final String END = "ettre"; 

    public Verb3rdGroupEttre(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    @Override
    protected String endingPlural(){
        return "ett";
    }

    @Override
    protected String ending1stPersonSingular() {
        return "ets";
    }

    @Override
    protected String ending2ndPersonSingular() {
        return ending1stPersonSingular(); 
    }

    @Override
    protected String ending3rdPersonSingular() {
        return "et";
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
        return "is";
    }

}
