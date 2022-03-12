package back.conjugaison.conjugate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mode {

    private Mode() {
      throw new IllegalStateException("Utility class");
    }

    public static final int INDICATIVE_INT = 0;
    public static final int CONDITIONAL_INT = 1;
    public static final int SUBJONCTIVE_INT = 2;

    public static final String INDICATIVE = "Indicatif";
    public static final String CONDITIONAL = "Conditionnel";
    public static final String SUBJONCTIVE = "Subjonctif";

    public static Map<Integer, String> modeMap() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(INDICATIVE_INT, INDICATIVE);
        map.put(CONDITIONAL_INT, CONDITIONAL);
        map.put(SUBJONCTIVE_INT, SUBJONCTIVE);
        return map;
    }

    public static List<String> getTenseMap(String tense, Map<String, List<String>> tenseConjugations){
        for(Map.Entry<String, List<String>> entry : tenseConjugations.entrySet())
            if(entry.getKey().equals(tense))
                return tenseConjugations.get(entry.getKey());
        return Collections.emptyList();
    }

    public static String getMode(int mode){
        return modeMap().get(mode);
    }
}
