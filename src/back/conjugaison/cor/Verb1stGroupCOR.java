package back.conjugaison.cor;

import back.conjugaison.conjugate.Verb;
import back.conjugaison.conjugate.Verb1stGroup;

public class Verb1stGroupCOR extends VerbCOR{

    public Verb1stGroupCOR(VerbCOR next){
        super(next);
    }

    @Override
    protected Verb findGroupExp(String verb) {
        try {
            return new Verb1stGroup(verb);
        } catch (Exception e) {
            return null;
        }
    }


}
