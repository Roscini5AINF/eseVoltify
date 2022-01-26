package com.example.esevoltify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Lista extends AppCompatActivity {
    //creo le variabili iniziali
    TextView tBrani;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        i= getIntent(); //assegno alla variabile intent l'intent che ho passato con l'avvio di questa activity
        tBrani=(TextView) findViewById(R.id.tBrani);// assegno alla variabile lo widget grafico
        tBrani.setText(i.getStringExtra("messaggio")); //assegno come testo della textView il contenuto dell'extra del mio intent
        tBrani.setMovementMethod(new ScrollingMovementMethod()); //utilizzo il metodo che permette alla mia TextView di essere scrollable
    }
}