package back.conjugaison.conjugate;

public class VerbParticularGer extends Verb1stGroup {

    public static final String END = "ger";

    public VerbParticularGer(String verb) {
        super(verb);
        if(!this.getRoot().endsWith("g"))
            throw new IllegalArgumentException(verb+ " is not a 'ger' verb");
    }

    @Override
    public String ending1stPersonPlural() {
        return "eons";
    }
}
