package front.conjugation;

import java.util.Map;
import java.util.Map.Entry;

import front.utils.Utils;

public class Tense {
    private Map<String,String> indicativeTenses;
    private Map<String,String> conditionalTenses;
    private Map<String,String> subjonctiveTenses;

    private static Tense instance;

    public String actual;

    public static Tense getInstance(){
      if(instance == null)
        instance = new Tense();
      return instance;
    }

    public Map<String, String> getIndicativeTenses() {
      return indicativeTenses;
    }

    public void setIndicativeTenses(Map<String, String> indicativeTenses) {
      this.indicativeTenses = indicativeTenses;
    }

    public Map<String, String> getConditionalTenses() {
      return conditionalTenses;
    }

    public void setConditionalTenses(Map<String, String> conditionalTenses) {
      this.conditionalTenses = conditionalTenses;
    }

    public Map<String, String> getSubjonctiveTenses() {
      return subjonctiveTenses;
    }

    public void setSubjonctiveTenses(Map<String, String> subjonctiveTenses) {
      this.subjonctiveTenses = subjonctiveTenses;
    }

    public String[] getTensesStrings(int i){
      return switch (i) {
        case 1 -> this.getSubjonctiveTenses() == null ? null : this.getSubjonctiveTenses().values().toArray(new String[0]);
        case 2 -> this.getConditionalTenses() == null ? null : this.getConditionalTenses().values().toArray(new String[0]);
        default -> this.getIndicativeTenses() == null ? null : this.getIndicativeTenses().values().toArray(new String[0]);
      };
    }

    public String getIntValForMode(int mode, String value){
      return switch (mode) {
        case 1 -> Utils.getKeyString(getSubjonctiveTenses(),value);
        case 2 -> Utils.getKeyString(getConditionalTenses(),value);
        default -> Utils.getKeyString(getIndicativeTenses(),value);
      };
    }

    public String getDefaultTense(int mode){
      return getTensesStrings(mode)[0];
    }

    
}
