package ca.cours5b5.nathancyr.vues;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import ca.cours5b5.nathancyr.global.GCouleur;

public class VCase extends AppCompatButton {

    private int rangee;
    private int colonne;

    public VCase(Context context){

        super(context);
        setEnabled(false);
    }

    public VCase(Context context, AttributeSet attrs){

        super(context, attrs);
        setEnabled(false);
    }

    public VCase(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        setEnabled(false);
    }

    public VCase(Context context, int rangee, int colonne){
        super(context);
        setEnabled(false);
        this.rangee = rangee;
        this.colonne = colonne;
        setText("" + rangee + "," + colonne);
    }

    public void afficherJeton(GCouleur jeton){
        if(jeton.equals(GCouleur.JAUNE)){
            this.setBackgroundColor(Color.YELLOW);
        }else if(jeton.equals(GCouleur.ROUGE)){
            this.setBackgroundColor(Color.RED);
        }
    }

}
