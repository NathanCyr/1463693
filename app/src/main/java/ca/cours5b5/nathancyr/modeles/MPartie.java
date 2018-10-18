package ca.cours5b5.nathancyr.modeles;

import android.util.Log;

import java.util.Map;

import ca.cours5b5.nathancyr.controleurs.ControleurAction;
import ca.cours5b5.nathancyr.controleurs.interfaces.Fournisseur;
import ca.cours5b5.nathancyr.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.nathancyr.exceptions.ErreurDeSerialisation;
import ca.cours5b5.nathancyr.global.GCommande;
import ca.cours5b5.nathancyr.global.GCouleur;
import ca.cours5b5.nathancyr.serialisation.AttributSerialisable;

public class MPartie extends Modele implements Fournisseur{

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";

    private MGrille grille;
    private GCouleur couleurCourante;

    public MPartie (MParametresPartie parametres){

        this.parametres = parametres;
        initialiserCouleurCourante();
        grille = new MGrille(this.parametres.getLargeur());
        fournirActionPlacerJeton();
    }

    private void initialiserCouleurCourante(){
        couleurCourante = GCouleur.ROUGE;
    }

    private void fournirActionPlacerJeton(){
        ControleurAction.fournirAction(this, GCommande.JOUER_COUP_ICI, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                joeurCoup((int) args[0]);
            }
        });
    }

    protected void joeurCoup(int colonne){
        Log.d("Atelier07", "JouerCoup");
        grille.placerJeton(colonne, couleurCourante);
        prochaineCouleurCourante();
    }

    private void prochaineCouleurCourante() {
        if (couleurCourante == GCouleur.JAUNE) {
            couleurCourante = GCouleur.ROUGE;
        } else if (couleurCourante == GCouleur.ROUGE) {
            couleurCourante = GCouleur.JAUNE;
        }

    }

    public MParametresPartie getParametres() {

        return parametres;
    }

    public MGrille getGrille() {
        return grille;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurDeSerialisation {

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurDeSerialisation{
        return null;
    }
}
