package com.hokumus.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hokumus.model.LogModel;

public class MyLogtakip {

	 Session ss;
	    
	    public void kayit(LogModel lg){
	        try{
	              ss = MyHibernateUtil.getSessionFactory().openSession();
	              if(ss.isConnected())
	              dbKayit(lg);             

	            //  fileKayit(lg);
	        }
	        catch(Exception ex){
	           //   fileKayit(lg);
	        }

	    }
	    
	    
	    private boolean dbKayit(LogModel lg){
	        Transaction tt = ss.beginTransaction();
	        ss.save(lg);
	        tt.commit();
	        ss.close();
	    return true;
	    }
	    
	    private boolean fileKayit(LogModel lg){
	        try{
	        File fl = new File("src//main/java//com//erenresortmvn//LogFiles//log.txt");
	            BufferedWriter bf = new BufferedWriter(new FileWriter(fl,true));
	            bf.append("Tarih..: "+lg.getTarih()+":"+
	                    "Sýnýf....: "+lg.getSinif()+":"+
	                    "Method...: "+lg.getMethod()+":"+
	                    "Hata.....: "+lg.getHataicerigi()
	                    );
	            bf.newLine();
	            bf.close();
	            
	            return true;
	        }
	        catch(Exception ex){
	            System.err.println("Hata...:"+ex.toString());
	        return false;
	        }
	        
	    
	    }
	    
	
}
