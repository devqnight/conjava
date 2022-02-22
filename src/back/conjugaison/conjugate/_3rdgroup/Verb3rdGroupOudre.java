package back.conjugaison.conjugate._3rdgroup;

import java.util.HashMap;

import back.conjugaison.conjugate.Mode;
import back.conjugaison.conjugate.Verb;
import back.conjugaison.utils.Utils;

public class Verb3rdGroupOudre extends Verb{
    private static final String END = "oudre"; 

    public Verb3rdGroupOudre(String verb) {
        this.init(verb, END);
        this.end = END;
    }

    @Override
    protected HashMap<String, String> getPresentMap(String mode) {
        return switch(mode){
            case Mode.CONDITIONAL -> Utils.conjugHashMap("oudrais", "oudrais", "oudrait", "oudrions", "oudriez", "oudraient");
            case Mode.SUBJONCTIVE -> Utils.conjugHashMap("olve", "olves", "olve", "olvions", "olviez", "olvent");
            default -> Utils.conjugHashMap("ous", "ous", "out", "olvons", "olvez", "olvent");
        };
    }

    @Override
    protected HashMap<String, String> getFutureMap(String mode) {
        return switch(mode){
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
            case Mode.INDICATIVE -> Utils.conjugHashMap("oudrai", "oudras", "oudra", "oudrons", "oudrez", "oudront");
        };
    }

    @Override
    protected HashMap<String, String> getImperfectMap(String mode) {
        return switch(mode){
            case Mode.INDICATIVE -> Utils.conjugHashMap("olvais", "olvais", "olvait", "olvions", "olviez", "olvaient");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    }

    @Override
    protected HashMap<String, String> getPastPerfectMap(String mode) {
        return switch(mode){
            case Mode.INDICATIVE -> Utils.conjugHashMap("ous", "ous", "ous", "ous", "ous", "ous");
            default -> throw new IllegalArgumentException("This tense does not exist for this mode");
        };
    }
    
    /* @Override
    protected String endingPlural(){
        return "olv";
    }

    @Override
    protected String ending1stPersonSingular() {
        return "ous";
    }

    @Override
    protected String ending2ndPersonSingular() {
        return ending1stPersonSingular();
    }

    @Override
    protected String ending3rdPersonSingular() {
        return "out";
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
        return "out";
    } */

}
