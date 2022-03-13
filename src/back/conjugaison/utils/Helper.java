package back.conjugaison.utils;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import back.conjugaison.conjugate.Mode;
import back.conjugaison.conjugate.Pronoun;

public class Helper {

    private static String VOWELS = "AÀÁÂÃÄÅĀĂĄǺȀȂẠẢẤẦẨẪẬẮẰẲẴẶḀÆǼEȄȆḔḖḘḚḜẸẺẼẾỀỂỄỆĒĔĖĘĚÈÉÊËIȈȊḬḮỈỊĨĪĬĮİÌÍÎÏĲOŒØǾȌȎṌṎṐṒỌỎỐỒỔỖỘỚỜỞỠỢŌÒÓŎŐÔÕÖUŨŪŬŮŰŲÙÚÛÜȔȖṲṴṶṸṺỤỦỨỪỬỮỰYẙỲỴỶỸŶŸÝ";
    private static String E_VOWELS = "EȄȆḔḖḘḚḜẸẺẼẾỀỂỄỆĒĔĖĘĚÈÉÊË";
    private static String I_VOWELS = "IȈȊḬḮỈỊĨĪĬĮİÌÍÎÏ";

    private Helper() {
        throw new IllegalStateException("Utility class");
    }
    
    public static boolean isVowel(char c){
        return VOWELS.indexOf(Character.toUpperCase(c)) >= 0;
    }

    public static boolean isInSequence(String seq, char c){
        return seq.indexOf(Character.toUpperCase(c)) >= 0;
    }

    public static String getPronoun(String pronoun, String mode, String root, boolean... isAuxiliaryConditional){
        boolean isAuxiliaryConditional2 = isAuxiliaryConditional.length>0?isAuxiliaryConditional[0]:false;
        String start = mode.equals(Mode.SUBJONCTIVE) && !isAuxiliaryConditional2 ? "Que " : "";
        String pr = pronoun;
        if(pronoun.equals(Pronoun.Personal.FIRST_SINGULAR_STRING) && isVowel(root.charAt(0)))
            pr = "J'";
        if(!start.equals("")){
            if(pronoun.contains(Pronoun.Personal.THIRD_SINGULAR_STRING.trim()))
                start = "Qu'";
            pr = pr.toLowerCase();
        }
        return  start + pr;
    }

    public static String needsE(String first, String second){
      Character endFirst = first.length()>0 ? first.charAt(first.length()-1) : null;
      if(endFirst != null){
          if (endFirst.equals('g') && !startsWithEorI(second))
              return first + "e" + second;
          if (endFirst.equals('c') && !startsWithEorI(second))
              return first.substring(0, first.length()-1) + "ç" + second;
      }
      return first + second;
    }

    private static boolean startsWithEorI(String seq){
      return isInSequence(E_VOWELS, seq.charAt(0)) || isInSequence(I_VOWELS, seq.charAt(0));
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
