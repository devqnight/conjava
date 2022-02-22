package back.conjugaison.conjugate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class VerbList {
    public ArrayList<Verb> verbList;

    private static VerbList instance;

    public static VerbList getInstance(){
        if(instance == null){
            instance = new VerbList();
        }
        return instance;
    }

    public String conjugate1stPersonSingular() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        return loop(verbList, Verb.class.getMethod("conjugate1stPersonSingular", (Class<?>[])null));
    }

    public String conjugate2ndPersonSingular() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        return loop(verbList, Verb.class.getMethod("conjugate2ndPersonSingular", (Class<?>[])null));
    }

    public String conjugate3rdPersonSingular() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        return loop(verbList, Verb.class.getMethod("conjugate3rdPersonSingular", (Class<?>[])null));
    }

    public String conjugate1stPersonPlural() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        return loop(verbList, Verb.class.getMethod("conjugate1stPersonPlural", (Class<?>[])null));
    }
    
    public String conjugate2ndPersonPlural() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        return loop(verbList, Verb.class.getMethod("conjugate2ndPersonPlural", (Class<?>[])null));
    }
    
    public String conjugate3rdPersonPlural() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        return loop(verbList, Verb.class.getMethod("conjugate3rdPersonPlural", (Class<?>[])null));
    }

    public String conjugatePresentParticipate() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        return loop(verbList, Verb.class.getMethod("conjugatePresentParticipate", (Class<?>[])null));
    }

    public String conjugatePastParticipate() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        return loop(verbList, Verb.class.getMethod("conjugatePastParticipate", (Class<?>[])null));
    }

    private String replaceString(String verb){
        return verb +"\n";
    }


    private String loop(ArrayList<Verb> verbs, Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        String res = "";

        for (Verb verb : verbs) {
            res += replaceString((String)method.invoke(verb));
        }
        return res;
    }
}
