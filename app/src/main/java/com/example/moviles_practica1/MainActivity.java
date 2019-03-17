package com.example.moviles_practica1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_STRING = "com.example.moviles_practica1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText edt = (EditText) findViewById(R.id.edtTexto);
        Button btn1 = (Button) findViewById(R.id.btnEnviar);

        //TODO: LLAMAMOS A LA OTRA ACTIVIDAD
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String parrafo = edt.getText().toString();
              /*  String cpalabras = String.valueOf(contarPalabras(parrafo));*/
               /* String palabrasR = String.valueOf(obtenerLaMasRepetida(parrafo));*/
                Intent intent = new Intent(getApplicationContext(), PalabrasActivity.class);
                intent.putExtra(EXTRA_STRING,parrafo );
                startActivity(intent);
            }
        });
    }

  /*  public static int contarPalabras(String s){
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
        return contador;
    }*/

   /* public String obtenerLaMasRepetida(String _frase)
    {
        String palabras [] = _frase.split(" ");
      String palabrasB [] = _frase.split(" ");

        int cantidad = palabras.length;
        String resultado = "";
        int contadorMasRepet  =  0;


        for (int i = 0; i < cantidad; i++) {
            int contador = 0;
            String palabra = palabras[i];

            for (int j = 0; j < cantidad; j++) {

                if (palabra.equalsIgnoreCase(palabrasB[j])){
                    contador++;
                    palabras[j] = "";

                }
            }

            if ((contador > 1)&& (contador > contadorMasRepet)){
                resultado = palabra;
                contadorMasRepet = contador;
                System.out.print(palabras[i]);
            }
            else if ((contador > 1)&& (contador == contadorMasRepet)){
                resultado += " " + palabra;
            }
        }
        if (resultado == "")
            resultado = "No hay palabra repetida";

        return resultado;
    }
*/

}
