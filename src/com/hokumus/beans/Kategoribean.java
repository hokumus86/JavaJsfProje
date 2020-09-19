package com.hokumus.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.hokumus.dao.CategoriDAO;
import com.hokumus.model.Categori;
@SuppressWarnings("deprecation")
@ManagedBean(name = "kategoribean")
@SessionScoped
public class Kategoribean {

	private String kategoriadi;
	private List<Categori> klist = new ArrayList<>();
	private int silnecekid=0;
	CategoriDAO db = new CategoriDAO();
	
	public void ekle() {
		
		Categori model = new Categori();
		model.setAd(kategoriadi);
		model.setSil_id(1);
		db.kaydet(model);	
		kategoriadi="";
	}

	public void sil() {
		
		if(silnecekid!=0) {
			db.sil(silnecekid);			
		}
		
	}
	
	
	
	public int getSilnecekid() {
		return silnecekid;
	}

	public void setSilnecekid(int silnecekid) {
		this.silnecekid = silnecekid;
	}

	public CategoriDAO getDb() {
		return db;
	}

	public void setDb(CategoriDAO db) {
		this.db = db;
	}

	public String getKategoriadi() {
		return kategoriadi;
	}

	public void setKategoriadi(String kategoriadi) {
		this.kategoriadi = kategoriadi;
	}

	public List<Categori> getKlist() {
		return db.listA(new Categori());
	}

	public void setKlist(List<Categori> klist) {
		this.klist = klist;
	}
	
}
