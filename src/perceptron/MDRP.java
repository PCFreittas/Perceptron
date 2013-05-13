package perceptron;

import java.util.Random;

/**
 * Multi Dimension Random Points
 * 
 * @version 0.2
 * @author pedro
 * "A simplicidade é o último grau de sofisticação"(Leonardo da Vinci)
 */
public class MDRP{
    
    /**
     * @param dVetPC Dimensão dos PC
     * @param qtdePC Quantidade de PC
     */
  
    // Pontos Centrais
    private int            dVetPC;
    private int            qtdePC;
    private double         raioPC; // Tamanho do Raio em volta ao(s) pontos centrais
    public double[][]      matrPC;
    // Pontos Aleatórios
    private int            qtdePA; // Numero de pontos a serem criados
    public double[][][]    matrPA; // Pontos Gerados (vetor)
    
    /**
    * Seta as variveis  de configuração
    * PC (Pontos Centrais)
    * PA (Pontos Aleatórios)
    * 
    * @param matrPC Conjunto dos PC;
    * @param raioPC Raio (em volta dos PC) que serão cridos os PA;
    * @param qtdePA Quantos PA devem ser criados.
    * @return null
    */
    public void setConfig(double[][] matrPC, double raioPC, int qtdePA){
     
        this.matrPC = matrPC;
        this.dVetPC = matrPC[0].length;
        this.qtdePC = matrPC.length;
        this.raioPC = raioPC;
        this.qtdePA = qtdePA;
        
        // Cria a Matriz de Pontos Aleatórios
        this.matrPA = new double[qtdePC][qtdePA][dVetPC];
    }
    /**
    * Inicializa a construção dos vetores de pontos multidimencionais
    * @return null 
    */
    public void geraMatr(){

        double b;
        
        long    currentTime = System.currentTimeMillis();
        Random gerRan = new Random(currentTime);
        
        for(int x=0; x < qtdePC; x++){
        
            for(int y=0; y < qtdePA; y++){
                
                for(int z=0; z < dVetPC ; z++){
                        
                    do{
                        
                        b = (gerRan.nextGaussian() * raioPC) + matrPC[x][z];
                        b = (Math.floor(b * 100))/100;
                        matrPA[x][y][z] = b;
                            
                    }while(Math.abs((matrPA[x][y][z])-(matrPC[x][z])) > raioPC);
                }
            }   
        }
    }
    
    public void print(){
        
        for(int x=0; x<qtdePC; x++){
            System.out.print("{");
            for(int y=0; y<qtdePA; y++){
                System.out.print("{");
                for(int z=0; z<dVetPC ; z++){
                    System.out.print(matrPA[x][y][z]);
                    if((z+1) < dVetPC){
                        System.out.print(", ");
                    }    
                }
                if((y+1)<qtdePA){
                    System.out.print("},");
                }else{
                    System.out.print("}");
                }
                
            }
            System.out.println("}");
        }
    }   
}