package com.hokumus.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.hokumus.dao.ProductDAO;
import com.hokumus.model.Product;
import com.hokumus.util.StaticValues;

@SuppressWarnings("deprecation")
@ManagedBean(name = "urunDetailBean")
@SessionScoped
public class UrunDetailBean {

	ProductDAO DB = new ProductDAO();
	
	private Product urun= new Product();

	public UrunDetailBean() {
		System.out.println("gelen id...:"+ StaticValues.secilenurun);
		urun = DB.bul(StaticValues.secilenurun, new Product());
	}
	
	public Product getUrun() {
		
		return urun;
	}

	public void setUrun(Product urun) {
		this.urun = urun;
	}
	
	
	
	
}
