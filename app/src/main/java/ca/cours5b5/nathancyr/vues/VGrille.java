package ca.cours5b5.nathancyr.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.nathancyr.controleurs.Action;
import ca.cours5b5.nathancyr.controleurs.ControleurAction;
import ca.cours5b5.nathancyr.global.GCommande;
import ca.cours5b5.nathancyr.global.GCouleur;
import ca.cours5b5.nathancyr.modeles.MColonne;
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

    private Action actionEnTete;

    private VCase[][] cases;

    private List<VEntete> entetes;

    @Override
    protected void onFinishInflate(){

        Log.d("Atelier06", "VGrille::onFinishInflate");
        super.onFinishInflate();
    }


    void creerGrille(int hauteur, int largeur) {

        cases = new VCase[hauteur][largeur];
        ajouterEnTetes(largeur);
        ajouterCases(hauteur, largeur);
    }

    private void ajouterEnTetes(int largeur){

        for(int i = 0; i < largeur; i++){
            VEntete entete = new VEntete(getContext(),i);
            addView(entete,getMiseEnPageEntete(i));
            installerListenerEntete(entete, i);
        }
        demanderActionEntete();
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
                cases[hauteur - i][j] = caseTemp;
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
        actionEnTete = ControleurAction.demanderAction(GCommande.JOUER_COUP_ICI);
    }

    private void installerListenerEntete(VEntete entete, final int colonne){
        entete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionEnTete.setArguments(colonne);
                actionEnTete.executerDesQuePossible();
            }
        });
    }

    void afficherJetons(MGrille grille){

        List<MColonne> listeColonnes = grille.getColonnes();

        for(int colonne = 0; colonne < listeColonnes.size(); colonne++){
            MColonne colonneActuelle = listeColonnes.get(colonne);

            for(int rangee = 0; rangee < colonneActuelle.getJetons().size(); rangee++){
                afficherJeton(colonne, rangee, colonneActuelle.getJetons().get(rangee));
            }
        }
    }

    private void afficherJeton(int colonne, int rangee, GCouleur jeton){
        cases[rangee][colonne].afficherJeton(jeton);
    }

}
