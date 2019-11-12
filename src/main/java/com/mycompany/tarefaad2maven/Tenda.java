
package com.mycompany.tarefaad2maven;

import java.util.ArrayList;
import java.util.Scanner;


public class Tenda {
    public String nome, cidade;
    public ArrayList <Producto> productos = new ArrayList <>();
    public ArrayList <Empregado> empregados = new ArrayList <>();

    
    public Tenda(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
        this.productos = productos;//new ArrayList <>();
        this.empregados = empregados; //new ArrayList <>();
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
        this.nome = teclado.next();
        System.out.println("Cidade donde se ubica: ");
        this.cidade = teclado.next();
    }
    
    public void engadirProducto (Producto p){
        this.productos.add(p);
    }
    
    public void engadirEmpregado (Empregado e){
        this.empregados.add(e);
    }
    
    
}
