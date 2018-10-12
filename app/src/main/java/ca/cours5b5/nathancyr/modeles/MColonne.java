package ca.cours5b5.nathancyr.modeles;

import java.util.List;
import java.util.Map;

import ca.cours5b5.nathancyr.exceptions.ErreurDeSerialisation;
import ca.cours5b5.nathancyr.global.GCouleur;

public class MColonne extends Modele {
    private List<GCouleur> jetons;

    public MColonne(){

    }

    public List<GCouleur> getJetons(){
        return null;
    }

    public void placerJeton(GCouleur couleur){

    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurDeSerialisation{

    }

    @Override
    public  Map<String, Object> enObjetJson() throws ErreurDeSerialisation{
        return null;
    }
}
