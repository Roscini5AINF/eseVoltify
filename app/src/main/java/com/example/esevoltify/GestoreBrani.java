package com.example.esevoltify;

import java.util.ArrayList;

public class GestoreBrani {
    ArrayList<Brano> listaBrani;
    public GestoreBrani ()
    {
        listaBrani = new ArrayList<Brano>();
    }

    public void addBrano(String titolo, int durata)
    {
        Brano b= new Brano(titolo,durata);
        listaBrani.add(b);
    }
    public String ListaBrani(){
        StringBuilder stbui= new StringBuilder(40);
        for(Brano Brv : listaBrani){
            stbui.append(Brv.toString());
            stbui.append(",");
        }
        stbui.deleteCharAt(-1);
        String s = stbui.toString();
        return s;

    }
}
