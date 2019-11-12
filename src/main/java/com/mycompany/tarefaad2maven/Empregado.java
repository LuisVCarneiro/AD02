
package com.mycompany.tarefaad2maven;

import java.util.Scanner;


public class Empregado {
    private String nomEmp, apelEmp;

    public Empregado(String nomEmp, String apelEmp) {
        this.nomEmp = nomEmp;
        this.apelEmp = apelEmp;
    }
    
    public Empregado (){
        
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public String getApelEmp() {
        return apelEmp;
    }

    public void setApelEmp(String apelEmp) {
        this.apelEmp = apelEmp;
    }

    @Override
    public String toString() {
        return "Empregado{" + "nomEmp=" + nomEmp + ", apelEmp=" +  '}';
    }
    
    public void pedirEmpregado(){
        Scanner teclado = new Scanner (System.in);
        System.out.println("Nome do empregado: ");
        this.nomEmp = teclado.next();
        System.out.println("Apelido do empregado: ");
        this.apelEmp = teclado.next();
    }
   
}
