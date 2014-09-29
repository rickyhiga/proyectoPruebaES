/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author juan
 */
public class LeerPregunta {

    public LeerPregunta() {
    }

    public String Pregunta() throws FileNotFoundException {

        ArrayList lista = new ArrayList();

        String[] Preguntas;
        String Pregunta="";
        FileReader in = new FileReader("C:\\xampp\\htdocs\\proyectoPruebaES\\Preguntas.txt");
        try {

            BufferedReader br = new BufferedReader(in);

            while ((Pregunta = br.readLine()) != null) {
                lista.add(br.readLine());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        int i=0;
        Random val = new Random();
        int x = val.nextInt(lista.size());
        Iterator itr = lista.iterator();
        Preguntas=new String[lista.size()];
        while( itr.hasNext() )
        {
            Preguntas[i] = (String) itr.next();   
           i++;
        }
        Pregunta= Preguntas[x];
        return Pregunta;
    }

}
