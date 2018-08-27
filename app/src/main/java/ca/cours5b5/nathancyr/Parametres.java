package ca.cours5b5.nathancyr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Parametres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
        Log.d("MontEtiquette",this.getResources().getString(R.string.Word));
        if(this.getResources().getBoolean(R.bool.est_paysage)){
            Log.d("MonEtiquette","Bonjour paysage!");
        }else if(this.getResources().getBoolean(R.bool.est_portrait)){
            Log.d("MonEtiquette","Bonjour portrait!");
        }

    }
}
