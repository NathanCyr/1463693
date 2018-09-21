package ca.cours5b5.nathancyr.controleurs;

import ca.cours5b5.nathancyr.controleurs.interfaces.Fournisseur;
import ca.cours5b5.nathancyr.controleurs.interfaces.ListenerFournisseur;

public class Action {

    Fournisseur fournisseur;

    ListenerFournisseur listenerFournisseur;

    Object[] args;
    public Action action;
    public void setArguments(Object... args){

    }

    public void executerDesQuePossible(){
        ControleurAction.executerDesQuePossible(action);
    }

    public Action cloner(){

        if(args.length == 0){
            action = null;
        }else {
           args.clone();
           action = cloner();
        }

        return action;
    }
}
