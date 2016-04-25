
package numeroprimo;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AlgAleatorio {
    
    public boolean esPrimo(BigInteger n, int m){
        Set<BigInteger> b = seleccionarMEnteros(n,m);
        return false;
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
}
