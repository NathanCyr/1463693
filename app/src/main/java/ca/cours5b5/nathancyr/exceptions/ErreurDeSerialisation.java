package ca.cours5b5.nathancyr.exceptions;


import android.util.Log;

public class ErreurDeSerialisation extends RuntimeException{
    public ErreurDeSerialisation(String erreur){
        Log.d("Atelier05", "Erreur de serialisation :" + erreur);
    }
}
