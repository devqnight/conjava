package back.conjugaison.conjugate;

import back.conjugaison.helper.Helper;

public abstract class Verb implements IConjugate{

    protected static String ENDING_1ST_PERSON_PLURAL = "ons";
    protected static String ENDING_2ND_PERSON_PLURAL = "ez";
    protected static String ENDING_3RD_PERSON_PLURAL = "ent";

    private String root;

    protected String end = "";

    protected void init(String verb, String end){
        if(!verb.endsWith(end)){
            throw new IllegalArgumentException("Verb does not end in "+end);
        }
        this.setRoot(verb.substring(0, verb.length()-end.length()));
    }

    protected abstract String ending1stPersonSingular();
    protected abstract String ending2ndPersonSingular();
    protected abstract String ending3rdPersonSingular();
    protected abstract String ending1stPersonPlural();
    protected abstract String ending2ndPersonPlural();
    protected abstract String ending3rdPersonPlural();
    protected abstract String endingPastParticipate();

    public String conjugate1stPersonSingular(){
        return this.getJe(this.root.charAt(0)) + this.root + this.ending1stPersonSingular();
    }
    public String conjugate2ndPersonSingular(){
        return "Tu " + this.root + this.ending2ndPersonSingular();
    }
    public String conjugate3rdPersonSingular(){
        return "Il " + this.root + this.ending3rdPersonSingular();
    }

    public String conjugate1stPersonPlural(){
        return "Nous " + this.root + this.ending1stPersonPlural();
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
        return "En " + this.root + this.ending1stPersonPlural().replace("ons", "ant");
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

    private String getJe(char start){
        return Helper.isVowel(start)? "J'" : "Je ";
    }
}
