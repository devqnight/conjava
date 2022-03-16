package front.conjugation;

import java.util.Map;

import front.utils.Utils;

public class Mode {
    private Map<String,String> modes;

    public String actual;

    private static Mode instance;

    public static Mode getInstance(){
      if(instance == null)
        instance = new Mode();
      return instance;
    }

    public Map<String,String> getModes(){
      return modes;
    }

    public void setModes(Map<String, String> modes) {
      this.modes = modes;
    }

    public String[] getModesStrings(){
      return this.modes.values().toArray(new String[0]);
    }

    public String getIntVal(String value){
      return Utils.getKeyString(modes, value);
    }
}
