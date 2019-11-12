
package com.mycompany.tarefaad2maven;

import java.util.Scanner;

public class Cliente {
    private String nome, apelidos, correo;

    public Cliente(String nome, String apelidos, String correo) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.correo = correo;
    }
    
    public Cliente(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", apelidos=" + apelidos + ", correo=" + correo + '}';
    }
    
    public void pedirCliente(){
        Scanner teclado = new Scanner (System.in);
        System.out.println("Nome do cliente: ");
        this.nome = teclado.next();
        System.out.println("Apelido do empregado: ");
        this.apelidos = teclado.next();
        System.out.println("Correo do empregado: ");
        this.correo = teclado.next();
    }

}
