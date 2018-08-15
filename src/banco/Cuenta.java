/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;
import java.io.*;
import banco.Transaccion;
/**
 *
 * @author john.llanes
 */
public abstract class Cuenta {
    private String cliente;
    private String cuenta;
    private double saldo;
    
    public Cuenta(){
        this.cliente=" ";
        this.cuenta=" ";
        this.saldo=0.0;
    }
    
    public Cuenta(String cliente,String cuenta,double saldo){
        this.cliente=cliente;
        this.cuenta=cuenta;
        this.saldo=saldo;
 
        
    }
    
    abstract public void addTrasaccion(Transaccion t);
    
    public void mostrarEstadoCuenta(){

    }
    
    public String getCliente() {
        return cliente;
    }

    public String getCuenta() {
        return cuenta;
    }

    
    public double getSaldo() {
        return saldo;
    }
    /*
           double totalp=0;
         for(int i=0;i<tra+1;i++){
            if(nt[i].getMonto()>0){
                if(nt[i] instanceof Retiro){
                    totalp-=nt[i].getMonto();
                }
                if(nt[i] instanceof Deposito){
                 totalp+=nt[i].getMonto();   
                }
            }
        }
         saldo=totalp;
    */
    
}
