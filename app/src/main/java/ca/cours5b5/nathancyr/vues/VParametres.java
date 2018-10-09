package ca.cours5b5.nathancyr.vues;

import android.support.constraint.ConstraintLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import ca.cours5b5.nathancyr.R;
import android.util.Log;


import ca.cours5b5.nathancyr.controleurs.Action;
import ca.cours5b5.nathancyr.controleurs.ControleurAction;
import ca.cours5b5.nathancyr.controleurs.ControleurObservation;
import ca.cours5b5.nathancyr.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.nathancyr.global.GCommande;
import ca.cours5b5.nathancyr.global.GConstantes;
import ca.cours5b5.nathancyr.modeles.MParametres;
import ca.cours5b5.nathancyr.modeles.Modele;

public class VParametres extends Vue{

    Spinner hauteurSpin, largeurSpin, gagnerSpin;
    ArrayAdapter<Integer> adapterHauteur, adapterLargeur, adapterGagner;

    public VParametres(Context context) {
        super(context);
    }

    public VParametres(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VParametres(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    static{
        Log.d("Atelier04", VParametres.class.getSimpleName() + "::static");
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        Log.d("Atelier04", VParametres.class.getSimpleName() + "::onFinishInflate");

        hauteurSpin = this.findViewById(R.id.hauteurSpin);
        adapterHauteur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        hauteurSpin.setAdapter(adapterHauteur);
        adapterHauteur.addAll(MParametres.instance.getChoixHauteur());
        hauteurSpin.setSelection(adapterHauteur.getPosition(GConstantes.HAUTEURDEF));
        hauteurSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                Action actionHauteur = ControleurAction.demanderAction(GCommande.CHOISIR_HAUTEUR);
                Integer leChoix = (Integer) parent.getAdapter().getItem(position);
                MParametres.instance.getParametresPartie().setHauteur(leChoix);
                actionHauteur.setArguments(leChoix);
                actionHauteur.executerDesQuePossible();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
            }
        });




        largeurSpin = this.findViewById(R.id.largeurSpin);
        adapterLargeur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        largeurSpin.setAdapter(adapterLargeur);
        adapterLargeur.addAll(MParametres.instance.getChoixLargeur());
        largeurSpin.setSelection(adapterLargeur.getPosition(GConstantes.LARGEURDEF));

        largeurSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                Action actionLargeur = ControleurAction.demanderAction(GCommande.CHOISIR_LARGEUR);
                Integer leChoix = (Integer) parent.getAdapter().getItem(position);
                MParametres.instance.getParametresPartie().setLargeur(leChoix);
                actionLargeur.setArguments(leChoix);
                actionLargeur.executerDesQuePossible();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
            }
        });


        gagnerSpin = this.findViewById(R.id.gagnerSpin);
        adapterGagner = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        gagnerSpin.setAdapter(adapterGagner);
        adapterGagner.addAll(MParametres.instance.getChoixPourGagner());
        gagnerSpin.setSelection(adapterGagner.getPosition(GConstantes.GAGNERDEF));
        gagnerSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                Action actionGagner = ControleurAction.demanderAction(GCommande.CHOISIR_POUR_GAGNER);
                Integer leChoix = (Integer) parent.getAdapter().getItem(position);
                MParametres.instance.getParametresPartie().setPourGagner(leChoix);
                actionGagner.setArguments(leChoix);
                actionGagner.executerDesQuePossible();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
            }
        });

        ControleurObservation.observerModele(MParametres.class.getSimpleName(), new ListenerObservateur() {
            @Override
            public void reagirChangementAuModele(Modele modele) {
                afficherParametres((MParametres) modele);
            }
        });

    }

    private void afficherParametres(MParametres modele){
        adapterHauteur.clear();
        adapterHauteur.addAll(modele.getChoixHauteur());

        adapterLargeur.clear();
        adapterLargeur.addAll(modele.getChoixLargeur());

        adapterGagner.clear();
        adapterGagner.addAll(modele.getChoixPourGagner());
    }

}
