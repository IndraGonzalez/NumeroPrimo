
package numeroprimo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class AlgAleatorio {
    
    public boolean esPrimo(BigInteger n, int m){
        
        BigInteger bi, mod, uno;
        uno = new BigInteger("1");
        
        Set<BigInteger> b = seleccionarMEnteros(n,m);
        ArrayList k = buscarJ(n,uno);      
        
        Iterator<BigInteger> iter = b.iterator();
        //Preguntar si se pude poner la primera condicion del segundo if fuera del while o en la propia condicion del while
        while(iter.hasNext()){
            bi = iter.next();
            mod =bi.modPow(n.subtract(uno), n);
            mod = mod.mod(n);
            if(mod.compareTo(uno) != 0){
                return false;
            } 
            if((k.size() >= 0) && encontrarDividor(bi,n)){
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
                if (i.compareTo(n) <= 0){
                    b.add(i);
                    break;
                }
            } while (true); 
        }
        return b;
    }

    private ArrayList buscarJ(BigInteger n, BigInteger uno) {
        ArrayList<BigInteger> solucion = new ArrayList();
        int j = 1; 
        BigInteger num = n.subtract(uno);
        BigInteger dos = new BigInteger("2");
        BigInteger cero = new BigInteger("0");
        BigInteger den;
        BigInteger[] division;
        while(num.compareTo(dos.pow(j)) >= 0){
            den = dos.pow(j);
            division = num.divideAndRemainder(den);
            if(division[1].compareTo(cero) == 0){
                solucion.add(division[0]);
            }
            j++;
        }
        return solucion;
    }

    private boolean encontrarDividor(BigInteger bi, BigInteger n) {
        return false;
    }

    
}
