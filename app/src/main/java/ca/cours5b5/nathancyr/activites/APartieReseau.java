package ca.cours5b5.nathancyr.activites;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ca.cours5b5.nathancyr.R;
import ca.cours5b5.nathancyr.controleurs.ControleurAction;
import ca.cours5b5.nathancyr.controleurs.ControleurModeles;
import ca.cours5b5.nathancyr.controleurs.ControleurPartie;
import ca.cours5b5.nathancyr.controleurs.ControleurPartieReseau;
import ca.cours5b5.nathancyr.controleurs.interfaces.Fournisseur;
import ca.cours5b5.nathancyr.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.nathancyr.donnees.SauvegardeTemporaire;
import ca.cours5b5.nathancyr.donnees.Serveur;
import ca.cours5b5.nathancyr.global.GCommande;
import ca.cours5b5.nathancyr.global.GConstantes;
import ca.cours5b5.nathancyr.modeles.MParametres;
import ca.cours5b5.nathancyr.modeles.MPartieReseau;
import ca.cours5b5.nathancyr.vues.VPartieReseau;


public class APartieReseau extends Activite implements Fournisseur {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie_reseau);

        fournirActionTerminerPartie();

        ControleurPartieReseau.getInstance().connecterAuServeur();

    }


    private void fournirActionTerminerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.TERMINER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        // XXX: terminerPartie() est appelée sur onDestroy
                        quitterCetteActivite();

                    }
                });
    }


    private void terminerPartie() {

        String nomModele = MPartieReseau.class.getSimpleName();

        ControleurPartieReseau.getInstance().deconnecterDuServeur();

        ControleurModeles.detruireModele(nomModele);

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("Atelier", "APartie.onSaveInstanceState()");
        super.onSaveInstanceState(outState);

        String nomModele = MPartieReseau.class.getSimpleName();

        ControleurModeles.sauvegarderModeleDansCetteSource(nomModele,
                new SauvegardeTemporaire(outState));

    }


    @Override
    protected void onPause() {
        super.onPause();

        ControleurPartieReseau.getInstance().detruireSauvegardeServeur();

    }


    @Override
    protected void onDestroy() {
        Log.d("Atelier", "APartie.onDestroy()");
        super.onDestroy();

        terminerPartie();

    }


}
