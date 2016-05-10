
package numeroprimo;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Set;

public class Main {
    
    public static void main(String[] args) {
        AlgAleatorio algoritmo = new AlgAleatorio();
        System.out.println("######### PRUEBAS #########");
        System.out.println("PRUEBA DEL NÚMERO 2");
        BigInteger num1 = new BigInteger("2");
        int m1 = 0;
        boolean solucion1 = algoritmo.esPrimo(num1,m1);
        evaluar(solucion1,m1);
        
        System.out.println("PRUEBA DEL NÚMERO 3");
        BigInteger num2 = new BigInteger("3");
        int m2 = 1;
        boolean solucion2 = algoritmo.esPrimo(num2,m2);
        evaluar(solucion2,m2);
        
        System.out.println("PRUEBA DEL NÚMERO 7");
        BigInteger num3 = new BigInteger("7");
        int m3 = 5;
        boolean solucion3 = algoritmo.esPrimo(num3,m3);
        evaluar(solucion3,m3);
        
        System.out.println("PRUEBA DEL NÚMERO 11");
        BigInteger num4 = new BigInteger("11");
        int m4 = 9;
        boolean solucion4 = algoritmo.esPrimo(num4,m4);
        evaluar(solucion4,m4);
        
        
        System.out.println("PRUEBA DEL NÚMERO 73939133 ");
        BigInteger num5 = new BigInteger("73939133");
        int m5 = 100;
        boolean solucion5 = algoritmo.esPrimo(num5,m5);
        evaluar(solucion5,m5);
        
        /*System.out.println("PRUEBA DEL NÚMERO 561");
        BigInteger num5 = new BigInteger("561");
        int m5 = 400;
        boolean solucion5 = algoritmo.esPrimo(num5,m5);
        evaluar(solucion5,m5);
        
        System.out.println("PRUEBA DEL NÚMERO ");
        BigInteger num = new BigInteger("");
        int m = ;
        boolean solucion = algoritmo.esPrimo(num,m);
        evaluar(solucion,m);
        
        System.out.println("PRUEBA DEL NÚMERO ");
        BigInteger num = new BigInteger("");
        int m = ;
        boolean solucion = algoritmo.esPrimo(num,m);
        evaluar(solucion,m);
        
        System.out.println("PRUEBA DEL NÚMERO ");
        BigInteger num = new BigInteger("");
        int m = ;
        boolean solucion = algoritmo.esPrimo(num,m);
        evaluar(solucion,m);
        
        System.out.println("PRUEBA DEL NÚMERO ");
        BigInteger num = new BigInteger("");
        int m = ;
        boolean solucion = algoritmo.esPrimo(num,m);
        evaluar(solucion,m);*/

    }

    private static void evaluar(boolean solucion,int m) {
        if(solucion == true){
            System.out.println("El número es primo.\nLa probabilidad de que este resultado sea correcto es mayor del " + (double)(1 - Math.pow(2,(-m)))*100 + "%");
        }
        else System.out.println("El número es compuesto.\nLa probabilidad de que este resultado sea correcto es del 100%");
        System.out.println("----------------------------------");
        
    }
    
    
    
}
