package back.conjugaison.conjugate.groups._3rdgroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import back.conjugaison.conjugate.Mode;
import back.conjugaison.conjugate.Tense;
import back.conjugaison.conjugate.Verb;
import back.conjugaison.utils.Utils;

public class Verb3rdGroupOudre extends Verb{
    private static final String END = "oudre"; 

    public Verb3rdGroupOudre(String verb) {
        this.init(verb, END);
        this.end = END;
    }
    
    @Override
    protected Map<String, String> getIndicativeMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.IndicativeTenses.PRESENT, Utils.conjugList("ous", "ous", "out", "olvons", "olvez", "olvent"));
        tenseConjugations.put(Tense.IndicativeTenses.FUTURE_SIMPLE, Utils.conjugList("oudrai", "oudras", "oudra", "oudrons", "oudrez", "oudront"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_FUTURE, Utils.conjugList("olu", "olu", "olu", "olu", "olu", "olu"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_SIMPLE, Utils.conjugList("olus", "olus", "olut", "olûmes", "olûtes", "olurent"));
        tenseConjugations.put(Tense.IndicativeTenses.IMPERFECT, Utils.conjugList("olvais", "olvais", "olvait", "olvions", "olviez", "olvaient"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_PERFECT, Utils.conjugList("olu", "olu", "olu", "olu", "olu", "olu"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

    @Override
    protected Map<String, String> getConditionalMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.ConditionalTenses.PRESENT, Utils.conjugList("oudrais", "oudrais", "oudrait", "oudrions", "oudriez", "oudraient"));
        tenseConjugations.put(Tense.ConditionalTenses.PAST_1, Utils.conjugList("olu", "olu", "olu", "olu", "olu", "olu"));
        tenseConjugations.put(Tense.ConditionalTenses.PAST_2, Utils.conjugList("olu", "olu", "olu", "olu", "olu", "olu"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

    @Override
    protected Map<String, String> getSubjonctiveMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.SubjonctiveTenses.PRESENT, Utils.conjugList("olve", "olves", "olve", "olvions", "olviez", "olvent"));
        tenseConjugations.put(Tense.SubjonctiveTenses.IMPERFECT, Utils.conjugList("olusse", "olusses", "olût", "olussions", "olussiez", "olussent"));
        tenseConjugations.put(Tense.SubjonctiveTenses.PAST, Utils.conjugList("olu", "olu", "olu", "olu", "olu", "olu"));
        tenseConjugations.put(Tense.SubjonctiveTenses.PLUPERFECT, Utils.conjugList("olu", "olu", "olu", "olu", "olu", "olu"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

}
