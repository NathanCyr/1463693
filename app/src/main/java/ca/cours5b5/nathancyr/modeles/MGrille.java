package ca.cours5b5.nathancyr.modeles;

import java.util.List;
import java.util.Map;

import ca.cours5b5.nathancyr.exceptions.ErreurDeSerialisation;
import ca.cours5b5.nathancyr.global.GCouleur;

public class MGrille extends Modele {
    private List<MColonne> colonnes;

    public MGrille(int largeur){

    }

    private void initialiserColonnes(int largeur){

    }

    public List<MColonne> getColonnes(){
        return null;
    }

    public void placerJeton(int colonone, GCouleur couleur){

    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurDeSerialisation {

    }

    @Override
    public  Map<String, Object> enObjetJson() throws ErreurDeSerialisation{
        return null;
    }
}
