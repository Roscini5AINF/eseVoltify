package com.example.esevoltify;



import java.util.ArrayList;
import java.util.Date;

public class GestoreBrani {
    //creazione arraylist
    ArrayList<Brano> listaBrani;
    //costruttore
    public GestoreBrani ()
    {
        listaBrani = new ArrayList<>();
    }
    //metodo di aggiunta di un brano
    public void addBrano(String titolo, int durata, String autore, Date datacreazione, String genere)
    {
        Brano b= new Brano(titolo,durata, autore, datacreazione, genere); //creazione varabile brano e invocazione del costruttore
        listaBrani.add(b); //aggiunta di un brano alla varibile listabrani tramite il metodo add
    }
    public StringBuilder ListaBrani(){
        int n=1;
        String s;
        StringBuilder stbui= new StringBuilder(1200); //creazione della variabile stringbuilder
        for(Brano Brv : listaBrani){
            s= "Brano" + n + "\n";
            stbui.append(s); //aggiunta alla variiabile stringbuilder il numero di brani
            stbui.append(Brv.toString()); //aggiunta alla variiabile stringbuilder il brano
            n++;
        }
        return stbui;
    }
}
