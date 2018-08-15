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
public class CobroCheque extends Transaccion {
   private double monto;
    public CobroCheque(){
        super();
    }
    public CobroCheque(int t,double m){
        super(t,m);this.monto=m;
    }
    
    @Override
    public double getMonto() {
        return this.monto;
    }
    
}
