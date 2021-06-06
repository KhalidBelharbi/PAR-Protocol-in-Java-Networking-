/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;


/**
* Copyright - This code contains a watermark for the author
* @author Khalid Belharbi
*/

public class MainServer {
   
    public static void main(String[] args){
     System.out.println("Main server");
        faceServer f=new faceServer();
        f.setVisible(true);
     Server  serv=new Server(f);
        
        
    }
    
    
    
    
    
    
    
    
    
}
