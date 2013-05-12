/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;



/**
 *
 * @author Pedro Cesar <pc.freittas@gmail.com>
 */
public final class Main extends javax.swing.JFrame {
    
    MDRP iMDRP = new MDRP();
    private double pontUP[][];

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        tela_Centro();
        String t = "Sistema pronto. \nAdicione os pontos";
        jTextPane1.setText(t);

        
        
        
    }
    public void tela_Centro(){
        
        this.setResizable(false);
        java.awt.Dimension tam = this.getToolkit().getScreenSize();      
        int x = (int) ((tam.getWidth()  - this.getSize().getWidth() ) / 2);
        int y = (int) ((tam.getHeight() - this.getSize().getHeight()) / 2);
        this.setLocation(x,y); 
    }
    
    private void Grafico(){
    
        CategoryDataset cds;
        String titulo = "Problema 2D";
        String eixox = "X";
        String eixoy = "Y";
        boolean legenda = true;
        boolean tooltips = false;
        boolean urls = false;
        
        JFreeChart graf = ChartFactory.createScatterPlot(titulo, eixox, eixoy, datGraf(), PlotOrientation.HORIZONTAL, legenda, tooltips, urls);
        
        XYPlot xyPlot = (XYPlot) graf.getPlot();
        
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        XYItemRenderer renderer = xyPlot.getRenderer();
        renderer.setSeriesPaint(0, Color.blue);
        NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
        domain.setVerticalTickLabels(true);
                
        ChartPanel myChartPanel = new ChartPanel(graf, true);
        myChartPanel.setSize(jPanel1.getWidth(),jPanel1.getHeight());
        myChartPanel.setVisible(true);
        
        jPanel1.removeAll();
        jPanel1.add(myChartPanel);
        jPanel1.revalidate();
        jPanel1.repaint(); 
        
    }
    
    private XYDataset datGraf(){
        XYSeriesCollection xyDatCol = new XYSeriesCollection();
        XYSeries randPts = new XYSeries("PC");
        XYSeries added   = new XYSeries("Added");
        
        for(int c1=0; c1< pontUP.length; c1++){
            for(int c2=0; c2< pontUP[c1].length ; c2++){
                randPts.add(pontUP[c1][0],pontUP[c1][1]);
            }
        }
        
        for(int c1=0; c1< (iMDRP.matrPA).length; c1++){
            for(int c2=0; c2< (iMDRP.matrPA[c1]).length; c2++){
            added.add(iMDRP.matrPA[c1][c2][0],iMDRP.matrPA[c1][c2][1]);
            }
        }
        
        xyDatCol.addSeries(randPts);
        xyDatCol.addSeries(added);
        return xyDatCol;
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 217, 180));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 624, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(jTextPane1);

        jButton1.setText("Carregar Pontos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Gera Gráfico 2D");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Gerar Pontos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 776, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .add(jButton2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jButton3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jButton1)
                        .add(18, 18, 18)
                        .add(jButton3)
                        .add(18, 18, 18)
                        .add(jButton2))
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 164, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            BufferedReader arquivo;
            
            ArrayList<String[]> b = new  ArrayList();
            String      a;
            String[]    c = null;
            int nroY, nroX;
            
            arquivo = new BufferedReader(new FileReader("/home/pedro/pontos.txt"));
        
            while(arquivo.ready()){
             
                a  = arquivo.readLine();
                c  = a.split(",");
                b.add(c);
            }
            nroX = c.length;
            nroY = b.size();
            
            System.out.println("" + nroX);
            
            pontUP = new double[nroY][nroX];
                
            for(int c1=0; c1< nroY; c1++){
                c = b.get(c1);
                for(int c2=0; c2< nroX ; c2++){
                    pontUP[c1][c2] =  Double.parseDouble(c[c2]);
                }
            }
            
            arquivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        jTextPane1.setText("Dados carregados!!   ");
        
        jButton2.setEnabled(true);
        
        
//        for(int c1=0; c1< pontUP.length; c1++){
//            System.out.print("{");
//            for(int c2=0; c2< pontUP[c1].length ; c2++){
//                System.out.print(pontUP[c1][c2]);
//                if(c2!=(pontUP[c1].length)-1){
//                    System.out.print(", ");
//                }else{
//                    System.out.println("}");
//                }
//            }
//        }
        


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Grafico();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(pontUP.length>0){
            iMDRP.setConfig(this.pontUP, 10, 50);
            iMDRP.geraMatr();
        }
        else{
            System.out.println("Sem dados");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
