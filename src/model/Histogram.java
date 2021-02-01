package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author angel
 */
public class Histogram<T> {
    
    //Se define un mapa de clave genérica y valores enteros
    public final Map<T,Integer> histogram = new HashMap<T, Integer>();
   
    //para el mapa, se devuelve el valor correspondiente a una clave.
    public Integer get(T key){
        return histogram.get(key);
    }
    
    // devuelve el conjunto de claces del mapa
    public Set<T> keySet(){
        return histogram.keySet();
    }
    
    //se rellena el mapa
    public void increment(T key){
        histogram.put(key, histogram.containsKey(key) ? histogram.get(key) + 1 : 1);
    }

}
