package back.conjugaison.cor;

import back.conjugaison.conjugate.Verb;
import back.conjugaison.conjugate.groups._3rdgroup.Verb3rdGroupEttre;

public class Verb3rdGroupEttreCOR extends VerbCOR{
    public Verb3rdGroupEttreCOR(VerbCOR next){
        super(next);
    }

    @Override
    protected Verb findGroupExp(String verb) {
        try {
            return new Verb3rdGroupEttre(verb);
        } catch (Exception e) {
            return null;
        }
    }
}
