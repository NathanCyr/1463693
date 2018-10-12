package ca.cours5b5.nathancyr.modeles;

import java.util.Map;

import ca.cours5b5.nathancyr.controleurs.interfaces.Fournisseur;
import ca.cours5b5.nathancyr.exceptions.ErreurDeSerialisation;
import ca.cours5b5.nathancyr.global.GCouleur;
import ca.cours5b5.nathancyr.serialisation.AttributSerialisable;

public class MPartie extends Modele implements Fournisseur{

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";

    private MGrille grille;
    private GCouleur couleurCourante;

    private void initialiserCouleurCourante(){

    }

    private void fournirActionPLacerJeton(){

    }

    protected void joeurCoup(int colonne){

    }

    private void prochaineCouleurCourante(){

    }

    public MPartie (MParametresPartie parametres){

        this.parametres = parametres;
    }

    public MParametresPartie getParametres() {

        return parametres;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurDeSerialisation {

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurDeSerialisation{
        return null;
    }
}
