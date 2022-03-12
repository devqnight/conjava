package back.conjugaison.conjugate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mode {

    public static final int INDICATIVE_INT = 0;
    public static final int CONDITIONAL_INT = 1;
    public static final int SUBJONCTIVE_INT = 2;

    public static final String INDICATIVE = "Indicatif";
    public static final String CONDITIONAL = "Conditionnel";
    public static final String SUBJONCTIVE = "Subjonctif";

    public static HashMap<Integer, String> modeHashMap() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(INDICATIVE_INT, INDICATIVE);
        map.put(CONDITIONAL_INT, CONDITIONAL);
        map.put(SUBJONCTIVE_INT, SUBJONCTIVE);
        return map;
    }

    public static List<String> getTenseMap(String tense, Map<String, List<String>> tenseConjugations){
        for(String key : tenseConjugations.keySet())
            if(key.equals(tense))
                return tenseConjugations.get(key);
        return null;
    }

    public static String getMode(String mode){
      return switch (mode) {
        case "Indicatif" -> INDICATIVE;
        case "Conditionnel" -> CONDITIONAL;
        case "Subjonctif" -> SUBJONCTIVE;
        default -> INDICATIVE;
      };
    }
}
