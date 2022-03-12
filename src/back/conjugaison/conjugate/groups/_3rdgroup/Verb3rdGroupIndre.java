package back.conjugaison.conjugate.groups._3rdgroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import back.conjugaison.conjugate.Mode;
import back.conjugaison.conjugate.Tense;
import back.conjugaison.conjugate.Verb;
import back.conjugaison.utils.Utils;

public class Verb3rdGroupIndre extends Verb {
    private static final String END = "indre"; 

    public Verb3rdGroupIndre(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    /* @Override
    protected HashMap<String, String> getPresentMap(String mode) {
        return switch(mode){
            case Mode.CONDITIONAL -> Utils.conjugHashMap("indrais", "indrais", "indrait", "indrions", "indriez", "indraient");
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("igne", "ignes", "igne", "ignions", "igniez", "ignent");
            default -> Utils.conjugHashMap("ins", "ins", "int", "ignons", "ignez", "ignent");
        };
    }

    @Override
    protected HashMap<String, String> getFutureMap(String mode) {
        return switch(mode){
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
            case Mode.INDICATIVE -> Utils.conjugHashMap("indrai", "indras", "indra", "indrons", "indrez", "indront");
        };
    }

    @Override
    protected HashMap<String, String> getImperfectMap(String mode) {
        return switch(mode){
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("ignisse", "ignisses", "ignît", "ignions", "igniez", "ignent");
            case Mode.INDICATIVE -> Utils.conjugHashMap("ignais", "ignais", "inait", "ignions", "igniez", "ignaient");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    }

    @Override
    protected HashMap<String, String> getPastPerfectMap(String mode) {
        return switch(mode){
            case Mode.INDICATIVE -> Utils.conjugHashMap("int", "int", "int", "int", "int", "int");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    } */
    
    @Override
    protected Map<String, String> getIndicativeMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.IndicativeTenses.PRESENT, Utils.conjugList("ins", "ins", "int", "ignons", "ignez", "ignent"));
        tenseConjugations.put(Tense.IndicativeTenses.FUTURE_SIMPLE, Utils.conjugList("indrai", "indras", "indra", "indrons", "indrez", "indront"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_FUTURE, Utils.conjugList("int", "int", "int", "int", "int", "int"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_SIMPLE, Utils.conjugList("ignis", "ignis", "ignit", "ignîmes", "ignîtes", "ignirent"));
        tenseConjugations.put(Tense.IndicativeTenses.IMPERFECT, Utils.conjugList("ignais", "ignais", "inait", "ignions", "igniez", "ignaient"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_PERFECT, Utils.conjugList("int", "int", "int", "int", "int", "int"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

    @Override
    protected Map<String, String> getConditionalMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.ConditionalTenses.PRESENT, Utils.conjugList("indrais", "indrais", "indrait", "indrions", "indriez", "indraient"));
        tenseConjugations.put(Tense.ConditionalTenses.PAST_1, Utils.conjugList("int", "int", "int", "int", "int", "int"));
        tenseConjugations.put(Tense.ConditionalTenses.PAST_2, Utils.conjugList("int", "int", "int", "int", "int", "int"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

    @Override
    protected Map<String, String> getSubjonctiveMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.SubjonctiveTenses.PRESENT, Utils.conjugList("igne", "ignes", "igne", "ignions", "igniez", "ignent"));
        tenseConjugations.put(Tense.SubjonctiveTenses.IMPERFECT, Utils.conjugList("ignisse", "ignisses", "ignît", "ignions", "igniez", "ignent"));
        tenseConjugations.put(Tense.SubjonctiveTenses.PAST, Utils.conjugList("int", "int", "int", "int", "int", "int"));
        tenseConjugations.put(Tense.SubjonctiveTenses.PLUSPERFECT, Utils.conjugList("int", "int", "int", "int", "int", "int"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

}
