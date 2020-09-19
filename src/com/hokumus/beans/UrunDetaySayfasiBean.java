package com.hokumus.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.hokumus.dao.ProductDAO;
import com.hokumus.model.Product;
import com.hokumus.util.StaticValues;

@SessionScoped
@ManagedBean(name = "urunDetaySayfasiBean")
public class UrunDetaySayfasiBean {
	
	ProductDAO DB = new ProductDAO();
	
	private Product urunbilgisi;

	public Product getUrunbilgisi() {
		return DB.bul(StaticValues.secilenurun, new Product());
	}

	public void setUrunbilgisi(Product urunbilgisi) {
		this.urunbilgisi = urunbilgisi;
	}
	
	
	
	
}
