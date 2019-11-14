
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
    
    private static String FILENAME = "data.json";
    
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
                    //Engadimos as tendas
                    Tenda t = new Tenda();
                    t.pedirTenda();//metodo que pide os datos da tenda
                    franquicia.engadirTenda(t);//Método que engade a tenda ó mapa
                    alma.gardarArquivo(franquicia);//Método que crea o json
                    break;
                case 2:
                    Tenda t2 = new Tenda ();
                    franquicia.seleccionarTenda();
                    franquicia.eliminarTenda(t2);
                    alma.gardarArquivo(franquicia);
                    break;
                case 3:
                    Producto p = new Producto();//Creo un obxeto de tipo producto
                    franquicia.seleccionarTenda();//Método que selecciona unha tenda de unha lista de key no mapa de tendas
                    Tenda t3 = franquicia.tendaSeleccionada(franquicia.tendaSeleccionada);
                    p.pedirProducto();//Método que pide os datos do producto para engadir
                    t3.engadirProducto(p);//Engado o producto ó array de productos na tenda elexida
                    alma.gardarArquivo(franquicia);//Grada o arquivo no json
                    break;
                case 4:
                    Tenda t4 = new Tenda();
                    Producto p4 = new Producto();
                    franquicia.seleccionarTenda();
                    t4.eliminarProducto(p4);
                    alma.gardarArquivo(franquicia);
                    break;
                case 5:
                    Tenda t5 = new Tenda();
                    Empregado e = new Empregado();
                    e.pedirEmpregado();
                    franquicia.seleccionarTenda();
                    t5.engadirEmpregado(e);
                    alma.gardarArquivo(franquicia);
                    break;
                case 6:
                    Tenda t6 = new Tenda();
                    Empregado e6 = new Empregado();
                    franquicia.seleccionarTenda();
                    t6.eliminarEmpregado(e6);
                    alma.gardarArquivo(franquicia);
                    break;
                case 7:
                    Cliente c = new Cliente();
                    c.pedirCliente();
                    franquicia.engadirCliente(c);
                    alma.gardarArquivo(franquicia);
                    break;
                case 8:
                    Cliente c8 = new Cliente();
                    franquicia.seleccionarCliente();
                    franquicia.eliminarCliente(c8);
                    alma.gardarArquivo(franquicia);
                    break;
                case 9: 
                    Copia copia = new Copia();
                    copia.lerArquivo();
                    copia.escribirArquivo();
                    break;
                case 10:
                    LeerXml lectura =  new LeerXml();
                    lectura.leerXml();
                    break;
                case 11:
                    System.exit(0);
                    break;
                    }
        }
    }

}
