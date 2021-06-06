/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commun;

/**
* Copyright - This code contains a watermark for the author
* @author Khalid Belharbi
*/
public class Trame {
    
    
    private long checksum;
    
    
    final int TypeTrameData=1,TypeTrameControle=2;
    
  public  Paquet Data;
    
  public int type_TRAME,SEQ_FIELD,ACK_FIELD;
    
    
    public Trame(int ack,int seq,Paquet d){
        
        this.ACK_FIELD=ack;
        this.SEQ_FIELD=seq;
        this.Data=d;
        if(Data==null) this.type_TRAME=TypeTrameControle;
        else this.type_TRAME=TypeTrameData;
        
        
    }
     public Trame(int ack,int seq,Paquet d,long crc){
        
        this.ACK_FIELD=ack;
        this.SEQ_FIELD=seq;
        this.Data=d;
        if(Data==null) this.type_TRAME=TypeTrameControle;
        else this.type_TRAME=TypeTrameData;
        this.checksum=crc;
        
    }
    
    
    
    // création de trame 
    public String getTrameString(){
        
        return this.type_TRAME+"§"+this.ACK_FIELD+"§"+this.SEQ_FIELD+"§"+this.Data.getInfo();
        
    }
     public String getTrameStringWithCRC32(){
        
        return this.type_TRAME+"§"+this.ACK_FIELD+"§"+this.SEQ_FIELD+"§"+this.Data.getInfo()+"§"+this.checksum;
        
    }

    
    public Trame(String str){
        
        
        String[] tab=str.split("§");
        this.type_TRAME=Integer.valueOf(tab[0]);
        this.ACK_FIELD=Integer.valueOf(tab[1]);
        this.SEQ_FIELD=Integer.valueOf(tab[2]);
        this.Data=new Paquet(tab[3]);
        this.checksum=Long.valueOf(tab[4]);
        
    }
    
    
    
    
    
    
    public void setCRC32(long c){
        this.checksum=c;
    }
    
    
    public long getCRC32(){
        return this.checksum;
    }
    
    
    
    
}
