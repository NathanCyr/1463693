package ca.cours5b5.nathancyr.controleurs;

import ca.cours5b5.nathancyr.controleurs.interfaces.Fournisseur;
import ca.cours5b5.nathancyr.controleurs.interfaces.ListenerFournisseur;

public class Action {

    Fournisseur fournisseur;

    ListenerFournisseur listenerFournisseur;

    Object[] args;

    public void setArguments(Object... args){

    }

    public void executerDesQuePossible(){

    }

    public Action cloner(){
        return null;
    }
}
