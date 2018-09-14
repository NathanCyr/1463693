package ca.cours5b5.nathancyr.activites;

import android.support.v7.app.AppCompatActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import ca.cours5b5.nathancyr.R;
import android.content.Intent;


public class AParametres extends Activite{

    static{
        Log.d("Atelier04", AParametres.class.getSimpleName() + "::static");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("Atelier04", AParametres.class.getSimpleName() + "::onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Log.d("MonEtiquette",this.getResources().getString(R.string.Word)+ "(Paysage)");
        }
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Log.d("MonEtiquette",this.getResources().getString(R.string.Word) + "(Portrait)");
        }
    }
    @Override
    protected void onResume(){
        Log.d("Atelier04", AParametres.class.getSimpleName() + "::onResume");
        super.onResume();
    }
    @Override
    protected void onPause(){
        Log.d("Atelier04", AParametres.class.getSimpleName() + "::onPause");
        super.onPause();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        Log.d("Atelier04", AParametres.class.getSimpleName() + "::onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putInt("MaCle",18);
    }
    @Override
    protected void onDestroy(){
        Log.d("Atelier04", AParametres.class.getSimpleName() + "::onDestroy");
        super.onDestroy();

    }
}
