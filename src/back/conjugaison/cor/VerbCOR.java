package back.conjugaison.cor;

import back.conjugaison.conjugate.Verb;

public abstract class VerbCOR implements IVerb{
    private VerbCOR next;

    public VerbCOR(VerbCOR next){
        this.next = next;
    }

    public void setNext(VerbCOR next){
        this.next = next;
    }

    public Verb findGroup(String verb){
        Verb result;
        result = findGroupExecute(verb);

        if(result == null)
            throw new IllegalArgumentException(verb+" is not a verb or is not handled");
        return result;
    }

    private Verb findGroupExecute(String verb){
        Verb result;

        result = findGroupExp(verb);

        if(result != null)
            return result;
        else
            if(this.next != null)
                return this.next.findGroupExecute(verb);
            else
                return null;
    }

    protected abstract Verb findGroupExp(String verb);
}
