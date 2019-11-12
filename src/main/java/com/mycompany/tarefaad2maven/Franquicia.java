
package com.mycompany.tarefaad2maven;

import java.util.ArrayList;
import java.util.Scanner;


public class Franquicia {

    public ArrayList <Tenda> tendas;
    public ArrayList <Cliente> clientes;

    public Franquicia() {
        this.tendas = new ArrayList <>();
        this.clientes = new ArrayList <>();
    }
    
    public void engadirTenda(Tenda t){
        this.tendas.add(t);
    }
    
    public void engadirCliente(Cliente c){
        this.clientes.add(c);
    }
    
    public boolean comprobarTenda(Tenda t){
        for (int i = 0; i < this.tendas.size(); i++){
            Tenda tendAux = this.tendas.get(i);//Obxeto tipo Tenda = valor leído ó recorrer o array de tendas
            System.out.println(tendAux.getNome());
            if (t.getNome().equalsIgnoreCase(tendAux.getNome()))//Si o valor leído é igual ó nome introducido como da tenda retorna verdadeiro
            return true;
        }
        return false; // en caso contrario, retorna false
    }
    
    public boolean comprobarCliente(Cliente c){
         for (int i = 0; i < this.clientes.size(); i++){
            Cliente clienteAux = this.clientes.get(i);//Obxeto tipo Tenda = valor leído ó recorrer o array de tendas
            if (c.getNome().equalsIgnoreCase(clienteAux.getNome()))//Si o valor leído é igual ó nome introducido como da tenda retorna verdadeiro
                System.out.println("Existe");
                return true;
        }
        System.out.println("Non existe");
        return false; // en caso contrario, retorna false
    } 
    
    public void eliminarTenda(Tenda t){
        
    }
    
    public void eliminarCliente(Cliente c){
        if (comprobarCliente(c)){
            this.clientes.remove(c);
        }
        else {
            System.out.println("Este cliente non existe");
        }
    }
    
    
    public ArrayList <String> getNomeTendas(){ //Método que almacena os datos lidos do array de tendas e os almacena noutro de tipo tendas
        return new ArrayList <>();
    }
    
    public Tenda getTenda (String nome){//Método que nos da unha tenda que lle metemos por parámetro para engadir productos
        return new Tenda ();
    }
    
    public ArrayList <String> getNomeClientes(){
        return new ArrayList <>();
    }
    
    public Cliente getCliente (String cliente){
        return new Cliente ();
    }
    
    public Tenda seleccionarTenda (Franquicia f){
        //Imprimir tendas
        ArrayList <String> nomesTendas = getNomeTendas();//Parámetros do Array, nomes das tendas
        Scanner teclado = new Scanner (System.in);
        System.out.println("Nome da tenda na que quere engadir o producto: ");
        String nomeTenda = teclado.nextLine();//Nome da tenda que queremos seleccionar
        String aux = new String (nomeTenda);//Obxeto tipo String con parámetro nome da tenda a buscar
        return getTenda(aux);
    }
    
    public Cliente seleccionarCliente (Franquicia f){
        ArrayList <String> nomesClientes = getNomeClientes();
        Scanner teclado = new Scanner (System.in);
        System.out.println("Nome do cliente: ");
        String nomCliente = teclado.nextLine();
        String clienteAux = new String (nomCliente);
        return getCliente(clienteAux);
    }
}
