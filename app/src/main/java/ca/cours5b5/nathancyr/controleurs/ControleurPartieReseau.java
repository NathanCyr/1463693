package ca.cours5b5.nathancyr.controleurs;

import android.util.Log;

import ca.cours5b5.nathancyr.controleurs.interfaces.ListenerGetModele;
import ca.cours5b5.nathancyr.global.GCommande;
import ca.cours5b5.nathancyr.global.GConstantes;
import ca.cours5b5.nathancyr.modeles.MPartieReseau;
import ca.cours5b5.nathancyr.modeles.Modele;
import ca.cours5b5.nathancyr.proxy.ProxyListe;
import ca.cours5b5.nathancyr.usagers.UsagerCourant;

public class ControleurPartieReseau {

    private static final ControleurPartieReseau instance = new ControleurPartieReseau();

    public static ControleurPartieReseau getInstance(){return instance;};

    private ProxyListe proxyEmettreCoups;
    private ProxyListe proxyRecevoirCoups;

    public void connecterAuServeur(){

        ControleurModeles.getModele(MPartieReseau.class.getSimpleName(), new ListenerGetModele() {
            @Override
            public void reagirAuModele(Modele modele) {

                MPartieReseau mPartieReseau = (MPartieReseau) modele;
                connecterAuServeur(mPartieReseau.idJoueurHote);
            }
        });

    }

    private void connecterAuServeur(String idJoueurHote){

        String cheminCoupJoueurHote = getCheminCoupsJoueurHote(idJoueurHote);
        String cheminCoupJoueurInvite = getCheminCoupsJoueurInvite(idJoueurHote);
        if(UsagerCourant.getId().equals(idJoueurHote)){
            connecterEnTantQueJoueurHote(cheminCoupJoueurHote,cheminCoupJoueurInvite);
        }else{
            connecterEnTantQueJoueurInvite(cheminCoupJoueurHote,cheminCoupJoueurInvite);
        }
        proxyRecevoirCoups.setActionNouvelItem(GCommande.RECEVOIR_COUP_RESEAU);
        proxyRecevoirCoups.connecterAuServeur();
        proxyEmettreCoups.connecterAuServeur();
    }

    private void connecterEnTantQueJoueurHote(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite){
        proxyEmettreCoups = new ProxyListe(cheminCoupsJoueurHote);
        proxyRecevoirCoups = new ProxyListe(cheminCoupsJoueurInvite);

    }

    private void connecterEnTantQueJoueurInvite(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite){
        proxyEmettreCoups = new ProxyListe(cheminCoupsJoueurInvite);
        proxyRecevoirCoups = new ProxyListe(cheminCoupsJoueurHote);
    }

    public void deconnecterDuServeur(){
        proxyEmettreCoups.deconnecterDuServeur();
        proxyRecevoirCoups.deconnecterDuServeur();


    }

    public void transmettreCoup(Integer idColonne){
        proxyEmettreCoups.ajouterValeur(idColonne);

    }

    private String getCheminCoupsJoueurInvite(String idJoueurInvite){
        return getCheminPartie(idJoueurInvite) + "/" + GConstantes.CLE_COUPS_JOUEUR_Invite;
    }

    private String getCheminCoupsJoueurHote(String idJoueurHote){
        return getCheminPartie(idJoueurHote) + "/" + GConstantes.CLE_COUPS_JOUEUR_HOTE;
    }

    private String getCheminPartie(String idJoueurHote){
        return MPartieReseau.class.getSimpleName() + "/" + idJoueurHote;
    }

    public void detruireSauvegardeServeur(){

    }
}
