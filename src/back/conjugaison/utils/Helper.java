package back.conjugaison.utils;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import back.conjugaison.conjugate.Mode;
import back.conjugaison.conjugate.Pronoun;

public class Helper {

    private static String VOWELS = "AÀÁÂÃÄÅĀĂĄǺȀȂẠẢẤẦẨẪẬẮẰẲẴẶḀÆǼEȄȆḔḖḘḚḜẸẺẼẾỀỂỄỆĒĔĖĘĚÈÉÊËIȈȊḬḮỈỊĨĪĬĮİÌÍÎÏĲOŒØǾȌȎṌṎṐṒỌỎỐỒỔỖỘỚỜỞỠỢŌÒÓŎŐÔÕÖUŨŪŬŮŰŲÙÚÛÜȔȖṲṴṶṸṺỤỦỨỪỬỮỰYẙỲỴỶỸŶŸÝ";
   
    private Helper() {
        throw new IllegalStateException("Utility class");
    }
    
    public static boolean isVowel(char c){
        return VOWELS.indexOf(Character.toUpperCase(c)) >= 0;
    }

    public static String getPronoun(String pronoun, String mode, String root){
        String start = mode.equals(Mode.SUBJONCTIVE) ? "Que " : "";
        String pr = pronoun;
        if(pronoun.equals(Pronoun.Personal.FIRST_SINGULAR_STRING))
            if(isVowel(root.charAt(0)))
                pr = "J'";
        if(!start.equals("")){
            if(pronoun.contains(Pronoun.Personal.THIRD_SINGULAR_STRING.trim()))
                start = "Qu'";
            pr = pr.toLowerCase();
        }
        return  start + pr;
    }

    public static String convertToJson(Map<Integer, String> map){
      ObjectMapper mapper = new ObjectMapper();
      try {
        return mapper.writeValueAsString(map);
      } catch (Exception e) {
        e.printStackTrace();
      }
      return "";
    }
}
