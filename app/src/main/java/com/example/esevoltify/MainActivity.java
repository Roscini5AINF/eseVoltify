package com.example.esevoltify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //creazione degli attributi
    Button bInserisci;
    EditText edTitolo;
    GestoreBrani gb;
    Button bInvia;
    EditText edDurata;
    EditText edAutore;
    EditText edData;
    Spinner spGenere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*String[] generi= {"Pop", "Rock", "indie", "Country"};*/
        //collegamento degli atrributi con i widget grafici

        bInserisci = (Button)findViewById(R.id.bInserisci);
        bInvia = (Button) findViewById(R.id.bInvia);

        edTitolo = (EditText) findViewById(R.id.edTitolo);
        edDurata =(EditText)findViewById(R.id.edDurata);
        edAutore= (EditText)findViewById(R.id.edAutore);
        edData =(EditText)findViewById(R.id.edData);

        gb=new GestoreBrani();

        spGenere=(Spinner)findViewById(R.id.spGenere);
        //creazione di un formato data per il casting da string a date
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        //creaione dell'arrayAdapter utilizzando un'array creato nel file strings.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genere, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //assegnazione dell'adpter allo spinner
        spGenere.setAdapter(adapter);

        /*ArrayAdapter<String> aag = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, generi);*/


        //creazione di un onclicklistener per il bottone inserisci
        bInserisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creazione e assegnazione di una varabile di tipo date e assegnazione della stringa inserita dall'utente
                Date d= null;
                try {
                    d = format.parse(edData.getText().toString());/*tramite il metodo getText prendo la string ainserita dall'utente e tramite il metodo toString la trasformo in stringa
                    poi tramite il metodo parse del formato inizializzato prima trasformo la stringa in date*/
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //creazione di un brano e assegnazione di esso all'aray listabrani presente nella classe GestoreBrani
                gb.addBrano(
                        edTitolo.getText().toString(), //tramite il metodo getText prendo la stringa inserita dall'utente e tramite il metodo toString la trasformo in stringa
                        Integer.parseInt(edDurata.getText().toString()),/*tramite il metodo getText prendo la stringa inserita dall'utente e tramite il metodo toString la trasformo in stringa
                        poi tramite il metodo parseInt della classe Integer trasformo la stringa in int*/
                        edAutore.getText().toString(), //tramite il metodo getText prendo la stringa inserita dall'utente e tramite il metodo toString la trasformo in stringa
                        d,
                        spGenere.getSelectedItem().toString()); //tramite il metodo getSelectedItem prendo la stringa scelta dall'utente e tramite il metodo toString la trasformo in stringa
            }
        });

        bInvia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder s = gb.ListaBrani();// creo una variabile StringBuilder e vi assegno la variabile contenente tutti i brani
                Intent i=new Intent(getApplicationContext(), Lista.class); //creao un intent
                i.putExtra("messaggio", s.toString()); //assegno all'intent come extra la variabile contenenjte tutti i brani trasformata in stringa tramite il metodo toString
                startActivity(i); //lancio la seconda activity
            }
        });


    }
}