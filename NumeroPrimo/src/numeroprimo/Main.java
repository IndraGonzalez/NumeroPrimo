
package numeroprimo;

import java.math.BigInteger;

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
        
        System.out.println("PRUEBA DEL NÚMERO 9887");
        BigInteger num5 = new BigInteger("9887");
        int m5 = 1000;
        boolean solucion5 = algoritmo.esPrimo(num5,m5);
        evaluar(solucion5,m5);
        
        System.out.println("PRUEBA DEL NÚMERO 561");
        BigInteger num6 = new BigInteger("561");
        int m6 = 400;
        boolean solucion6 = algoritmo.esPrimo(num6,m6);
        evaluar(solucion6,m6);
        
        System.out.println("PRUEBA DEL NÚMERO 8");
        BigInteger num7 = new BigInteger("8");
        int m7 = 6;
        boolean solucion7 = algoritmo.esPrimo(num7,m7);
        evaluar(solucion7,m7);
        
        System.out.println("PRUEBA DEL NÚMERO 327");
        BigInteger num8 = new BigInteger("327");
        int m8 = 325;
        boolean solucion8 = algoritmo.esPrimo(num8,m8);
        evaluar(solucion8,m8);
        
        System.out.println("PRUEBA DEL NÚMERO 22");
        BigInteger num9 = new BigInteger("22");
        int m9 = 20;
        boolean solucion9 = algoritmo.esPrimo(num9,m9);
        evaluar(solucion9,m9);
        
        System.out.println("PRUEBA DEL NÚMERO 123456789075");
        BigInteger num10 = new BigInteger("123456789075");
        int m10 = 200;
        boolean solucion10 = algoritmo.esPrimo(num10,m10);
        evaluar(solucion10,m10);

    }

    private static void evaluar(boolean solucion,int m) {
        if(solucion == true){
            System.out.println("El número es primo.\nLa probabilidad de que este resultado sea correcto es mayor del " + (double)(1 - Math.pow(2,(-m)))*100 + "%");
        }
        else System.out.println("El número es compuesto.\nLa probabilidad de que este resultado sea correcto es del 100%");
        System.out.println("----------------------------------");
        
    }
    
    
    
}
