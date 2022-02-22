package back.conjugaison.conjugate;

public class Verb2ndGroup extends Verb{

    public static final String END = "ir";

    public Verb2ndGroup(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    @Override
    protected String endingPlural(){
      return "iss";
    }

    @Override
    protected String ending1stPersonSingular() {
        return "is";
    }

    @Override
    protected String ending2ndPersonSingular() {
        return ending1stPersonSingular();
    }

    @Override
    protected String ending3rdPersonSingular() {
        return "it";
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
        return "i";
    }


}
