
package numeroprimo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class AlgAleatorio {
    
    public boolean esPrimo(BigInteger n, int m){
        
        BigInteger bi, mod;
        
        Set<BigInteger> b = seleccionarMEnteros(n,m);
        ArrayList k = buscarJ(n);
        
        System.out.println("K -->");
        Iterator<BigInteger> iter2 = k.iterator();
        while(iter2.hasNext()){
            System.out.print(iter2.next().toString());
            System.out.print(" , ");
        }
        System.out.println("");
        
        Iterator<BigInteger> iter = b.iterator();
        
        while(iter.hasNext()){
            bi = iter.next();
            System.out.println("Bi -> " + bi.toString());
            mod = bi.modPow(n.subtract(BigInteger.ONE), n);
            mod = mod.mod(n);
            if(mod.compareTo(BigInteger.ONE) != 0){
                System.out.println("FALLA LA PRIMERA CONDICIÓN");
                return false;
            } 
            if((k.size() >= 0) && encontrarDivisor(bi,n,k)){
                System.out.println("FALLA LA SEGUNDA CONDICIÓN");
                return false;
            }
        }
        return true;
    }
       
    public static Set<BigInteger> seleccionarMEnteros(BigInteger n, int m) {
        Set<BigInteger> b = new HashSet<BigInteger>();
        int iter = 0;
        while(iter <= m){
            iter++;
            Random rnd = new Random();
            do {
                BigInteger i = new BigInteger(n.bitLength(), rnd);
                if ((i.compareTo(n) <= 0) && (i.compareTo(BigInteger.ZERO) != 0)){
                    System.out.println("Bi = " + b + " i = " + i);
                    b.add(i);
                    break;
                }
            } while (true); 
        }
        return b;
    }

    private ArrayList buscarJ(BigInteger n) {
        ArrayList<BigInteger> solucion = new ArrayList();
        int j = 1; 
        BigInteger num = n.subtract(BigInteger.ONE);
        BigInteger dos = new BigInteger("2");
        BigInteger den;
        BigInteger[] division;
        while(num.compareTo(dos.pow(j)) >= 0){
            den = dos.pow(j);
            division = num.divideAndRemainder(den);
            if(division[1].compareTo(BigInteger.ZERO) == 0){
                solucion.add(division[0]);
            }
            j++;
        }
        return solucion;
    }

    private boolean encontrarDivisor(BigInteger bi, BigInteger n, ArrayList k) {
        int i = 0;
        while(i <= k.size()){
            BigInteger ki = (BigInteger) k.get(i);
            BigInteger mcd = mcd(bi,ki,n);
            if((mcd.compareTo(BigInteger.ONE) < 0) && ((mcd.compareTo(n)) < 0)){
                return true;
            }
            i++;
        }
        return false;
    }
    
    private BigInteger potencia(BigInteger base, BigInteger exponente){
        BigInteger potencia = BigInteger.ONE;
        for (BigInteger i = BigInteger.ZERO; i.compareTo(exponente) <= 0; i.add(BigInteger.ONE)) {            
            potencia.multiply(base);
        }
        return potencia;
    }

    private BigInteger mcd(BigInteger bi, BigInteger k, BigInteger n) {
        BigInteger bik = potencia(bi,k).subtract(BigInteger.ONE);
        return bik.gcd(n);
    }

    
}
