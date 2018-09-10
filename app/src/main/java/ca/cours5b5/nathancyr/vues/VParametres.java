package ca.cours5b5.nathancyr.vues;

import android.support.constraint.ConstraintLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import ca.cours5b5.nathancyr.R;
import ca.cours5b5.nathancyr.global.GConstantes;

public class VParametres extends ConstraintLayout{
    public VParametres(Context context) {
        super(context);
    }

    public VParametres(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VParametres(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        Spinner hauteurSpin = this.findViewById(R.id.hauteurSpin);
        ArrayAdapter<Integer> adapterHauteur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        hauteurSpin.setAdapter(adapterHauteur);
        for(int i = GConstantes.HAUTEURMIN;i<=GConstantes.HAUTEURMAX;i++){
            adapterHauteur.add(i);
        }
        hauteurSpin.setSelection(adapterHauteur.getPosition(GConstantes.HAUTEURDEF));




        Spinner largeurSpin = this.findViewById(R.id.largeurSpin);
        ArrayAdapter<Integer> adapterLargeur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        largeurSpin.setAdapter(adapterLargeur);
        for(int i = GConstantes.LARGEURMIN;i<=GConstantes.LARGEURMAX;i++){
            adapterLargeur.add(i);
        }
        largeurSpin.setSelection(adapterLargeur.getPosition(GConstantes.LARGEURDEF));

        Spinner gagnerSpin = this.findViewById(R.id.gagnerSpin);
        ArrayAdapter<Integer> adapterGagner = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        gagnerSpin.setAdapter(adapterGagner);
        for(int i = GConstantes.GAGNERMIN;i<=GConstantes.GAGNERMAX;i++){
            adapterGagner.add(i);
        }
        gagnerSpin.setSelection(adapterGagner.getPosition(GConstantes.GAGNERDEF));

    }
}
