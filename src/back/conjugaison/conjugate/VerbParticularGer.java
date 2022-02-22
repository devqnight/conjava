package back.conjugaison.conjugate;

public class VerbParticularGer extends Verb1stGroup {

    public static final String END = "ger";

    public VerbParticularGer(String verb) {
        super(verb);
        if(!this.getRoot().endsWith("g"))
            throw new IllegalArgumentException(verb+ " is not a 'ger' verb");
        this.ENDING_1ST_PERSON_PLURAL = "eons";
    }

    //@Override
    //protected String ending1stPersonPlural() {
    //    return "eons";
    //}
}
