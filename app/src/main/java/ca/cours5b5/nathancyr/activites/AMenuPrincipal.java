package ca.cours5b5.nathancyr.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.auth.api.Auth;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.nathancyr.R;
import ca.cours5b5.nathancyr.controleurs.ControleurAction;
import ca.cours5b5.nathancyr.controleurs.interfaces.Fournisseur;
import ca.cours5b5.nathancyr.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.nathancyr.global.GCommande;
import ca.cours5b5.nathancyr.global.GConstantes;

public class AMenuPrincipal extends Activite implements Fournisseur {

    private static List<AuthUI.IdpConfig> fournisseurDeConnexion = new ArrayList<>();

    static{
        fournisseurDeConnexion.add(new AuthUI.IdpConfig.GoogleBuilder().build());
        fournisseurDeConnexion.add(new AuthUI.IdpConfig.EmailBuilder().build());
        fournisseurDeConnexion.add(new AuthUI.IdpConfig.PhoneBuilder().build());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        fournirActions();

    }

    private void fournirActions() {

        fournirActionOuvrirMenuParametres();

        fournirActionDemarrerPartie();

        fournirActionConnecter();
    }

    private void fournirActionConnecter(){
        ControleurAction.fournirAction(this, GCommande.CONNEXION, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                connexion();
            }
        });
    }



    private void fournirActionOuvrirMenuParametres() {

        ControleurAction.fournirAction(this,
                GCommande.OUVRIR_MENU_PARAMETRES,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionParametres();

                    }
                });
    }

    private void fournirActionDemarrerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.DEMARRER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionPartie();

                    }
                });
    }


    private void transitionParametres(){

        Intent intentionParametres = new Intent(this, AParametres.class);
        startActivity(intentionParametres);

    }

    private void transitionPartie(){

        Intent intentionParametres = new Intent(this, APartie.class);
        startActivity(intentionParametres);

    }

    private void connexion(){
        Intent intentionConnexion = AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(fournisseurDeConnexion).build();

        this.startActivityForResult(intentionConnexion, GConstantes.CODE_FIREBASE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCOde, Intent data){
        if(requestCode == GConstantes.CODE_FIREBASE){
            if(resultCOde == RESULT_OK){
                Log.d("Atelier 11: ", "onActivityResult: Reussi");
            }else{
                Log.d("Atelier 11: ", "onActivityResult: Echoue");
            }
        }
    }
}
