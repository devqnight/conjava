package back.conjugaison;

import java.util.ArrayList;

import back.conjugaison.conjugate.Verb;
import back.conjugaison.conjugate.VerbList;
import back.conjugaison.cor.Verb1stGroupCOR;
import back.conjugaison.cor.Verb2ndGroupCOR;
import back.conjugaison.cor.Verb3rdGroupAitreCOR;
import back.conjugaison.cor.Verb3rdGroupEttreCOR;
import back.conjugaison.cor.Verb3rdGroupIndreCOR;
import back.conjugaison.cor.Verb3rdGroupOudreCOR;
import back.conjugaison.cor.VerbCOR;
import back.conjugaison.cor.VerbParticularGerCOR;

public class App {
    public static void main(String[] args) throws Exception {
        VerbCOR finder = new Verb2ndGroupCOR(null);
        finder = new Verb1stGroupCOR(finder);
        finder = new VerbParticularGerCOR(finder);
        finder = new Verb3rdGroupAitreCOR(finder);
        finder = new Verb3rdGroupIndreCOR(finder);
        finder = new Verb3rdGroupEttreCOR(finder);
        finder = new Verb3rdGroupOudreCOR(finder);

        String[] verbList = {
            "marcher",
            "frémir",
            "finir",
            "chanter",
            "nourrir",
            "parler",
            "planter",
            "porter",
            "rugir",
            "ralentir",
            "être",
            "Michael Jackson",
            "manger",
            "aimer",
            "paraître",
            "rejoindre",
            "absoudre",
            "transmettre"
        };

        ArrayList<Verb> verbObjList = new ArrayList<Verb>();
        for(String verb : verbList){
            try {
                verbObjList.add(finder.findGroup(verb));
            } catch (Exception e) {
                System.out.println("\n"+e.getMessage()+"\n");
            }
        }

        VerbList.getInstance().verbList = verbObjList;
        System.out.println(VerbList.getInstance().conjugate1stPersonSingular());
        System.out.println(VerbList.getInstance().conjugate2ndPersonSingular());
        System.out.println(VerbList.getInstance().conjugate3rdPersonSingular());
        System.out.println(VerbList.getInstance().conjugate1stPersonPlural());
        System.out.println(VerbList.getInstance().conjugate2ndPersonPlural());
        System.out.println(VerbList.getInstance().conjugate3rdPersonPlural());
        System.out.println(VerbList.getInstance().conjugatePresentParticipate());
        System.out.println(VerbList.getInstance().conjugatePastParticipate());

        Verb verb = finder.findGroup("transmettre");
        System.out.println(verb.conjugate2ndPersonPlural());
    }
}
