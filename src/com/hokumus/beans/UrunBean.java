package com.hokumus.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.hokumus.dao.CategoriDAO;
import com.hokumus.dao.ProductDAO;
import com.hokumus.model.Categori;
import com.hokumus.model.Product;
import com.hokumus.util.StaticValues;


@SuppressWarnings("deprecation")
@ManagedBean(name = "urunBean")
@SessionScoped
public class UrunBean {

	
	List<Product> listem = new ArrayList<>();
	List<Categori> listeC = new ArrayList<>();
	private String ad;
	private String fiyat;
	private int kategoriid;
	private String aciklama;
	private String kategoriadi;
	private int silinecekid=0;
	private int urunid;
	private String ortalan="urunlistesi.xhtml";
	private Product urun = new Product();
	ProductDAO DataB = new ProductDAO();
		
	CategoriDAO dao = new CategoriDAO();
	
	public void urunsec() {
	urun = DataB.bul(urunid, new Product());
	StaticValues.secilenurun = urunid;	
	ortalan = "urundetails.xhtml";
	}
	
	
	public void kaydet() {
		
		Product item = new Product();
		item.setAciklama(aciklama);
		item.setAd(ad);
		item.setFiyat(fiyat);
		item.setKategori_id(kategoriid);
		item.setSil_id(1);
		DataB.kaydet(item);
		ad="";
		fiyat="";
		kategoriid=0;
		aciklama="";
		
		
	}
	
	public void sil() {
		
		if(silinecekid!=0) {
			
			DataB.sil(silinecekid);
			silinecekid=0;
		}
		
	}
	
	
	
	
	public Product getUrun() {
		return urun;
	}


	public void setUrun(Product urun) {
		this.urun = urun;
	}


	public String getOrtalan() {
		return ortalan;
	}


	public void setOrtalan(String ortalan) {
		this.ortalan = ortalan;
	}


	public int getUrunid() {
		return urunid;
	}


	public void setUrunid(int urunid) {
		this.urunid = urunid;
	}


	public int getSilinecekid() {
		return silinecekid;
	}

	public void setSilinecekid(int silinecekid) {
		
		this.silinecekid = silinecekid;
	}

	public String getKategoriadi() {
		return kategoriadi;
	}



	public void setKategoriadi(String kategoriadi) {
		this.kategoriadi = kategoriadi;
	}



	public String getAd() {
		return ad;
	}


	public void setAd(String ad) {
		this.ad = ad;
	}


	public String getFiyat() {
		return fiyat;
	}


	public void setFiyat(String fiyat) {
		this.fiyat = fiyat;
	}


	public int getKategoriid() {
		return kategoriid;
	}


	public void setKategoriid(int kategoriid) {
		this.kategoriid = kategoriid;
	}


	public String getAciklama() {
		return aciklama;
	}


	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}


	public List<Categori> getListeC() {
		return dao.listA(new Categori());
	}


	public void setListeC(List<Categori> listeC) {
		this.listeC = listeC;
	}


		public List<Product> getListem() {
		return DataB.listA(new Product());
	}


	public void setListem(List<Product> listem) {
		this.listem = listem;
	}

	
	
	
	
	
	

	
		
}
