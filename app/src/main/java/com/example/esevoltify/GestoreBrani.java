package com.example.esevoltify;



import java.util.ArrayList;
import java.util.Date;

public class GestoreBrani {
    ArrayList<Brano> listaBrani;
    public GestoreBrani ()
    {
        listaBrani = new ArrayList<Brano>();
    }

    public void addBrano(String titolo, int durata, String autore, Date datacreazione, String genere)
    {
        Brano b= new Brano(titolo,durata, autore, datacreazione, genere);
        listaBrani.add(b);
    }
    public StringBuilder ListaBrani(){
        int n=1;
        String s;
        StringBuilder stbui= new StringBuilder(1200);
        for(Brano Brv : listaBrani){
            s= "Brano" + n + "\n";
            stbui.append(s);
            stbui.append(Brv.toString());
            n++;
        }
        return stbui;
    }
}
