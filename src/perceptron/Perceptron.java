package perceptron;

/**
 *
 * @author Pedro César
 */
public class Perceptron {
    
    private Double[][] X;
    private Double[][] W;
    private int tX;
    private int dX;
          
    public void input(Double[][] Dados ){
        
        // Dados: Dimensões
        int tDados = Dados.length;
        tX = tDados;
        // Dados: Tamanho
        int dDados = Dados[0].length;
        dX = dDados;
        
        System.out.println("Dados:");
        System.out.println("Dimensões "+ dDados + ", Tamanho " + tDados );
        
        X = new Double[tDados][dDados];
        W = new Double[tDados][dDados];
        
        for(int t = 0; t < tDados; t++) {
            for(int d = 1; d < dDados; d++){
                // Bias
                X[t][0] = 1.0;
                // Entradas
                X[t][d] = Dados[t][d-1];
                // Pesos
                W[t][0] = 0.0;
                W[t][d] = 0.0;
            }
        }
    }
    
    public void listDados(){
        
        if(tX == 0){
            System.out.println("Dados não carregados !!");
        }
                
        for(int t = 0; t<tX; t++){
            for(int d = 0; d<dX; d++){
                System.out.printf("| X[%02d] %05.2f ", d, X[t][d] );
                System.out.printf("| W[%02d] %05.2f ", d, W[t][d] );
            }
            System.out.println("");
        }
            
    }
    
    public Double Nucleo(){
        
        Double M,T = 0.0;
        
        for(int t = 0; t<tX; t++){
            for(int d = 0; d<dX; d++){
                M = X[t][d] * W[t][d];
                
                System.out.println("T = "+ T);
            }
                
        }
        
        
        
        return(T);
    }
    
    private Double funcTrans(Double I){
        Double R = 0.0;
        
        if(I>0){ 
            R=1.0;
        }
        
        return(R);
    }

}
