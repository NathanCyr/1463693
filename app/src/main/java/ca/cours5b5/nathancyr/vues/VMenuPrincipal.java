package ca.cours5b5.nathancyr.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import ca.cours5b5.nathancyr.R;
import ca.cours5b5.nathancyr.controleurs.Action;
import ca.cours5b5.nathancyr.controleurs.ControleurAction;
import ca.cours5b5.nathancyr.global.GCommande;


public class VMenuPrincipal extends Vue {

    private Button boutonParametres;
    private Action actionParametres;

    private Button boutonPartie;
    private Action actionPartie;

    private Button boutonConnexion;
    private Action actionConnection;

    private Button boutonEnLigne;
    private Action actionEnLigne;

    public VMenuPrincipal(Context context) {
        super(context);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        recupererControles();

        demanderActions();

        installerListeners();

    }


    private void recupererControles() {

        boutonParametres = findViewById(R.id.bouton_parametres);

        boutonPartie = findViewById(R.id.bouton_partie);

        boutonConnexion = findViewById(R.id.bouton_connexion);

        boutonEnLigne = findViewById(R.id.bouton_en_ligne);


    }

    private void demanderActions() {

        actionParametres = ControleurAction.demanderAction(GCommande.OUVRIR_MENU_PARAMETRES);

        actionPartie = ControleurAction.demanderAction(GCommande.DEMARRER_PARTIE);

        actionConnection = ControleurAction.demanderAction(GCommande.CONNEXION);

        actionEnLigne = ControleurAction.demanderAction(GCommande.JOINDRE_OU_CREER_PARTIE_RESEAU);

    }


    private void installerListeners() {

        installerListenerParametres();

        installerListenerPartie();

        installerListenerConnexion();

        installerListenerEnLigne();

    }

    private void installerListenerEnLigne() {
        boutonEnLigne.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                actionEnLigne.executerDesQuePossible();
            }
        });
    }

    private void installerListenerPartie() {

        boutonPartie.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionPartie.executerDesQuePossible();
            }
        });

    }

    private void installerListenerParametres() {

        boutonParametres.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionParametres.executerDesQuePossible();
            }
        });

    }

    private void installerListenerConnexion(){
        boutonConnexion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionConnection.executerDesQuePossible();
            }
        });
    }

}
