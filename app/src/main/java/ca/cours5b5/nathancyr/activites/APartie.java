package ca.cours5b5.nathancyr.activites;

import android.os.Bundle;
import android.util.Log;

import java.util.Map;

import ca.cours5b5.nathancyr.R;
import ca.cours5b5.nathancyr.controleurs.ControleurObservation;
import ca.cours5b5.nathancyr.controleurs.interfaces.Fournisseur;
import ca.cours5b5.nathancyr.modeles.MPartie;
import ca.cours5b5.nathancyr.serialisation.JSonification;

public class APartie extends Activite  implements Fournisseur{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Atelier04", AMenuPrincipal.class.getSimpleName() + "::onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie);

        if(savedInstanceState != null){
            String Json = savedInstanceState.getString(MPartie.class.getSimpleName());
            Map<String, Object> objetJson = JSonification.enObjetJson(Json);
            ControleurObservation.partie.aPartirObjetJson(objetJson);
        }
    }

    @Override
    protected void onResume(){

        super.onResume();
    }

    @Override
    protected void onPause(){

        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){

        super.onSaveInstanceState(outState);
        Map<String, Object> objetJson = ControleurObservation.partie.enObjetJson();
        String Json = JSonification.enChaine(objetJson);
        outState.putString("MPartie", Json);
        Log.d("Atelier08", Json);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }
}
