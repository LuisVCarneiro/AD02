
package com.mycompany.tarefaad2maven;


import java.util.Scanner;

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
                    String nomeTenda = franquicia.seleccionarTenda();
                    franquicia.eliminarTenda(nomeTenda);
                    alma.gardarArquivo(franquicia);
                    break;
                case 3:
                    nomeTenda = franquicia.seleccionarTenda();
                    Tenda t3 = franquicia.getTenda(nomeTenda);
                    System.out.println(t3);
                   
                    break;
                case 4:
                   
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    Cliente c = new Cliente();
                    c.pedirCliente();
                    franquicia.engadirCliente(c);
                    alma.gardarArquivo(franquicia);
                    break;
                case 8:
                    String nomeCliente = franquicia.seleccionarCliente();
                    franquicia.eliminarCliente(nomeCliente);
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
