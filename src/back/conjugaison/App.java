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
            "être",
            "avoir",
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

        for(String verb : verbList){
            try {
                System.out.println(conjug.conjugatePronouns(verb, Mode.INDICATIVE, Tense.IndicativeTenses.PRESENT));
                System.out.println(conjug.conjugatePronouns(verb, Mode.INDICATIVE, Tense.IndicativeTenses.FUTURE_SIMPLE));
                System.out.println(conjug.conjugatePronouns(verb, Mode.INDICATIVE, Tense.IndicativeTenses.IMPERFECT));
                System.out.println(conjug.conjugatePronouns(verb, Mode.INDICATIVE, Tense.IndicativeTenses.PAST_PERFECT));
                System.out.println(conjug.conjugatePronouns(verb, Mode.INDICATIVE, Tense.IndicativeTenses.PAST_FUTURE));
                System.out.println(conjug.conjugatePronouns(verb, Mode.SUBJONCTIVE, Tense.SubjonctiveTenses.PRESENT));
                System.out.println(conjug.conjugatePronouns(verb, Mode.SUBJONCTIVE, Tense.SubjonctiveTenses.IMPERFECT));
                System.out.println(conjug.conjugatePronouns(verb, Mode.SUBJONCTIVE, Tense.SubjonctiveTenses.PAST));
                System.out.println(conjug.conjugatePronouns(verb, Mode.SUBJONCTIVE, Tense.SubjonctiveTenses.PLUPERFECT));
                System.out.println(conjug.conjugatePronouns(verb, Mode.CONDITIONAL, Tense.ConditionalTenses.PRESENT));
                System.out.println(conjug.conjugatePronouns(verb, Mode.CONDITIONAL, Tense.ConditionalTenses.PAST_1));
                System.out.println(conjug.conjugatePronouns(verb, Mode.CONDITIONAL, Tense.ConditionalTenses.PAST_2));
            } catch (Exception e) {
                System.out.println("\n"+e.getMessage()+"\n");
            }
        }

    }
}
