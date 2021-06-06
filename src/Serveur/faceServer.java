/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;

import Commun.Trame;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.CRC32;
import javax.swing.*;
/**
* Copyright - This code contains a watermark for the author
* @author Khalid Belharbi
*/
public class faceServer extends javax.swing.JFrame {

    
   public Server ser;
    

     ObjectInputStream inS=null;
    ObjectOutputStream outS=null;
    
            static final int port=49490;

    /**
     * Creates new form faceServer
     */
            
            
            
            
    public faceServer() {
    
     
        
                initComponents();
                
        
                
                this.setBounds(700,50,632,538);
        this.setResizable(false);
         this.setIconImage(new ImageIcon(this.getClass().getResource("/srcc/n.png")).getImage());
                this.setTitle(" Belharbi Khaled G02 - Protocole PAR ");
        
        this.CrcCorrectLabel.setVisible(false);
        this.CrcIncorrect.setVisible(false);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTextInfoPaquet = new javax.swing.JTextArea();
        ACK_Envoyer = new javax.swing.JTextField();
        TA1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTextTrameRecu1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        CheckSumField = new javax.swing.JTextField();
        CrcCorrectLabel = new javax.swing.JLabel();
        CrcIncorrect = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JTextInfoPaquet.setBackground(new java.awt.Color(0, 0, 0));
        JTextInfoPaquet.setColumns(20);
        JTextInfoPaquet.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        JTextInfoPaquet.setForeground(new java.awt.Color(255, 255, 255));
        JTextInfoPaquet.setRows(3);
        JTextInfoPaquet.setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.setViewport(new MyViewport());
        jScrollPane1.setViewportView(JTextInfoPaquet);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 220, 440, 110);

        ACK_Envoyer.setEditable(false);
        ACK_Envoyer.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        ACK_Envoyer.setForeground(new java.awt.Color(255, 255, 255));
        ACK_Envoyer.setBorder(null);
        ACK_Envoyer.setFocusable(false);
        ACK_Envoyer.setOpaque(false);
        getContentPane().add(ACK_Envoyer);
        ACK_Envoyer.setBounds(430, 477, 180, 30);

        TA1.setEditable(false);
        TA1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        TA1.setForeground(new java.awt.Color(255, 255, 255));
        TA1.setBorder(null);
        TA1.setFocusable(false);
        TA1.setOpaque(false);
        getContentPane().add(TA1);
        TA1.setBounds(40, 480, 180, 30);

        JTextTrameRecu1.setColumns(20);
        JTextTrameRecu1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        JTextTrameRecu1.setForeground(new java.awt.Color(255, 255, 255));
        JTextTrameRecu1.setRows(3);
        JTextTrameRecu1.setBorder(null);
        JTextTrameRecu1.setOpaque(false);
        jScrollPane2.setOpaque(false);
        jScrollPane2.setViewport(new MyViewport());
        jScrollPane2.setViewportView(JTextTrameRecu1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(100, 80, 440, 110);

        jButton1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(280, 340, 80, 90);

        CheckSumField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        CheckSumField.setForeground(new java.awt.Color(255, 255, 255));
        CheckSumField.setBorder(null);
        CheckSumField.setEnabled(false);
        CheckSumField.setOpaque(false);
        getContentPane().add(CheckSumField);
        CheckSumField.setBounds(240, 480, 170, 30);

        CrcCorrectLabel.setBackground(new java.awt.Color(0, 153, 0));
        CrcCorrectLabel.setFont(new java.awt.Font("Adobe Devanagari", 1, 14)); // NOI18N
        CrcCorrectLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srcc/Vert.png"))); // NOI18N
        CrcCorrectLabel.setVisible(false);
        getContentPane().add(CrcCorrectLabel);
        CrcCorrectLabel.setBounds(380, 430, 30, 20);

        CrcIncorrect.setBackground(new java.awt.Color(0, 153, 0));
        CrcIncorrect.setFont(new java.awt.Font("Adobe Devanagari", 1, 14)); // NOI18N
        CrcIncorrect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srcc/Rouj.png"))); // NOI18N
        CrcCorrectLabel.setVisible(false);
        getContentPane().add(CrcIncorrect);
        CrcIncorrect.setBounds(240, 430, 40, 20);

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srcc/Finale.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-10, 0, 640, 510);

        pack();
    }// </editor-fold>                        
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      
        
     this.ser.faireTraitement(this.ser.SauveGardeTrameRecu);
        
    
        
        
        
    }                                        

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {                                      

        
        this.jLabel5.setIcon(new ImageIcon(this.getClass().getResource("/srcc/EffectButton.png")));
        
        
        
        
    }                                     

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {                                     
        this.jLabel5.setIcon(new ImageIcon(this.getClass().getResource("/srcc/Finale.png")));
    }                                    

    // Variables declaration - do not modify                     
    public javax.swing.JTextField ACK_Envoyer;
    private javax.swing.JTextField CheckSumField;
    public javax.swing.JLabel CrcCorrectLabel;
    public javax.swing.JLabel CrcIncorrect;
    public javax.swing.JTextArea JTextInfoPaquet;
    public javax.swing.JTextArea JTextTrameRecu1;
    public javax.swing.JTextField TA1;
    public javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration                   



public void setCRC(long k){
    this.CheckSumField.setText(k+"");
}

public boolean isCorrect(String s,long crc){
    
    byte[] vect=s.getBytes();
    CRC32 x=new CRC32();
    x.update(vect);
    long vvv=x.getValue();
   
    if(vvv==crc) return true;
    else return false;
    
}




}

class MyViewport extends JViewport {

    public MyViewport() {
        this.setOpaque(false);
       
    }
}