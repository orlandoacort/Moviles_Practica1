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

    private static int cpalindroma;

    ListView lista ;
    String listas[] = {"1","2","3","4","5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palabras);

        Intent intent = getIntent();
        String palabras= intent.getStringExtra(MainActivity.EXTRA_STRING);
        String cpalabras = contarPalabras(palabras);






       ///////CANTIDAD DE PALABRAS
        TextView textView = (TextView) findViewById(R.id.idResultado);
        textView.setText("TOTAL DE PALABRAS: " + cpalabras);


        //Palabras repetidas

        //repetidas(convirtiendo array en String)
        String miarray2[] = palabrasRepetidas(palabras);
        StringBuffer cadena2 = new StringBuffer();
        for (int i=0;i<miarray2.length;i++){
            cadena2 =cadena2.append(miarray2[i]);
        }

        TextView tvRepetidas = (TextView) findViewById(R.id.idRepetidas);
        tvRepetidas.setText("REPITE: \n" + cadena2 );




        ///////PALINDROMAS con array adapter
      /*  lista = (ListView)findViewById(R.id.simpleLV);
        ArrayAdapter<String> arrayAdapter  = new ArrayAdapter<String> (this,R.layout.list_view,R.id.TvLv,palindromas(palabras)  );//listas palabrasRepetidas(cpalabras)
        lista.setAdapter(arrayAdapter); */


        //PALINDROMAS(convirtiendo array en String)
        String miarray[] = palindromas(palabras);
        StringBuffer cadena = new StringBuffer();
        for (int i=0;i<miarray.length;i++){
            cadena =cadena.append(miarray[i]);
        }
        TextView textView3 = (TextView) findViewById(R.id.idResPalindromas);
        textView3.setText("PALINDROMAS: " + "\n" +  cadena);



        //////CANTIDAD DE PALABRAS PALINDROMAS
        String cPalindromas = String.valueOf(cpalindroma); //C. DE PALINDROMAS
        TextView textView2 = (TextView) findViewById(R.id.idResCPalindromas);
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


        int contador=0;
        String  reverso;
        String palabra[]= p.split(" ");
        String palResult[] = new String[palabra.length]  ;
        String parcial[] = new String[palabra.length];
        for(int i =0;i<palabra.length;i++){
            reverso = "";
            String original = palabra[i];

            int length = original.length();

            for (int j=length-1;j>=0;j--){

                if(original.length()>1)
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

        cpalindroma = contador;
        return palResult;


    }


    public static String[] palabrasRepetidas(String p){
        String palabras [] = p.split(" ");
        String palabrasAyu [] = p.split(" ");
        int contador[] = new int[palabras.length];
        String contadorResult[] = new String[palabras.length];
        //   String Scont[] = new String[palabras.length];

        for(int i=0; i< palabras.length ; i++ ){
            contador[i] = 0;
            String palabra = palabras[i];

            for(int j=0;j<palabras.length; j++){
                if (palabra.equalsIgnoreCase(palabrasAyu[j])){
                    contador[i]++;

                    //palabras[j]= "";
                }

            }

            if (contador[i]>1 || contador[i]==0 ){
                contadorResult[i] = palabra + " Se repite: " + contador[i] + " veces \n"  ;
            }
            else {

                contadorResult[i] = palabra + " Se repite: " + contador[i] + " vez \n"  ;
            }


            //  Scont[i] = String.valueOf(contador[i]) ;
           // System.out.println(palabrasAyu[i] + " se repite: " + contador[i]);
        }


        return contadorResult;
    }



}
