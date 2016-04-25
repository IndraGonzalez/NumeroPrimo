
package numeroprimo;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Set;

public class Main {

    //public static void main(String[] args) {
    //}
    
    public static void main(String... args) {
        Set<BigInteger> solucion = AlgAleatorio.seleccionarMEnteros(new BigInteger("8180385048"),10);
        Iterator<BigInteger> iter = solucion.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next().toString());
        }
    }
    
}
