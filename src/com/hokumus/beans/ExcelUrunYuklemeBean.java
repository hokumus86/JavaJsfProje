package com.hokumus.beans;

import java.io.File;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hokumus.dao.ProductDAO;
import com.hokumus.model.Product;

@ManagedBean(name = "excelUrunYuklemeBean")
@SessionScoped
public class ExcelUrunYuklemeBean {

	 //A�IKLAMA SATIRI EKLENECEK T�M SAYFAYA
	 public static XSSFSheet xlsTablo ;
	 

//		public void XLSDosyaAl(FileUploadEvent event) throws Exception {
//
//			
//			UploadedFile uploadedFile = (UploadedFile) event.getFile();
//			
//			File dosya= new File("tmp.xlsx");
//			FileUtils.copyInputStreamToFile(uploadedFile.getInputstream(), dosya);
//		
//			
//			XSSFWorkbook workbook = new XSSFWorkbook(dosya);
//			
//			xlsTablo = workbook.getSheetAt(0);
//	 
//			 
//			workbook.close();
//		}
		
		
		public void XSLSistemeAktar() throws Exception{
			
		
			int rowNum = xlsTablo.getLastRowNum() + 1;
			
			ProductDAO DB = new ProductDAO();
			Product urun;
			for (int i = 1; i < rowNum; i++) {
				
				Row row = xlsTablo.getRow(i);
		
				 if(row == null){
					 
				 }else{
					 				 
					 if(row.getCell(0) != null && row.getCell(2)!=null && row.getCell(1)!=null);
					
					 
					
					 urun = new Product();
					 urun.setAd(row.getCell(0).getStringCellValue());
					 urun.setAciklama(row.getCell(2).getStringCellValue());
					 urun.setFiyat(row.getCell(5).getNumericCellValue()+"");
					 urun.setKategori_id((int)row.getCell(3).getNumericCellValue());
					 urun.setKategoriadi(row.getCell(4).getStringCellValue());
					 urun.setKod(row.getCell(1).getStringCellValue());
					 urun.setSil_id((int)row.getCell(6).getNumericCellValue());
					 DB.kaydet(urun);
					 //dao.ExcelGuncelle((int)row.getCell(0).getNumericCellValue(), row.getCell(2).getStringCellValue(), row.getCell(1).getStringCellValue());
					
				 }
			
						
				
			}
			
			// FacesContext context = FacesContext.getCurrentInstance();
	         
		   //  context.addMessage(null, new FacesMessage("Sisteme Aktar�m Mesaj�",  "��lem Ba�ar� ile Ger�ekle�tirilmi�tir. ") );
			
		}


	
	
}
