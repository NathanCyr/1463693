package ca.cours5b5.nathancyr.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class VGrille extends GridLayout{

    public VGrille(Context context){

    }

    public VGrille(Context context, AttributeSet attrs){

    }

    public VGrille(Context context, AttributeSet attrs, int defStyleAttr){

    }

    private int nombreRangees;

    private class Colonne extends ArrayList<VCase>{}

    private List<Colonne> colonnesDeCases;

    private List<VEntete> entetes;

    @Override
    protected void onFinishInflate(){

    }

    private void initialiser(){

    }

    void creerGrille(int hauteur, int largeur){

    }

    private void initialiserColonnes(int largeur){

    }

    private void ajouterEnTetes(int largeur){

    }

    private LayoutParams getMiseEnPageEntete(int colonne){
        return null;
    }

    private void ajouterCases(int hauteur, int largeur){

    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne){
        return null;
    }

}
