package back.conjugaison.conjugate.groups;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import back.conjugaison.conjugate.Mode;
import back.conjugaison.conjugate.Tense;
import back.conjugaison.conjugate.Verb;
import back.conjugaison.utils.Utils;

public class Verb2ndGroup extends Verb{

    public static final String END = "ir";

    public Verb2ndGroup(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    /* @Override
    protected HashMap<String, String> getPresentMap(String mode) {
        return switch(mode){
            case Mode.CONDITIONAL -> Utils.conjugHashMap("irais", "irais", "irait", "irions", "iriez", "iraient");
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("isse", "isses", "isse", "issions", "issiez", "issent");
            default -> Utils.conjugHashMap("is", "is", "it", "issons", "issez", "issent");
        };
    }

    @Override
    protected HashMap<String, String> getFutureMap(String mode) {
        return switch(mode){
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
            case Mode.INDICATIVE -> Utils.conjugHashMap("irai", "iras", "ira", "irons", "irez", "iront");
        };
    }

    @Override
    protected HashMap<String, String> getImperfectMap(String mode) {
        return switch(mode){
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("isse", "isses", "isse", "issions", "issiez", "issent");
            case Mode.INDICATIVE -> Utils.conjugHashMap("issais", "issais", "issait", "issions", "issiez", "issaient");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    }

    @Override
    protected HashMap<String, String> getPastPerfectMap(String mode) {
        return switch(mode){
            case Mode.INDICATIVE -> Utils.conjugHashMap("i", "i", "i", "i", "i", "i");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    } */

    @Override
    protected Map<String, String> getIndicativeMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.IndicativeTenses.PRESENT, Utils.conjugList("is", "is", "it", "issons", "issez", "issent"));
        tenseConjugations.put(Tense.IndicativeTenses.FUTURE_SIMPLE, Utils.conjugList("irai", "iras", "ira", "irons", "irez", "iront"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_FUTURE, Utils.conjugList("i", "i", "i", "i", "i", "i"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_SIMPLE, Utils.conjugList("is", "is", "it", "îmes", "îtes", "irent"));
        tenseConjugations.put(Tense.IndicativeTenses.IMPERFECT, Utils.conjugList("issais", "issais", "issait", "issions", "issiez", "issaient"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_PERFECT, Utils.conjugList("i", "i", "i", "i", "i", "i"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

    @Override
    protected Map<String, String> getConditionalMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.ConditionalTenses.PRESENT, Utils.conjugList("irais", "irais", "irait", "irions", "iriez", "iraient"));
        tenseConjugations.put(Tense.ConditionalTenses.PAST_1, Utils.conjugList("i", "i", "i", "i", "i", "i"));
        tenseConjugations.put(Tense.ConditionalTenses.PAST_2, Utils.conjugList("i", "i", "i", "i", "i", "i"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

    @Override
    protected Map<String, String> getSubjonctiveMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.SubjonctiveTenses.PRESENT, Utils.conjugList("isse", "isses", "isse", "issions", "issiez", "issent"));
        tenseConjugations.put(Tense.SubjonctiveTenses.IMPERFECT, Utils.conjugList("isse", "isses", "isse", "issions", "issiez", "issent"));
        tenseConjugations.put(Tense.SubjonctiveTenses.PAST, Utils.conjugList("i", "i", "i", "i", "i", "i"));
        tenseConjugations.put(Tense.SubjonctiveTenses.PLUSPERFECT, Utils.conjugList("i", "i", "i", "i", "i", "i"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }


}
