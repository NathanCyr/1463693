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
import ca.cours5b5.nathancyr.global.GCommande;
import ca.cours5b5.nathancyr.global.GConstantes;
import ca.cours5b5.nathancyr.modeles.MParametres;

public class VParametres extends Vue{

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

        Spinner hauteurSpin = this.findViewById(R.id.hauteurSpin);
        ArrayAdapter<Integer> adapterHauteur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        hauteurSpin.setAdapter(adapterHauteur);
        for(int i = MParametres.instance.getChoixHauteur().get(0); i<GConstantes.HAUTEURMAX; i++){
            adapterHauteur.add(i);
        }
        hauteurSpin.setSelection(adapterHauteur.getPosition(MParametres.instance.getHauteur()));
        hauteurSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                Integer leChoix = (Integer) parent.getAdapter().getItem(position);
                Action actionHauteur = ControleurAction.demanderAction(GCommande.CHOISIR_HAUTEUR);
                actionHauteur.setArguments(leChoix);
                actionHauteur.executerDesQuePossible();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
            }
        });




        Spinner largeurSpin = this.findViewById(R.id.largeurSpin);
        ArrayAdapter<Integer> adapterLargeur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        largeurSpin.setAdapter(adapterLargeur);
        for(int i = MParametres.instance.getChoixLargeur().get(0); i<GConstantes.LARGEURMAX; i++){
            adapterLargeur.add(i);
        }
        largeurSpin.setSelection(adapterLargeur.getPosition(MParametres.instance.getLargeur()));
        largeurSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                Integer leChoix = (Integer) parent.getAdapter().getItem(position);
                Action actionLargeur = ControleurAction.demanderAction(GCommande.CHOISIR_LARGEUR);
                actionLargeur.setArguments(leChoix);
                actionLargeur.executerDesQuePossible();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
            }
        });


        Spinner gagnerSpin = this.findViewById(R.id.gagnerSpin);
        ArrayAdapter<Integer> adapterGagner = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        gagnerSpin.setAdapter(adapterGagner);
        for(int i = MParametres.instance.getChoixPourGagner().get(0); i<GConstantes.GAGNERMAX; i++){
            adapterGagner.add(i);
        }
        gagnerSpin.setSelection(adapterGagner.getPosition(MParametres.instance.getPourGagner()));
        gagnerSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                Integer leChoix = (Integer) parent.getAdapter().getItem(position);
                Action actionPourGagner = ControleurAction.demanderAction(GCommande.CHOISIR_POUR_GAGNER);
                actionPourGagner.setArguments(leChoix);
                actionPourGagner.executerDesQuePossible();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
            }
        });

    }
}
