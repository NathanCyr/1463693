package ca.cours5b5.nathancyr.controleurs;

import ca.cours5b5.nathancyr.global.GCommande;
import ca.cours5b5.nathancyr.global.GCouleur;

public final class ControleurPartie {

    private ControleurPartie(){

    }

    private static final ControleurPartie instance = new ControleurPartie();

    public static ControleurPartie getInstance(){
        return null;
    }

    public void gagnerPartie(GCouleur couleurGagnante){
        Action actionPourGagner = ControleurAction.demanderAction(GCommande.AFFICHER_GAGNANT);
        actionPourGagner.setArguments(couleurGagnante);
        actionPourGagner.executerDesQuePossible();
    }
}
