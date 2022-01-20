package com.example.esevoltify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Lista extends AppCompatActivity {
    TextView t2;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        i= getIntent();
        t2=(TextView) findViewById(R.id.t2);
        t2.setText(i.getStringExtra("messaggio"));
    }
}