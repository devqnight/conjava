package back.conjugaison.cor;

import back.conjugaison.conjugate.Verb;
import back.conjugaison.conjugate.groups._3rdgroup.auxiliaries.Etre;

public class EtreCOR extends VerbCOR{

    public EtreCOR(VerbCOR next) {
        super(next);
    }

    @Override
    protected Verb findGroupExp(String verb) {
        try {
            return new Etre(verb);
        } catch (Exception e) {
            return null;
        }
    }
    
}
