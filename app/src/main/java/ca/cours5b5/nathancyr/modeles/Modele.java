package ca.cours5b5.nathancyr.modeles;

import java.util.Map;

import ca.cours5b5.nathancyr.exceptions.ErreurSerialisation;


public abstract class Modele {

    public abstract void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation;

    public abstract Map<String, Object> enObjetJson();

}
