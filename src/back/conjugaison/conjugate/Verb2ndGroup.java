package back.conjugaison.conjugate;

import java.util.HashMap;

import back.conjugaison.utils.Utils;

public class Verb2ndGroup extends Verb{

    public static final String END = "ir";

    public Verb2ndGroup(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    @Override
    protected HashMap<String, String> getPresentMap(String mode) {
        return switch(mode){
            case Mode.CONDITIONAL -> Utils.conjugHashMap("irais", "irais", "irait", "irions", "iriez", "iraient");
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("isse", "isses", "isse", "issions", "issiez", "issent");
            default -> Utils.conjugHashMap("is", "is", "it", "issons", "issez", "issent");
        };
    }

    @Override
    protected HashMap<String, String> getFutureMap(String mode) {
        return switch(mode){
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
            case Mode.INDICATIVE -> Utils.conjugHashMap("irai", "iras", "ira", "irons", "irez", "iront");
        };
    }

    @Override
    protected HashMap<String, String> getImperfectMap(String mode) {
        return switch(mode){
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("isse", "isses", "isse", "issions", "issiez", "issent");
            case Mode.INDICATIVE -> Utils.conjugHashMap("issais", "issais", "issait", "issions", "issiez", "issaient");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    }

    @Override
    protected HashMap<String, String> getPastPerfectMap(String mode) {
        return switch(mode){
            case Mode.INDICATIVE -> Utils.conjugHashMap("i", "i", "i", "i", "i", "i");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    }

    /* @Override
    protected String endingPlural(){
      return "iss";
    }

    @Override
    protected String ending1stPersonSingular() {
        return "is";
    }

    @Override
    protected String ending2ndPersonSingular() {
        return ending1stPersonSingular();
    }

    @Override
    protected String ending3rdPersonSingular() {
        return "it";
    }

    //@Override
    //protected String ending1stPersonPlural() {
    //    return endingPlural() + ENDING_1ST_PERSON_PLURAL;
    //}

    @Override
    protected String ending2ndPersonPlural() {
        return endingPlural() + ENDING_2ND_PERSON_PLURAL;
    }

    @Override
    protected String ending3rdPersonPlural() {
        return endingPlural() + ENDING_3RD_PERSON_PLURAL;
    }

    @Override
    protected String endingPastParticipate() {
        return "i";
    } */


}
