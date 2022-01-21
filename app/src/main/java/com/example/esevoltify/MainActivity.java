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
    Button b1;
    EditText ed1;
    GestoreBrani gb;
    Button b2;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    Spinner sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*String[] generi= {"Pop", "Rock", "indie", "Country"};*/

        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);

        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 =(EditText)findViewById(R.id.ed2);
        ed3= (EditText)findViewById(R.id.ed3);
        ed4 =(EditText)findViewById(R.id.ed4);

        gb=new GestoreBrani();

        sp1=(Spinner)findViewById(R.id.sp1);

        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genere, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);

        /*ArrayAdapter<String> aag = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, generi);*/



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date d= null;
                try {
                    d = format.parse(ed4.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                gb.addBrano(ed1.getText().toString(), Integer.parseInt(ed2.getText().toString()), ed3.getText().toString(), d, sp1.getSelectedItem().toString());
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder s= new StringBuilder();
                s=gb.ListaBrani();
                Intent i=new Intent(getApplicationContext(), Lista.class);
                i.putExtra("messaggio", s.toString());
                startActivity(i);
            }
        });


    }
}