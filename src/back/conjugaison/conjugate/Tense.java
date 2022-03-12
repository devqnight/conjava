package back.conjugaison.conjugate;

import java.util.HashMap;
import java.util.Map;

public class Tense {
  public static final int PRESENT_INT = 0;
  public static final int IMPERFECT_INT = 1;
  public static final int FUTURE_SIMPLE_INT = 2;
  public static final int PAST_FUTURE_INT = 3;
  public static final int PAST_PERFECT_INT = 4;
  public static final int PAST_SIMPLE_INT = 5;

  public static final int PAST_INT = 6;
  public static final int PLUSPERFECT_INT = 7;

  public static final int PAST_1_INT = 8;
  public static final int PAST_2_INT = 9;

  public static final String PRESENT = "Présent";
  public static final String IMPERFECT = "Imparfait";
  public static final String FUTURE = "Futur";
  public static final String PAST_PERFECT = "Passé composé";

  public class IndicativeTenses {
    public static final String PRESENT = "Présent";
    public static final String IMPERFECT = "Imparfait";
    public static final String FUTURE_SIMPLE = "Futur simple";
    public static final String PAST_FUTURE = "Futur antérieur";
    public static final String PAST_PERFECT = "Passé composé";
    public static final String PAST_SIMPLE = "Passé simple";
  }

  public class SubjonctiveTenses {
    public static final String PRESENT = "Présent";
    public static final String PAST = "Passé";
    public static final String IMPERFECT = "Imparfait";
    public static final String PLUSPERFECT = "Plus-que-parfait";
  }

  public class ConditionalTenses {
    public static final String PRESENT = "Présent";
    public static final String PAST_1 = "Passé première forme";
    public static final String PAST_2 = "Passé deuxième forme";
  }

  public static Map<Integer, String> tenseMap(int mode) {
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    switch (mode) {
      case Mode.INDICATIVE_INT -> {
        map.put(PRESENT_INT, IndicativeTenses.PRESENT);
        map.put(IMPERFECT_INT, IndicativeTenses.IMPERFECT);
        map.put(FUTURE_SIMPLE_INT, IndicativeTenses.FUTURE_SIMPLE);
        map.put(PAST_FUTURE_INT, IndicativeTenses.PAST_FUTURE);
        map.put(PAST_PERFECT_INT, IndicativeTenses.PAST_PERFECT);
        map.put(PAST_SIMPLE_INT, IndicativeTenses.PAST_SIMPLE);
        break;
      }
      case Mode.SUBJONCTIVE_INT -> {
        map.put(PRESENT_INT, SubjonctiveTenses.PRESENT);
        map.put(PAST_INT, SubjonctiveTenses.PAST);
        map.put(IMPERFECT_INT, SubjonctiveTenses.IMPERFECT);
        map.put(PLUSPERFECT_INT, SubjonctiveTenses.PLUSPERFECT);
        break;
      }
      case Mode.CONDITIONAL_INT -> {
        map.put(PRESENT_INT, ConditionalTenses.PRESENT);
        map.put(PAST_1_INT, ConditionalTenses.PAST_1);
        map.put(PAST_2_INT, ConditionalTenses.PAST_2);
        break;
      }
    }
    return map;
  }
}