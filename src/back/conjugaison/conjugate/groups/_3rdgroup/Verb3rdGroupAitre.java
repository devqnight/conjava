package back.conjugaison.conjugate.groups._3rdgroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import back.conjugaison.conjugate.Mode;
import back.conjugaison.conjugate.Tense;
import back.conjugaison.conjugate.Verb;
import back.conjugaison.utils.Utils;

public class Verb3rdGroupAitre extends Verb {
    private static final String END = "aître"; 

    public Verb3rdGroupAitre(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    /* @Override
    protected HashMap<String, String> getPresentMap(String mode) {
        return switch(mode){
            case Mode.CONDITIONAL -> Utils.conjugHashMap("aîtrais", "aîtrais", "aîtrait", "aîtrions", "aîtriez", "aîtraient");
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("aisse", "aisses", "aisse", "aissions", "aissiez", "aissent");
            default -> Utils.conjugHashMap("ais", "ais", "aît", "aissons", "aissez", "aissent");
        };
    }

    @Override
    protected HashMap<String, String> getFutureMap(String mode) {
        return switch(mode){
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
            case Mode.INDICATIVE -> Utils.conjugHashMap("aîtrai", "aîtras", "aîtra", "aîtrons", "aîtrez", "aîtront");
        };
    }

    @Override
    protected HashMap<String, String> getImperfectMap(String mode) {
        return switch(mode){
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("usse", "usses", "ût", "ussions", "ussiez", "ussent");
            case Mode.INDICATIVE -> Utils.conjugHashMap("aissais", "aissais", "aissait", "aissions", "aissiez", "aissaient");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    }

    @Override
    protected HashMap<String, String> getPastPerfectMap(String mode) {
        return switch(mode){
            case Mode.INDICATIVE -> Utils.conjugHashMap("u", "u", "u", "u", "u", "u");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    } */

    @Override
    protected Map<String, String> getIndicativeMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.IndicativeTenses.PRESENT, Utils.conjugList("ais", "ais", "aît", "aissons", "aissez", "aissent"));
        tenseConjugations.put(Tense.IndicativeTenses.FUTURE_SIMPLE, Utils.conjugList("aîtrai", "aîtras", "aîtra", "aîtrons", "aîtrez", "aîtront"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_FUTURE, Utils.conjugList("u", "u", "u", "u", "u", "u"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_SIMPLE, Utils.conjugList("us", "us", "ut", "ûmes", "ûtes", "urent"));
        tenseConjugations.put(Tense.IndicativeTenses.IMPERFECT, Utils.conjugList("aissais", "aissais", "aissait", "aissions", "aissiez", "aissaient"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_PERFECT, Utils.conjugList("u", "u", "u", "u", "u", "u"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

    @Override
    protected Map<String, String> getConditionalMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.ConditionalTenses.PRESENT, Utils.conjugList("aîtrais", "aîtrais", "aîtrait", "aîtrions", "aîtriez", "aîtraient"));
        tenseConjugations.put(Tense.ConditionalTenses.PAST_1, Utils.conjugList("u", "u", "u", "u", "u", "u"));
        tenseConjugations.put(Tense.ConditionalTenses.PAST_2, Utils.conjugList("u", "u", "u", "u", "u", "u"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

    @Override
    protected Map<String, String> getSubjonctiveMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.SubjonctiveTenses.PRESENT, Utils.conjugList("aisse", "aisses", "aisse", "aissions", "aissiez", "aissent"));
        tenseConjugations.put(Tense.SubjonctiveTenses.IMPERFECT, Utils.conjugList("usse", "usses", "ût", "ussions", "ussiez", "ussent"));
        tenseConjugations.put(Tense.SubjonctiveTenses.PAST, Utils.conjugList("u", "u", "u", "u", "u", "u"));
        tenseConjugations.put(Tense.SubjonctiveTenses.PLUSPERFECT, Utils.conjugList("u", "u", "u", "u", "u", "u"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

}
