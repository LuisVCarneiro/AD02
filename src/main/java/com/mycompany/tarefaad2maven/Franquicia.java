
package com.mycompany.tarefaad2maven;

import java.util.HashMap;
import java.util.Scanner;


public class Franquicia {

    public HashMap <String, Tenda> mapaTendas = new HashMap <>();
    public HashMap <String, Cliente> mapaClientes = new HashMap <>();
    String tendaSeleccionada;
    String clienteSeleccionado = null;
   

    public Franquicia() {
      
        this.mapaTendas = new HashMap <>();
        this.mapaClientes = new HashMap <>();
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
    
    public String seleccionarTenda(){
        Scanner teclado = new Scanner (System.in);
        System.out.println("Que tenda desexas seleccionar?:");
        for (String key : mapaTendas.keySet()){
            System.out.println(key);
        }
        this.tendaSeleccionada = teclado.nextLine();
        return  tendaSeleccionada;
    }
    
    public String seleccionarCliente(){
        Scanner teclado = new Scanner (System.in);
        System.out.println("Que cliente desexas seleccionar?:");
        for (String key : mapaClientes.keySet()){
            System.out.println(key);
        }
        clienteSeleccionado = teclado.nextLine();
        return  clienteSeleccionado;
    }
    
    public void eliminarTenda(Tenda t){
        if (mapaTendas.containsKey(tendaSeleccionada)){
            mapaTendas.remove(tendaSeleccionada);
            System.out.println("Tenda eliminada");
        }
    }
    
    public void eliminarCliente(Cliente c){
        if (mapaClientes.containsKey(clienteSeleccionado)){
            mapaClientes.remove(clienteSeleccionado);
            System.out.println("Cliente eliminado");
        }
    }
    
    
    public Tenda getTenda (String nome){//Método que nos da unha tenda que lle metemos por parámetro para engadir productos
        return new Tenda ();
    }

    
    public Cliente getCliente (String cliente){
        return new Cliente ();
    }

    public String getTendaSeleccionada() {
        return tendaSeleccionada;
    }

    public void setTendaSeleccionada(String tendaSeleccionada) {
        this.tendaSeleccionada = tendaSeleccionada;
    }

    public String getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    public void setClienteSeleccionado(String clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
    }
    
    public Tenda tendaSeleccionada (String tendaSeleccionada){
        return new Tenda();
    }    
    
}
