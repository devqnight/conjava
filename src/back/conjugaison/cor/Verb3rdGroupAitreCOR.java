package back.conjugaison.cor;

import back.conjugaison.conjugate.Verb;
import back.conjugaison.conjugate._3rdgroup.Verb3rdGroupAitre;

public class Verb3rdGroupAitreCOR extends VerbCOR {
    public Verb3rdGroupAitreCOR(VerbCOR next){
        super(next);
    }

    @Override
    protected Verb findGroupExp(String verb) {
        try {
            return new Verb3rdGroupAitre(verb);
        } catch (Exception e) {
            return null;
        }
    }
}
