package com.hokumus.beans;



import java.util.List;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.hokumus.dao.ProductDAO;
import com.hokumus.model.Product;


@SuppressWarnings("deprecation")
@ManagedBean(name = "urunEklemeBean")
@SessionScoped
public class UrunEklemeBean {

		private List<Product> listeUrun;
		
		private Product urun = new Product();
		
		private ProductDAO db = new ProductDAO();
		public UrunEklemeBean() {
		//	listeUrun = new ArrayList<>();
		//	
		//	tblurun item = new tblurun();
		//	
		//	item.setAd("Bilgisayar");
		//	item.setKod("bil0001mrv");
		//	item.setAciklama("Hp pavillion laptop i7 3,4ghz");
		//	db.kaydet(item);
		//	listeUrun.add(item);
		//	
		//	 item = new tblurun();
		//		
		//		item.setAd("Yazýcý");
		//		item.setKod("bil0002mrv");
		//		item.setAciklama("Lexmark 811");
		//		db.kaydet(item);
		//		listeUrun.add(item);
		//		
		//		 item = new tblurun();
		//		
		//			item.setAd("Monitör");
		//			item.setKod("bil0003mrv");
		//			item.setAciklama("Samsung 27' wide screen");
		//			db.kaydet(item);
		//			listeUrun.add(item);
		//			
		//			System.err.println("KAYIT TAMAM");
			
		}
	
		
		public void kaydet() {
			System.out.println("buradayým");
			saveMessage();
		}
		
		
		 public void saveMessage() {
		        FacesContext context = FacesContext.getCurrentInstance();
		         
		        context.addMessage(null, new FacesMessage("Successful",  "Kayýt Yapýldý ") );
		        
		    }
		
		public Product getUrun() {
			return urun;
		}


		public void setUrun(Product urun) {
			this.urun = urun;
		}


		public List<Product> getListeUrun() {
			return db.listele(new Product());
		}

		public void setListeUrun(List<Product> listeUrun) {
			this.listeUrun = listeUrun;
		}
		
		
		
	
}
