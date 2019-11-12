
package com.mycompany.tarefaad2maven;

import java.util.Scanner;


public class Producto {
    private String id, descripcion, cantidade, prezo;    

    public Producto(String id, String descripcion, String cantidade, String prezo) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidade = cantidade;
        this.prezo = prezo;
    }
    
    public Producto (){
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidade() {
        return cantidade;
    }

    public void setCantidade(String cantidade) {
        this.cantidade = cantidade;
    }

    public String getPrezo() {
        return prezo;
    }

    public void setPrezo(String prezo) {
        this.prezo = prezo;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", descripcion=" + descripcion + ", cantidade=" + cantidade + ", prezo=" + prezo + '}';
    }
    
    public void pedirProducto(){
        Scanner teclado = new Scanner (System.in);
        System.out.println("Id do producto: ");
        this.id = teclado.next();
        System.out.println("Descripción do producto: ");
        this.descripcion = teclado.next();
        System.out.println("Cantidade: ");
        this.cantidade = teclado.next();
        System.out.println("Prezo: ");
        this.prezo = teclado.next();
    }
}
