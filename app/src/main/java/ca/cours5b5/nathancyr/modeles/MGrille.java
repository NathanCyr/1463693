package ca.cours5b5.nathancyr.modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.cours5b5.nathancyr.exceptions.ErreurSerialisation;
import ca.cours5b5.nathancyr.global.GCouleur;
import ca.cours5b5.nathancyr.global.GDirection;


public class MGrille extends Modele  {

    public boolean siCouleurGagne(GCouleur couleur, int pourGagner){
        return false;
    }
    public boolean siCouleurGagneCetteColonne(GCouleur couleur, int idColonne, int pourGagner){
        return false;
    }
    public boolean siCouleurGagneCetteCase(GCouleur couleur, int idColonne, int idRangee, int pourGagner){
        return false;
    }
    public boolean siCouleurGagneDansCetteDirection(GCouleur couleur, int idColonne, int idRangee, GDirection direction, int pourGagner){
        return false;
    }
    public boolean siMemeCouleurCetteCasse(GCouleur couleur, int idColonne, int idRangee){
        return false;
    }

    private List<MColonne> colonnes;

    public MGrille(int largeur){

        colonnes = new ArrayList<>();

        initialiserColonnes(largeur);

    }

    private void initialiserColonnes(int largeur) {

        for(int i=0; i<largeur; i++){

            colonnes.add(new MColonne());

        }
    }


    public List<MColonne> getColonnes() {
        return colonnes;
    }


    public void placerJeton(int colonne, GCouleur couleur) {

        colonnes.get(colonne).placerJeton(couleur);

    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {

        throw new UnsupportedOperationException();

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {

        throw new UnsupportedOperationException();

    }

}
