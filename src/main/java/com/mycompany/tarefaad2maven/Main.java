
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
                case 1://Engadir tenda á franquicia
                    Tenda t = new Tenda();
                    t.pedirTenda();//metodo que pide os datos da tenda
                    franquicia.engadirTenda(t);//Método que engade a tenda ó mapa
                    alma.gardarArquivo(franquicia);//Método que crea o json
                    break;
                    
                case 2://Eliminar tenda
                    String nomeTenda = franquicia.seleccionarTenda();
                    franquicia.eliminarTenda(nomeTenda);
                    alma.gardarArquivo(franquicia);
                    break;
                    
                case 3://Engadir producto a tenda
                    nomeTenda = franquicia.seleccionarTenda();//selecciono unha das tendas
                    Tenda t3 = franquicia.getTendaSeleccionada(nomeTenda);//inicializo un obxeto de tipo tenda coa que selecciono
                    Producto p3 = new Producto();//Creo un producto
                    p3.pedirProducto();//Pido os datos de ese producto
                    t3.engadirProducto(p3);//Engado o producto ó obxeto inicializado anteriormente
                    alma.gardarArquivo(franquicia);//gardo os datos no json
                    break;
                    
                case 4://Eliminar producto de tenda
                    nomeTenda = franquicia.seleccionarTenda();//selecciono unha das tendas
                    Tenda t4 = franquicia.getTendaSeleccionada(nomeTenda);//inicializo un obxeto que se corresponde ca tenda seleccionada
                    String nomeProducto = t4.seleccionarProducto();//Selecciono un producto da tenda
                    Producto p4 = t4.getProductoSeleccionado(nomeProducto);//inicializo un producto dos da tenda
                    t4.eliminarProducto(p4);//elimino o producto da tenda
                    alma.gardarArquivo(franquicia);  //gardo os datos no json
                   break;
                   
                case 5://Engadir empregado a tenda
                    nomeTenda = franquicia.seleccionarTenda();
                    Tenda t5 = franquicia.getTendaSeleccionada(nomeTenda);
                    Empregado e5 = new Empregado();
                    e5.pedirEmpregado();
                    t5.engadirEmpregado(e5);
                    alma.gardarArquivo(franquicia);
                    break;
                    
                case 6://Eliminar empregado de tenda
                    nomeTenda = franquicia.seleccionarTenda();
                    Tenda t6 = franquicia.getTendaSeleccionada(nomeTenda);
                    String nomeEmpregado = t6.seleccionarEmpregado();
                    Empregado e6 = t6.getEmpregadoSeleccionado(nomeEmpregado);
                    t6.eliminarEmpregado(e6);
                    alma.gardarArquivo(franquicia);
                    break;
                    
                case 7://Engadir cliente á franquicia
                    Cliente c = new Cliente();
                    c.pedirCliente();
                    franquicia.engadirCliente(c);
                    alma.gardarArquivo(franquicia);
                    break;
                    
                case 8://Eliminar empregado
                    String nomeCliente = franquicia.seleccionarCliente();
                    franquicia.eliminarCliente(nomeCliente);
                    alma.gardarArquivo(franquicia);
                    break;
                    
                case 9://Crear copia de seguridade .backup
                    Copia copia = new Copia();
                    copia.lerArquivo();
                    copia.escribirArquivo();
                    break;
                    
                case 10://Leer xml periódico El Pais (web)
                    LeerXml lectura =  new LeerXml();
                    lectura.leerXml();
                    break;
                    
                case 11://Salir do programa
                    System.exit(0);
                    break;
                    }
        }
    }

}
