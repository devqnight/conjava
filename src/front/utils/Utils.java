package front.utils;

import java.util.HashMap;
import java.util.Map;

public class Utils {
  public static Map<String, String> getMap(String json){
    Map<String, String> map = new HashMap<>();
    String[] jsonTenses = json.replaceAll("[{-}]", "").split(",");
    for(String tense : jsonTenses)
      map.put(tense.split(":")[0], tense.split(":")[0]);
    return map;
  }
}
