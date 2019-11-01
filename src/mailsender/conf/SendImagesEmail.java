package mailsender.conf;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.smtp.SMTPTransport;
import mailsender.conf.MailListReader;
import mailsender.conf.RandomSearch;



public class SendImagesEmail {


	public static void main(String[] args) {
		
		// mail adresi daxil edilir
		String mail_from        = "mail address";	
		String mail_host        = "smtp.mail.ru";
                // String mail_host     = "host03.datacenter.az";
		// mail passw daxil edilir
		String mail_password    = "xxxxxxxxxxx";
		// file path
		String image_path       = "C:\\Users\\Aydin\\Documents\\NetBeansProjects\\PinguMail\\src\\mailsender\\attack\\";
                String mail_path        = "C:\\Users\\Aydin\\Documents\\NetBeansProjects\\PinguMail\\src\\mailsender\\conf\\maillist.txt";
		
                String mail_adr_tmp     = "";
                String image_name_tmp   = "";
                
                int mail_adreslerinin_sayi = new MailListReader().mail_list_size(mail_path) - 1;

                // Gonderenin Adi SoyAdi
                String mail_sender_name = "Name Firstname";
                String BCC_mail_name =    "copy mail";
                
                
  

			MailListReader tfr = new MailListReader();

			// mail.smtp.host ---confige elave elemek
			Properties props = System.getProperties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.host", mail_host  );

			Session session = Session.getInstance(props, null);


		while(mail_adreslerinin_sayi >= 0){
		
			
			try {
                                mail_adr_tmp = new MailListReader().mail_list_reader(mail_path, mail_adreslerinin_sayi);
                                
                                image_name_tmp = new RandomSearch().senderFileName();
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(mail_from, mail_sender_name));

				// gonderilecek adresilerin massivi...
				// message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail_to_arrays[index-1], false));
//				mail_to_arrays = tfr.mail_list_reader((index-1), mail_path);
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail_adr_tmp, false));
          			message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(BCC_mail_name, false));

				message.setSubject(":::::::Поздравление:::::::");
				// message.setText("salam");

				// message.setHeader("Aydin", "Quliyev");
				// message.setSentDate(new Date());

				MimeMultipart multipart = new MimeMultipart("related");

				BodyPart messageBodyPart = new MimeBodyPart();
				String htmlText = "<img src=\"cid:image\">";
				messageBodyPart.setContent(htmlText, "text/html");

				multipart.addBodyPart(messageBodyPart);

				messageBodyPart = new MimeBodyPart();
				// FileDataSource(path);
				DataSource fds = new FileDataSource(image_path+"\\"+image_name_tmp);
				messageBodyPart.setDataHandler(new DataHandler(fds));
				messageBodyPart.setHeader("Content-ID", "<image>");

				multipart.addBodyPart(messageBodyPart);
				message.setContent(multipart);

				//send message
				SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
				t.connect(mail_host, mail_from, mail_password);
				t.sendMessage(message, message.getAllRecipients());
				// Transport.send(message);
				System.out.println("*******Отчеть о работе программы******\n");
//				System.out.print(mail_adreslerinin_sayi+" "+ mail_adr_tmp + " "+image_name_tmp+"\n");
                                System.out.println(mail_adreslerinin_sayi);
                                System.out.println(mail_adr_tmp);
                                System.out.println(image_name_tmp);
			} catch (Exception e) {
				e.printStackTrace();
			}

			mail_adreslerinin_sayi--;				// ciklin sonu end while
		}

	}
}
