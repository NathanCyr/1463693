package ca.cours5b5.nathancyr.controleurs;

import java.util.HashMap;
import java.util.Map;
import android.util.Log;

import ca.cours5b5.nathancyr.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.nathancyr.modeles.MParametres;
import ca.cours5b5.nathancyr.modeles.MPartie;
import ca.cours5b5.nathancyr.modeles.Modele;

public class ControleurObservation {

    private static Map<Modele, ListenerObservateur> observations;
    private static MPartie partie;

    static{
    observations = new HashMap<>();
    }

    public static void  observerModele(String nomModele, final ListenerObservateur listenerObservateur){
        Log.d("Ateliero06", "ControleurObservation::observerModele");
        if(nomModele.equals("MParametres")){
            observations.put(MParametres.instance, listenerObservateur);
            lancerObservationPremiereFois(MParametres.instance);
        }else{
            partie = new MPartie(MParametres.instance.getParametresPartie().cloner());
            observations.put(ControleurObservation.partie, listenerObservateur);
            lancerObservationPremiereFois(ControleurObservation.partie);
        }

    }

    public static void lancerObservation(Modele modele){
        ListenerObservateur listenerObservateur = observations.get(modele);
        if(listenerObservateur != null){
            listenerObservateur.reagirChangementAuModele(modele);
        }
    }

    public static void lancerObservationPremiereFois(Modele modele){
        ListenerObservateur listenerObservateur = observations.get(modele);
        if(listenerObservateur != null){
            listenerObservateur.reagirNouveauModele(modele);
        }
    }


}
