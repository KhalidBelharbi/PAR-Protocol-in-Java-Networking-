package Serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import Commun.Trame;
import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
/**
* Copyright - This code contains a watermark for the author
* @author Khalid Belharbi
*/
public class Server {

    
    //InetAddress InetClient;
    
    
    //   datagrammes
    
    DatagramSocket socketUDP;
    DatagramPacket paquetUDP;
    static final int port=49499;
    ByteArrayInputStream ArrayIn;  // la réception des vecteurs Bytes
    ObjectInputStream ReaderObj;   // pour la conversion d'un Byte vers un Objet
    byte[] data;
    ByteArrayOutputStream ArrayOut;
    ObjectOutputStream WriterOut;
    
    faceServer ref;
    
    
    
    
            
	String msgRecu;
	
	
        
        int Trame_Attendu=0;
        
public Server(faceServer ref){
           
            data=new byte[512];
        try {
              
            this.ref=ref;
            
            ref.ser=this;
             
            this.ref.TA1.setText(Trame_Attendu+"");
             
            
            this.paquetUDP=new DatagramPacket(data,data.length);
            
            this.socketUDP=new DatagramSocket(port);
            
      
         while(true){   
           this.socketUDP.receive(this.paquetUDP); // réception
            
          
         this.ArrayIn=new ByteArrayInputStream(this.paquetUDP.getData());
         ReaderObj=new ObjectInputStream(ArrayIn);
         Object obj=ReaderObj.readObject();
         if(obj instanceof String){
              msgRecu=(String)  obj;
              
               SauveGardeTrameRecu=new Trame(msgRecu);
               this.ref.JTextTrameRecu1.setText(this.ref.JTextTrameRecu1.getText()+"\n ***** \n"+SauveGardeTrameRecu.getTrameStringWithCRC32()+"\n");

               
              if(this.ref.isCorrect(SauveGardeTrameRecu.getTrameString(),Long.valueOf(SauveGardeTrameRecu.getTrameStringWithCRC32().split("§")[4].trim()))){
                 
                  this.ref.CrcCorrectLabel.setVisible(true);
                  //this.ref.CrcCorrectLabel.setText("Correct");
                  this.ref.CrcCorrectLabel.setForeground(Color.GREEN);
                  this.ref.jButton1.setEnabled(true);
                   this.ref.CrcIncorrect.setVisible(false);
                  
                  
              } else{
                   this.ref.CrcIncorrect.setVisible(true);
                //  this.ref.CrcIncorrect.setText("Incorrect");
                  this.ref.CrcIncorrect.setForeground(Color.RED);
                  this.ref.jButton1.setEnabled(false);
                  this.ref.CrcCorrectLabel.setVisible(false);
                  
              }
                                 this.ref.CrcCorrectLabel.repaint();

                  this.ref.setCRC(SauveGardeTrameRecu.getCRC32());  
               

//*************************** si nous voulons n'utilisent pas le bouton d'acquitement   ************************************
//               if(SauveGardeTrameRecu.SEQ_FIELD==Integer.valueOf(this.Trame_Attendu)){
//                        this.ref.JTextInfoPaquet.setText(SauveGardeTrameRecu.Data.getInfo()+" \n");
//                        
//                                                   
//                        Trame_Attendu=1-Trame_Attendu;
//                        this.ref.TA1.setText(Trame_Attendu+"");
//                        
//                    }
//                this.ref.ACK_Envoyer.setText(1-Trame_Attendu+"");
//                    
//              Vers_Couche_Physique(Integer.valueOf(1-Trame_Attendu)) ;
//*************************************************************************************************************************               
               
               
               
               
         }
         
         
           
            
            
                    
            
            
         }  
            
            
            
            
            
            
        } catch (SocketException ex) {
ex.printStackTrace();
        
        
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
            
            
            
             }
     
	public void increment(int x){
        x=1-x;
        
    }

    
        
       public Trame SauveGardeTrameRecu; 
        
    public void faireTraitement(Trame t){
         
        
       if(SauveGardeTrameRecu.SEQ_FIELD==Integer.valueOf(this.Trame_Attendu)){
                        this.ref.JTextInfoPaquet.setText(SauveGardeTrameRecu.Data.getInfo()+" \n");
                        
                                                   
                        Trame_Attendu=1-Trame_Attendu;
                        this.ref.TA1.setText(Trame_Attendu+"");
                        
                    }
                this.ref.ACK_Envoyer.setText(1-Trame_Attendu+"");
                    
              Vers_Couche_Physique(Integer.valueOf(1-Trame_Attendu)) ;
                    
        
        
        
    }
        
        
        
        
        
        
        
        
        
        
        
    
     public void Vers_Couche_Physique (Integer trm){
          try {
         
         byte[] ackArray=new byte[512];
       // ackArray[0]=trm.byteValue();
        ArrayOut=new ByteArrayOutputStream();
        WriterOut=new ObjectOutputStream(ArrayOut);
         
        WriterOut.writeObject(trm);
                
                ackArray=ArrayOut.toByteArray();
                this.paquetUDP.setData(ackArray);
                this.socketUDP.send(this.paquetUDP);
                
                
           
            } catch (IOException ex) {
            }
        
        
        
        
    }
    
	
}
