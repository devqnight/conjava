package back.conjugaison.conjugate;

public interface IConjugate {
    public String conjugate(String pronoun, String tense, String mode);
    public String conjugatePronouns(String tense, String mode);
}
