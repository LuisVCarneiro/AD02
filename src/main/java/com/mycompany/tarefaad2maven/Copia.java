
package com.mycompany.tarefaad2maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Copia {
    ArrayList <Franquicia> datos = null;
    String FILE = "datos.backup";
    File ficheiro = new File ("datos.json");
    
    public void lerArquivo(){
        try
            (ObjectInputStream ois = new ObjectInputStream (new FileInputStream ("ficheiro"))){
            datos = (ArrayList <Franquicia>)ois.readObject();
        }
        catch (FileNotFoundException fnfe){
            datos = new ArrayList <>();
        }
        catch (ClassNotFoundException cnfe){
            System.out.println(cnfe.getMessage());
        }
        catch (IOException ioe){
            System.out.println("Erro de entrada/saída");
        }
        
    }
    
    public void escribirArquivo(){
        try 
            (ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream (FILE))){
            oos.writeObject(ficheiro);
            oos.flush();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("Copia creada.");
    }
}
