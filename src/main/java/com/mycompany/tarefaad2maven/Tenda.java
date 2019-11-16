
package com.mycompany.tarefaad2maven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Tenda {
    public String nome, cidade;
   // public ArrayList <Producto> productos = new ArrayList <>();
    public HashMap <String, Producto> productos = new HashMap <>();
    public HashMap <String,Empregado> empregados = new HashMap <>();
    Franquicia f = new Franquicia ();
    
    public Tenda(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
        this.productos = productos;
        this.empregados = empregados;
    }
    
    public Tenda (){   
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Tenda{" + "nome=" + nome + ", cidade=" + cidade + ", productos=" + productos + ", empregados=" + empregados + '}';
    }
    
    public void pedirTenda(){
        Scanner teclado = new Scanner (System.in);
        System.out.println("Nome da tenda: ");
        this.nome = teclado.nextLine();
        System.out.println("Cidade donde se ubica: ");
        this.cidade = teclado.nextLine();
        
    }
    
    public void engadirProducto (Producto p){
        String key = "P" + p.getId();
        this.productos.put(key,p);
        System.out.println("Producto engadido");
    }       
    
    public String engadirEmpregado (Empregado e){
        String key = "E" + e.getNomEmp();
        this.empregados.put(key,e);
        return  "Empregado engadido";
    }
    
    public void eliminarProducto (Producto p){
        
        System.out.println("Producto eliminado");
    }
    
    public void eliminarEmpregado (Empregado e){
       
        System.out.println("Empregado eliminado");
    }

    
    public String elexirProducto (){
        Scanner teclado = new Scanner (System.in);
        System.out.println("Escolle un producto: ");
        for (String key : productos.keySet()){
            System.out.print (key + " ");
        }
        return teclado.nextLine();
    }

    public Producto getProductoSeleccionado(String productoAux){
        if (productos.containsKey(productoAux)){
            System.out.println("Producto atopada");
        } else{
            System.out.println("Ese producto non existe");
        }
        return new Producto();
    }
    
    public String elexirEmpregado (){
        Scanner teclado = new Scanner (System.in);
        System.out.println("Escolle un empregado: ");
        for (String key : empregados.keySet()){
            System.out.print(key + " ");
        }
        return teclado.nextLine();
    }

    public Producto getEmpregadoSeleccionado(String empregadoAux){
        if (empregados.containsKey(empregadoAux)){
            System.out.println("Empregado atopada");
        } else{
        System.out.println("Ese empregado non existe");
        }
        return new Producto();
    }
     
    
}

