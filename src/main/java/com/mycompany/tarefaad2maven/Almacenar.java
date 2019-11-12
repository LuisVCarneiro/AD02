package com.mycompany.tarefaad2maven;




import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.tarefaad2maven.Franquicia;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Almacenar {
    private String FILENAME = new String ("datos.json");
     File arquivo = new File(FILENAME);
    
     
    public void gardarArquivo(Franquicia f){
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(f);
        
        try {
            FileWriter fluxoDatos = new FileWriter(arquivo);
            BufferedWriter buferSaida = new BufferedWriter(fluxoDatos);
            buferSaida.write(json);

            buferSaida.close();
        } catch (IOException e) {
            System.err.println("Erro ao gardalos datos");
        }
    }
    
    public boolean existsJSON(){
       
        if(arquivo.exists()){
            return true;
        }
        return false;
    }
    
    public Franquicia leerJson(){
        
        try{
            
            //Creamos o bufer de entrada

            FileReader fluxoDatos = new FileReader(arquivo);
            BufferedReader buferEntrada = new BufferedReader(fluxoDatos);

            StringBuilder jsonBuilder = new StringBuilder();
            String linea;
            while ((linea=buferEntrada.readLine()) != null) {
                jsonBuilder.append(linea).append("\n");
            }
            buferEntrada.close();

            String json = jsonBuilder.toString();
            Gson gson = new Gson();
            Franquicia f = gson.fromJson(json, Franquicia.class);
            return f;
        }catch(Exception e){
            return new Franquicia();
        }
        
    }
    
}
