package back.conjugaison.conjugate;

import java.util.HashMap;

import back.conjugaison.utils.Utils;

public class Verb1stGroup extends Verb {

    public static final String END = "er";

    public Verb1stGroup(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    @Override
    protected HashMap<String, String> getPresentMap(String mode) {
        return switch(mode){
            case Mode.CONDITIONAL -> Utils.conjugHashMap("erais", "erais", "erait", "erions", "eriez", "eraient");
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("e", "es", "e", "ions", "iez", "ent");
            default -> Utils.conjugHashMap("e", "es", "e", "ons", "ez", "ent");
        };
    }

    @Override
    protected HashMap<String, String> getFutureMap(String mode) {
        return switch(mode){
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
            case Mode.INDICATIVE -> Utils.conjugHashMap("erai", "eras", "era", "erons", "erez", "eront");
        };
    }

    @Override
    protected HashMap<String, String> getImperfectMap(String mode) {
        return switch(mode){
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("asse", "asses", "ât", "assions", "assiez", "assent");
            case Mode.INDICATIVE -> Utils.conjugHashMap("ais", "ais", "ait", "ions", "iez", "aient");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    }

    @Override
    protected HashMap<String, String> getPastPerfectMap(String mode) {
        return switch(mode){
            case Mode.INDICATIVE -> Utils.conjugHashMap("é", "é", "é", "é", "é", "é");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    }

    

    /* @Override
    protected String endingPlural() {
        return "";
    }

    @Override
    protected String ending1stPersonSingular() {
        return "e";
    }

    @Override
    protected String ending2ndPersonSingular() {
        return "es";
    }

    @Override
    protected String ending3rdPersonSingular() {
        return this.ending1stPersonSingular();
    }

    //@Override
    //protected String ending1stPersonPlural() {
    //    return ENDING_1ST_PERSON_PLURAL;
    //}

    @Override
    protected String ending2ndPersonPlural() {
        return ENDING_2ND_PERSON_PLURAL;
    }

    @Override
    protected String ending3rdPersonPlural() {
        return ENDING_3RD_PERSON_PLURAL;
    }

    @Override
    protected String endingPastParticipate() {
        return "é";
    } */
}
