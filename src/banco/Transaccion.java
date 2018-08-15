/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;
import java.io.*;
/**
 *
 * @author john.llanes
 */
public abstract class Transaccion {
    private int tipo;
    private double monto;
    public Transaccion(){
        this.monto=0.0;
        this.tipo=0;
    }
    public Transaccion(int tipo,double monto){
        this.tipo=tipo;
        this.monto=monto;
    }
    public void mostrar(){
        if(tipo==1){
            System.out.println("Deposito= "+monto);
        }else if(tipo==2){
            System.out.println("Retiro= -"+monto);
        }else if(tipo==3){
            System.out.println("Cobro de cheque: -"+monto);
        }
    }
    public abstract double getMonto();
    
}
