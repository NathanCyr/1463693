package ca.cours5b5.nathancyr.controleurs;

import ca.cours5b5.nathancyr.controleurs.interfaces.Fournisseur;
import ca.cours5b5.nathancyr.controleurs.interfaces.ListenerFournisseur;

public class Action {

    Fournisseur fournisseur;
    ListenerFournisseur listenerFournisseur;
    Object[] args;

    public void setArguments(Object... args) {
        this.args = args;

    }
    public void executerDesQuePossible(){
        ControleurAction.executerDesQuePossible(this);
    }

    public Action cloner(){
        Action action = new Action();

        if(args!=null){
            action.setArguments(args.clone());

        }
        action.fournisseur = fournisseur;
        action.listenerFournisseur = listenerFournisseur;
        return action;
    }

}
