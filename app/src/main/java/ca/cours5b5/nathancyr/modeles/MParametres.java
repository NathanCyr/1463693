package ca.cours5b5.nathancyr.modeles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.nathancyr.exceptions.ErreurDeSerialisation;
import ca.cours5b5.nathancyr.global.GConstantes;
import ca.cours5b5.nathancyr.serialisation.AttributSerialisable;

import static ca.cours5b5.nathancyr.global.GConstantes.HAUTEURMAX;
import static ca.cours5b5.nathancyr.global.GConstantes.LARGEURMAX;

public class MParametres extends Modele{
    public static MParametres instance = new MParametres();

    @AttributSerialisable
    public MParametresPartie parametresPartie;
    private String __parametresPartie = "parametresPartie";

    private List<Integer> choixHauteur;
    private List<Integer> choixLargeur;
    private List<Integer> choixPourGagner;

    public MParametres() {

    }

    public List<Integer> getChoixHauteur() {
        return choixHauteur;
    }

    public List<Integer> getChoixLargeur() {
        return choixLargeur;
    }

    public List<Integer> getChoixPourGagner() {
        return choixPourGagner;
    }

    public MParametresPartie getParametresPartie() {
        return parametresPartie;
    }

    private void genererListeDeChoix(){

    }

    private List<Integer> genererListeChoix(int min, int max){
        return null;
    }

    private void genererListeChoixHauteur(){

    }

    private void genererListeChoixLargeur(){

    }

    private void genererListeChoixPourGagner(){

    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurDeSerialisation {

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurDeSerialisation{
        return null;
    }

}
