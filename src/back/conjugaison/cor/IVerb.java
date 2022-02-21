package back.conjugaison.cor;

import back.conjugaison.conjugate.Verb;

public interface IVerb {
    /**
     * 
     * @param infinitif exemples : "chanter", "danser", "courir", "frémir", "paraître", ...
     * @return Objet Verb correspondant
     * @throws IllegalArgumentException si le verbe n'est pas reconnu
     */
    public Verb findGroup(String infinitif);
}
