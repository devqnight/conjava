package back.conjugaison.cor;

import back.conjugaison.conjugate.Verb;
import back.conjugaison.conjugate.VerbParticularGer;

public class VerbParticularGerCOR extends VerbCOR{

    public VerbParticularGerCOR(VerbCOR next){
        super(next);
    }

    @Override
    protected Verb findGroupExp(String verb) {
        try {
            return new VerbParticularGer(verb);
        } catch (Exception e) {
            return null;
        }
    }
}
