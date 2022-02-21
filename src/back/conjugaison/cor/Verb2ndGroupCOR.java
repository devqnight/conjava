package back.conjugaison.cor;

import back.conjugaison.conjugate.Verb;
import back.conjugaison.conjugate.Verb2ndGroup;

public class Verb2ndGroupCOR extends VerbCOR{

    public Verb2ndGroupCOR(VerbCOR next){
        super(next);
    }

    @Override
    protected Verb findGroupExp(String verb) {
        try {
            return new Verb2ndGroup(verb);
        } catch (Exception e) {
            return null;
        }
    }

    
}
