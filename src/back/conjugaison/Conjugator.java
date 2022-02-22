package back.conjugaison;

import back.conjugaison.conjugate.Verb;
import back.conjugaison.cor.Verb1stGroupCOR;
import back.conjugaison.cor.Verb2ndGroupCOR;
import back.conjugaison.cor.Verb3rdGroupAitreCOR;
import back.conjugaison.cor.Verb3rdGroupEttreCOR;
import back.conjugaison.cor.Verb3rdGroupIndreCOR;
import back.conjugaison.cor.Verb3rdGroupOudreCOR;
import back.conjugaison.cor.VerbCOR;
import back.conjugaison.cor.VerbParticularGerCOR;

public class Conjugator {

    private VerbCOR finder;

    private Conjugator(){
        finder = new Verb2ndGroupCOR(null);
        finder = new Verb1stGroupCOR(finder);
        finder = new VerbParticularGerCOR(finder);
        finder = new Verb3rdGroupAitreCOR(finder);
        finder = new Verb3rdGroupIndreCOR(finder);
        finder = new Verb3rdGroupEttreCOR(finder);
        finder = new Verb3rdGroupOudreCOR(finder);
    }

    private static Conjugator instance;

    public static Conjugator getInstance(){
        if(instance == null){
            instance = new Conjugator();
        }
        return instance;
    }

    public String conjugatePronouns(String verb, String mode, String tense){
        Verb result = finder.findGroup(verb);
        return result.conjugatePronouns(tense, mode);
    }
}
