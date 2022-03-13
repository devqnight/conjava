package front.conjugation;

import java.util.Map;

public class Tense {
    private Map<String,String> indicativeTenses;
    private Map<String,String> conditionalTenses;
    private Map<String,String> subjonctiveTenses;

    private static Mode instance;

    public static Mode getInstance(){
      if(instance == null)
        instance = new Mode();
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

    public static void setInstance(Mode instance) {
      Tense.instance = instance;
    }

}
