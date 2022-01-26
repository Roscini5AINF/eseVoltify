package com.example.esevoltify;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Brano {
    //creazione degli attributi
    private String titolo;
    private int durata;
    private String genere;
    private String autore;
    private Date datacreazione;
    //costruttore
    public Brano (String titolo, int durata, String autore, Date datacrezione, String genere)
    {
        this.titolo=titolo;
        this.durata=durata;
        this.autore=autore;
        this.datacreazione=datacrezione;
        this.genere=genere;
    }
    //getters e setters
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getAutore() {
        return autore;
    }

    public void setDatacreazione(Date datacreazione) {
        this.datacreazione = datacreazione;
    }

    public Date getDatacreazione() {
        return datacreazione;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getDurata() {
        return durata;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }


    @Override
    public String toString() {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy"); //creazione del format per data allo scopo di convertire la variabile date in string
        String s= format.format(datacreazione); //conversione della varibile date in string tramite il metodo format della variabile format creata prima
        return
                "Titolo: " + titolo + "\nDurata: " + durata + " secondi\nGenere: " + genere + "\nAutore:" + autore + "\nData Uscita:" + s + "\n";

    }
}
