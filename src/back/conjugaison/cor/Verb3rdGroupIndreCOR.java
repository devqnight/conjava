package back.conjugaison.cor;

import back.conjugaison.conjugate.Verb;
import back.conjugaison.conjugate.Verb3rdGroupIndre;

public class Verb3rdGroupIndreCOR extends VerbCOR {
    public Verb3rdGroupIndreCOR(VerbCOR next){
        super(next);
    }

    @Override
    protected Verb findGroupExp(String verb) {
        try {
            return new Verb3rdGroupIndre(verb);
        } catch (Exception e) {
            return null;
        }
    }
}
