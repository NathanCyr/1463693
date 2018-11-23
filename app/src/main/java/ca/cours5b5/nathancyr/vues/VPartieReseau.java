package ca.cours5b5.nathancyr.vues;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.nathancyr.R;
import ca.cours5b5.nathancyr.controleurs.ControleurObservation;
import ca.cours5b5.nathancyr.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.nathancyr.exceptions.ErreurObservation;
import ca.cours5b5.nathancyr.modeles.MParametresPartie;
import ca.cours5b5.nathancyr.modeles.MPartie;
import ca.cours5b5.nathancyr.modeles.MPartieReseau;
import ca.cours5b5.nathancyr.modeles.Modele;


public class VPartieReseau extends VPartie {


    private VGrille grille;


    public VPartieReseau(Context context) {
        super(context);
    }

    public VPartieReseau(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartieReseau(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected String getNomModele(){
        return MPartieReseau.class.getSimpleName();
    }

}
