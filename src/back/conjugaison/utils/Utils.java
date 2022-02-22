package back.conjugaison.utils;

import java.util.HashMap;

import back.conjugaison.conjugate.Pronoun;
import back.conjugaison.conjugate.Tense;
import back.conjugaison.conjugate.Pronoun.Personal;

public class Utils {
    public static String getPronoun(int pronoun){
        return switch(pronoun){
            case Pronoun.FIRST_SINGULAR -> Pronoun.Personal.FIRST_SINGULAR_STRING;
            case Pronoun.SECOND_SINGULAR -> Pronoun.Personal.SECOND_SINGULAR_STRING;
            case Pronoun.THIRD_SINGULAR -> Pronoun.Personal.THIRD_SINGULAR_STRING;
            case Pronoun.FIRST_PLURAL -> Pronoun.Personal.FIRST_PLURAL_STRING;
            case Pronoun.SECOND_PLURAL -> Pronoun.Personal.SECOND_PLURAL_STRING;
            case Pronoun.THIRD_PLURAL -> Pronoun.Personal.THIRD_PLURAL_STRING;
            default -> Pronoun.Personal.FIRST_SINGULAR_STRING;
        };
    }

    public static String getTense(int tense){
        return switch(tense){
            case Tense.FUTURE_INT -> Tense.FUTURE;
            case Tense.IMPERFECT_INT -> Tense.IMPERFECT;
            case Tense.PAST_PERFECT_INT -> Tense.PAST_PERFECT;
            default -> Tense.PRESENT;
        };
    }

    public static HashMap<String, String> conjugHashMap(String first_singular, String second_singular, String third_singular, String first_plural, String second_plural, String third_plural){
        HashMap<String, String> map = new HashMap<String, String>();

        map.put(Personal.FIRST_SINGULAR_STRING, first_singular);
        map.put(Personal.SECOND_SINGULAR_STRING, second_singular);
        map.put(Personal.THIRD_SINGULAR_STRING, third_singular);
        map.put(Personal.FIRST_PLURAL_STRING, first_plural);
        map.put(Personal.SECOND_PLURAL_STRING, second_plural);
        map.put(Personal.THIRD_PLURAL_STRING, third_plural);

        return map;
    }
}
