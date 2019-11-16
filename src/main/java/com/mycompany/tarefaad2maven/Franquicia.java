
package com.mycompany.tarefaad2maven;

import java.util.HashMap;
import java.util.Scanner;


public class Franquicia {

    public HashMap <String, Tenda> mapaTendas = new HashMap <>();
    public HashMap <String, Cliente> mapaClientes = new HashMap <>();

    public Franquicia() {
        this.mapaTendas = new HashMap <>();
        this.mapaClientes = new HashMap <>();
    }
    
    public String seleccionarTenda(){
        Scanner teclado = new Scanner (System.in);
        System.out.println("Que tenda desexas seleccionar?:");
        for (String key : mapaTendas.keySet()){
            System.out.print(key + " ");
        }
        return teclado.nextLine(); 
    }
    
    public String seleccionarCliente(){
        Scanner teclado = new Scanner (System.in);
        System.out.println("Que cliente desexas seleccionar?:");
        for (String key : mapaClientes.keySet()){
            System.out.println(key);
        }
        return teclado.nextLine();  
    }
    
    public void engadirTenda(Tenda t){
        String key = t.getNome();
        if (!this.mapaTendas.containsKey(key)){
            this.mapaTendas.put(key,t);
        }else{
            System.out.println("Esta tenda xa está engadida");
        }
    }
    
    public void engadirCliente(Cliente c){
        String key = c.getNome();
        if (!this.mapaClientes.containsKey(key)){
            this.mapaClientes.put(key,c);
        }else{
            System.out.println("Este cliente xa existe");
        }
    }
    
    public void eliminarTenda(String nomeTenda){
        if (mapaTendas.containsKey(nomeTenda)){
            mapaTendas.remove(nomeTenda);
            System.out.println("Tenda eliminada");
        }
    }
    
    public void eliminarCliente(String nomeCliente){
        if (mapaClientes.containsKey(nomeCliente)){
            mapaClientes.remove(nomeCliente);
            System.out.println("Cliente eliminado");
        }
    }
    
    public Tenda getTendaSeleccionada (String nomeTenda){//Método que nos da unha tenda que lle metemos por parámetro para engadir productos
        if (mapaTendas.containsKey(nomeTenda)){
            System.out.println("Tenda atopada");
        } else{
        System.out.println("Esa tenda non existe");
        }
        return new Tenda();
    }
 
}
