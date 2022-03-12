package back.conjugaison.conjugate.groups._3rdgroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import back.conjugaison.conjugate.Mode;
import back.conjugaison.conjugate.Tense;
import back.conjugaison.conjugate.Verb;
import back.conjugaison.utils.Utils;

public class Verb3rdGroupEttre extends Verb{
    private static final String END = "ettre"; 

    public Verb3rdGroupEttre(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    /* @Override
    protected HashMap<String, String> getPresentMap(String mode) {
        return switch(mode){
            case Mode.CONDITIONAL -> Utils.conjugHashMap("ettrais", "ettrais", "ettrait", "ettrions", "ettriez", "ettraient");
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("ette", "ettes", "ette", "ettions", "ettiez", "ettent");
            default -> Utils.conjugHashMap("ets", "ets", "et", "ettons", "ettez", "ettent");
        };
    }

    @Override
    protected HashMap<String, String> getFutureMap(String mode) {
        return switch(mode){
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
            case Mode.INDICATIVE -> Utils.conjugHashMap("ettrai", "ettras", "ettra", "ettrons", "ettrez", "ettront");
        };
    }

    @Override
    protected HashMap<String, String> getImperfectMap(String mode) {
        return switch(mode){
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("isse", "isses", "ît", "issions", "issiez", "issent");
            case Mode.INDICATIVE -> Utils.conjugHashMap("ettais", "ettais", "ettait", "ettions", "ettiez", "ettaient");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    }

    @Override
    protected HashMap<String, String> getPastPerfectMap(String mode) {
        return switch(mode){
            case Mode.INDICATIVE -> Utils.conjugHashMap("is", "is", "is", "is", "is", "is");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    } */
    
    @Override
    protected Map<String, String> getIndicativeMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.IndicativeTenses.PRESENT, Utils.conjugList("ets", "ets", "et", "ettons", "ettez", "ettent"));
        tenseConjugations.put(Tense.IndicativeTenses.FUTURE_SIMPLE, Utils.conjugList("ettrai", "ettras", "ettra", "ettrons", "ettrez", "ettront"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_FUTURE, Utils.conjugList("is", "is", "is", "is", "is", "is"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_SIMPLE, Utils.conjugList("is", "is", "it", "îmes", "îtes", "irent"));
        tenseConjugations.put(Tense.IndicativeTenses.IMPERFECT, Utils.conjugList("ettais", "ettais", "ettait", "ettions", "ettiez", "ettaient"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_PERFECT, Utils.conjugList("is", "is", "is", "is", "is", "is"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

    @Override
    protected Map<String, String> getConditionalMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.ConditionalTenses.PRESENT, Utils.conjugList("ettrais", "ettrais", "ettrait", "ettrions", "ettriez", "ettraient"));
        tenseConjugations.put(Tense.ConditionalTenses.PAST_1, Utils.conjugList("is", "is", "is", "is", "is", "is"));
        tenseConjugations.put(Tense.ConditionalTenses.PAST_2, Utils.conjugList("is", "is", "is", "is", "is", "is"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

    @Override
    protected Map<String, String> getSubjonctiveMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.SubjonctiveTenses.PRESENT, Utils.conjugList("ette", "ettes", "ette", "ettions", "ettiez", "ettent"));
        tenseConjugations.put(Tense.SubjonctiveTenses.IMPERFECT, Utils.conjugList("isse", "isses", "ît", "issions", "issiez", "issent"));
        tenseConjugations.put(Tense.SubjonctiveTenses.PAST, Utils.conjugList("is", "is", "is", "is", "is", "is"));
        tenseConjugations.put(Tense.SubjonctiveTenses.PLUSPERFECT, Utils.conjugList("is", "is", "is", "is", "is", "is"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

}
