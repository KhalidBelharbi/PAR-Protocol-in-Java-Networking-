/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commun;

import Client.faceClient;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
* Copyright - This code contains a watermark for the author
* @author Khalid Belharbi
*/
public class TimerDescrement  extends TimerTask{

    Integer delai;
    JTextField field;
    
    faceClient ref;
    
    public TimerDescrement(int d,JTextField field,faceClient ref){
        this.ref=ref;
        delai=d;
        this.field=field;
        
    }
    
    
    @Override
   public void run()
            {
                
                if(delai>0){
                                   this.delai--;
                                   this.field.setText(String.valueOf(delai));
                           
                }
                else{
                    //  TimeOutEvent
                    
                    this.ref.timeOut();
                    
                    
                }
//                this.cancel();
                
            }
    
}
