package com.hokumus.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.hokumus.dao.CategoriDAO;
import com.hokumus.dao.ProductDAO;
import com.hokumus.model.Categori;
import com.hokumus.model.Product;

@ManagedBean(name = "xmlUrunCiktilamaBean")
@SessionScoped
public class XmlUrunCiktilamaBean {

	CategoriDAO DBkategori = new CategoriDAO();
	ProductDAO DBurun = new ProductDAO();
	
	private List<Product> urunListesi = new  ArrayList<>();
	private List<Categori> kategoriListesi = new ArrayList<>();
	private int categoriId=0;
	
	
	public void urunleriListele() {
		
		
	}
	
	public void urunleriXmlDonustur() {
		
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("exchangeData");
			doc.appendChild(rootElement);

			Element staff = doc.createElement("exchangeHeader");
			rootElement.appendChild(staff);

			staff.setAttribute("version", "1.1");

			Element urunler = doc.createElement("Urunler");
			rootElement.appendChild(urunler);

			for (Product item : getUrunListesi()) {
				Element urun = doc.createElement("urun");
				urunler.appendChild(urun);

				urun.setAttribute("ID", item.getId()+"");
				urun.setAttribute("AD", item.getAd()+"");
				urun.setAttribute("KATEGORI_ID", item.getKategori_id()+"");
				urun.setAttribute("KATEGORIADI", item.getKategoriadi()+"");
				urun.setAttribute("FIYAT", item.getFiyat()+"");
				urun.setAttribute("KOD", item.getKod()+"");
				urun.setAttribute("ACIKLAMA", item.getAciklama()+"");				
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("d:\\test.xml"));
		    transformer.transform(source, result);

			File file = new File("d:\\test.xml");
			
			InputStream fis = new FileInputStream(file);
			byte[] buf = new byte[(int) file.length()];
			int offset = 0;
			int numRead = 0;
			while ((offset < buf.length) && ((numRead = fis.read(buf, offset, buf.length - offset)) >= 0)) {
				offset += numRead;
			}
			fis.close();
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();

			response.setContentType("text/xml");
			response.setHeader("Content-Disposition", "attachment;filename=UrunListesi.xml");
			response.getOutputStream().write(buf);
			response.getOutputStream().flush();
			response.getOutputStream().close();
			FacesContext.getCurrentInstance().responseComplete();

			
		}
		catch(Exception ex) {
			System.out.println("Hata.....: "+ ex.toString());			
		}
		
	}
	
	
	// TÜM GET - SET METHODLARI BURADAN İTİBAREN BAŞLAYACAKTIR.
	public List<Product> getUrunListesi() {
		if(categoriId<=0) {
			return DBurun.listA(new Product());
		}
		
		return DBurun.araCategoriyeGore(categoriId);
	}
	public void setUrunListesi(List<Product> urunListesi) {
		this.urunListesi = urunListesi;
	}
	public List<Categori> getKategoriListesi() {
		return DBkategori.listA(new Categori());
	}
	public void setKategoriListesi(List<Categori> kategoriListesi) {
		this.kategoriListesi = kategoriListesi;
	}
	public int getCategoriId() {
		return categoriId;
	}
	public void setCategoriId(int categoriId) {
		this.categoriId = categoriId;
	}
	
	
	
}

