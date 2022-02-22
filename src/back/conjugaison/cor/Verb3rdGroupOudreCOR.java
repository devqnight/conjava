package back.conjugaison.cor;

import back.conjugaison.conjugate.Verb;
import back.conjugaison.conjugate._3rdgroup.Verb3rdGroupOudre;

public class Verb3rdGroupOudreCOR extends VerbCOR{
    public Verb3rdGroupOudreCOR(VerbCOR next){
        super(next);
    }

    @Override
    protected Verb findGroupExp(String verb) {
        try {
            return new Verb3rdGroupOudre(verb);
        } catch (Exception e) {
            return null;
        }
    }
}
