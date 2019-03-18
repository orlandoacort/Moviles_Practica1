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

    ListView lista ;
    String listas[] = {"1","2","3","4","5"};
    private static int contador=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palabras);

        Intent intent = getIntent();
        String palabras= intent.getStringExtra(MainActivity.EXTRA_STRING);
        String cpalabras = contarPalabras(palabras);
        //String[] prepetidas = palabrasRepetidas(palabras);


       ///////CANTIDAD DE PALABRAS
        TextView textView = (TextView) findViewById(R.id.idResultado);
        textView.setText("TOTAL DE PALABRAS: " + cpalabras);


        lista = (ListView)findViewById(R.id.simpleLV);
        ArrayAdapter<String> arrayAdapter  = new ArrayAdapter<String> (this,R.layout.list_view,R.id.TvLv,palindromas(palabras)  );/*listas palabrasRepetidas(cpalabras)*/
        lista.setAdapter(arrayAdapter);

        String cPalindromas = String.valueOf(contador); //C. DE PALINDROMAS
        //////CANTIDAD DE PALABRAS PALINDROMAS
        TextView textView2 = (TextView) findViewById(R.id.idResPalindromas);
        textView2.setText("TOTAL DE PALINDROMAS: " + cPalindromas);















    }



    public static String contarPalabras(String p){

        String palabras[] = p.split(" ");
        return String.valueOf(palabras.length) ;
    }

    public static String[] guardarPalabras(String p){

        String palabras[] = p.split(" ");
        return palabras;
    }

    public static String[] palindromas(String p){

        String  reverso;
        String palabra[]= p.split(" ");
        String palResult[] = new String[palabra.length]  ;
        for(int i =0;i<palabra.length;i++){
            reverso = "";
            String original = palabra[i];

            int length = original.length();

            for (int j=length-1;j>=0;j--){
                reverso = reverso + original.charAt(j);


            }

            if (original.equalsIgnoreCase(reverso)){
                palResult[i] = original + " Es palindroma " + "\n";
                contador++;
            }
            else {
               // palResult[i] = original + " NO es palindroma" + "\n";
                palResult[i] = "";
            }



        }


        return palResult;
    }


    ////////////////////////////////////////////////////////
   /* public static String[] palabrasRepetidas(String p){
        String palabras [] = p.split(" ");
        String palabrasAyu [] = p.split(" ");
        int contador[] = new int[Integer.parseInt(contarPalabras(p))-1];
        String Scont[] = new String[Integer.parseInt(contarPalabras(p))-1];

        for(int i=0; i< Integer.parseInt(contarPalabras(p)) ; i++ ){
            contador[i] = 0;
            String palabra = palabras[i];

            for(int j=0;j<Integer.parseInt(contarPalabras(p)); j++){
                if (palabra.equalsIgnoreCase(palabrasAyu[j])){
                    contador[i]++;

                    palabras[j]= "";
                }

            }
            Scont[i] = String.valueOf(contador[i]) ;
        }


        return palabras;
    }
*/



}
