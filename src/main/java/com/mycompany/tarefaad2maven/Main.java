
package com.mycompany.tarefaad2maven;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class Main {
    
    //private static String FILENAME = "data.json";
    
    public static void main (String [] args){
        
        
        //Vamos comprabar se existe o ficheiro
        Almacenar alma = new Almacenar();
        Franquicia franquicia;
        if(alma.existsJSON()){
            franquicia = alma.leerJson();
        }
        else{
            franquicia = new Franquicia();
        }

        Scanner teclado = new Scanner (System.in);
        
        boolean salir = false;
        while (!salir){
            System.out.println("--------- MENU PRINCIPAL ----------\n1:Engadir tenda. \n2:Eliminar tenda. \n3:Engadir produto. \n4:Eliminar produto."
                    + "\n5:Engadir empregado. \n6:Eliminar empregado. \n7:Engadir cliente. \n8:Eliminar cliente. \n9:Crear copia de seguridade. "
                    + "\n10:Leer RRSS. \n11:Salir.");
            byte opcion = teclado.nextByte();
            switch (opcion){
                /*As opcións funcionan da mesma maneira.. Chamada a métodos das clases correspondentes 
                e creación de obxetos de clase cos datos introducidos
                */
                case 1:

                    Tenda t = new Tenda();
                    t.pedirTenda();//metodo que pide os datos da tenda

                    if(franquicia.comprobarTenda(t))
                        System.out.println("Esta tenda xa esta engadida");
                    else{  
                        franquicia.engadirTenda(t);          
                        //saveJSON(franquicia); 
                    }         
                
                    break;
                case 2:
                    
                    break;
                    
                case 3:
                   
                    Tenda t3 = franquicia.seleccionarTenda(franquicia);
                    //Pido datos producto
                    Producto p = new Producto();
                    p.pedirProducto();
                    t3.engadirProducto(p);
                    
                    //saveJSON(franquicia);
                    
                    //alma.gardarArquivo(franquicia);*/
                    break;
                    
                case 4:
                    
                    
                    break;
                    
                case 5:
                    Tenda t5 = franquicia.seleccionarTenda(franquicia);
                    //Pido datos producto
                    Empregado e = new Empregado ();
                    e.pedirEmpregado();
                    t5.engadirEmpregado(e);
                    
                    break;
                    
                case 6:
                    
                    
                    break;
                    
                case 7:
                    
                    Cliente c = new Cliente();
                    c.pedirCliente();
                    if(franquicia.comprobarCliente(c))
                        System.out.println("Este cliente xa existe");
                    else {
                        franquicia.engadirCliente(c);
                    }
                    System.out.println(franquicia.clientes);
                    break;
                    
                case 8:
                    /*Tenda t3 = selecionarTienda(franquicia);
                    
                    //Pido datos producto
                    Producto p = new Producto();
                    t3.engadirProducto(p);
                    
                    saveJSON(franquicia);*/
                    
                    Cliente c8 = franquicia.seleccionarCliente(franquicia);
                    franquicia.comprobarCliente(c8);
                    break;
                    
                case 9:
                    
                    break;
                    
                case 10:
                    
                    XMLReader procesadorXML = null;

                    try {
                        //Creo parseador de texto e engádolle a clase que vai parsear o texto:
                        procesadorXML = XMLReaderFactory.createXMLReader();
                        NoticiaXML noticiaXML = new NoticiaXML();
                        procesadorXML.setContentHandler((ContentHandler) noticiaXML);

                        //Indico o texto donde estága gardada a noticia
                        InputSource arquivoXML = new InputSource("http://ep00.epimg.net/rss/elpais/portada.xml");
                        procesadorXML.parse(arquivoXML);

                        //Imprimo os datos lidos no XML
                        ArrayList <Noticia> noticias = noticiaXML.getNoticias();
                        for (int j = 0; j < noticias.size(); j++){
                            Noticia noticiaAux = noticias.get(j);
                            System.out.println("Noticia: "  + noticiaAux.getTitular());
                        }
                    }
                    catch (SAXException saxe){
                            System.out.println ("Ocurriu un erro ao ler o arquivo XML");
                            }
                    catch (IOException ioe){
                            System.out.println ("Ocurriu outro erro ao ler o arquivo XML");
                            }

                    break;
                    
                case 11:
                    Tenda t11 = new Tenda ();
                    System.out.println();
                    System.out.println(t11.productos);
                    System.out.println(t11.empregados);
                    System.exit(0);
                    break;
            
                    
            }
        }
    }
    
   /* private static void saveJSON(Franquicia f){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(f);
        
        File arquivo = new File(FILENAME);

        try {
            FileWriter fluxoDatos = new FileWriter(arquivo);
            BufferedWriter buferSaida = new BufferedWriter(fluxoDatos);
            buferSaida.write(json);

            buferSaida.close();
        } catch (IOException e) {
            System.err.println("Erro ao gardalos datos");
        }
        
    }
    
    private static boolean existsJSON(){
        File archivo = new File(FILENAME);
        if(archivo.exists()){
            return true;
        }
        return false;
    }
    
    private static Franquicia fromJSON(){
        
        try{
            File archivo = new File(FILENAME);
            //Creamos o bufer de entrada

            FileReader fluxoDatos = new FileReader(archivo);
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
    
   /* private static Tenda selecionarTienda(Franquicia f){
        //Imprimir tiendas
        ArrayList<String> nomesTendas = f.getNomeTendas();
        
        
        //Menu
        
        String aux = new String("sanclemente");
        return f.getTenda(aux);
    }*/


}
