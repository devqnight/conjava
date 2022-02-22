package back.conjugaison.conjugate._3rdgroup;

import java.util.HashMap;

import back.conjugaison.conjugate.Mode;
import back.conjugaison.conjugate.Verb;
import back.conjugaison.utils.Utils;

public class Verb3rdGroupAitre extends Verb {
    private static final String END = "aître"; 

    public Verb3rdGroupAitre(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    @Override
    protected HashMap<String, String> getPresentMap(String mode) {
        return switch(mode){
            case Mode.CONDITIONAL -> Utils.conjugHashMap("aîtrais", "aîtrais", "aîtrait", "aîtrions", "aîtriez", "aîtraient");
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("aisse", "aisses", "aisse", "aissions", "aissiez", "aissent");
            default -> Utils.conjugHashMap("ais", "ais", "aît", "aissons", "aissez", "aissent");
        };
    }

    @Override
    protected HashMap<String, String> getFutureMap(String mode) {
        return switch(mode){
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
            case Mode.INDICATIVE -> Utils.conjugHashMap("aîtrai", "aîtras", "aîtra", "aîtrons", "aîtrez", "aîtront");
        };
    }

    @Override
    protected HashMap<String, String> getImperfectMap(String mode) {
        return switch(mode){
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("usse", "usses", "ût", "ussions", "ussiez", "ussent");
            case Mode.INDICATIVE -> Utils.conjugHashMap("aissais", "aissais", "aissait", "aissions", "aissiez", "aissaient");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    }

    @Override
    protected HashMap<String, String> getPastPerfectMap(String mode) {
        return switch(mode){
            case Mode.INDICATIVE -> Utils.conjugHashMap("u", "u", "u", "u", "u", "u");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    }

    /* @Override
    protected String endingPlural(){
        return "aiss";
    }

    @Override
    protected String ending1stPersonSingular() {
        return "ais";
    }

    @Override
    protected String ending2ndPersonSingular() {
        return ending1stPersonSingular();
    }

    @Override
    protected String ending3rdPersonSingular() {
        return "âit";
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
        return "u";
    } */

}
