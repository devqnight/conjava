package back.conjugaison.conjugate._3rdgroup;

import java.util.HashMap;

import back.conjugaison.conjugate.Mode;
import back.conjugaison.conjugate.Verb;
import back.conjugaison.utils.Utils;

public class Verb3rdGroupEttre extends Verb{
    private static final String END = "ettre"; 

    public Verb3rdGroupEttre(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    @Override
    protected HashMap<String, String> getPresentMap(String mode) {
        return switch(mode){
            case Mode.CONDITIONAL -> Utils.conjugHashMap("ettrais", "ettrais", "ettrait", "ettrions", "ettriez", "ettraient");
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("ette", "ettes", "ette", "ettions", "ettiez", "ettent");
            default -> Utils.conjugHashMap("ets", "ets", "et", "ettons", "ettez", "ettent");
        };
    }

    @Override
    protected HashMap<String, String> getFutureMap(String mode) {
        return switch(mode){
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
            case Mode.INDICATIVE -> Utils.conjugHashMap("ettrai", "ettras", "ettra", "ettrons", "ettrez", "ettront");
        };
    }

    @Override
    protected HashMap<String, String> getImperfectMap(String mode) {
        return switch(mode){
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("isse", "isses", "ît", "issions", "issiez", "issent");
            case Mode.INDICATIVE -> Utils.conjugHashMap("ettais", "ettais", "ettait", "ettions", "ettiez", "ettaient");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    }

    @Override
    protected HashMap<String, String> getPastPerfectMap(String mode) {
        return switch(mode){
            case Mode.INDICATIVE -> Utils.conjugHashMap("is", "is", "is", "is", "is", "is");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    }
    /* @Override
    protected String endingPlural(){
        return "ett";
    }

    @Override
    protected String ending1stPersonSingular() {
        return "ets";
    }

    @Override
    protected String ending2ndPersonSingular() {
        return ending1stPersonSingular(); 
    }

    @Override
    protected String ending3rdPersonSingular() {
        return "et";
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
        return "is";
    } */

}
