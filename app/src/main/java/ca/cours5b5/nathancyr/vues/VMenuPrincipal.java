package ca.cours5b5.nathancyr.vues;


import android.content.Context;

import android.util.AttributeSet;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import ca.cours5b5.nathancyr.R;
import ca.cours5b5.nathancyr.controleurs.Action;
import ca.cours5b5.nathancyr.controleurs.ControleurAction;
import ca.cours5b5.nathancyr.global.GCommande;


public class VMenuPrincipal extends Vue{

    static{
        Log.d("Atelier04", VMenuPrincipal.class.getSimpleName() + "::static");
    }

    public VMenuPrincipal(Context context) {

        super(context);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();
        Log.d("Atelier04", VMenuPrincipal.class.getSimpleName() + "::onFinishInflate");
        Button boutonParametres = this.findViewById(R.id.bouton_parametres);
        boutonParametres.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Action actionParametres = ControleurAction.demanderAction((GCommande.OUVRIR_MENU_PARAMETRES));
                actionParametres.executerDesQuePossible();
            }
        });
        Button boutonPartie = this.findViewById(R.id.bouton_partie);
        boutonPartie.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Action actionPartie = ControleurAction.demanderAction((GCommande.OUVRIR_MENU_PARTIE));
                actionPartie.executerDesQuePossible();
            }
        });
    }

}
