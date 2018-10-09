package ca.cours5b5.nathancyr.modeles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.nathancyr.controleurs.ControleurAction;
import ca.cours5b5.nathancyr.controleurs.interfaces.Fournisseur;
import ca.cours5b5.nathancyr.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.nathancyr.exceptions.ErreurDeSerialisation;
import ca.cours5b5.nathancyr.global.GCommande;
import ca.cours5b5.nathancyr.global.GConstantes;
import ca.cours5b5.nathancyr.serialisation.AttributSerialisable;

import static ca.cours5b5.nathancyr.global.GConstantes.HAUTEURMAX;
import static ca.cours5b5.nathancyr.global.GConstantes.LARGEURMAX;
import static java.lang.Math.max;

public class MParametres extends Modele implements Fournisseur{
    public static MParametres instance = new MParametres();

    @AttributSerialisable
    public MParametresPartie parametresPartie;
    private String __parametresPartie = "parametresPartie";

    private List<Integer> choixHauteur;
    private List<Integer> choixLargeur;
    private List<Integer> choixPourGagner;

    public MParametres() {
        parametresPartie = new MParametresPartie();
        choixHauteur = new ArrayList<>();
        choixLargeur = new ArrayList<>();
        choixPourGagner = new ArrayList<>();
        genererListeDeChoix();

        ControleurAction.fournirAction(this, GCommande.CHOISIR_HAUTEUR, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                parametresPartie.setHauteur((int)args[0]);
                choixPourGagner = genererListeChoix(GConstantes.GAGNERMIN, max(parametresPartie.getHauteur(),parametresPartie.getLargeur())*75/100);
            }
        });
        ControleurAction.fournirAction(this, GCommande.CHOISIR_LARGEUR, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                parametresPartie.setLargeur((int)args[0]);
                choixPourGagner = genererListeChoix(GConstantes.GAGNERMIN, max(parametresPartie.getHauteur(),parametresPartie.getLargeur())*75/100);
            }
        });
        ControleurAction.fournirAction(this, GCommande.CHOISIR_POUR_GAGNER, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                parametresPartie.setPourGagner((int)args[0]);
            }
        });


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



    public MParametresPartie getParametresPartie()
    {
        return parametresPartie;
    }

    private void genererListeDeChoix(){
        choixHauteur = genererListeChoix(GConstantes.HAUTEURMIN, GConstantes.HAUTEURMAX);
        choixLargeur = genererListeChoix(GConstantes.LARGEURMIN, GConstantes.LARGEURMAX);
        choixPourGagner = genererListeChoix(GConstantes.GAGNERMIN, max(parametresPartie.getHauteur(),parametresPartie.getLargeur()));

    }

    private List<Integer> genererListeChoix(int min, int max)
    {
        List<Integer> temp = new ArrayList<>();
        for(int i = min; i <+ max; i++){
            temp.add(i);
    }
    return temp;
    }

    private void genererListeChoixHauteur(){

    }

    private void genererListeChoixLargeur(){

    }

    private void genererListeChoixPourGagner(){

    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurDeSerialisation{
        for(Map.Entry entry : objetJson.entrySet()){
            if(entry.getKey().equals("hauteur")){
                parametresPartie.hauteur = Integer.valueOf((String)entry.getValue());
            }else if(entry.getKey().equals("largeur")){
                parametresPartie.largeur = Integer.valueOf((String)entry.getValue());
            }else if(entry.getKey().equals("pourGagner")){
                parametresPartie.pourGagner=Integer.valueOf((String)entry.getValue());
            }
        }
    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurDeSerialisation{
        Map<String, Object> objetJson = new HashMap<>();

        objetJson.put("hauteur",parametresPartie.hauteur.toString());
        objetJson.put("largeur",parametresPartie.largeur.toString());
        objetJson.put("pourGagner",parametresPartie.pourGagner.toString());
        return objetJson;
    }

}
