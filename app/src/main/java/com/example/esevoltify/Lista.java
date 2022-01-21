package com.example.esevoltify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Lista extends AppCompatActivity {
    TextView tBrani;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        i= getIntent();
        tBrani=(TextView) findViewById(R.id.tBrani);
        tBrani.setText(i.getStringExtra("messaggio"));
        tBrani.setMovementMethod(new ScrollingMovementMethod());
    }
}