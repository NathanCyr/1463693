package ca.cours5b5.nathancyr.controleurs;

import java.util.List;
import java.util.Map;

import ca.cours5b5.nathancyr.controleurs.interfaces.Fournisseur;
import ca.cours5b5.nathancyr.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.nathancyr.global.GCommande;


public class ControleurAction {

    private static Map<GCommande, Action> actions;
    private static List<Action> fileAttenteExecution;

    static{

    }

    public static Action demanderAction(GCommande commande){
    return null;
    }

    public static void  fournirAction(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur){


    }

    static void executerDesQuePossible(Action action){

    }

    private static void executerActionExecutables(){

    }

    static boolean siActionExecutable(Action action){
        return false;
    }

    private static void lancerObservationSiApplicable(Action action){

    }

    private static synchronized void executerMaintenant(Action action){

    }

    private static void enregistrerFournisseur(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur){

    }

    private static void ajouterActionFileDAttente(Action action){

    }

}
