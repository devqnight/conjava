package front.conjugation;

import java.util.Map;

public class Mode {
    private Map<String,String> modes;

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
}
