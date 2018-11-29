package com.example.miguelangel.practicau4_3_fabula_duranocampomiguelangel;

import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class Liebre extends AsyncTask<Void,Integer,Integer> {
    MainActivity activity;
    TextView resul,estado;
    ImageView imagen;
    SeekBar barra;
    int progreso;

    public Liebre(MainActivity activity,TextView resul,TextView estado,ImageView imagen,SeekBar barra){
        this.activity=activity;
        this.barra=barra;
        this.estado=estado;
        this.imagen=imagen;
        this.resul=resul;
        progreso=0;

    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        estado.setText("Juego iniciado");
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        while(progreso<70){
            int valores[]=new int[1];
            int random=(int)(Math.random()*99)+1;
            valores[0]=avance(random);
            progreso+=valores[0];
            if (progreso<0){
                progreso=0;
            }
            if (progreso>70){
                progreso=70;
            }
            publishProgress(valores[0]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int valorActual=values[0];
        colocarImagen(valorActual);
        barra.setProgress(progreso);
        if (progreso==70){
            if (resul.getText().toString().equals("")){
                resul.setText("Gano la Liebre");
            }
        }
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        estado.setText("Termino la Liebre");
    }
    public void colocarImagen(int valor){
        switch (valor){
            case 0:
                estado.setText("Durmiendo - "+progreso);
                imagen.setImageResource(R.drawable.dormido);
                break;
            case 9:
                estado.setText("Gran Salto - "+progreso);
                imagen.setImageResource(R.drawable.arapido);
                break;
            case -12:
                estado.setText("Resbalon Grande - "+ progreso);
                imagen.setImageResource(R.drawable.largo);
                break;
            case 1:
                estado.setText("Pequeño Salto - "+progreso);
                imagen.setImageResource(R.drawable.acorto);
                break;
            case -2:
                estado.setText("Resbalon Pequeño - "+progreso);
                imagen.setImageResource(R.drawable.corto);
                break;

        }
        return;
    }
    public int avance(int probabilidad){
        int resultado=0;
        if (probabilidad<=20){
            resultado=0;
        }
        else if(probabilidad<=40){
            resultado=9;
        }
        else if (probabilidad<=50){
            resultado=-12;
        }
        else if(probabilidad<=80){
            resultado=1;
        }
        else if(probabilidad<=100){
            resultado=-2;
        }
        return resultado;
    }

}
