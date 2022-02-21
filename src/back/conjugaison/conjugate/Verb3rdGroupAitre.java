package back.conjugaison.conjugate;

public class Verb3rdGroupAitre extends Verb {
    private static final String END = "aître"; 

    public Verb3rdGroupAitre(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    @Override
    protected String ending1stPersonSingular() {
        return "ais";
    }

    @Override
    protected String ending1stPersonPlural() {
        return "aissons";
    }

    @Override
    protected String endingPastParticipate() {
        return "u";
    }
    
}
