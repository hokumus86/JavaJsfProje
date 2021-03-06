package com.hokumus.beans;

import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.hokumus.dao.CustomerDAO;
import com.hokumus.model.Customer;

@SuppressWarnings("deprecation")
@ManagedBean(name = "createAccoundBean")
@SessionScoped
public class CreateAccoundBean {

	private String isim;
	private String email;
	private String telefon;
	private String sifre1;
	private String sifre2;
	private String durum;
	private CustomerDAO DBmusteri = new CustomerDAO();
	
	
		public String kodver() {
			//muhammedali55@gmail.com
			String mail = email;
			int deger=13;
			String kod="";
			for (int i=0;i<mail.length();i++) {
				kod += ((int)mail.charAt(i)*deger)+"_";
			}
			return kod;			
		}
	
		public void ismusteri() {
			Customer mst=null;
		for (Customer item : DBmusteri.ara("email", email, new Customer())) {
			mst = item;
		}	
		if(mst!=null) {
			if(mst.getDurum()==0)
				durum="Bu E-Mail Adresi daha önce kullanılmıştır ve aktivasyon beklemektedir. <br />"
						+ "Lütfen e-mail adresini kontrol ederek ilgili aktivasyonu sağlayınız.";
			else
				durum="Bu E-Mail adresi ile daha önce kayıt açılmıştır. Lütfen kontrol sağlayarak başka bir email adresi giriniz.";
		}			
		else {
		
			Customer kayit = new Customer();
			kayit.setAd(isim);
			kayit.setEmail(email);
			kayit.setSifre(sifre1);
			kayit.setSil_id(1);
			kayit.setTelefon(telefon);
			kayit.setDurum(0);
			DBmusteri.kaydet(kayit);
			mailyolla();
			durum="KAYIT İŞLEMİ TAMAMLANMIŞTIR LÜTFEN AKTİVASYON İÇİN MAİL ADRESİNİZİ KONTROL EDİNİZ.";
		}			
		}
	
		public void mailyolla() {
		
			final String username = "muhammed.ali.kaya.0606@gmail.com";
			final String password = "Aa123456*";

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("muhammedali55@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("muhammedali55@gmail.com"));
				message.setSubject("Üyelik Aktivasyonu");
				message.setText("Merhabe Yeni Üye," + "\n\n "
								+"Üye Adınız...: "+isim
								+"Şifreniz.....: "+sifre1+
								"Üyeliğini Aktif Etmek için Link e Tıkla...: \n\n"+
								"http://localhost:8080/MusteriTakip/aktivasyon.jsf?kod="+kodver()
						);

				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
	}
	
		
		public String getDurum() {
			return durum;
		}
		public void setDurum(String durum) {
			this.durum = durum;
		}
		public String getIsim() {
			return isim;
		}


		public void setIsim(String isim) {
			this.isim = isim;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getTelefon() {
			return telefon;
		}


		public void setTelefon(String telefon) {
			this.telefon = telefon;
		}


		public String getSifre1() {
			return sifre1;
		}


		public void setSifre1(String sifre1) {
			this.sifre1 = sifre1;
		}


		public String getSifre2() {
			return sifre2;
		}


		public void setSifre2(String sifre2) {
			this.sifre2 = sifre2;
		}

		
		
		
}
