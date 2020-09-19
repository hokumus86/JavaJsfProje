package com.hokumus.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.hokumus.model.LogModel;
import com.hokumus.model.Product;
import com.hokumus.util.MyHibernateUtil;
import com.hokumus.util.VtIsletimcisi;



public class ProductDAO extends VtIsletimcisi<Product>{

public void sil(int id) {
		ProductDAO item = new ProductDAO();
		Product cat = item.bul(id, new Product());
		cat.setSil_id(0);
		item.duzenle(cat);		
		
	}
	

public List<Product> araCategoriyeGore(int categoriid) {
     List<Product> listem;
    try{
    Session ss1 = MyHibernateUtil.getSessionFactory().openSession();
    Criteria cr = ss1.createCriteria(Product.class);
    cr.add(Restrictions.eq("kategori_id", categoriid));
    listem = cr.list();
    
    return listem;
    }catch(Exception ex){
          LogModel log = new LogModel();
      log.setSinif(Product.class.toString());
      log.setMethod("Kategoriye Göre Ara");
      Date dt = new Date();
      log.setTarih(dt);
      log.setHataicerigi(ex.toString());
     // logt.kayit(log);    
    return null;
    }
}

}
