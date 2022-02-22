package back.conjugaison.conjugate;

import java.util.HashMap;

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

    /* protected abstract String ending1stPersonSingular();
    protected abstract String ending2ndPersonSingular();
    protected abstract String ending3rdPersonSingular();
    protected abstract String endingPlural();
    //protected abstract String ending1stPersonPlural();
    protected abstract String ending2ndPersonPlural();
    protected abstract String ending3rdPersonPlural();
    protected abstract String endingPastParticipate(); */

    protected abstract HashMap<String, String> getPresentMap(String mode);
    protected abstract HashMap<String, String> getFutureMap(String mode);
    protected abstract HashMap<String, String> getImperfectMap(String mode);
    protected abstract HashMap<String, String> getPastPerfectMap(String mode);

    private HashMap<String, String> getMap(String tense, String mode){
        return switch(tense){
            case Tense.FUTURE -> getFutureMap(mode);
            case Tense.IMPERFECT -> getImperfectMap(mode);
            case Tense.PAST_PERFECT -> getPastPerfectMap(mode);
            default -> getPresentMap(mode);
        };
    }


    public String conjugate(String pronoun, String tense, String mode){
        HashMap<String, String> map = getMap(tense, mode);
        return Helper.getPronoun(pronoun, mode, root) + root + map.get(pronoun);
    }

    public String conjugatePronouns(String tense, String mode){
        String conjugations = "";
        for(int i = Pronoun.FIRST_SINGULAR; i < Pronoun.THIRD_PLURAL + 1; i++){
            conjugations += "\n" + conjugate(Utils.getPronoun(i), tense, mode);
        }
        return conjugations;
    }


    /* public String conjugate1stPersonSingular(){
        return this.getJe(this.root.charAt(0)) + this.root + this.ending1stPersonSingular();
    }
    public String conjugate2ndPersonSingular(){
        return "Tu " + this.root + this.ending2ndPersonSingular();
    }
    public String conjugate3rdPersonSingular(){
        return "Il " + this.root + this.ending3rdPersonSingular();
    }

    public String conjugate1stPersonPlural(){
        return "Nous " + this.root + this.endingPlural() + ENDING_1ST_PERSON_PLURAL;//this.ending1stPersonPlural();
    }
    public String conjugate2ndPersonPlural(){
        return "Vous " + this.root + this.ending2ndPersonPlural();
    }
    public String conjugate3rdPersonPlural(){
        return "Ils " + this.root + this.ending3rdPersonPlural();
    }

    public String conjugatePastParticipate(){
        return  this.root + this.endingPastParticipate();
    }

    public String conjugatePresentParticipate() {
        return "En " + this.root + this.endingPlural() + ENDING_1ST_PERSON_PLURAL.replace("ons", "ant");
    } */

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
