package perceptron;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private double         raioPC;          // Tamanho do Raio em volta ao(s) pontos centrais
    public double[][]      matrPC;
    public boolean         onLnPC = false;  // matrPC carregada (true/false);
    // Pontos Aleatórios
    private int            qtdePA; // Numero de pontos a serem criados
    public double[][][]    matrPA; // Pontos Gerados (vetor)
    
    
    
    
    
    
    
    public void iniciar(){
        upArqPC();
        this.dVetPC = matrPC[0].length;
        this.qtdePC = matrPC.length;
    }
 
    /**
    * Seta as variveis  de configuração
    * PC (Pontos Centrais)
    * PA (Pontos Aleatórios)
    * 
    * @param raioPC Raio (em volta dos PC) que serão cridos os PA;
    * @param qtdePA Quantos PA devem ser criados.
    * @return null
    */
    public void setConfig(double raioPC, int qtdePA){
        this.raioPC = raioPC;
        this.qtdePA = qtdePA;
        
        // Cria a Matriz de Pontos Aleatórios
        this.matrPA = new double[qtdePC][qtdePA][dVetPC];
    }
    private void upArqPC(){    
        try {
            BufferedReader arquivo;
            
            ArrayList<String[]> b = new  ArrayList();
            String      a;
            String[]    c= null;
            int nroY, nroX;
            
            arquivo = new BufferedReader(new FileReader("/home/pedro/pontos.txt"));
        
            while(arquivo.ready()){
             
                a  = arquivo.readLine();
                c  = a.split(",");
                b.add(c);
            }
            nroX = c.length;
            nroY = b.size();
            
            matrPC = new double[nroY][nroX];
                
            for(int c1=0; c1< nroY; c1++){
                c = b.get(c1);
                for(int c2=0; c2< nroX ; c2++){
                    matrPC[c1][c2] =  Double.parseDouble(c[c2]);
                }
            }
            
            arquivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(matrPC.length>0){
            onLnPC = true;
        }
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