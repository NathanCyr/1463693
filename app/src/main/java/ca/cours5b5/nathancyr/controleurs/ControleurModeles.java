package ca.cours5b5.nathancyr.controleurs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.nathancyr.controleurs.interfaces.Fournisseur;
import ca.cours5b5.nathancyr.controleurs.interfaces.ListenerGetModele;
import ca.cours5b5.nathancyr.donnees.ListenerChargement;
import ca.cours5b5.nathancyr.donnees.Serveur;
import ca.cours5b5.nathancyr.donnees.SourceDeDonnees;
import ca.cours5b5.nathancyr.exceptions.ErreurModele;
import ca.cours5b5.nathancyr.modeles.MParametres;
import ca.cours5b5.nathancyr.modeles.MPartie;
import ca.cours5b5.nathancyr.modeles.Modele;
import ca.cours5b5.nathancyr.donnees.Disque;
import ca.cours5b5.nathancyr.usagers.UsagerCourant;

public final class ControleurModeles {

    private ControleurModeles() {
    }

    private static Map<String, Modele> modelesEnMemoire;

    private static SourceDeDonnees[] sequenceDeChargement;

    private static List<SourceDeDonnees> listeDeSauvegardes;

    static {

        modelesEnMemoire = new HashMap<>();

        listeDeSauvegardes = new ArrayList<>();
        listeDeSauvegardes.add(Disque.getInstance());
        listeDeSauvegardes.add(Serveur.getInstance());

    }

    public static void setSequenceDeChargement(SourceDeDonnees... sequenceDeChargement) {

        ControleurModeles.sequenceDeChargement = sequenceDeChargement;

    }

    public static void sauvegarderModeleDansCetteSource(String nomModele, SourceDeDonnees sourceDeDonnees) {

        Modele modele = modelesEnMemoire.get(nomModele);

        String cheminDeSauvegarde = getCheminSauvegarde(nomModele);

        if (modele != null) {

            Map<String, Object> objetJson = modele.enObjetJson();

            sourceDeDonnees.sauvegarderModele(cheminDeSauvegarde, objetJson);

        }
    }

    static void getModele(final String nomModele, ListenerGetModele listenerGetModele) {

        Modele modele = modelesEnMemoire.get(nomModele);

        if (modele == null) {

            creerModeleEtChargerDonnees(nomModele, listenerGetModele);

        } else {
            listenerGetModele.reagirAuModele(modele);
        }
    }

    public static void sauvegarderModele(String nomModele) throws ErreurModele {

        for (SourceDeDonnees source : listeDeSauvegardes) {

            sauvegarderModeleDansCetteSource(nomModele, source);

        }

    }


    private static void creerModeleSelonNom(String nomModele, final ListenerGetModele listenerGetModele) throws ErreurModele {

        if (nomModele.equals(MParametres.class.getSimpleName())) {

            MParametres mParametres = new MParametres();
            listenerGetModele.reagirAuModele(mParametres);

        } else if (nomModele.equals(MPartie.class.getSimpleName())) {

            getModele(MParametres.class.getSimpleName(), new ListenerGetModele() {
                @Override
                public void reagirAuModele(Modele modele) {
                    MParametres parametres = (MParametres) modele;
                    MPartie partie = new MPartie(parametres.getParametresPartie().cloner());
                    listenerGetModele.reagirAuModele(partie);
                }
            });

        } else {

            throw new ErreurModele("Modèle inconnu: " + nomModele);

        }
    }

    private static void creerModeleEtChargerDonnees(final String nomModele, final ListenerGetModele listenerGetModele) {
        creerModeleSelonNom(nomModele, new ListenerGetModele() {
            @Override
            public void reagirAuModele(Modele modele) {
                modelesEnMemoire.put(nomModele, modele);
                chargerDonnees(modele, nomModele, listenerGetModele);
            }
        });
    }

    private static void chargementViaSequence(Modele modele, String cheminSauvegarde, ListenerGetModele listenerGetModele, int ind) {
        if (ind >= sequenceDeChargement.length) {
            terminerChargement(modele, listenerGetModele);
        } else {
            chargementViaSourceCouranteOuSuivante(modele, cheminSauvegarde, listenerGetModele, ind);
        }
    }

    private static void chargementViaSourceCouranteOuSuivante(final Modele modele, final String cheminSauvegarde, final ListenerGetModele listenerGetModele, final int ind) {

        sequenceDeChargement[ind].chargerModele(cheminSauvegarde, new ListenerChargement() {
            @Override
            public void reagirSucces(Map<String, Object> objetJson) {
                terminerChargementAvecDonnees(objetJson, modele, listenerGetModele);
            }

            @Override
            public void reagirErreur(Exception e) {
                chargementViaSourceSuivante(modele, cheminSauvegarde, listenerGetModele, ind);
            }

        });
    }

    private static void terminerChargementAvecDonnees(Map<String, Object> objetJson, Modele modele, ListenerGetModele listenerGetModele){
        modele.aPartirObjetJson(objetJson);
        terminerChargement(modele, listenerGetModele);
    }

    private static void chargementViaSourceSuivante(Modele modele, String cheminSauvegarde, ListenerGetModele listenerGetModele, int ind){
        chargementViaSequence(modele, cheminSauvegarde, listenerGetModele, ind + 1);
    }

    private static void chargerDonnees(Modele modele, String nomModele, ListenerGetModele listenerGetModele){
        String chemin = getCheminSauvegarde(nomModele);
        int indice = 0;

        chargementViaSequence(modele, chemin, listenerGetModele, indice);
    }

    private static void terminerChargement(Modele modele, ListenerGetModele listenerGetModele){
        listenerGetModele.reagirAuModele(modele);
    }


    public static void detruireModele(String nomModele) {

        Modele modele = modelesEnMemoire.get(nomModele);

        if (modele != null) {

            modelesEnMemoire.remove(nomModele);

            ControleurObservation.detruireObservation(modele);

            if (modele instanceof Fournisseur) {

                ControleurAction.oublierFournisseur((Fournisseur) modele);

            }
        }
    }

    private static String getCheminSauvegarde(String nomModele) {
        String resultat;

        resultat = nomModele + "/" + UsagerCourant.getId();

        return resultat;
    }


}