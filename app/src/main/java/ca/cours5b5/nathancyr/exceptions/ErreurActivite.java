package ca.cours5b5.nathancyr.exceptions;


public class ErreurActivite extends RuntimeException {

    public ErreurActivite(Exception e) {super(e);}

    public ErreurActivite(String message){
        super(message);
    }


}
