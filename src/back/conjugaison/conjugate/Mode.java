package back.conjugaison.conjugate;

import java.util.List;
import java.util.Map;

public class Mode {
    public static final String INDICATIVE = "Indicatif";
    public static final String CONDITIONAL = "Conditionnel";
    public static final String SUBJONCTIVE = "Subjonctif";

    public static List<String> getTenseMap(String tense, Map<String, List<String>> tenseConjugations){
        for(String key : tenseConjugations.keySet())
            if(key.equals(tense))
                return tenseConjugations.get(key);
        return null;
    }
}
