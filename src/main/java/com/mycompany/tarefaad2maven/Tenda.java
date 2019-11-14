
package com.mycompany.tarefaad2maven;

import java.util.ArrayList;
import java.util.Scanner;


public class Tenda {
    public String nome, cidade;
    public ArrayList <Producto> productos = new ArrayList <>();
    public ArrayList <Empregado> empregados = new ArrayList <>();
    Franquicia f = new Franquicia ();
    String tSeleccionada;
    
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
        System.out.println(f.tendaSeleccionada);
        if (f.mapaTendas.containsKey(f.getTendaSeleccionada())){
           
           System.out.println("Tenda atopada");
            this.productos.add(p);
            System.out.println("Producto engadido");
        }
    }       
    
    public void engadirEmpregado (Empregado e){
       if (f.mapaTendas.containsKey(f.tendaSeleccionada)){
            this.empregados.add(e);
            System.out.println("Empregado engadido");
        }
    }
    
    public void eliminarProducto (Producto p){
        if (f.mapaTendas.containsKey(f.tendaSeleccionada)){
            this.productos.remove(p);
            System.out.println("Producto eliminado");
        }
    }
    
    public void eliminarEmpregado (Empregado e){
        if (f.mapaTendas.containsKey(f.tendaSeleccionada)){
            this.empregados.remove(e);
            System.out.println("Empregado eliminado");
        }
    }
}
