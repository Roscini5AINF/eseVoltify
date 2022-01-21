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

        bInserisci = (Button)findViewById(R.id.bInserisci);
        bInvia = (Button) findViewById(R.id.bInvia);

        edTitolo = (EditText) findViewById(R.id.edTitolo);
        edDurata =(EditText)findViewById(R.id.edDurata);
        edAutore= (EditText)findViewById(R.id.edAutore);
        edData =(EditText)findViewById(R.id.edData);

        gb=new GestoreBrani();

        spGenere=(Spinner)findViewById(R.id.spGenere);

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genere, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spGenere.setAdapter(adapter);

        /*ArrayAdapter<String> aag = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, generi);*/



        bInserisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date d= null;
                try {
                    d = format.parse(edData.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                gb.addBrano(edTitolo.getText().toString(),
                        Integer.parseInt(edDurata.getText().toString()),
                        edAutore.getText().toString(),
                        d,
                        spGenere.getSelectedItem().toString());
            }
        });

        bInvia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder s = gb.ListaBrani();
                Intent i=new Intent(getApplicationContext(), Lista.class);
                i.putExtra("messaggio", s.toString());
                startActivity(i);
            }
        });


    }
}