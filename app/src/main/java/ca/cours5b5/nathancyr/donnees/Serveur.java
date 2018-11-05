package ca.cours5b5.nathancyr.donnees;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public class Serveur extends SourceDeDonnees {

    private Serveur(){

    }

    private static final Serveur instance = new Serveur();

    public static Serveur getInstance(){
        return instance;
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);

        ref.setValue(objetJson);
    }

    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde){
        return null;
    }



}
