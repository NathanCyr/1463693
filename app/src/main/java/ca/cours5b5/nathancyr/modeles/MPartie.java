package ca.cours5b5.nathancyr.modeles;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.nathancyr.controleurs.ControleurAction;
import ca.cours5b5.nathancyr.controleurs.interfaces.Fournisseur;
import ca.cours5b5.nathancyr.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.nathancyr.exceptions.ErreurDeSerialisation;
import ca.cours5b5.nathancyr.global.GCommande;
import ca.cours5b5.nathancyr.global.GCouleur;
import ca.cours5b5.nathancyr.serialisation.AttributSerialisable;

public class MPartie extends Modele implements Fournisseur{

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";

    @AttributSerialisable
    public List<Integer> coups;
    private final String __coups = "coups";

    private MGrille grille;
    private GCouleur couleurCourante;
    public static MPartie instance;

    public MPartie (MParametresPartie parametres){
        coups = new ArrayList<>();
        this.parametres = parametres;
        initialiserCouleurCourante();
        grille = new MGrille(this.parametres.getLargeur());
        fournirActionPlacerJeton();
    }

    private void initialiserCouleurCourante(){
        couleurCourante = GCouleur.ROUGE;
    }

    private void fournirActionPlacerJeton(){
        ControleurAction.fournirAction(this, GCommande.JOUER_COUP_ICI, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                jouerCoup((int) args[0]);
            }
        });
    }

    protected void jouerCoup(int colonne){
        Log.d("Atelier07", "JouerCoup: " + colonne);
        grille.placerJeton(colonne, couleurCourante);
        prochaineCouleurCourante();
        coups.add(colonne);
    }

    private void prochaineCouleurCourante() {
        if (couleurCourante == GCouleur.JAUNE) {
            couleurCourante = GCouleur.ROUGE;
        } else if (couleurCourante == GCouleur.ROUGE) {
            couleurCourante = GCouleur.JAUNE;
        }

    }

    public MParametresPartie getParametres() {

        return parametres;
    }

    public MGrille getGrille() {
        return grille;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurDeSerialisation {

        MParametresPartie parametresPartie = new MParametresPartie();

        if(objetJson.containsKey("parametres")){
            parametresPartie.aPartirObjetJson((Map<String, Object>) objetJson.get("parametres"));
        }else{
            throw new ErreurDeSerialisation("Les paramètres devraient s'affichés");
        }

        grille = new MGrille(this.parametres.getLargeur());
        initialiserCouleurCourante();

        List<Integer> Temp = new ArrayList<>();

        if(objetJson.containsKey("coups")){
            Temp = listeCoupsAPartirJson((List<String>) objetJson.get("coups"));
        }else{
            throw new ErreurDeSerialisation("Les coups devraient s'affichés");
        }

        rejouerLesCoups(Temp);


    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurDeSerialisation{
        Map<String, Object> objetJson= new HashMap<>();

        objetJson.put("coups", listeCoupEnObjetJson(coups));
        objetJson.put("parametres", parametres.enObjetJson());

        return objetJson;
    }

    private void rejouerLesCoups(List<Integer> coupsARejouer){
        coups.clear();
        for(int i = 0; i < coupsARejouer.size(); i++){
            jouerCoup(coupsARejouer.get(i));
        }
    }

    private List<Integer> listeCoupsAPartirJson(List<String> listeCoupsObjetJson){
        List<Integer> Temp = new ArrayList<>();

        for(int i = 0; i < listeCoupsObjetJson.size(); i++){
            Temp.add(Integer.parseInt(listeCoupsObjetJson.get(i)));
        }

        return Temp;
    }

    private List<String> listeCoupEnObjetJson(List<Integer> listeCoups){
        List<String> Temp = new ArrayList<>();

        for(int i = 0; i < listeCoups.size(); i++){
            Temp.add(listeCoups.get(i).toString());
        }

        return Temp;
    }
}
