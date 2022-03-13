package back.conjugaison.conjugate;

import java.util.Map;

import back.conjugaison.conjugate.groups._3rdgroup.auxiliaries.Avoir;
import back.conjugaison.utils.Helper;
import back.conjugaison.utils.Utils;

public abstract class Verb implements IConjugate{

    protected String ENDING_1ST_PERSON_PLURAL = "ons";
    protected final String ENDING_2ND_PERSON_PLURAL = "ez";
    protected final String ENDING_3RD_PERSON_PLURAL = "ent";

    private String root;

    protected String end = "";

    protected void init(String verb, String end){
        if(!verb.endsWith(end)){
            throw new IllegalArgumentException("Verb does not end in "+end);
        }
        this.setRoot(verb.substring(0, verb.length()-end.length()));
    }

    protected abstract Map<String, String> getIndicativeMap(String tense);
    protected abstract Map<String, String> getConditionalMap(String tense);
    protected abstract Map<String, String> getSubjonctiveMap(String tense);

    private Map<String, String> getModeMap(String mode, String tense){
        return switch(mode){
            case Mode.INDICATIVE -> getIndicativeMap(tense);
            case Mode.CONDITIONAL -> getConditionalMap(tense);
            case Mode.SUBJONCTIVE -> getSubjonctiveMap(tense);
            default -> throw new IllegalArgumentException("Mode " + mode + " does not exist");
        };
    }

    private String conjugateParticipate(String pronoun, String tense, String mode, String verb, boolean isAuxiliaryConditional){
        return new Avoir("avoir").conjugate(pronoun, tense, mode, isAuxiliaryConditional) + " " + verb;
    }

    public String conjugate(String pronoun, String tense, String mode, boolean isAuxiliaryConditional){
        Map<String, String> map = getModeMap(mode, tense);
        String verb = Helper.needsE(this.root, map.get(pronoun));
        if(mode.equals(Mode.INDICATIVE)){
            if(tense.equals(Tense.IndicativeTenses.PAST_PERFECT))
                return conjugateParticipate(pronoun, Tense.IndicativeTenses.PRESENT, Mode.INDICATIVE, verb, isAuxiliaryConditional);
            if(tense.equals(Tense.IndicativeTenses.PAST_FUTURE))
                return conjugateParticipate(pronoun, Tense.IndicativeTenses.FUTURE_SIMPLE, Mode.INDICATIVE, verb, isAuxiliaryConditional);
        }
        if(mode.equals(Mode.SUBJONCTIVE)){
            if(tense.equals(Tense.SubjonctiveTenses.PAST))
                return conjugateParticipate(pronoun, Tense.SubjonctiveTenses.PRESENT, Mode.SUBJONCTIVE, verb, isAuxiliaryConditional);
            if(tense.equals(Tense.SubjonctiveTenses.PLUSPERFECT))
                return conjugateParticipate(pronoun, Tense.SubjonctiveTenses.IMPERFECT, Mode.SUBJONCTIVE, verb, isAuxiliaryConditional);
        }
        if(mode.equals(Mode.CONDITIONAL)){
            if(tense.equals(Tense.ConditionalTenses.PAST_1))
                return conjugateParticipate(pronoun, Tense.ConditionalTenses.PRESENT, Mode.CONDITIONAL, verb, isAuxiliaryConditional);
            if(tense.equals(Tense.ConditionalTenses.PAST_2))
                return conjugateParticipate(pronoun, Tense.SubjonctiveTenses.IMPERFECT, Mode.SUBJONCTIVE, verb, true);
        }
        return Helper.getPronoun(pronoun, mode, verb, isAuxiliaryConditional) +verb;
    }

    public String conjugatePronouns(String tense, String mode){
        String conjugations = "";
        for(int i = Pronoun.FIRST_SINGULAR; i < Pronoun.THIRD_PLURAL + 1; i++){
            conjugations += "\n" + conjugate(Utils.getPronoun(i), tense, mode, false);
        }
        return conjugations;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }
    
    public String getEnd(){
        return end;
    }
}
