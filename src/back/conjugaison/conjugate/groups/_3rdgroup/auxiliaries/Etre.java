package back.conjugaison.conjugate.groups._3rdgroup.auxiliaries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import back.conjugaison.conjugate.Mode;
import back.conjugaison.conjugate.Tense;
import back.conjugaison.conjugate.Verb;
import back.conjugaison.utils.Utils;

public class Etre extends Verb{

    public static final String END = "être";

    public Etre(String verb){
        this.init(verb, END);
        this.end = END; 
    }   
    
    @Override
    protected HashMap<String, String> getIndicativeMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.IndicativeTenses.PRESENT, Utils.conjugList("suis", "es", "est", "sommes", "êtes", "sont"));
        tenseConjugations.put(Tense.IndicativeTenses.FUTURE_SIMPLE, Utils.conjugList("serai", "seras", "sera", "serons", "serez", "seront"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_FUTURE, Utils.conjugList("été", "été", "été", "été", "été", "été"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_SIMPLE, Utils.conjugList("fus", "fus", "fut", "fûmes", "fûtes", "furent"));
        tenseConjugations.put(Tense.IndicativeTenses.IMPERFECT, Utils.conjugList("étais", "étais", "était", "étions", "étiez", "étaient"));
        tenseConjugations.put(Tense.IndicativeTenses.PAST_PERFECT, Utils.conjugList("été", "été", "été", "été", "été", "été"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

    @Override
    protected HashMap<String, String> getConditionalMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.ConditionalTenses.PRESENT, Utils.conjugList("serais", "serais", "serait", "serions", "seriez", "seraient"));
        tenseConjugations.put(Tense.ConditionalTenses.PAST_1, Utils.conjugList("été", "été", "été", "été", "été", "été"));
        tenseConjugations.put(Tense.ConditionalTenses.PAST_2, Utils.conjugList("été", "été", "été", "été", "été", "été"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }

    @Override
    protected HashMap<String, String> getSubjonctiveMap(String tense) {
        Map<String, List<String>> tenseConjugations = new HashMap<String, List<String>>();

        tenseConjugations.put(Tense.SubjonctiveTenses.PRESENT, Utils.conjugList("sois", "sois", "sois", "soyons", "soyez", "soient"));
        tenseConjugations.put(Tense.SubjonctiveTenses.IMPERFECT, Utils.conjugList("fusse", "fusses", "fût", "fussions", "fussiez", "fussent"));
        tenseConjugations.put(Tense.SubjonctiveTenses.PAST, Utils.conjugList("été", "été", "été", "été", "été", "été"));
        tenseConjugations.put(Tense.SubjonctiveTenses.PLUPERFECT, Utils.conjugList("été", "été", "été", "été", "été", "été"));

        return Utils.conjugHashMap(Mode.getTenseMap(tense, tenseConjugations));
    }
}
