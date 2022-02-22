package back.conjugaison.conjugate._3rdgroup;

import java.util.HashMap;

import back.conjugaison.conjugate.Mode;
import back.conjugaison.conjugate.Verb;
import back.conjugaison.utils.Utils;

public class Verb3rdGroupIndre extends Verb {
    private static final String END = "indre"; 

    public Verb3rdGroupIndre(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    @Override
    protected HashMap<String, String> getPresentMap(String mode) {
        return switch(mode){
            case Mode.CONDITIONAL -> Utils.conjugHashMap("indrais", "indrais", "indrait", "indrions", "indriez", "indraient");
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("igne", "ignes", "igne", "ignions", "igniez", "ignent");
            default -> Utils.conjugHashMap("ins", "ins", "int", "ignons", "ignez", "ignent");
        };
    }

    @Override
    protected HashMap<String, String> getFutureMap(String mode) {
        return switch(mode){
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
            case Mode.INDICATIVE -> Utils.conjugHashMap("indrai", "indras", "indra", "indrons", "indrez", "indront");
        };
    }

    @Override
    protected HashMap<String, String> getImperfectMap(String mode) {
        return switch(mode){
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("ignisse", "ignisses", "ignît", "ignions", "igniez", "ignent");
            case Mode.INDICATIVE -> Utils.conjugHashMap("ignais", "ignais", "inait", "ignions", "igniez", "ignaient");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    }

    @Override
    protected HashMap<String, String> getPastPerfectMap(String mode) {
        return switch(mode){
            case Mode.INDICATIVE -> Utils.conjugHashMap("int", "int", "int", "int", "int", "int");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    }
    
    /* @Override
    protected String endingPlural(){
        return "ign";
    }

    @Override
    protected String ending1stPersonSingular() {
        return "ins";
    }

    @Override
    protected String ending2ndPersonSingular() {
        return ending1stPersonSingular();
    }

    @Override
    protected String ending3rdPersonSingular() {
        return "int";
    }

    //@Override
    //public String ending1stPersonPlural() {
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
        return "int";
    } */

}
