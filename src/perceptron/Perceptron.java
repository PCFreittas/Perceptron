package perceptron;

/**
 *
 * @author Pedro César
 */
public class Perceptron {
    Double Y = null;
    
    public Double nucleo(Double[] W){
        
        int tamW = W.length;
        Double[] X = new Double[tamW];
        
        
        for(int c=1;c < tamW;c++){
            Y=Y+(X[c]*W[c]);        
        }
        return(Y);
    }
}
