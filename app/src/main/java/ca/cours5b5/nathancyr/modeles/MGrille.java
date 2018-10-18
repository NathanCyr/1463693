package ca.cours5b5.nathancyr.modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.cours5b5.nathancyr.exceptions.ErreurDeSerialisation;
import ca.cours5b5.nathancyr.global.GCouleur;

public class MGrille extends Modele {
    private List<MColonne> colonnes;

    public MGrille(int largeur){
        initialiserColonnes(largeur);
    }

    private void initialiserColonnes(int largeur){
        colonnes = new ArrayList<>();

        for(int i = 0; i < largeur; i++){
            colonnes.add(new MColonne());
        }
    }

    public List<MColonne> getColonnes(){
        return colonnes;
    }

    public void placerJeton(int colonone, GCouleur couleur){
        colonnes.get(colonone).placerJeton(couleur);
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurDeSerialisation {

    }

    @Override
    public  Map<String, Object> enObjetJson() throws ErreurDeSerialisation{
        return null;
    }
}
