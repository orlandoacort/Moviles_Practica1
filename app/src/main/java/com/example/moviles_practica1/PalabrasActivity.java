package com.example.moviles_practica1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;

public class PalabrasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palabras);

        Intent intent = getIntent();
        String palabras= intent.getStringExtra(MainActivity.EXTRA_STRING);
        String cpalabras = contarPalabras(palabras);


        TextView textView = (TextView) findViewById(R.id.idResultado);

        textView.setText("Cantidad de palabras: " + cpalabras);
















    }

  /*  public static String contarPalabras(String s){
        int contador = 1 , pos;
        s = s.trim();
        if (s.isEmpty()){
            contador = 0;
        }
        else {
            pos = s.indexOf(" ");
            while (pos != -1) {
                contador++;
                pos = s.indexOf(" ", pos + 1);
            }
        }
        return String.valueOf(contador) ;
    }*/

    public static String contarPalabras(String p){

        String palabras[] = p.split(" ");
        return String.valueOf(palabras.length) ;
    }

    public static String[] palabrasRepetidas(String p){
        String palabras [] = p.split(" ");
        String palabrasAyu [] = p.split(" ");
        int contador[] = new int[Integer.parseInt(contarPalabras(p))-1];

        for(int i=0; i< Integer.parseInt(contarPalabras(p)) ; i++ ){
            contador[i] = 0;
            String palabra = palabras[i];

            for(int j=0;j<Integer.parseInt(contarPalabras(p)); j++){
                if (palabra.equalsIgnoreCase(palabrasAyu[j])){
                    contador[i]++;
                    palabras[j]= "";
                }

            }

        }


        return new String[]{Arrays.toString(contador)};
    }

    // CREAR ITEM



}
