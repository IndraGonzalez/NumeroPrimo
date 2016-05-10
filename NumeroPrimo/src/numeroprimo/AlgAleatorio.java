
package numeroprimo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class AlgAleatorio {
    
    public boolean esPrimo(BigInteger n, int m){
        if(BigInteger.valueOf(m).compareTo(n.subtract(new BigInteger("2"))) > 0){
            throw new IllegalArgumentException("El número de pruebas debe ser menor o igual al número a probar menos dos.\n m <= n-2");
        }
        
        BigInteger bi, mod;
        Set<BigInteger> b = seleccionarMEnteros(n,m);
        ArrayList<BigInteger> k = buscarJ(n);
        
        Iterator<BigInteger> iter = b.iterator();
        
        while(iter.hasNext()){
            bi = iter.next();
            mod = bi.modPow(n.subtract(BigInteger.ONE), n);
            mod = mod.mod(n);
            if(mod.compareTo(BigInteger.ONE) != 0){
                return false;
            } 
            if((k.size() >= 0) && encontrarDivisor(bi,n,k)){
                return false;
            }
        }
        return true;
    }
       
    public static Set<BigInteger> seleccionarMEnteros(BigInteger n, int m) {
        Set<BigInteger> b = new HashSet<BigInteger>();
        int iter = 1;
        while(iter <= m){
            iter++;
            Random rnd = new Random();
            do {
                BigInteger i = new BigInteger(n.bitLength(), rnd);
                if ((i.compareTo(n) < 0) && (i.compareTo(BigInteger.ONE) > 0) && (!b.contains(i))){
                    b.add(i);
                    break;
                }
            } while (true); 
        }
        return b;
    }

    private ArrayList<BigInteger> buscarJ(BigInteger n) {
        ArrayList<BigInteger> solucion = new ArrayList<BigInteger>();
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
        while(i < k.size()){
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
        BigInteger i = BigInteger.ZERO;
        while(i.compareTo(exponente) <= 0){
            potencia = potencia.multiply(base);
            i = i.add(BigInteger.ONE);
        }
        return potencia;
    }

    private BigInteger mcd(BigInteger bi, BigInteger k, BigInteger n) {
        BigInteger bik = potencia(bi,k).subtract(BigInteger.ONE);
        return bik.gcd(n);
    }    
}
