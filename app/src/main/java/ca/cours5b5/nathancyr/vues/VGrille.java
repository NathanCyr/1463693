package ca.cours5b5.nathancyr.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.nathancyr.global.GCouleur;
import ca.cours5b5.nathancyr.modeles.MGrille;

public class VGrille extends GridLayout{

    public VGrille(Context context){
        super(context);
    }

    public VGrille(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public VGrille(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    private int nombreRangees;

    private class Colonne extends ArrayList<VCase>{}

    private List<Colonne> colonnesDeCases;

    private List<VEntete> entetes;

    @Override
    protected void onFinishInflate(){

        Log.d("Atelier06", "VGrille::onFinishInflate");
        super.onFinishInflate();
    }

    private void initialiser(){

    }

    void creerGrille(int hauteur, int largeur){
        ajouterEnTetes(largeur);
        ajouterCases(hauteur, largeur);
    }

    private void initialiserColonnes(int largeur){

    }

    private void ajouterEnTetes(int largeur){

        for(int i = 0; i < largeur; i++){
            VEntete entete = new VEntete(getContext(),i);
            addView(entete,getMiseEnPageEntete(i));
        }

    }

    private LayoutParams getMiseEnPageEntete(int colonne){
        int rangee= 0;
        float poidsRangee = 3;
        float poidsColonne = 3;

        Spec specRangee = GridLayout.spec(rangee, poidsRangee);
        Spec specColonne = GridLayout.spec(colonne,poidsColonne);

        LayoutParams layParam = new LayoutParams(specRangee, specColonne);

        layParam.width=0;
        layParam.height=0;
        layParam.setGravity(Gravity.FILL);

        return layParam;
    }

    private void ajouterCases(int hauteur, int largeur){
        for(int i = 1; i < hauteur+1; i++){
            for(int j=0; j<largeur;++j) {
                VCase caseTemp= new VCase(getContext(), j, (hauteur-i));
                addView(caseTemp, getMiseEnPageCase(i, j));
            }
        }
    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne){

        float poidsRangee = 1;
        float poidsColonne = 1;

        Spec specRangee = GridLayout.spec(rangee, poidsRangee);
        Spec specColonne = GridLayout.spec(colonne,poidsColonne);

        LayoutParams layParam = new LayoutParams(specRangee, specColonne);

        layParam.width=0;
        layParam.height=0;
        layParam.setGravity(Gravity.FILL);

        return layParam;
    }

    private void demanderActionEntete(){

    }

    private void installerListenerEntete(VEntete entete, final int colonne){

    }

    void afficherJetons(MGrille grille){

    }

    private void afficherJeton(int colonne, int rangee, GCouleur jeton){

    }

}
