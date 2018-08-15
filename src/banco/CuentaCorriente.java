/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;
import java.io.*;
import banco.Cuenta;
import banco.Transaccion;
/**
 *
 * @author john.llanes
 */
public class CuentaCorriente extends Cuenta{
    private int total;
    private int tra;
    private Transaccion []nt=new Transaccion[100];
    
    public CuentaCorriente(){
        super();
        this.total=0;
        tra=0;
    }
    public CuentaCorriente(String c,String cu,double s){
        super(c,cu,s);
         this.total=0;
        Transaccion an=new Deposito(1,s); 
        addTrasaccion(an);
        tra=0;
    }
 
    public void mostrarEstadoCuenta(){
        double totalp=0.0;
        for(int i=0;i<tra+1;i++){
            if(nt[i].getMonto()>0){
                nt[i].mostrar();
                if(nt[i] instanceof Retiro){
                    totalp-=nt[i].getMonto();
                }
                if(nt[i] instanceof CobroCheque){
                    totalp-=nt[i].getMonto();
                }
                if(nt[i] instanceof Deposito){
                 totalp+=nt[i].getMonto();   
                }
            }
        }
        System.out.println("Saldo disponible: "+totalp);
    }

    @Override
    public void addTrasaccion(Transaccion t) {
      for(int i=0;i<nt.length;i++){
         if(total==i){
             nt[i]=t;
             i=nt.length+1;
             tra++;
         }
     }
     total++; 
    }
    
}
