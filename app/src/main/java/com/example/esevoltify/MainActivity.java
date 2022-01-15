package com.example.esevoltify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText ed1;
    GestoreBrani gb;
    Button b2;
    EditText ed2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.b1);
        ed1 = (EditText) findViewById(R.id.ed1);
        b2 = (Button) findViewById(R.id.b2);
        ed2 =(EditText)findViewById(R.id.ed2);
        gb=new GestoreBrani();
        t1= (TextView)findViewById(R.id.t1);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gb.addBrano(ed1.getText().toString(),Integer.parseInt(ed2.getText().toString()));
            }
        });
        t1.setText(gb.ListaBrani());

    }
}