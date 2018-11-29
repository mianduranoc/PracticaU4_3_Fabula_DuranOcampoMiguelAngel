package com.example.miguelangel.practicau4_3_fabula_duranocampomiguelangel;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtTortuga,txtLiebre,resul;
    ImageView imgTortuga,imgLiebre;
    SeekBar barTortuga,barLiebre;
    Liebre liebre;
    Tortuga tortuga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTortuga=findViewById(R.id.accionTortuga);
        txtLiebre=findViewById(R.id.accionLiebre);
        resul=findViewById(R.id.resul);
        imgTortuga=findViewById(R.id.imagenTortuga);
        imgLiebre=findViewById(R.id.imagenLiebre);
        barLiebre=findViewById(R.id.barraLiebre);
        barTortuga=findViewById(R.id.barraTortuga);
        barTortuga.setEnabled(false);
        barLiebre.setEnabled(false);
        liebre=new Liebre(this,resul,txtLiebre,imgLiebre,barLiebre);
        tortuga=new Tortuga(this,resul,txtTortuga,imgTortuga,barTortuga);
        tortuga.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        liebre.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
