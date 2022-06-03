/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aitumourclasification;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author mortimer
 */
public class Visualisation extends javax.swing.JFrame {

    /**
     * Creates new form HumannVsAiMnist
     */
    JLabel[][]pixel= new JLabel[224][224];
   // JLabel[][]colourImage;
    NeuralNetwork net;
    double[][]testData;
    int ind=0;

    public Visualisation(){
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        compGuess = new javax.swing.JTextField();
        nextBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        computerScoreTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        totalViewedTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        accuracyOverallTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        correctAnswerTxt = new javax.swing.JTextField();
        exitBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        correctSoFarTxt = new javax.swing.JTextField();
        yayOrNayLbl = new javax.swing.JLabel();
        outConfTxt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        benignTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        malignantTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel1KeyReleased(evt);
            }
        });

        jLabel1.setText("Computer Guess");

        compGuess.setEditable(false);

        nextBtn.setText("Next Image");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Total computer got correct");

        computerScoreTxt.setEditable(false);
        computerScoreTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computerScoreTxtActionPerformed(evt);
            }
        });

        jLabel4.setText("Total Images Viewed");

        totalViewedTxt.setEditable(false);
        totalViewedTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalViewedTxtActionPerformed(evt);
            }
        });

        jLabel5.setText("Overall Accuracy Of Network (tested across whole data set) (%)");

        accuracyOverallTxt.setEditable(false);

        jLabel6.setText("Correct Answer");

        correctAnswerTxt.setEditable(false);

        exitBtn.setText("Menu");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Correct so far (%)");

        correctSoFarTxt.setEditable(false);

        outConfTxt.setEditable(false);

        jLabel17.setText("Confidence in answer(%) - higher percent = more confident");

        benignTxt.setEditable(false);

        jLabel7.setText("Confidence (%) that tumour is");

        jLabel8.setText("Benign (Non-cancerous)");

        jLabel9.setText("Malignant (Cancerous)");

        malignantTxt.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(outConfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(benignTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(malignantTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(correctAnswerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(yayOrNayLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(273, 273, 273)
                                    .addComponent(nextBtn))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(101, 101, 101)
                                    .addComponent(exitBtn)
                                    .addGap(21, 21, 21))))
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(totalViewedTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(computerScoreTxt))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(accuracyOverallTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(171, 171, 171))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(correctSoFarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(compGuess, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(161, 161, 161))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accuracyOverallTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(computerScoreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalViewedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(correctSoFarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yayOrNayLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(correctAnswerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(compGuess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(benignTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(malignantTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(exitBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextBtn)
                    .addComponent(outConfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void computerScoreTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computerScoreTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_computerScoreTxtActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        // TODO add your handling code here:
        this.nextBtn.setEnabled(true);
        this.setImage();

        
        
        
    }//GEN-LAST:event_nextBtnActionPerformed

    private void totalViewedTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalViewedTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalViewedTxtActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        MenuUI men = new MenuUI();
        men.init(net);
        men.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_exitBtnActionPerformed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_formKeyReleased

    private void jPanel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel1KeyReleased

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
     // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */

    public void begin(NeuralNetwork net){
        this.testData=NeuralNetwork.shuffleTrainingDataArray(AITumourClasification.getTestData());
        this.net=net;
        int width=1;
        int height=1;
        this.getRootPane().setDefaultButton(nextBtn);
       // JLabel colourImage[][]=new JLabel[224][224];
        for(int y=0;y<224;y++){
            for(int x =0;x<224;x++){
              //  colourImage[y][x]=new JLabel();colourImage[y][x].setText("");colourImage[y][x].setSize(width,height);
                pixel[y][x]=new JLabel();
                //pixel[y][x].setText("");
                pixel[y][x].setSize(width, height);
                pixel[y][x].setOpaque(true);
                //System.out.println("black "+black+" white "+white+" val "+val);
                //pixel[y][x].setBackground(Color.red);
            //    colourImage[y][x].setBackground(Color.yellow);
             //   this.jPanel1.add(colourImage[y][x]);
             pixel[y][x].setLocation(x*width+width, y*height+height);
                this.jPanel1.add(pixel[y][x]);
               
                //pixel[y][x].setVisible(true);
             //   colourImage[y][x].setLocation(224*width+gapBetweenColourAndGray, y*height+height);
              //  colourImage[y][x].setVisible(true);colourImage[y][x].setOpaque(true);
            }
        }
        //yayOrNayLbl.setVisible(true);
        yayOrNayLbl.setOpaque(true);
        /*double[] acc=this.net.testAccuracy(testData);
        if(acc[0]==(9874.0/10000.0)*100.0){
            accuracyOverallTxt.setText("98.74");
        }else{
            accuracyOverallTxt.setText(String.valueOf(acc[0]));
        }*/accuracyOverallTxt.setText(String.valueOf(100.0*545.0/660.0)); //THIS IS COMMENTED OUT TO OPTIMISE LOADING TIME OF TOOL, UNCOMMENT THIS IF CODING GENERAL NETWORK WHERE ACCURACY IS NOT ALREADY KNOWN!!!
        
        totalViewedTxt.setText("0");
        computerScoreTxt.setText("0");
      //  this.colourImage=colourImage;
        this.setImage();



    }
    public  void setImage(){
            int indexCorrect=0;
            if(ind==testData.length){
                ind=0;
            }
            if(testData[ind][1]>testData[ind][0]){
                indexCorrect=1;
            }
            if(indexCorrect==1){
                correctAnswerTxt.setText("Benign");
            }else{
                correctAnswerTxt.setText("Malignant");
            }
            double[]in = new double[AITumourClasification.WIDTH_OF_DATA-2];
            for(int i =2;i<testData[0].length;i++){
                in[i-2]=testData[ind][i];
            }
            double[]out = this.net.feedThroughNet(in);
            String b=String.valueOf(out[1]*100.0);String m=String.valueOf(out[0]*100.0);
            String buff="";
            for(int cha =0;cha<5&&cha<m.length();cha++){
                buff=buff+String.valueOf(m.charAt(cha));
            }m=buff;buff="";
            for(int cha =0;cha<5&&cha<b.length();cha++){
                buff=buff+String.valueOf(b.charAt(cha));
            }b=buff;
            malignantTxt.setText(m);benignTxt.setText(b);
            int compInd=0;
            if(out[1]>out[0]){
                compInd=1;
            }
            outConfTxt.setText(String.valueOf(out[compInd]*100.0));
            if(compInd==1){
                compGuess.setText("Benign");
            }else{
                compGuess.setText("Malignant");
            }
            if(compInd==indexCorrect){
                computerScoreTxt.setText(String.valueOf(Integer.parseInt(computerScoreTxt.getText())+1));
                yayOrNayLbl.setBackground(Color.green);
            }else{
                yayOrNayLbl.setBackground(Color.red);
            }

            int index=0;int red,g,bl;
            Color r;
                for(int y=0;y<224;y++){
                    for(int x=0;x<224;x++){
                        red=(int)((in[index]-AITumourClasification.BIAS_TO_DATA)*AITumourClasification.NORMALISE_VALUE);index++;
                        bl = (int)((in[index]-AITumourClasification.BIAS_TO_DATA)*AITumourClasification.NORMALISE_VALUE);index++;
                        g=(int)((in[index]-AITumourClasification.BIAS_TO_DATA)*AITumourClasification.NORMALISE_VALUE);index++;
                        r = new Color(red, g, bl);
                        this.pixel[y][x].setBackground(r);
                        //valOfPix=(int)((in[index])*AITumourClasification.NORMALISE_VALUE);
                       // index++;
                  //      f= new File(path);
                 //       img=ImageIO.read(f);
                //        c = new Color(img.getRGB(x, y));
                   //     this.colourImage[y][x].setBackground(c);
                       // val =  (valOfPix*(DIFF_D/255.0))+BLACK;
                      //  int valNew=(int)Math.round(val);

                        //Color r = new Color(valNew);
                      //  r = new Color(valOfPix);
                        //this.pixel[y][x].setBackground(r);
                    }
                }
        totalViewedTxt.setText(String.valueOf(Integer.parseInt(totalViewedTxt.getText())+1));
        double co=Double.parseDouble(computerScoreTxt.getText())/Double.parseDouble(totalViewedTxt.getText());
        co=co*100.0;
        String ca="";
        for(int ch=0;ch<String.valueOf(co).length()&&ch<5;ch++){
            ca=ca+String.valueOf(co).charAt(ch);
        }
        correctSoFarTxt.setText(ca);
        ind++;
    }
  
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
            java.util.logging.Logger.getLogger(Visualisation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visualisation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visualisation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visualisation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Visualisation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accuracyOverallTxt;
    private javax.swing.JTextField benignTxt;
    private javax.swing.JTextField compGuess;
    private javax.swing.JTextField computerScoreTxt;
    private javax.swing.JTextField correctAnswerTxt;
    private javax.swing.JTextField correctSoFarTxt;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField malignantTxt;
    private javax.swing.JButton nextBtn;
    private javax.swing.JTextField outConfTxt;
    private javax.swing.JTextField totalViewedTxt;
    private javax.swing.JLabel yayOrNayLbl;
    // End of variables declaration//GEN-END:variables
}