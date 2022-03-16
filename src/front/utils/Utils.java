package front.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Utils {
  public static Map<String, String> getMap(String json){
    Map<String, String> map = new HashMap<>();
    String[] jsonData = json.replaceAll("[{-}]", "").split(",");
    for(String data : jsonData)
      map.put(data.split(":")[0].replace("\"", ""), data.split(":")[1].replace("\"", ""));
    return map;
  }

  public static String getKeyString(Map<String, String> map, String value){
    for(Entry<String, String> item : map.entrySet()){
      if(item.getValue().equals(value))
        return item.getKey();
    }
    return null;
  }
}
