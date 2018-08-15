/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;
import java.io.*;
import banco.*;

/**
 *
 * @author john.llanes
 */
public class Banco {
   private int totalc; 
   private Cuenta []totalcuenta=new Cuenta[100];
   
   public Banco(){
       this.totalc=0;
   }
   public void menu() throws IOException{
       int res=0,b=0,c=0,nr=0;
       DataInputStream lector=new DataInputStream(System.in);
      do{
       System.out.println("           Banco  Airus");
       System.out.println("Bueno dias en que le podemos ayudar  ");
       System.out.println("1).==Crear Cuenta                     ");
       System.out.println("2).==Consultar Cuenta                 ");
       System.out.println("3).==Realizar Transaccion             ");
       System.out.println("4).==Salir                             ");c=0;
       try{
           res=Integer.parseInt(lector.readLine());
       }catch(NumberFormatException ex){
           System.out.println("Dato no valido ingrese nuevo dato");c++;res=5;
       }
       if(0>res||res>=5&&c==0){
           res=5;
           System.out.println("Dato no valido ingrese nuevo dato");
       }else{
           switch(res){
           case 1:
            crearCuenta();
           break;
           case 2:
            consultarCuenta();
           break;
           case 3:
           realizarTransaccion();
           break;
           case 4:
           b++;    
           break;
           case 5:
           break;    
       }
      }
      }while(b==0);
   }
   public void crearCuenta()throws IOException{
       int res=0,a=0,nr=0;String auxN,auxC;double mon;
       DataInputStream lector=new DataInputStream(System.in);
  System.out.println("¿Que tipo de cuenta desea? Corriente |1|; Ahorro |2| \n"+
                     "1.=Cuenta Corriente podra hacer depositos y cobros de cheque \n"+
                     "2.=Cuenta de Ahorro podra hacer depositos y retiros ");
               try{
               res=Integer.parseInt(lector.readLine());
               System.out.println("Ingrese los datos requeridos");
               System.out.println("Numero de cuenta");
               auxC=lector.readLine();
               do{
                nr=0;   
               for(int i=0;i<totalc;i++){
                   if(auxC.compareTo(totalcuenta[i].getCuenta())==0){
                       nr=1;
                   }
               } 
                if(nr==1){
                System.out.println("Numero de cuenta ya existente ingrese una diferente");
                 auxC=lector.readLine();
               }
               }while(nr==1);
               System.out.println("Nombre");
               auxN=lector.readLine();
               System.out.println("Monto incial");
               mon=Float.parseFloat(lector.readLine());
               if(0>=mon){
                   a=1;
               }
               }catch(NumberFormatException ex){
                   System.out.println("Creacion de cuenta invalida");
                  auxC=" ";auxN=" ";mon=0.0;
               }
               if(a==0){
                 for(int i=0;i<totalcuenta.length;i++){
                   if(totalc==i){
                       if(res==1){
                           totalcuenta[i]=new CuentaCorriente(auxN,auxC,mon);totalc++;
                           System.out.println("Bienvenido a la familia Airus, "+totalcuenta[i].getCliente());
                       }else if(res==2){
                           totalcuenta[i]=new CuentaAhorros(auxN,auxC,mon);totalc++;
                           System.out.println("Bienvenido a la familia Airus, "+totalcuenta[i].getCliente());
                       }
                    i=totalcuenta.length+1; 
                   }
               };
           }else if(a==1){
             System.out.println("Crecion invalida necesita un monto inicial vuelva a intentar");
           }
   }
   public void consultarCuenta()throws IOException{
       DataInputStream lector=new DataInputStream(System.in);
                String aux;int a=0;
              if(totalc>0){
               try{
                System.out.println("Ingrese cuenta");
                aux=lector.readLine();
                 for(int i=0;i<totalcuenta.length;i++){
                   if(aux.compareTo(totalcuenta[i].getCuenta())==0){
                       System.out.println("Estado de cuenta");
                       System.out.println("NC:"+totalcuenta[i].getCuenta()+
                                          " Dueño:"+totalcuenta[i].getCliente());
                       System.out.println("Movimientos:");
                       totalcuenta[i].mostrarEstadoCuenta();
                       i=totalcuenta.length+1;a++;
                   }
               }        
               }catch(NullPointerException ex){
                 aux=" ";a=1;
               }   
               if(a!=1){
               if(0==a){System.out.println("la cuenta no existe");}   
              }
            }
   }
   public void realizarTransaccion()throws IOException{
       DataInputStream lector=new DataInputStream(System.in);
               int resp;Transaccion auxT;double m = 0;String uxC = null;int numero;
              if(totalc>0){
                try{
                     System.out.println("Ingrese que tipo trasaccion Deposito 1 retiro 2 cobro de cheque 3");
                     resp=Integer.parseInt(lector.readLine());
               }catch(NumberFormatException ex){
                  resp=0;System.out.println("Dato invalido intente de nuevo");
              }
               if(resp==1){
                   System.out.println("Deposito");
                   try{
                 System.out.println("Ingrese los datos requeridos");
                   System.out.println("El monto que va a depositar");
                   m=Float.parseFloat(lector.readLine());
                   System.out.println("La cuenta a Depositar");
                   uxC=lector.readLine();
                   for(int i=0;i<totalcuenta.length;i++){
                       if(uxC.compareTo(totalcuenta[i].getCuenta())==0){
                           auxT=new Deposito(1,m);
                           totalcuenta[i].addTrasaccion(auxT);
                           i=totalcuenta.length+1;
                           System.out.println("**== Operacion exitosa ==**");
                       }
                   }    
                   }catch(NumberFormatException ex){
                       System.out.println("Dato invalido ");
                   }catch(NullPointerException ex){
                       System.out.println("Cuenta no existe");
               }
               }else if(resp==2){
                   try{
                   System.out.println("Retiro");
                   System.out.println("Ingrese los datos requeridos");
                   System.out.println("Monto de retiro");
                   m=Float.parseFloat(lector.readLine());
                   System.out.println("La cuenta a retirar");
                   uxC=lector.readLine();
                  for(int i=0;i<totalcuenta.length;i++){
                       if(uxC.compareTo(totalcuenta[i].getCuenta())==0){
                              if( totalcuenta[i] instanceof CuentaAhorros){
                                   if(totalcuenta[i].getSaldo()>m){
                                   auxT=new Retiro(2,m);
                                   totalcuenta[i].addTrasaccion(auxT);
                                   i=totalcuenta.length+1;
                                   }else{
                                  System.out.println("Notiene los fondos necesarios");
                                  i=totalcuenta.length+1;
                                  System.out.println("**== Operacion exitosa ==**");
                              }
                           }else{
                           System.out.println("Cuenta invalida necesita una cuenta  corriente");
                              }
                       }
                    }       
                   }catch(NumberFormatException ex){
                       System.out.println("Dato invalido"); 
                   }catch(NullPointerException ex){    }
               }else if(resp==3){
                   try{
                   System.out.println("cobro de cheque ");
                   System.out.println("Ingrese los datos requeridos");
                   System.out.println("Nuemero de cheque");
                   numero=Integer.parseInt(lector.readLine());
                   System.out.println("Monto del cheque ");
                   m=Float.parseFloat(lector.readLine());
                   System.out.println("La cuenta a cobrar");
                   uxC=lector.readLine();
                  for(int i=0;i<totalcuenta.length;i++){
                       if(uxC.compareTo(totalcuenta[i].getCuenta())==0){
                           if(totalcuenta[i] instanceof CuentaCorriente){
                             if(totalcuenta[i].getSaldo()>m){
                             auxT=new Retiro(3,m);
                             totalcuenta[i].addTrasaccion(auxT);
                             i=totalcuenta.length+1;
                             System.out.println("**== Operacion exitosa ==**");
                             }else{
                              System.out.println("No tiene los fondos necesarios");
                             i=totalcuenta.length+1;
                           }
                         }else{
                        System.out.println("Cuenta invalida necesita cuenta corriente ");
                           }
                       }
                   } 
                   }catch(NumberFormatException ex){
                       System.out.println("Dato invalido"); 
                   }catch(NullPointerException ex){
                      
                   }
               }
         }if(totalc==0){
             System.out.println("Registro vacio crea una cuenta");
         }

}

}