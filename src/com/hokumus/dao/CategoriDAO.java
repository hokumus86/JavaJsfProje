package com.hokumus.dao;

import com.hokumus.model.Categori;
import com.hokumus.util.VtIsletimcisi;

public class CategoriDAO extends VtIsletimcisi<Categori> {

	public void sil(int id) {

		CategoriDAO item = new CategoriDAO();
		Categori cat = item.bul(id, new Categori());
		cat.setSil_id(0);
		item.duzenle(cat);
	}

}
