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
public class Retiro extends Transaccion {
    private double monto;
    public Retiro(){
        super();
    }
    public Retiro(int t,double m){
        super(t,m);this.monto=m;
    }
    public double getMonto() {
        return this.monto;
    }
}
