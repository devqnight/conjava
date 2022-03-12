package back.conjugaison.conjugate.groups;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import back.conjugaison.conjugate.Mode;
import back.conjugaison.conjugate.Tense;
import back.conjugaison.conjugate.Verb;
import back.conjugaison.utils.Utils;

public class Verb1stGroup extends Verb {

    public static final String END = "er";

    public Verb1stGroup(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    /* @Override
    protected HashMap<String, String> getPresentMap(String mode) {
        return switch(mode){
            case Mode.CONDITIONAL -> Utils.conjugHashMap("erais", "erais", "erait", "erions", "eriez", "eraient");
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("e", "es", "e", "ions", "iez", "ent");
            default -> Utils.conjugHashMap("e", "es", "e", "ons", "ez", "ent");
        };
    }

    @Override
    protected HashMap<String, String> getFutureMap(String mode) {
        return switch(mode){
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
            case Mode.INDICATIVE -> Utils.conjugHashMap("erai", "eras", "era", "erons", "erez", "eront");
        };
    }

    @Override
    protected HashMap<String, String> getImperfectMap(String mode) {
        return switch(mode){
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("asse", "asses", "ât", "assions", "assiez", "assent");
            case Mode.INDICATIVE -> Utils.conjugHashMap("ais", "ais", "ait", "ions", "iez", "aient");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    }

    @Override
    protected HashMap<String, String> getPastPerfectMap(String mode) {
        return switch(mode){
            case Mode.INDICATIVE -> Utils.conjugHashMap("é", "é", "é", "é", "é", "é");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    } */

    @Override
    protected Map<String, String> getIndicativeMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.IndicativeTenses.PRESENT, Utils.conjugList("e", "es", "e", "ons", "ez", "ent"));
        tenseConjugations.put(Tense.IndicativeTenses.FUTURE_SIMPLE, Utils.conjugList("erai", "eras", "era", "erons", "erez", "eront"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_FUTURE, Utils.conjugList("é", "é", "é", "é", "é", "é"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_SIMPLE, Utils.conjugList("ai", "as", "a", "âmes", "âtes", "èrent"));
        tenseConjugations.put(Tense.IndicativeTenses.IMPERFECT, Utils.conjugList("ais", "ais", "ait", "ions", "iez", "aient"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_PERFECT, Utils.conjugList("é", "é", "é", "é", "é", "é"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

    @Override
    protected Map<String, String> getConditionalMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.ConditionalTenses.PRESENT, Utils.conjugList("erais", "erais", "erait", "erions", "eriez", "eraient"));
        tenseConjugations.put(Tense.ConditionalTenses.PAST_1, Utils.conjugList("é", "é", "é", "é", "é", "é"));
        tenseConjugations.put(Tense.ConditionalTenses.PAST_2, Utils.conjugList("é", "é", "é", "é", "é", "é"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

    @Override
    protected Map<String, String> getSubjonctiveMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.SubjonctiveTenses.PRESENT, Utils.conjugList("e", "es", "e", "ions", "iez", "ent"));
        tenseConjugations.put(Tense.SubjonctiveTenses.IMPERFECT, Utils.conjugList("asse", "asses", "ât", "assions", "assiez", "assent"));
        tenseConjugations.put(Tense.SubjonctiveTenses.PAST, Utils.conjugList("é", "é", "é", "é", "é", "é"));
        tenseConjugations.put(Tense.SubjonctiveTenses.PLUSPERFECT, Utils.conjugList("é", "é", "é", "é", "é", "é"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }
}
