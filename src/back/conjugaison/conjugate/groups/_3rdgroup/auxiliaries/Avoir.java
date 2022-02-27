package back.conjugaison.conjugate.groups._3rdgroup.auxiliaries;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import back.conjugaison.conjugate.Mode;
import back.conjugaison.conjugate.Tense;
import back.conjugaison.conjugate.Verb;
import back.conjugaison.utils.Utils;

public class Avoir extends Verb {

    public static final String END = "avoir";

    public Avoir(String verb){
        this.init(verb, END);
        this.end = END;
    }

    @Override
    protected Map<String, String> getIndicativeMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.IndicativeTenses.PRESENT, Utils.conjugList("ai", "as", "a", "avons", "avez", "ont"));
        tenseConjugations.put(Tense.IndicativeTenses.FUTURE_SIMPLE, Utils.conjugList("aurai", "auras", "aura", "aurons", "aurez", "auront"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_FUTURE, Utils.conjugList("eu", "eu", "eu", "eu", "eu", "eu"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_SIMPLE, Utils.conjugList("eus", "eus", "eut", "eûmes", "eûtes", "eurent"));
        tenseConjugations.put(Tense.IndicativeTenses.IMPERFECT, Utils.conjugList("avais", "avais", "avait", "avions", "aviez", "avaient"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_PERFECT, Utils.conjugList("eu", "eu", "eu", "eu", "eu", "eu"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

    @Override
    protected Map<String, String> getConditionalMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.ConditionalTenses.PRESENT, Utils.conjugList("aurais", "aurais", "aurait", "aurions", "auriez", "auraient"));
        tenseConjugations.put(Tense.ConditionalTenses.PAST_1, Utils.conjugList("eu", "eu", "eu", "eu", "eu", "eu"));
        tenseConjugations.put(Tense.ConditionalTenses.PAST_2, Utils.conjugList("eu", "eu", "eu", "eu", "eu", "eu"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

    @Override
    protected Map<String, String> getSubjonctiveMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.SubjonctiveTenses.PRESENT, Utils.conjugList("aie", "aies", "ait", "ayons", "ayez", "aient"));
        tenseConjugations.put(Tense.SubjonctiveTenses.IMPERFECT, Utils.conjugList("eusse", "eusses", "eût", "eussions", "eussiez", "eussent"));
        tenseConjugations.put(Tense.SubjonctiveTenses.PAST, Utils.conjugList("eu", "eu", "eu", "eu", "eu", "eu"));
        tenseConjugations.put(Tense.SubjonctiveTenses.PLUPERFECT, Utils.conjugList("eu", "eu", "eu", "eu", "eu", "eu"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }
    
}
