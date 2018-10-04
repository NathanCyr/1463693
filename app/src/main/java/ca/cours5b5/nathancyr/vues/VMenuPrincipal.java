package ca.cours5b5.nathancyr.vues;

import android.support.constraint.ConstraintLayout;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import ca.cours5b5.nathancyr.R;
import ca.cours5b5.nathancyr.activites.AParametres;

public class VMenuPrincipal extends Vue{

    static{
        Log.d("Atelier04", VMenuPrincipal.class.getSimpleName() + "::static");
    }
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
        Log.d("Atelier04", VMenuPrincipal.class.getSimpleName() + "::onFinishInflate");
        Button boutonParametres = this.findViewById(R.id.bouton_parametres);
        Button boutonPartie = this.findViewById(R.id.bouton_partie);
    }

}
