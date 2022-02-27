package back.conjugaison.cor;

import back.conjugaison.conjugate.Verb;
import back.conjugaison.conjugate.groups._3rdgroup.auxiliaries.Avoir;

public class AvoirCOR extends VerbCOR {

    public AvoirCOR(VerbCOR next) {
        super(next);
    }

    @Override
    protected Verb findGroupExp(String verb) {
        try {
            return new Avoir(verb);
        } catch (Exception e){
            return null;
        }
    }
    
}
