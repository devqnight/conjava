package back.conjugaison;

import back.conjugaison.conjugate.Mode;
import back.conjugaison.conjugate.Tense;

public class App {
    public static void main(String[] args) throws Exception {
        Conjugator conjug = Conjugator.getInstance();
        String result = conjug.conjugatePronouns("aimer", Mode.SUBJONCTIVE, Tense.PRESENT);
        System.out.println(result);

        String[] verbList = {
            "marcher",
            //"frémir",
            //"finir",
            //"chanter",
            //"nourrir",
            //"parler",
            //"planter",
            //"porter",
            //"rugir",
            //"ralentir",
            //"être",
            //"Michael Jackson",
            "manger",
            "aimer",
            "paraître",
            "rejoindre",
            "absoudre",
            "transmettre"
        };

        for(String verb : verbList){
            try {
                System.out.println(conjug.conjugatePronouns(verb, Mode.INDICATIVE, Tense.PRESENT));
                System.out.println(conjug.conjugatePronouns(verb, Mode.INDICATIVE, Tense.FUTURE));
                System.out.println(conjug.conjugatePronouns(verb, Mode.INDICATIVE, Tense.PAST_PERFECT));
                System.out.println(conjug.conjugatePronouns(verb, Mode.INDICATIVE, Tense.IMPERFECT));
                //System.out.println(conjug.conjugatePronouns(verb, Mode.SUBJONCTIVE, Tense.PRESENT));
                //System.out.println(conjug.conjugatePronouns(verb, Mode.SUBJONCTIVE, Tense.IMPERFECT));
                //System.out.println(conjug.conjugatePronouns(verb, Mode.CONDITIONAL, Tense.PRESENT));
                //System.out.println(conjug.conjugatePronouns(verb, Mode.CONDITIONAL, Tense.PAST_PERFECT));
            } catch (Exception e) {
                System.out.println("\n"+e.getMessage()+"\n");
            }
        }

    }
}
