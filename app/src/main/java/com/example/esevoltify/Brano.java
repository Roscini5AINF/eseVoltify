package com.example.esevoltify;

import java.util.Date;

public class Brano {
    private String titolo;
    private int durata;
    private String genere;
    private String autore;
    private Date datacreazione;

    public Brano (String titolo, int durata, String autore, Date datacrezione, String genere)
    {
        this.titolo=titolo;
        this.durata=durata;
        this.autore=autore;
        this.datacreazione=datacrezione;
        this.genere=genere;
    }

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
        return
                "titolo=" + titolo + ", durata=" + durata + ", genere=" + genere + ", autore=" + autore + ", data creazione=" + datacreazione;

    }
}
