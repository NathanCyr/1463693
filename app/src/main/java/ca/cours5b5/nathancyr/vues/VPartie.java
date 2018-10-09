package ca.cours5b5.nathancyr.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import ca.cours5b5.nathancyr.R;
import ca.cours5b5.nathancyr.controleurs.ControleurObservation;
import ca.cours5b5.nathancyr.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.nathancyr.modeles.MPartie;
import ca.cours5b5.nathancyr.modeles.Modele;

public class VPartie extends Vue{

    private VGrille grille;

    public VPartie(Context context){
        super(context);
    }

    public VPartie(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public VPartie(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate(){
        Log.d("Atelier06", "VPartie::onFinishInflate");
        super.onFinishInflate();
        initialiser();
        observerPartie();
    }

    private void initialiser(){
        grille = findViewById(R.id.grille);
    }

    private void observerPartie(){
        Log.d("Atelier06", "VPartie::observerPartie");
        String name = MPartie.class.getSimpleName();

        ControleurObservation.observerModele(name, new ListenerObservateur() {
            @Override
            public void reagirNouveauModele(Modele modele) {
                Log.d("Ate;ier06", "VPartie::reagirNouveauModele");
                super.reagirNouveauModele(modele);
                MPartie partie = (MPartie) modele;
                initialiserGrille(partie);
            }

            @Override
            public void reagirChangementAuModele(Modele modele){
                afficherParametres((MPartie) modele);
            }
        });
    }

    private MPartie getPartie(Modele modele){
        return null;
    }

    private void initialiserGrille(MPartie mPartie){
        int hauteur = mPartie.getParametres().getHauteur();
        int largeur = mPartie.getParametres().getLargeur();
        grille.creerGrille(hauteur, largeur);
    }

    private void afficherParametres(MPartie partie){

    }

}
