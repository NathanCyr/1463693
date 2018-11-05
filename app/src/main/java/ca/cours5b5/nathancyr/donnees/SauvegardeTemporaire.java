package ca.cours5b5.nathancyr.donnees;

import android.os.Bundle;
import android.util.Log;

import java.util.Map;


import ca.cours5b5.nathancyr.serialisation.Jsonification;

public class SauvegardeTemporaire extends SourceDeDonnees {

    private Bundle bundle;

    public SauvegardeTemporaire(Bundle bundle){
        this.bundle = bundle;
    }

    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde) {
        String cle = getCle(cheminSauvegarde);

        if(bundle != null && bundle.containsKey(cheminSauvegarde)){

            String json = bundle.getString(cle);

            Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

            return objetJson;

        }else{

            return null;

        }
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {
        String cle = getCle(cheminSauvegarde);

        Log.d("Atelier 11: ", "sauvegardeTemporaire");
        if(bundle != null){
            String json = Jsonification.enChaineJson(objetJson);
            bundle.putString(cle, json);

        }
    }

    private String getCle(String cheminSauvegarde){
        return getNomModele(cheminSauvegarde);
    }

}