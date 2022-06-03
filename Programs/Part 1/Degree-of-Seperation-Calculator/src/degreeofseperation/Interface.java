/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package degreeofseperation;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author mortimer
 */
public class Interface extends javax.swing.JFrame {

    static String[][]moviesFile;
    static String[][]peopleFile;
    static String[][]starsFile;
    static String personStar[][];
    static String namePer[][];
    final String MOVIE_FILE_NAME="movies.txt";
    final String PEOPLE_FILE_NAME="people.txt";
    final String STAR_FILE_NAME="stars.txt";
    final String PERSON_STAR="personStar.txt";
    final String NAME_PERSONID="namePerson.txt";
    final static String SPLIT=",";
    public Interface() {
        initComponents();
        loadDataAsArray();
        this.rootPane.setDefaultButton(runBtn);
            searchTypeBtn.setText("Breadth First Search");
            label.setText("Optimal Solution Guaranteed");label.setForeground(Color.green);
    }
    public  String[][]getAsSplitArray(String fileName,int width){
        String[][]ret;
        try{
            FileReader read =new FileReader(fileName);
            BufferedReader buffRead = new BufferedReader(read);
            Object[]f=buffRead.lines().toArray();
            ret=new String[f.length-1][width];
            String[]buf;
            for(int y=1;y<f.length;y++){
                buf=f[y].toString().split(SPLIT);
                for(int x=0;x<Math.min(buf.length,width);x++){
                    ret[y-1][x]=buf[x];
                    if(buf[x]==null){
                        ret[y-1][x]="";
                    }
                }for(int x=buf.length;x<width;x++){
                    ret[y-1][x]="";
                }
            }
            return ret;
        }catch(IOException e){
            JOptionPane.showMessageDialog(this,"Error with file "+fileName+" : "+e);
        }
        return new String[0][0];
    }
    public void generatePersonStarFile(){
        String[][]newF=Sort.mergeSort(starsFile);
        try{
            FileWriter write = new FileWriter(PERSON_STAR,false);
            BufferedWriter buffWrite = new BufferedWriter(write);
            buffWrite.write("personID"+SPLIT+"MoveId");
            for(int i=0;i<newF.length;i++){
                buffWrite.newLine();
                buffWrite.write(newF[i][0]+SPLIT+newF[i][1]);
            }
            buffWrite.flush();write.flush();
            buffWrite.close();write.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(this,"Error with file "+e);
        }
    }
        public void generateNamePersonFile(){
        String newPer[][]=new String[peopleFile.length][3];
        for(int y=0;y<newPer.length;y++){
            newPer[y][1]=peopleFile[y][0];
            newPer[y][0]=peopleFile[y][1];
            newPer[y][2]=peopleFile[y][2];
        }
        newPer=Sort.mergeSort(newPer);
        try{
            FileWriter write = new FileWriter(NAME_PERSONID,false);
            BufferedWriter buffWrite = new BufferedWriter(write);
            buffWrite.write("Name"+SPLIT+"Person"+SPLIT+"birth");
            for(int i=0;i<newPer.length;i++){
                buffWrite.newLine();
                String w="";
                if(newPer[i][2]!=null){
                    w=newPer[i][2];
                }
                buffWrite.write(newPer[i][0]+SPLIT+newPer[i][1]+SPLIT+w);
            }
            buffWrite.flush();write.flush();
            buffWrite.close();write.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(this,"Error with file "+e);
        }
    }
    public void generateStarProperly(){
        try{
            FileWriter write = new FileWriter(STAR_FILE_NAME,false);
            BufferedWriter buffWrite = new BufferedWriter(write);
            buffWrite.write("moveId"+SPLIT+"Person");
            for(int y=0;y<starsFile.length;y++){
                buffWrite.newLine();
                buffWrite.write(starsFile[y][1]+SPLIT+starsFile[y][0]);
            }
                        buffWrite.flush();write.flush();
            buffWrite.close();write.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(this,"Error with file "+e);
        }
    }
    public  void fixFileSoSortedByPkProperly(String fileName, int width){
       
         try{
           FileReader read = new FileReader(fileName);
           BufferedReader buffRead = new BufferedReader(read);
            String heading=buffRead.readLine();
            buffRead.close();read.close();
            String f [][]=getAsSplitArray(fileName,width);
            f=Sort.mergeSort(f);
            FileWriter write = new FileWriter(fileName,false);
            BufferedWriter buffWrite=new BufferedWriter(write);
            buffWrite.write(heading);
            for(int y=0;y<f.length;y++){
                buffWrite.newLine();
                String cont="";
                for(int x=0;x<f[0].length;x++){
                    if(f[y][x]==null){
                        if(x==0){
                            cont="";
                        }else{
                            cont=cont+SPLIT+"";
                        }
                    }else{
                        String n="";
                            for(int c=0;c<f[y][x].length();c++){
                                if(f[y][x].charAt(c)=='"'){
                                    
                                }else{
                                    n=n+f[y][x].charAt(c);
                                }
                            }
                        if(x==0){

                            cont=n;
                        }else{
                            cont=cont+SPLIT+n;
                        }
                    }
                }
                buffWrite.write(cont);
            }
                                    buffWrite.flush();write.flush();
            buffWrite.close();write.close();
       }catch(IOException e){
           JOptionPane.showMessageDialog(this,"Error with file "+e);
       }
    }
    public void generatePersonStarCorrect(){
        String buff;
        for(int y=0;y<personStar.length;y++){
            buff=personStar[y][0];
            personStar[y][0]=personStar[y][1];
            personStar[y][1]=buff;
        }
        personStar=Sort.mergeSort(personStar);
        try{
            FileWriter write = new FileWriter(PERSON_STAR,false);
            BufferedWriter buffWrite = new BufferedWriter(write);
            buffWrite.write("PersonID"+SPLIT+"MovId");
            for(int y=0;y<personStar.length;y++){
                buffWrite.newLine();
                buffWrite.write(personStar[y][0]+SPLIT+personStar[y][1]);
            }
                                   buffWrite.flush();write.flush();
            buffWrite.close();write.close(); 
        }catch(IOException e){
                    JOptionPane.showMessageDialog(this,"Error with file "+e);
        }
    }
    public void loadDataAsArray(){
        
  //   fixFileSoSortedByPkProperly(MOVIE_FILE_NAME, 3);
  //fixFileSoSortedByPkProperly(PEOPLE_FILE_NAME, 3);
        
     //   starsFile=getAsSplitArray(STAR_FILE_NAME, 2);
  //generateStarProperly();
  //  starsFile=getAsSplitArray(STAR_FILE_NAME, 2);
    // fixFileSoSortedByPkProperly(STAR_FILE_NAME, 2);
   starsFile=getAsSplitArray(STAR_FILE_NAME, 2);
        moviesFile=getAsSplitArray(MOVIE_FILE_NAME, 3);
        peopleFile=getAsSplitArray(PEOPLE_FILE_NAME, 3);
  //  generateNamePersonFile();
  //    generatePersonStarFile();
    //  fixFileSoSortedByPkProperly(PERSON_STAR, 2);
  //fixFileSoSortedByPkProperly(NAME_PERSONID, 3);
        personStar=getAsSplitArray(PERSON_STAR, 2);
        namePer=getAsSplitArray(NAME_PERSONID, 3);
   //     generatePersonStarCorrect();
            
    }
    public  String[] getAllFilmsWithStar(String starId){
                int el =Search.searchForRecordWithPrimaryKeyAtNoughtElementReturnElement(personStar, starId);
        int lowest=el;
        int i;
        for( i=el-1;i>=0;i--){
            if(!personStar[i][0].equals(starId)){

                break;
            }else{
                lowest=i;
            }
        }
        String starIds="";
        for(int y=lowest;y<personStar.length;y++){
            if(!personStar[y][0].equals(starId)){
                break;
            }
            if(starIds.equals("")){
                starIds=personStar[y][1];
            }else{
                starIds=starIds+SPLIT+personStar[y][1];
            }

        }
        return starIds.split(SPLIT);
    }
    public static String getLinkingActors(String[]filmOneActors,String[]filmTwoActors){
        for(int i=0;i<filmOneActors.length;i++){
            for(int j=0;j<filmTwoActors.length;j++){
                if(filmOneActors[i].equals(filmTwoActors[j])){
                    return filmOneActors[i];
                }
            }
        }
        return"";
    }
    public static String[]getAllStarsInFilm(String filmId){
        int el =Search.searchForRecordWithPrimaryKeyAtNoughtElementReturnElement(starsFile, filmId);
        int lowest =el;
        int i ;
        for( i=el-1;i>=0;i--){
            if(!starsFile[i][0].equals(filmId)){
                break;
            }else{
                lowest =i;
            }
        }

        String starIds="";
        for(int y=lowest;y<starsFile.length;y++){
            if(starsFile[y][0].equals(filmId)==false){
                break;
            }
            if(starIds.equals("")){
                starIds=starsFile[y][1];
            }else{
                starIds=starIds+SPLIT+starsFile[y][1];
            }
            
        }
        if(starIds.equals("")){
            return new String[0];
        }
        return starIds.split(SPLIT);
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTxt = new javax.swing.JTextArea();
        starOneTxt = new javax.swing.JTextField();
        starTwoTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchTypeBtn = new javax.swing.JToggleButton();
        runBtn = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        clearBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        outputTxt.setEditable(false);
        outputTxt.setColumns(20);
        outputTxt.setRows(5);
        jScrollPane1.setViewportView(outputTxt);

        jLabel1.setText("Star One Name");

        jLabel2.setText("Star Two Name");

        searchTypeBtn.setText("Breadth First Search");
        searchTypeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTypeBtnActionPerformed(evt);
            }
        });

        runBtn.setText("Run");
        runBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runBtnActionPerformed(evt);
            }
        });

        label.setForeground(new java.awt.Color(255, 51, 51));
        label.setToolTipText("");

        clearBtn.setText("Clear Text");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton1)
                        .addGap(427, 427, 427))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(starTwoTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                            .addComponent(starOneTxt, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(runBtn)
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(clearBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchTypeBtn)
                .addGap(26, 26, 26)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(starOneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(starTwoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchTypeBtn)
                            .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearBtn)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(runBtn))
                .addContainerGap())
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchTypeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTypeBtnActionPerformed
        if(searchTypeBtn.isSelected()){
            searchTypeBtn.setText("Depth First Search");
            label.setText("Optimal Solution not Guaranteed");
            label.setForeground(Color.red);
        }else{
            searchTypeBtn.setText("Breadth First Search");
            label.setText("Optimal Solution Guaranteed");label.setForeground(Color.green);
        }
    }//GEN-LAST:event_searchTypeBtnActionPerformed

    private void runBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runBtnActionPerformed
        boolean isDepth=searchTypeBtn.getText().equals("Depth First Search");
        
        String[] starOneId=Search.searchForRecordWithPrimaryKeyAtNoughtElement(namePer, starOneTxt.getText());
        if(starOneId[0]==null){
            JOptionPane.showMessageDialog(this, "Star one ("+starOneTxt.getText()+") was not found");
            return;
        }
        String []starTwoId=Search.searchForRecordWithPrimaryKeyAtNoughtElement(namePer, starTwoTxt.getText());
        if(starTwoId[0]==null){
            JOptionPane.showMessageDialog(this, "Star Two ("+starTwoTxt.getText()+") was not found");
            return;
        }
        double time = System.currentTimeMillis();
        String filmsWithStar[]=getAllFilmsWithStar(starOneId[1]);
        Node[]nodes = new Node[filmsWithStar.length];
        for(int i=0;i<nodes.length;i++){
            nodes[i]=new Node(null, filmsWithStar[i]);
        }
        Frontier front =new Frontier(isDepth, nodes);
        Node rem=null;
        boolean found=false;
        while(found==false){
            rem = front.removeNode();
            for(int star=0;star<rem.starsInFilm.length;star++){
                if(rem.starsInFilm[star].equals(starTwoId[1])){
                    found=true;
                    break;
                }
            }
            if(found){
                break;
            }
            for(int st=0;st<rem.starsInFilm.length;st++){
                String[] mov = getAllFilmsWithStar(rem.starsInFilm[st]);
                for(int m=0;m<mov.length;m++){
                    if(front.hasFilmBeenExplored(mov[m])==false){
                        front.addNode(new Node(rem, mov[m]));
                    }
                }
            }
            if(front.isFrontEmpty()){
                JOptionPane.showMessageDialog(this,"No link was found between two stars");
                return;
            }
        }
        int length=0;
        Node buff=rem;
        while(true){
            length++;
                buff=buff.getParent();
                if(buff==null){
                    break;
                }
        }

        Node[]path = new Node[length];
        int i=0;
        buff=rem;
        while(true){
                path[i]=buff;
                i++;
                buff=buff.getParent();
                if(buff==null){
                    break;
                }
 
        }

        String text="";
        String newLine=System.lineSeparator();
        String []movDet;
        String prevAct=starOneId[0];
        for(int j=path.length-2;j>=0;j--){
            if(j==path.length-2){
                movDet=Search.searchForRecordWithPrimaryKeyAtNoughtElement(moviesFile,path[j+1].filmId);
                text=starOneId[0]+" was in "+movDet[1]+" released in "+movDet[2];
                String act=Search.searchForRecordWithPrimaryKeyAtNoughtElement(peopleFile,getLinkingActors(path[j].getStarsInFilm(), path[j+1].getStarsInFilm()))[1];
                text=text+newLine+act+" was in "+movDet[1]+ " released in "+movDet[2];
           /*     String movDet2[]=Search.searchForRecordWithPrimaryKeyAtNoughtElement(moviesFile,path[j].filmId);
                text = text+newLine+act+" was in "+movDet[1]+" released in "+movDet[2];*/
                prevAct=act;
            }else{
                String act=Search.searchForRecordWithPrimaryKeyAtNoughtElement(peopleFile,getLinkingActors(path[j].getStarsInFilm(), path[j+1].getStarsInFilm()))[1];
                movDet=Search.searchForRecordWithPrimaryKeyAtNoughtElement(moviesFile,path[j+1].getFilmId());
                if(text.equals("")){
                    text=prevAct+" was in "+movDet[1]+" released in "+movDet[2];
                }else{
                    text=text+newLine+prevAct+" was in "+movDet[1]+" released in "+movDet[2];
                }
                text=text+newLine+act+" was in "+movDet[1]+" released in "+movDet[2];
                prevAct=act;
            }
        }
        movDet=Search.searchForRecordWithPrimaryKeyAtNoughtElement(moviesFile,path[0].getFilmId());
        if(text.equals("")){
            text =text+prevAct+" was in "+movDet[1]+" released in "+movDet[2];
        }else{
            text =text+newLine+prevAct+" was in "+movDet[1]+" released in "+movDet[2];
        }
        text =text+newLine+starTwoId[0]+" was in "+movDet[1]+" released in "+movDet[2];
        time = System.currentTimeMillis()-time;
        text = text+newLine+"Time explored (seconds): "+time/1000.0;
        text = text+newLine+"Degree of Seperation: "+path.length;
        if(isDepth){
            text = text +newLine+"Note: This is possibly but not necessarily the smallest degree of seperation based on the database used";
        }else{
            text = text +newLine+"Note: This is the smallest degree of seperation based on the database used";
        }
        outputTxt.setText(text);
    }//GEN-LAST:event_runBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        outputTxt.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JTextArea outputTxt;
    private javax.swing.JButton runBtn;
    private javax.swing.JToggleButton searchTypeBtn;
    private javax.swing.JTextField starOneTxt;
    private javax.swing.JTextField starTwoTxt;
    // End of variables declaration//GEN-END:variables
}
